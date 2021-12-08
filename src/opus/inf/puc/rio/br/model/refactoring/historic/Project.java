package opus.inf.puc.rio.br.model.refactoring.historic;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

	private String projectName;
	
	@JsonProperty("commits")
	private List<String> commits;
	
	public Project(@JsonProperty("projectName") String projectName){
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}


	
}