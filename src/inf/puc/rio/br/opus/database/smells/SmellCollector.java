package inf.puc.rio.br.opus.database.smells;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.model.smell.organic.CodeSmellOrganic;
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
        List<CodeSmellOrganic> smells = collector.getAllSmells();
        collector.smellRepository.insertAllSmells(smells);
    }

    private List<CodeSmellOrganic> getAllSmells(){
        ObjectMapper mapper = new ObjectMapper();
        List<CodeSmellOrganic> compositeList = new ArrayList<>();
        CodeSmellOrganic[] smells = new CodeSmellOrganic[0];
        List<String> smellFiles = AnalysisUtils.getAllFileNames("smells", ".json");
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                smells = mapper.readValue(new File(smellFile), CodeSmellOrganic[].class);
                List<CodeSmellOrganic> smellList = new ArrayList<>(Arrays.asList(smells));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return compositeList;
    }



}
