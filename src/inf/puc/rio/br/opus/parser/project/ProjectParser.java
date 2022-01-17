package inf.puc.rio.br.opus.parser.project;

import inf.puc.rio.br.opus.model.project.Commit;
import inf.puc.rio.br.opus.model.project.Project;
import inf.puc.rio.br.opus.model.project.miner.CommitMiner;
import inf.puc.rio.br.opus.model.project.miner.ProjectMiner;


public class ProjectParser {

    public ProjectParser() { }

    public Project parserProjectMinerToProject(ProjectMiner projectMiner){
        Project project = new Project(projectMiner.getName());
        return project;
    }

    public Commit parserCommitMinerToCommit(CommitMiner commitMiner, String projectName){

        Commit commit = new Commit(projectName,
                                  commitMiner.getAuthorName(),
                                  commitMiner.getAuthorEmail(),
                                  commitMiner.getAuthorTimeZone(),
                                  commitMiner.getCommitterName(),
                                  commitMiner.getCommitterEmail(),
                                  commitMiner.getCommitterTimeZone(),
                                  commitMiner.getNumberOfBranches(),
                                  commitMiner.getHash(),
                                  commitMiner.getMsg(),
                                  commitMiner.getModifiedFiles(),
                                  commitMiner.getDate(),
                                  commitMiner.getNumberOfModifiedFiles());

        return commit;
    }
}
