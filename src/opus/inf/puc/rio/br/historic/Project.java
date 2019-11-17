package opus.inf.puc.rio.br.historic;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Project {

	private String projectName;
	private List<String> commits;
	
	public Project(String projectName){
		this.projectName = projectName;
	
	}

	public String getProjectName() {
		return projectName;
	}


	
}