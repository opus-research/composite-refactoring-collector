package inf.puc.rio.br.opus.minerator.smells.pmd;

import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PMDMinerator {


    public  List<DuplicatedCodePMD> findDuplicatedMethod(String path){

        String methodNameRegex = "\\s*(public|private|protected)?\\s+\\w+\\s+\\w+\\(.*\\)\\s*(throws\\s+\\w+)?\\s*\\{?\\s*";

        List<String> classNames = new ArrayList<String>();
        List<String> methodNames = new ArrayList<String>();
        DuplicatedCodePMD duplicatedCodePMD;
        List<DuplicatedCodePMD> duplicatedCodePMDs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {

                if(line.contains("====")){
                    duplicatedCodePMD = new DuplicatedCodePMD();
                    duplicatedCodePMD.setClassNames(classNames);
                    duplicatedCodePMD.setMethodNames(methodNames);
                    duplicatedCodePMDs.add(duplicatedCodePMD);

                    classNames = new ArrayList<String>();
                    methodNames = new ArrayList<String>();
                }

                if (line.contains(".java")) {
                    classNames.add(line);
                }

                if (line.matches(methodNameRegex)) {
                    methodNames.add(line);
                }
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        return duplicatedCodePMDs;
    }

    public String parserClassName(String projectPath, String classNamePMDFormat){

        String className = "";
        int javaIndex = classNamePMDFormat.lastIndexOf(".java");
        classNamePMDFormat = classNamePMDFormat.substring(projectPath.length(), javaIndex);
        classNamePMDFormat.replace("\\", ".");

        return className;

    }


    public List<String> parserMethodName(String methodNameFromPMDFormat) {
        Pattern pattern = Pattern.compile("\\s*public\\s+\\w+\\s+(\\w+)\\s*\\((.*?)\\)\\s*\\{.*");
        Matcher matcher = pattern.matcher(methodNameFromPMDFormat);


        if (matcher.find()) {
            String methodName = matcher.group(1);
            System.out.println(methodName);

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
                    }
                    );

            params.stream().forEach(System.out::println);

            return params;
        }

        return null;
    }
}
