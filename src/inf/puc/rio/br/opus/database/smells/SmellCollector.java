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
        List<CodeSmell> smells = collector.getAllSmells("fresco");
        collector.smellRepository.insertAllSmells(smells);
    }

    private List<CodeSmell> getAllSmells(String projectName){
        ObjectMapper mapper = new ObjectMapper();
        OuputOrganic[] smells = new OuputOrganic[0];
        String extensionName = ".json";
        List<String> smellFiles = AnalysisUtils.getAllFileNames(projectName, extensionName);
        SmellParser parser = new SmellParser();
        List<CodeSmell> smellsOurModel = new ArrayList<>();
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                String commit = AnalysisUtils.getOnlyFileNameFromPath(smellFile, extensionName);
                smells = mapper.readValue(new File(smellFile), OuputOrganic[].class);
                List<OuputOrganic> smellOutputOrganic = new ArrayList<>(Arrays.asList(smells));
                List<CodeSmell> smellsAuxOurModel = parser.parserOrganicSmellToOurSmellModel(smellOutputOrganic, projectName, commit);
                smellsOurModel.addAll(smellsAuxOurModel);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return smellsOurModel;
    }



}
