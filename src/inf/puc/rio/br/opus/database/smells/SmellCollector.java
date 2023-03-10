package inf.puc.rio.br.opus.database.smells;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
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
import java.util.Set;

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
        collector.collectLongSignedClone(AnalysisUtils.PROJECT_NAME);
    }

    public void collectLongSignedClone(String project){
        List<CodeSmell> longMethods = SmellCollector.readSmellsFromJson("smelly_methods_" + project + ".json");
        longMethods = AnalysisUtils.fixCommits(longMethods);

        List<CodeSmell> duplicatedMethods = collectDuplicatedCodeFromLongMethods(longMethods, project);
        List<CodeSmell> longSignedClones = new ArrayList<CodeSmell>();

        int countID = 0;
        for (CodeSmell duplicatedMethod : duplicatedMethods) {

            for (CodeSmell longMethod : longMethods) {


                if(duplicatedMethod.getCommit() != null & longMethod.getCommit() != null
                    && !duplicatedMethod.getCommit().isEmpty() & !longMethod.getCommit().isEmpty()
                    &&  duplicatedMethod.getCodeElement() != null & longMethod.getCodeElement() != null
                    && !duplicatedMethod.getCodeElement().isEmpty() & !longMethod.getCodeElement().isEmpty()
                    &&   duplicatedMethod.getCommit().equals(longMethod.getCommit()) &&
                   duplicatedMethod.getCodeElement().equals(longMethod.getCodeElement())){
                   String id = "lsc-" + countID;

                    CodeSmell smell = new CodeSmell(id,
                    "LongSignedClone",
                    project,
                    duplicatedMethod.getCodeElement(),
                    longMethod.getCommit(),
                    "SmellDetector",
                    "",
                    null);

                    longSignedClones.add(smell);

                    countID ++;
                }

            }
        }

        writeCodeSmellsAsJson(longSignedClones, "lsc-" + project + ".json");
    }

    private List<CodeSmell> collectDuplicatedCodeFromLongMethods(List<CodeSmell> longMethods, String project){

        //Run PMD
        PMDMinerator mineratorPMD = new PMDMinerator();

        List<CodeSmell> duplicatedMethodsByProject = new ArrayList<>();

        Set<String> commitsFromLongMethods = AnalysisUtils.getSmellyCommits(longMethods);

       for (String commitFromLongMethod : commitsFromLongMethods) {
            String output = mineratorPMD.execute(project, commitFromLongMethod);
            //Save Duplicated Code in List
            List<DuplicatedCodePMD> duplicatedCodePMDs = mineratorPMD.getDuplicatedMethods(output, project, commitFromLongMethod);
            // Parser Duplicated Code
            List<CodeSmell> duplicatedMethods = parser.parserPMDSmellToOurModel(duplicatedCodePMDs);
            duplicatedMethodsByProject.addAll(duplicatedMethods);

        }

        writeCodeSmellsAsJson(duplicatedMethodsByProject, "duplicated-methods-" + project + ".json");
        return duplicatedMethodsByProject;

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

            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

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
