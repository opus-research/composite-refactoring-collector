package inf.puc.rio.br.opus.analyzer;

import inf.puc.rio.br.opus.database.smells.SmellCollector;
import inf.puc.rio.br.opus.minerator.smells.pmd.DuplicatedCodePMD;
import inf.puc.rio.br.opus.model.smell.CodeSmell;

import java.util.*;

public class SmellAnalyzer {

    private SmellCollector smellCollector;


    public SmellAnalyzer() {
        this.smellCollector =  new SmellCollector();
    }

    public static void main(String[] args) {

        SmellAnalyzer smellAnalyzer = new SmellAnalyzer();

        String[] vetor = {"activiti", "asynchttpclient", "bytebuddy", "checkstyle",
                "geoserver", "hystrix", "javadriver", "jitwatch", "materialdialogs",
                "materialdrawer", "mockito", "quasar", "restassured", "retrolambda", "xabberandroid"};

        // Converter o vetor em um array list
        List<String> projects = Arrays.asList(vetor);

        projects.forEach( project ->{
            String lscPath = "duplicated//lsc//lsc-" + project + ".json";
            String dmPath = "duplicated//dm//duplicated-methods-" + project + ".json";
            smellAnalyzer.removeDuplicatedCodeSmells(lscPath, "new-lsc-" + project + ".json");
            smellAnalyzer.removeDuplicatedCodeSmells(dmPath, "new-dm-" + project + ".json");
        });


    }

    public void removeDuplicatedCodeSmells(String oldPath, String newPath){

        List<CodeSmell> smells = SmellCollector.readSmellsFromJson(oldPath);
        Set<String> smellsSet = new HashSet<>();
        List<CodeSmell> nonDuplicatedSmells = new ArrayList<>();
        for (CodeSmell smell : smells) {
            String smellAsText = smell.getCodeElement() + smell.getCommit();

            if (!smellsSet.contains(smellAsText)){
                nonDuplicatedSmells.add(smell);
                smellsSet.add(smellAsText);
            }

        }

        smellCollector.writeCodeSmellsAsJson(nonDuplicatedSmells, newPath);

    }



}
