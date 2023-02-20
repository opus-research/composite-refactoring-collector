package inf.puc.rio.br.opus.minerator.smells.organic;

import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import inf.puc.rio.br.opus.model.refactoring.historic.collect.commit.CommitCollector;

import java.util.List;


public class SmellMinerator {

    public static void main(String[] args) {
        SmellOrganic smellOrganic = new SmellOrganic();

        Constants.PROJECT = args[0];
        Constants.BRANCH = args[1];
        Constants.OUTPUT = args[2];
        Constants.FOLDER_PROJECT = args[3];
        Constants.FOLDER_ORGANIC = args[4];

        System.out.println(args[0]);

        CommitCollector collector = new CommitCollector(Constants.PROJECT, Constants.FOLDER_PROJECT, Constants.BRANCH);
        List<Commit> commits = collector.getCommits();

        for (Commit commit : commits) {
            smellOrganic.collectSmells(commit.getCommit(), Constants.OUTPUT);
        }

    }
}























