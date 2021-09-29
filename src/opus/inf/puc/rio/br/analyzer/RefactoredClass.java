package opus.inf.puc.rio.br.analyzer;

import opus.inf.puc.rio.br.model.refactoring.Refactoring;

import java.util.Set;

public class RefactoredClass {

    private String className;
    private Set<Refactoring> refactorings;
    private int numberOfRefactorings;


    public RefactoredClass(String className, Set<Refactoring> refactorings) {
        this.className = className;
        this.refactorings = refactorings;
        this.numberOfRefactorings = refactorings.size();
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfRefactorings() {
        return numberOfRefactorings;
    }

    public Set<Refactoring> getRefactorings() {
        return refactorings;
    }
}
