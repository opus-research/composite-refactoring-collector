package inf.puc.rio.br.opus.model.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import org.bson.types.ObjectId;

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


	private String refactoringType;
	private String refactoringId;
	private String refactoringDetail;
	private Commit currentCommit;
	private String project;
	private ObjectId _id;

	@JsonProperty("elements")
	private List<CodeElement> elements;
    
	public Refactoring(
						@JsonProperty("_id") ObjectId _id,
						@JsonProperty("refactoringId") String refactoringId,
					    @JsonProperty("project") String project,
					    @JsonProperty("currentCommit") Commit commit,
					    @JsonProperty("refactoringType") String refactoringType,
					    @JsonProperty("refactoringDetail") String refactoringDetail){

		this._id = _id;
		this.refactoringId = refactoringId;
		this.project = project;
		this.currentCommit = commit;
		this.refactoringType = refactoringType;
		this.refactoringDetail = refactoringDetail;
		this.elements = new ArrayList<>();
	}

	public Refactoring(){

	}

	public void setRefactoringType(String refactoringType) {
		this.refactoringType = refactoringType;
	}

	public void setRefactoringId(String refactoringId) {
		this.refactoringId = refactoringId;
	}

	public void setRefactoringDetail(String refactoringDetail) {
		this.refactoringDetail = refactoringDetail;
	}

	public void setCurrentCommit(Commit currentCommit) {
		this.currentCommit = currentCommit;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
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




