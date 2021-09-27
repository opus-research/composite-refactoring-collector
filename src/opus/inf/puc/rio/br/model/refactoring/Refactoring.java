package opus.inf.puc.rio.br.model.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import opus.inf.puc.rio.br.model.historic.CodeElement;
import opus.inf.puc.rio.br.model.historic.Commit;

public class Refactoring {
	
	public final String refactoringType;
	public final String refactoringId;
	public final String refactoringDetail;
	public final Commit currentCommit;
	public final String project;
	
	private List<CodeElement> elements;
    
	public Refactoring(String id, 
			           String project, 
			           Commit commit, 
					   String refactoringType, 
				       String refactoringDetail){
		
		this.refactoringId = id;
		this.project = project;
		this.currentCommit = commit;
		this.refactoringType = refactoringType;
		this.refactoringDetail = refactoringDetail;
		this.elements = new ArrayList<>();
	}
	
	public void setCodeElements(List<CodeElement> elements){
		
	   if(this.elements == null || this.elements.size() == 0) {
		   this.elements = elements;
	   }
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

	public void setElements(List<CodeElement> elements) {
		this.elements = elements;
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




