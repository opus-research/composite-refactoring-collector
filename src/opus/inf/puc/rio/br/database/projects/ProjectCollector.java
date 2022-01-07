package opus.inf.puc.rio.br.database.projects;

import com.fasterxml.jackson.databind.ObjectMapper;
import opus.inf.puc.rio.br.model.project.Project;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;
import opus.inf.puc.rio.br.utils.AnalysisUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectCollector {
    private ProjectRepository projectRepository;

    private ProjectCollector(String[] args){
        projectRepository = new ProjectRepository(args);
    }
    public static void main(String[] args) {
        ProjectCollector collector = new ProjectCollector(args);
        List<Project> projects = collector.getAllProjects();
        collector.projectRepository.insertAllProjects(projects);
    }


    private List<Project> getAllProjects(){
        ObjectMapper mapper = new ObjectMapper();
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        List<String> projectFiles = AnalysisUtils.getAllFileNames("projects", ".json");
        try {

            for (String projectFile : projectFiles) {
                System.out.println(projectFile);
                project = mapper.readValue(new File(projectFile), Project.class);
                projectList.add(project);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return projectList;
    }
}
