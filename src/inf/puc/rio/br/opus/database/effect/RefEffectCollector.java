package inf.puc.rio.br.opus.database.effect;

import inf.puc.rio.br.opus.database.smells.SmellRepository;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.model.refeffect.RefEffect;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RefEffectCollector {


    private SmellRepository smellRepository;
    public void collectRefEffect(){
        List<Refactoring> refs = new ArrayList<>();
        List<CodeSmell> smell = new ArrayList<>();
        List<RefEffect> effects = new ArrayList<>();

        for (Refactoring ref : refs) {
             getRefEffectByRefactoring(ref);

        }



    }

    private RefEffect getRefEffectByRefactoring(Refactoring ref){

        RefEffect effect = null;
        List<CodeElement> elements = ref.getElements();


        String previousCommit = ref.getCurrentCommit().previousCommit;
        String currentCommit = ref.getCurrentCommit().commit;

        List<CodeSmell> smellsOfPreviousCommit = new ArrayList<>();
        List<CodeSmell> smellsOfCurrentCommit = new ArrayList<>();

        for (CodeElement element : elements) {
                String className = element.className;
                String methodSignature = element.methodName;

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

        List<String> smellsBefore = smellsOfPreviousCommit.stream().map(CodeSmell::getId).collect(Collectors.toList());
        List<String> smellsAfter = smellsOfCurrentCommit.stream().map(CodeSmell::getId).collect(Collectors.toList());
        effect = new RefEffect(null, ref.refactoringId, smellsBefore, smellsAfter);
        return effect;

    }




}
