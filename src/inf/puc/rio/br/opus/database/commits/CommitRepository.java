package inf.puc.rio.br.opus.database.commits;

import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.project.Commit;

import java.util.List;

public class CommitRepository extends Repository {

    public CommitRepository(String[] args){
        init(args);
    }

    public void insertAllCommits(List<Commit> commitList) {
        commits().insertMany(commitList);
    }
}
