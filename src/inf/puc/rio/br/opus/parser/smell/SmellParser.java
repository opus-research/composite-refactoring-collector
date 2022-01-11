package inf.puc.rio.br.opus.parser.smell;

import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.CodeSmellOrganic;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;

import java.util.ArrayList;
import java.util.List;

public class SmellParser{



    private List<CodeSmell> parserOrganicSmellToOurSmellModel(List<OuputOrganic> outputOrganicList,
                                                              String projectName, String commit){

        List<CodeSmell> smells = new ArrayList<>();
        int count = 0;
        String detectorName = "Organic";
        for(OuputOrganic outputOrganic: outputOrganicList){

            for (CodeSmellOrganic smellOrganic : outputOrganic.getSmells()) {

                String smellId = "smell-" + projectName + "-" + count;
                String details = smellOrganic.getReason() +
                                ", startingLine: " + smellOrganic.getStartingLine()+ ", EndingLine: " + smellOrganic.getEndingLine();
                CodeSmell smell = new CodeSmell(smellId,
                                                smellOrganic.getName(),
                                                outputOrganic.getFullyQualifiedName(),
                                                commit,
                                                detectorName,
                                                details);
                count ++;
            }
        }


        return smells;
    }
}
