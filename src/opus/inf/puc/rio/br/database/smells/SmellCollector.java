package opus.inf.puc.rio.br.database.smells;

import com.fasterxml.jackson.databind.ObjectMapper;
import opus.inf.puc.rio.br.model.smell.CodeSmell;
import opus.inf.puc.rio.br.utils.AnalysisUtils;

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
        List<opus.inf.puc.rio.br.model.smell.CodeSmell> smells = collector.getAllSmells();
        collector.smellRepository.insertAllSmells(smells);
    }

    private List<CodeSmell> getAllSmells(){
        ObjectMapper mapper = new ObjectMapper();
        List<CodeSmell> compositeList = new ArrayList<>();
        CodeSmell[] smells = new CodeSmell[0];
        List<String> smellFiles = AnalysisUtils.getAllFileNames("smells", ".json");
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                smells = mapper.readValue(new File(smellFile), CodeSmell[].class);
                List<CodeSmell> smellList = new ArrayList<>(Arrays.asList(smells));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return compositeList;
    }



}
