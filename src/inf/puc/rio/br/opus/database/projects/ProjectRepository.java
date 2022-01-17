package inf.puc.rio.br.opus.database.projects;

import com.mongodb.BasicDBObject;
import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.project.Commit;
import inf.puc.rio.br.opus.model.project.Project;

import java.util.List;

public class ProjectRepository extends Repository {

    public ProjectRepository(String[] args){
        init(args);
    }

    public void insertAllProjects(List<Project> projectList) {

        projects().insertMany(projectList);
    }

}
