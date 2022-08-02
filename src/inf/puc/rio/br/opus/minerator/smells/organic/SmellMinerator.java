package inf.puc.rio.br.opus.minerator.smells.organic;

import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import inf.puc.rio.br.opus.model.refactoring.historic.collect.commit.CommitCollector;

import java.util.List;

public class SmellMinerator {


    public static void main(String[] args) {
        SmellOrganic smellOrganic = new SmellOrganic();

        CommitCollector collector = new CommitCollector(Constants.PROJECT, Constants.FOLDER_PROJECT, Constants.BRANCH);
        List<Commit> commits = collector.getCommits();

        for (Commit commit : commits) {
            smellOrganic.colectSmells(commit.getCommit(), Constants.OUTPUT);
        }

    }
}























