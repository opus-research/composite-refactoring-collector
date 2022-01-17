package inf.puc.rio.br.opus.parser.smell;

import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.CodeSmellOrganic;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;

import java.util.ArrayList;
import java.util.List;

public class SmellParser{



    public List<CodeSmell> parserOrganicSmellToOurSmellModel(List<OuputOrganic> outputOrganicList,
                                                              String projectName, String commit){

        List<CodeSmell> smells = new ArrayList<>();

        String detectorName = "Organic";
        for(OuputOrganic outputOrganic: outputOrganicList){

            for (CodeSmellOrganic smellOrganic : outputOrganic.getSmells()) {
                String details = smellOrganic.getReason() +
                                ", startingLine: " + smellOrganic.getStartingLine()+ ", EndingLine: " + smellOrganic.getEndingLine();

                CodeSmell smell = new CodeSmell(null,
                                                smellOrganic.getName(),
                                                projectName,
                                                outputOrganic.getFullyQualifiedName(),
                                                commit,
                                                detectorName,
                                                details);
                smells.add(smell);
            }
        }


        return smells;
    }
}
