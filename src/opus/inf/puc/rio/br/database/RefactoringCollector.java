package opus.inf.puc.rio.br.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefactoringCollector {

    private RefactoringRepository refRepository;

    private RefactoringCollector(String[] args){
        refRepository= new RefactoringRepository(args);
    }
    public static void main(String[] args) {
        RefactoringCollector collector = new RefactoringCollector(args);
        List<Refactoring> refactorings = collector.getAllRefactorings();
        collector.refRepository.insertAllRefactorings(refactorings);
    }


    private List<Refactoring> getAllRefactorings(){
        ObjectMapper mapper = new ObjectMapper();
        List<Refactoring> refList = new ArrayList<>();
        Refactoring[] refactorings = new Refactoring[0];
        try {
            refactorings = mapper.readValue(new File("refs-project1.json"), Refactoring[].class);
            refList = Arrays.asList(refactorings);

            refactorings = mapper.readValue(new File("refs-project2.json"), Refactoring[].class);
            refList = Arrays.asList(refactorings);

            refactorings = mapper.readValue(new File("refs-project3.json"), Refactoring[].class);
            refList = Arrays.asList(refactorings);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return refList;
    }
}

