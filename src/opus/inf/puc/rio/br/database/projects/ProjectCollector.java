package opus.inf.puc.rio.br.database.projects;

import com.fasterxml.jackson.databind.ObjectMapper;
import opus.inf.puc.rio.br.model.project.Project;

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
        Project[] projects = new Project[0];
        try {

            projects = mapper.readValue(new File("junit4.json"), Project[].class);
            // List<Refactoring> auxRefList = new ArrayList<>(Arrays.asList(refactorings));
            projectList.addAll(Arrays.asList(projects));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return projectList;
    }
}
