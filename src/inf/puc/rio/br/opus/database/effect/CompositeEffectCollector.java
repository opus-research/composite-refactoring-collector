package inf.puc.rio.br.opus.database.effect;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.database.composites.CompositeCollector;
import inf.puc.rio.br.opus.database.smells.SmellRepository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.effect.CompositeEffect;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CompositeEffectCollector {

    private SmellRepository smellRepository;

    public CompositeEffectCollector(String[] args) {

        this.smellRepository = new SmellRepository(args);

    }

    public static void main(String[] args)
    {
        String projectName = "realmjava";
        String compositePath = "realm-java-composite-rangebased.json";

        System.out.println("Evaluating " +  projectName);

        String[] connection = new String[]{"mongodb://localhost:27017"};
        CompositeEffectCollector effectCollector = new CompositeEffectCollector(connection);

        CompositeCollector collector = new CompositeCollector();
        List<CompositeRefactoring> composites = collector.getAllCompositesByProject(compositePath);

        List<CompositeEffect> effectList = effectCollector.getAllCompositeEffects(composites);
        List<CompositeEffect> simplifiedEffectList = effectCollector.getSimplifiedCompositeEffects(effectList);

        effectCollector.writeEffectListToJson(projectName + "-composite-effect.json", effectList);
        effectCollector.writeEffectListToJson(projectName + "-composite-effect-simplified.json", simplifiedEffectList);
    }

    public List<CompositeEffect> getAllCompositeEffects(List<CompositeRefactoring> composites){
        List<CompositeEffect> compositeEffectList = new ArrayList<>();

        int count = 0;
        for (CompositeRefactoring composite : composites) {
            System.out.println(count + "/" + composites.size());
            CompositeEffect effect = collectCompositeEffect(composite);
            compositeEffectList.add(effect);
            count++;
        }

        return compositeEffectList;
    }

    public List<CompositeEffect> getSimplifiedCompositeEffects(List<CompositeEffect> effectList){

        List<CompositeEffect> simplifiedEffectList = new ArrayList<>();
        for (CompositeEffect effect : effectList) {
            simplifiedEffectList.add(effect);
        }

        return simplifiedEffectList;
    }

    //todo - SAVE PREVIOUS AND CURRENT COMMIT
    public CompositeEffect collectCompositeEffect(CompositeRefactoring composite){

        List<Refactoring> refs = composite.getRefactorings();

        Map<String, String> previousAndCurrentCommits = getPreviousAndCurrentCommits(refs);
        //f1eacbff7ec5912d041184e1b35aa4e5468ea4ba
        String previousCommit = previousAndCurrentCommits.get("previousCommit");
        //3355d0c99bb946a6441f08fe6fd1c9881a9ea96a
        String currentCommit = previousAndCurrentCommits.get("currentCommit");

        List<CodeElement> elements = new ArrayList<>();
        refs.forEach(ref -> elements.addAll(ref.getElements()));

        List<CodeSmell> smellsOfPreviousCommit = new ArrayList<>();
        List<CodeSmell> smellsOfCurrentCommit = new ArrayList<>();
        Set<String> classesSet = new HashSet<>();
        Set<String> methodsSet = new HashSet<>();

        for (CodeElement element : elements) {
            String className = element.getClassName();
            if (className != null && !classesSet.contains(className)) {
                classesSet.add(className);
            }
            if(element.getMethodName() != null){
                String methodName = AnalysisUtils.parserToMethodNameSmellFormat(element.getMethodName());
                String methodSignature = className + "." + methodName;
                if (!methodsSet.contains(methodSignature)) {
                    methodsSet.add(methodSignature);
                }
            }

        }
        // Conferir ClassSet e MethodSet
        for (String className : classesSet) {
            smellsOfPreviousCommit.addAll(smellRepository.getSmellsOfClassByCommit(previousCommit, className));
            smellsOfCurrentCommit.addAll(smellRepository.getSmellsOfClassByCommit(currentCommit, className));
        }

        for (String methodName : methodsSet) {
            //Previous Commit
            List<CodeSmell> tempSmells = smellRepository.getSmellsOfMethodByCommit(previousCommit, methodName);
            smellsOfPreviousCommit.addAll(tempSmells);

            //Current Commit
            tempSmells = smellRepository.getSmellsOfMethodByCommit(currentCommit, methodName);
            smellsOfCurrentCommit.addAll(tempSmells);
        }

        String id = "effect-" + composite.getId();
        CompositeEffect effectDetailed = new CompositeEffect(id, composite, smellsOfPreviousCommit, smellsOfCurrentCommit);
        return effectDetailed;
    }

    private void writeEffectListToJson(String jsonName, List<CompositeEffect> compositeEffectList) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(jsonName), compositeEffectList);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private CompositeEffect getSimplifiedEffect(CompositeEffect effect){

        List<String> smellsBefore = effect.getCodeSmellsBefore().stream().map(CodeSmell::getSmellId).collect(Collectors.toList());
        List<String> smellsAfter = effect.getCodeSmellsAfter().stream().map(CodeSmell::getSmellId).collect(Collectors.toList());

        CompositeEffect simplifiedEffect = new CompositeEffect(effect.getId(), effect.getComposite().getId(), smellsBefore, smellsAfter);

        return simplifiedEffect;
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
