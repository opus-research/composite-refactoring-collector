package opus.inf.puc.rio.br.historic;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.codecs.pojo.annotations.BsonProperty;



public class Project {

	@BsonProperty(value = "project_name")
	private String projectName;
	
	@BsonProperty(value = "commits")
	private List<String> commits;
	
	public Project(String projectName){
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}


	
}