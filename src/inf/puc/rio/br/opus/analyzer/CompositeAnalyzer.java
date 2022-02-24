package inf.puc.rio.br.opus.analyzer;

import inf.puc.rio.br.opus.database.composites.CompositeRepository;
import inf.puc.rio.br.opus.database.refactorings.RefactoringRepository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompositeAnalyzer {

    CompositeRepository compositeRepository;
    RefactoringRepository refactoringRepository;

    private Set<String> getCommitsOfComposites(String projectName){
        Set<String> commits = new HashSet<>();
        Set<String> refsIDs = new HashSet<>();
        List<CompositeRefactoring> composites = compositeRepository.getAllComposites(projectName);

        composites.forEach(composite -> {
            refsIDs.addAll(composite.getRefactoringIDs());
        });

        for (String refID : refsIDs) {
            Refactoring ref = refactoringRepository.getRefactoringById(refID);
            commits.add(ref.getCurrentCommit().previousCommit);
            commits.add(ref.getCurrentCommit().commit);
        }


        return commits;
    }

}
