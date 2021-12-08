package opus.inf.puc.rio.br.database.composites;

import com.fasterxml.jackson.databind.ObjectMapper;
import opus.inf.puc.rio.br.model.compositeref.CompositeRefactoring;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeCollector {

    private CompositeRepository refRepository;

    private CompositeCollector(String[] args){
        refRepository= new CompositeRepository(args);
    }
    public static void main(String[] args) {
        CompositeCollector collector = new CompositeCollector(args);
        List<CompositeRefactoring> composites = collector.getAllComposites();
        collector.refRepository.insertAllComposites(composites);
    }



    private List<CompositeRefactoring> getAllComposites(){
        ObjectMapper mapper = new ObjectMapper();
        List<CompositeRefactoring> refList = new ArrayList<>();
        CompositeRefactoring[] composites = new CompositeRefactoring[0];
        try {
            composites = mapper.readValue(new File("jfreechart-refactorings.json"), CompositeRefactoring[].class);
            refList = new ArrayList<>(Arrays.asList(composites));

            composites = mapper.readValue(new File("okhttp-refactorings.json"), CompositeRefactoring[].class);
           // List<Refactoring> auxRefList = new ArrayList<>(Arrays.asList(refactorings));
            refList.addAll(Arrays.asList(composites));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return refList;
    }
}

