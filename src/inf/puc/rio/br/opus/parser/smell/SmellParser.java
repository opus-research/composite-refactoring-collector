package inf.puc.rio.br.opus.parser.smell;

import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.CodeSmellOrganic;
import inf.puc.rio.br.opus.model.smell.organic.MethodOrganic;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;

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

            //getSmellsOfClass(detectorName, outputOrganic, projectName,commit);
            getSmellsOfMethod(detectorName, outputOrganic, projectName,commit);
        }
        return smells;
    }

    private CodeSmell getSmellsOfMethod(String detectorName, OuputOrganic outputOrganic, String projectName, String commit){
        CodeSmell smell = null;
        for (MethodOrganic method : outputOrganic.getMethods()) {


            for (CodeSmellOrganic smellOrganic : method.getSmells()) {
                String details = smellOrganic.getReason() +
                        ", startingLine: " + smellOrganic.getStartingLine()+ ", EndingLine: " + smellOrganic.getEndingLine();


                String elementName = method.getFullyQualifiedName();
                if (method.getParametersTypes().size() > 0){
                    elementName += "(" + method.getParametersTypes().toString()+ ")";
                }

                smell = new CodeSmell(null,
                        smellOrganic.getName(),
                        projectName,
                        elementName,
                        commit,
                        detectorName,
                        details);
            }
        }
        return smell;
    }

    private CodeSmell getSmellsOfClass(String detectorName, OuputOrganic outputOrganic, String projectName, String commit){

        CodeSmell smell = null;
        for (CodeSmellOrganic smellOrganic : outputOrganic.getSmells()) {
            String details = smellOrganic.getReason() +
                    ", startingLine: " + smellOrganic.getStartingLine()+ ", EndingLine: " + smellOrganic.getEndingLine();

            smell = new CodeSmell(null,
                    smellOrganic.getName(),
                    projectName,
                    outputOrganic.getFullyQualifiedName(),
                    commit,
                    detectorName,
                    details);

        }
        return smell;
    }
}
