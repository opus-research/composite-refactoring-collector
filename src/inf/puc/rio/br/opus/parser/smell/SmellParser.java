package inf.puc.rio.br.opus.parser.smell;

import inf.puc.rio.br.opus.minerator.smells.pmd.DuplicatedCodePMD;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.CodeSmellOrganic;
import inf.puc.rio.br.opus.model.smell.organic.MethodOrganic;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;

public class SmellParser{


    public List<CodeSmell> parserOrganicSmellToOurSmellModel(List<OuputOrganic> outputOrganicList,
                                                              String projectName, String commit){

        List<CodeSmell> smells = new ArrayList<>();

        String detectorName = "Organic";
        for(OuputOrganic outputOrganic: outputOrganicList){

            if(outputOrganic.getSmells() == null){
                outputOrganic.setSmells(new ArrayList<>());
            }

            smells.addAll(getSmellsOfMethod(detectorName, outputOrganic, projectName,commit));
            smells.addAll(getSmellsOfClass(detectorName, outputOrganic, projectName,commit));

        }
        return smells;
    }

    private List<CodeSmell> getSmellsOfMethod(String detectorName, OuputOrganic outputOrganic, String projectName, String commit){

        List<CodeSmell> smells = new ArrayList<>();
        for (MethodOrganic method : outputOrganic.getMethods()) {

            for (CodeSmellOrganic smellOrganic : method.getSmells()) {
                String details = smellOrganic.getReason() +
                        ", startingLine: " + smellOrganic.getStartingLine()+ ", EndingLine: " + smellOrganic.getEndingLine();

                String elementName = method.getFullyQualifiedName();
                if (method.getParametersTypes().size() > 0){
                    elementName += "(" + method.getParametersTypes().toString()+ ")";
                }

                CodeSmell smell = new CodeSmell(null,
                        smellOrganic.getName(),
                        projectName,
                        elementName,
                        commit,
                        detectorName,
                        details,
                        method.getMetricsValues());

                smells.add(smell);
            }
        }
        return smells;
    }

    private List<CodeSmell> getSmellsOfClass(String detectorName, OuputOrganic outputOrganic, String projectName, String commit){

        List<CodeSmell> smells = new ArrayList<>();
        for (CodeSmellOrganic smellOrganic : outputOrganic.getSmells()) {
            String details = smellOrganic.getReason() +
                    ", startingLine: " + smellOrganic.getStartingLine()+ ", EndingLine: " + smellOrganic.getEndingLine();

            CodeSmell smell = new CodeSmell(null,
                    smellOrganic.getName(),
                    projectName,
                    outputOrganic.getFullyQualifiedName(),
                    commit,
                    detectorName,
                    details,
                    outputOrganic.getMetricsValues());

            smells.add(smell);
        }
        return smells;
    }


    public List<CodeSmell> parserPMDSmellToOurModel(List<DuplicatedCodePMD> duplicatedCodePMDs) {

        List<CodeSmell> smells = new ArrayList<>();
        for (DuplicatedCodePMD duplicatedCodePMD : duplicatedCodePMDs) {

            List<String> absoluteMethodNames = getAbsoluteMethodNamesFromPMDOutput(duplicatedCodePMD);

            for (String methodName : absoluteMethodNames) {
                CodeSmell smell = new CodeSmell();

                smell.setCommit(duplicatedCodePMD.getCommit());
                smell.setProjectName(duplicatedCodePMD.getProjectName());
                smell.setDetectorName("PMD");
                methodName = AnalysisUtils.parserToMethodNamePerPackage(methodName);
                smell.setCodeElement(methodName);
                smells.add(smell);
            }

        }

        return smells;
    }

    private List<String> getAbsoluteMethodNamesFromPMDOutput(DuplicatedCodePMD duplicatedCodePMD) {

        List<String> absoluteMethodNames = new ArrayList<>();

        for (String methodName : duplicatedCodePMD.getMethodNames()) {

            for (String className : duplicatedCodePMD.getClassNames()) {

                String absoluteMethodName = className + "." + methodName;
                absoluteMethodNames.add(absoluteMethodName);
            }

        }
        return absoluteMethodNames;
    }
}
