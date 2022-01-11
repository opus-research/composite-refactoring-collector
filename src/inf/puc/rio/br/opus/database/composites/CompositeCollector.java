package inf.puc.rio.br.opus.database.composites;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeCollector {

    private CompositeRepository compositeRepository;

    private CompositeCollector(String[] args){
        compositeRepository= new CompositeRepository(args);
    }
    public static void main(String[] args) {
        CompositeCollector collector = new CompositeCollector(args);
        List<CompositeRefactoring> composites = collector.getAllComposites();
        collector.compositeRepository.insertAllComposites(composites);
    }



    private List<CompositeRefactoring> getAllComposites(){
        ObjectMapper mapper = new ObjectMapper();
        List<CompositeRefactoring> compositeList = new ArrayList<>();
        CompositeRefactoring[] composites = new CompositeRefactoring[0];
        List<String> compositeFiles = AnalysisUtils.getAllFileNames("composites", ".json");
        try {
            for (String compositeFile : compositeFiles) {
                System.out.println(compositeFile);
                composites = mapper.readValue(new File(compositeFile), CompositeRefactoring[].class);
                List<CompositeRefactoring> auxCompositeList = new ArrayList<>(Arrays.asList(composites));
                auxCompositeList = prepareComposites(auxCompositeList);
                compositeList.addAll(auxCompositeList);
            }


            // composites = mapper.readValue(new File("okhttp-refactorings.json"), CompositeRefactoring[].class);
            //
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

