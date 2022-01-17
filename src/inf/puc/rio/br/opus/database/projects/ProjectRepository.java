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

    private void insertCommitByProjectName(String projectName, Commit commit){
        BasicDBObject query = new BasicDBObject();
        query.put("name", projectName);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("commits", commit);

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$push", newDocument);

        projects().updateOne(query, updateObject);
    }
}
