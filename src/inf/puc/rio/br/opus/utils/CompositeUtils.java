package inf.puc.rio.br.opus.utils;

import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompositeUtils {

    public static List<String> getCommitsOfCompositesByProject(List<CompositeRefactoring> composites){

        Set<String> commits = new HashSet<>();

        for (CompositeRefactoring composite : composites) {
            for (Refactoring ref : composite.getRefactorings()) {
                commits.add(ref.getCurrentCommit().getCommit());
                commits.add(ref.getCurrentCommit().getPreviousCommit());
                System.out.println(ref.getProject() + ": "  + ref.getCurrentCommit().getCommit());
                System.out.println(ref.getProject() + ": "  + ref.getCurrentCommit().getPreviousCommit());
            }
        }

        return new ArrayList<>(commits);
    }
}
