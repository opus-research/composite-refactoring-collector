package opus.inf.puc.rio.br.database.projects;

import opus.inf.puc.rio.br.database.Repository;
import opus.inf.puc.rio.br.model.project.Project;

import java.util.List;

public class ProjectRepository extends Repository {

    public ProjectRepository(String[] args){
        init(args);
    }

    public void insertAllProjects(List<Project> projectListList) {
        projects().insertMany(projectListList);
    }
}
