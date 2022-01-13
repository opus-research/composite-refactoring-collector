package inf.puc.rio.br.opus.database.smells;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;
import inf.puc.rio.br.opus.parser.smell.SmellParser;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmellCollector {

    private SmellRepository smellRepository;

    private SmellCollector(String[] args){
        smellRepository= new SmellRepository(args);
    }

    public static void main(String[] args) {
        SmellCollector collector = new SmellCollector(args);
        List<CodeSmell> smells = collector.getAllSmells("");
        collector.smellRepository.insertAllSmells(smells);
    }

    private List<CodeSmell> getAllSmells(String projectName){
        ObjectMapper mapper = new ObjectMapper();
        OuputOrganic[] smells = new OuputOrganic[0];
        List<String> smellFiles = AnalysisUtils.getAllFileNames(projectName, ".json");
        SmellParser parser = new SmellParser();
        List<CodeSmell> smellsOurModel = new ArrayList<>();
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                smells = mapper.readValue(new File(smellFile), OuputOrganic[].class);
                List<OuputOrganic> smellOutputOrganic = new ArrayList<>(Arrays.asList(smells));
                List<CodeSmell> smellsAuxOurModel = parser.parserOrganicSmellToOurSmellModel(smellOutputOrganic, projectName, smellFile);
                smellsOurModel.addAll(smellsAuxOurModel);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return smellsOurModel;
    }



}
