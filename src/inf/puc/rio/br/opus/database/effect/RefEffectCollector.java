package inf.puc.rio.br.opus.database.effect;

import inf.puc.rio.br.opus.database.smells.SmellRepository;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.model.effect.RefactoringEffect;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RefEffectCollector {


    private SmellRepository smellRepository;

    public RefEffectCollector(String[] args) {
        this.smellRepository = new SmellRepository(args);
    }

    public void collectRefEffect(){
        List<Refactoring> refs = new ArrayList<>();
        List<CodeSmell> smell = new ArrayList<>();
        List<RefactoringEffect> effects = new ArrayList<>();

        for (Refactoring ref : refs) {
             getRefEffectByRefactoring(ref);

        }



    }

    public RefactoringEffect getRefEffectByRefactoring(Refactoring ref){

        RefactoringEffect effect = null;
        List<CodeElement> elements = ref.getElements();


        String previousCommit = ref.getCurrentCommit().getPreviousCommit();
        String currentCommit = ref.getCurrentCommit().getCommit();

        List<CodeSmell> smellsOfPreviousCommit = new ArrayList<>();
        List<CodeSmell> smellsOfCurrentCommit = new ArrayList<>();

        for (CodeElement element : elements) {
                String className = element.getClassName();
                String methodSignature = element.getMethodName();

                if (className !=null) {
                    smellsOfPreviousCommit = smellRepository.getSmellsOfClassByCommit(previousCommit, className);
                    smellsOfCurrentCommit = smellRepository.getSmellsOfClassByCommit(currentCommit, className);
                }
                if (methodSignature !=null) {
                    String methodName = AnalysisUtils.getMethodName(methodSignature);
                    List<CodeSmell> tempSmells = smellRepository.getSmellsOfMethodByCommit(previousCommit, methodName);
                    List<String> methodNames = tempSmells.stream().map(CodeSmell::getCodeElement).collect(Collectors.toList());
                    if( !AnalysisUtils.isSameCodeElementName(methodNames)){
                        return null;
                    }
                    smellsOfPreviousCommit.addAll(tempSmells);

                    tempSmells = smellRepository.getSmellsOfMethodByCommit(currentCommit, methodName);
                    methodNames = tempSmells.stream().map(CodeSmell::getCodeElement).collect(Collectors.toList());
                    if( !AnalysisUtils.isSameCodeElementName(methodNames)){
                        return null;
                    }

                    smellsOfCurrentCommit.addAll(tempSmells);
                }


        }

        List<String> smellsBefore = smellsOfPreviousCommit.stream().map(CodeSmell::getSmellId).collect(Collectors.toList());
        List<String> smellsAfter = smellsOfCurrentCommit.stream().map(CodeSmell::getSmellId).collect(Collectors.toList());
        effect = new RefactoringEffect(null, ref.getRefactoringId(), smellsBefore, smellsAfter);
        return effect;

    }




}
