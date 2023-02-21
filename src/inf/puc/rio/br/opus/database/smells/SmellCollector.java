package inf.puc.rio.br.opus.database.smells;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.minerator.smells.pmd.DuplicatedCodePMD;
import inf.puc.rio.br.opus.minerator.smells.pmd.PMDMinerator;
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
    private SmellParser parser;

    private SmellCollector(String[] args){
        smellRepository= new SmellRepository(args);
        parser = new SmellParser();
    }

    public SmellCollector(){

    }

    public static void main(String[] args) {
        SmellCollector collector = new SmellCollector(args);
        List<CodeSmell> smells = collector.getAllSmells("sitewhere");
        collector.smellRepository.insertAllSmells(smells);
    }

    private void collectDuplicatedCode(){

        //Run PMD
        PMDMinerator mineratorPMD = new PMDMinerator();
        String project = "";

        List<CodeSmell> duplicatedMethodsByProject = new ArrayList<>();
        List<String> commitsFromLongMethods = AnalysisUtils.getCommitsFromLongMethods(project);
        for (String commitsFromLongMethod : commitsFromLongMethods) {

            String output = mineratorPMD.execute(project, commitsFromLongMethod);
            //Save Duplicated Code in List
            List<DuplicatedCodePMD> duplicatedCodePMDs = mineratorPMD.getDuplicatedMethods(output, project, commitsFromLongMethod);
            // Parser Duplicated Code
            List<CodeSmell> duplicatedMethods = parser.parserPMDSmellToOurModel(duplicatedCodePMDs);
            duplicatedMethodsByProject.addAll(duplicatedMethods);

        }

        writeCodeSmellsAsJson(duplicatedMethodsByProject, "smells-" + project + ".json");

    }

    public List<CodeSmell> getAllSmells(String projectName){
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


    public void writeCodeSmellsAsJson(List<CodeSmell> smells, String fileName) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(fileName),  smells);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<CodeSmell> readSmellsFromJson(String path){

        ObjectMapper mapper = new ObjectMapper();
        List<CodeSmell> smellsList = new ArrayList<>();
        try {

            CodeSmell[] smells = mapper.readValue(new File(path),
                    CodeSmell[].class);

           smellsList = new ArrayList<CodeSmell>(Arrays.asList(smells));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return smellsList;

    }
}
