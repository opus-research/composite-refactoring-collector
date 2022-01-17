package inf.puc.rio.br.opus.database.projects;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.database.commits.CommitRepository;
import inf.puc.rio.br.opus.model.project.Commit;
import inf.puc.rio.br.opus.model.project.Project;
import inf.puc.rio.br.opus.model.project.miner.CommitMiner;
import inf.puc.rio.br.opus.model.project.miner.ProjectMiner;
import inf.puc.rio.br.opus.parser.project.ProjectParser;
import inf.puc.rio.br.opus.utils.AnalysisUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectCollector {
    private ProjectRepository projectRepository;
    private CommitRepository commitRepository;
    private ProjectParser parser;

    private ProjectCollector(String[] args){

        projectRepository = new ProjectRepository(args);
        commitRepository = new CommitRepository(args);
        parser = new ProjectParser();
    }

    public static void main(String[] args) {
        ProjectCollector collector = new ProjectCollector(args);
        collector.getProject();

    }


    private List<Project> getProject(){
        ObjectMapper mapper = new ObjectMapper();
        List<ProjectMiner> projectMinerList;
        List<Project> projectList = new ArrayList<>();
        List<String> projectFiles = AnalysisUtils.getAllFileNames("projects", ".json");
        List<Commit> commitList = new ArrayList<>();
        try {

            for (String projectFile : projectFiles) {
                System.out.println(projectFile);
                ProjectMiner projectMiner = mapper.readValue(new File(projectFile), ProjectMiner.class);
                List<CommitMiner> commitMinerList = projectMiner.getCommits();

                Project project = parser.parserProjectMinerToProject(projectMiner);
                projectList.add(project);

                for (CommitMiner commitMiner : commitMinerList) {
                    Commit commit = parser.parserCommitMinerToCommit(commitMiner, project.getName());
                    commitList.add(commit);
                }
            }

            projectRepository.insertAllProjects(projectList);
            commitRepository.insertAllCommits(commitList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return projectList;
    }
}
