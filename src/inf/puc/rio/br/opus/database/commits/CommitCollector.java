package inf.puc.rio.br.opus.database.commits;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.model.project.Commit;
import inf.puc.rio.br.opus.utils.AnalysisUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommitCollector {

    private CommitRepository commitRepository;

    private CommitCollector(String[] args){
        commitRepository = new CommitRepository(args);
    }
    public static void main(String[] args) {
        CommitCollector collector = new CommitCollector(args);
        List<Commit> commits = collector.getCommits();
        collector.commitRepository.insertAllCommits(commits);
    }


    private List<Commit> getCommits(){
        ObjectMapper mapper = new ObjectMapper();
        List<Commit> commitList = new ArrayList<>();
        Commit commit = new Commit();
        List<String> commitFiles = AnalysisUtils.getAllFileNames("commits", ".json");
        try {

            for (String commitFile : commitFiles) {
                System.out.println(commitFile);
                commit = mapper.readValue(new File(commitFile), Commit.class);
                commitList.add(commit);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return commitList;
    }
}
