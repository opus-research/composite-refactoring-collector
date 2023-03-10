package inf.puc.rio.br.opus.minerator.smells.pmd;

import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PMDMinerator {


    private final SmellPMD smellPMD;

    public PMDMinerator(){
        smellPMD = new SmellPMD();
    }

    public List<DuplicatedCodePMD> getDuplicatedMethods(String outputPMD, String projectName, String commit){

        String methodNameRegex = "\\s*(public|private|protected)?\\s+\\w+\\s+\\w+\\(.*\\)\\s*(throws\\s+\\w+)?\\s*\\{?\\s*";
//        String methodNameRegex = "\\s*(static)?\\s*(public|private)\\s*\\w+\\s*(\\w+)\\s*(\\(\\s*\\w*(,?\\s*\\w+)*\\))?";

        List<String> classNames = new ArrayList<>();
        List<String> methodNames = new ArrayList<>();
        DuplicatedCodePMD duplicatedCodePMD;
        List<DuplicatedCodePMD> duplicatedCodePMDs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(AnalysisUtils.PMD_PATH + outputPMD))) {
            String line;
            while ((line = br.readLine()) != null) {

                if(line.contains("====")){
                    duplicatedCodePMD = new DuplicatedCodePMD();

                    if(!classNames.isEmpty() && !methodNames.isEmpty()) {
                        duplicatedCodePMD.setClassNames(classNames);
                        duplicatedCodePMD.setMethodNames(methodNames);
                        duplicatedCodePMD.setCommit(commit);
                        duplicatedCodePMD.setProjectName(projectName);

                        duplicatedCodePMDs.add(duplicatedCodePMD);
                    }

                    classNames = new ArrayList<>();
                    methodNames = new ArrayList<>();
                }

                if (line.contains(".java")) {
                    String className = parserClassName(projectName, line);
                    if(className != null){
                        classNames.add(className);
                    }

                }

                if (line.matches(methodNameRegex)) {
                    String methodName = AnalysisUtils.parserToMethodNameSmellFormat(line);
                    if (methodName!=null) {
                        methodNames.add(methodName);
                    }

                }
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        return duplicatedCodePMDs;
    }

    public String parserClassName(String projectName, String classNamePMDFormat){
        int start = classNamePMDFormat.indexOf(projectName);
        int end = classNamePMDFormat.lastIndexOf(".java");
        if(end > start) {
            classNamePMDFormat = classNamePMDFormat.substring(start + projectName.length() + 1, end);
            return classNamePMDFormat.replace("\\", ".");
        }
        return null;
    }


    public String parserMethodName(String methodNameFromPMDFormat) {

        Pattern pattern = Pattern.compile("\\s*public|private|protected\\s+\\w+\\s+(\\w+)\\s*\\((.*?)\\)\\s*\\{.*");
        Matcher matcher = pattern.matcher(methodNameFromPMDFormat);
        String methodName = "";

        if (matcher.find()) {
            methodName = matcher.group(1);


            String paramList = matcher.group(2);
            List<String> params = Arrays.asList(paramList.split("\\s*,\\s*"));

            params.replaceAll(param -> {

                        String paramType;
                        if(param.contains("final ")){
                            paramType = param.split("\\s+")[1];
                        }
                        else {
                            paramType = param.split("\\s+")[0];
                        }
                        return paramType;
                    });
             methodName = methodName + "(" + params + ")";
             params.forEach(System.out::println);

        }

        return methodName;
    }

    public String execute(String project, String commit) {

        String outputPMDPerProject = "result-" + project + ".txt";
        smellPMD.collectSmells(commit, AnalysisUtils.PROJECT_PATH + project, outputPMDPerProject);

        return outputPMDPerProject;
    }
}
