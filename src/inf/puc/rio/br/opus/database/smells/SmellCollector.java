package inf.puc.rio.br.opus.database.smells;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;
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
        List<OuputOrganic> smells = collector.getAllSmells();
        collector.smellRepository.insertAllSmells(smells);
    }

    private List<OuputOrganic> getAllSmells(){
        ObjectMapper mapper = new ObjectMapper();
        List<OuputOrganic> compositeList = new ArrayList<>();
        OuputOrganic[] smells = new OuputOrganic[0];
        List<String> smellFiles = AnalysisUtils.getAllFileNames("smells", ".json");
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                smells = mapper.readValue(new File(smellFile), OuputOrganic[].class);
                List<OuputOrganic> smellList = new ArrayList<>(Arrays.asList(smells));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return compositeList;
    }



}
