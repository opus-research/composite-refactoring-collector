package opus.inf.puc.rio.br.database.composites;

import com.fasterxml.jackson.databind.ObjectMapper;
import opus.inf.puc.rio.br.model.compositeref.CompositeRefactoring;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;

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
        List<CompositeRefactoring> compositeList = new ArrayList<>();
        CompositeRefactoring[] composites = new CompositeRefactoring[0];
        try {
            composites = mapper.readValue(new File("junit4-composite-rangebased.json"), CompositeRefactoring[].class);
            compositeList = new ArrayList<>(Arrays.asList(composites));
            compositeList = prepareComposites(compositeList);

           // composites = mapper.readValue(new File("okhttp-refactorings.json"), CompositeRefactoring[].class);
           // List<Refactoring> auxRefList = new ArrayList<>(Arrays.asList(refactorings));
          //  compositeList.addAll(Arrays.asList(composites));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return compositeList;
    }


    private List<CompositeRefactoring> prepareComposites(List<CompositeRefactoring> compositeList){

        if (compositeList!= null || compositeList.size() != 0){
            String projectName = compositeList.get(0).getRefactorings().get(0).getProject();

            for (CompositeRefactoring composite : compositeList) {
                composite.setId( projectName + "-" + composite.getId());
                composite.setRefactoringIDs(new ArrayList<>());

                for (Refactoring refactoring : composite.getRefactorings()) {
                     String refactoringId = refactoring.refactoringId;
                     composite.getRefactoringIDs().add(refactoringId);
                }

                composite.setRefactorings(null);
            }
            return compositeList;
        }

        return null;
    }
}

