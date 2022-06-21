package inf.puc.rio.br.opus.database.effect;

import inf.puc.rio.br.opus.database.smells.SmellRepository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.effect.CompositeEffect;
import inf.puc.rio.br.opus.model.effect.RefactoringEffect;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CompositeEffectCollector {

    private SmellRepository smellRepository;

    public CompositeEffectCollector(String[] args) {
        this.smellRepository = new SmellRepository(args);
    }

    public CompositeEffect collectRefEffect(CompositeRefactoring composite){

        List<Refactoring> refs = composite.getRefactorings();

        Map<String, String> previousAndCurrentCommits = getPreviousAndCurrentCommits(refs);
        String previousCommit = previousAndCurrentCommits.get("previousCommit");
        String currentCommit = previousAndCurrentCommits.get("currentCommit");


        List<CodeElement> elements = new ArrayList<>();
        refs.forEach(ref -> elements.addAll(ref.getElements()));


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
                String methodName = AnalysisUtils.parserToMethodNameSmellFormat(methodSignature);

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
        CompositeEffect effect = new CompositeEffect(null, composite.getId(), smellsBefore, smellsAfter);
        return effect;

    }

    private Map<String, String> getPreviousAndCurrentCommits(List<Refactoring> refactorings){
        List<Commit> commits = refactorings.stream().map(Refactoring::getCurrentCommit).collect(Collectors.toList());

        Comparator<Commit> compareByOrder = Comparator
                .comparing(Commit::getOrderCommit);

        List<Commit> sortedCommit = commits.stream()
                .sorted(compareByOrder)
                .collect(Collectors.toList());

        int previousCommitIndex = 0;
        int currentCommitIndex = sortedCommit.size() - 1;
        Map<String, String> previousAndCurrentCommits = new HashMap<>();

        previousAndCurrentCommits.put("previousCommit", sortedCommit.get(previousCommitIndex).getPreviousCommit());
        previousAndCurrentCommits.put("currentCommit", sortedCommit.get(currentCommitIndex).getCommit());

        return previousAndCurrentCommits;
    }
}
