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
        smellOrganic.colectSmells("1090348566dd5afd1f5a03477ccc3120167bd639", "C:\\Users\\anaca\\Documents");
       /*
        0680ed627d84f8107f590d6e3951c4c7db67635f
        CommitCollector collector = new CommitCollector("", "", "");
        List<Commit> commits = collector.getCommits();

        for (Commit commit : commits) {
            smellOrganic.colectSmells(commit.getCommit(), "");
        }*/

    }
}
