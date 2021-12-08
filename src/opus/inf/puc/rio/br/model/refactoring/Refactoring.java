package opus.inf.puc.rio.br.model.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import opus.inf.puc.rio.br.model.refactoring.historic.CodeElement;
import opus.inf.puc.rio.br.model.refactoring.historic.Commit;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"refactoringType",
		"refactoringId",
		"refactoringDetail",
		"currentCommit",
		"project",
		"previousCommit",
		"elements"
})
public class Refactoring {


	public final String refactoringType;
	public final String refactoringId;
	public final String refactoringDetail;
	public final Commit currentCommit;
	public final String project;

	@JsonProperty("elements")
	private List<CodeElement> elements;
    
	public Refactoring(	@JsonProperty("refactoringId") String id,
					    @JsonProperty("project") String project,
					    @JsonProperty("currentCommit") Commit commit,
					    @JsonProperty("refactoringType") String refactoringType,
					    @JsonProperty("refactoringDetail") String refactoringDetail){
		
		this.refactoringId = id;
		this.project = project;
		this.currentCommit = commit;
		this.refactoringType = refactoringType;
		this.refactoringDetail = refactoringDetail;
		this.elements = new ArrayList<>();
	}

	@Override
	public String toString() {
		return refactoringType;
	}
	
	public List<CodeElement> getElements(){
		return elements;
	}
	
	public String getRefactoringType() {
		return refactoringType;
	}

	public String getRefactoringId() {
		return refactoringId;
	}

	public String getRefactoringDetail() {
		return refactoringDetail;
	}

	public Commit getCurrentCommit() {
		return currentCommit;
	}

	public String getProject() {
		return project;
	}

	@JsonProperty("elements")
	public void setElements(List<CodeElement> elements) {
		if(this.elements == null || this.elements.size() == 0) {
			this.elements = elements;
		}
	}

	public static boolean equalsToRefactoringType(String refType){

		for(RefactoringTypesEnum refTypeEnum : RefactoringTypesEnum.values()){
			List<String> refTypesList = new ArrayList<String>(Arrays.asList(refTypeEnum.toString().split(",")));

			for(String refTypeAsText : refTypesList) {

				if(refType.trim().equals(refTypeAsText.trim())) {
					return true;
				}
			}


		}
		return false;
	}
}




