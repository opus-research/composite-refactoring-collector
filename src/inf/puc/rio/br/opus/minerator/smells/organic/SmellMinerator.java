package inf.puc.rio.br.opus.minerator.smells.organic;

import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import inf.puc.rio.br.opus.model.refactoring.historic.collect.commit.CommitCollector;

import java.util.List;

public class SmellMinerator {


    public void getSmellsFromCommits(List<String> commits){
        // Get composites
        // Get refactorings from composites
        // Get commits from refactorings
        // Get smells from commits running Organic
    }


    public static void main(String[] args) {
        SmellOrganic smellOrganic = new SmellOrganic();

        CommitCollector collector = new CommitCollector("okhttp", Constants.FOLDER_PROJECT, "master");
        List<Commit> commits = collector.getCommits();

        for (Commit commit : commits) {
            smellOrganic.colectSmells(commit.getCommit(), "C:\\Users\\anaca\\Documents");
        }

    }
}























