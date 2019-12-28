package opus.inf.puc.rio.br.refactoring;

import java.util.ArrayList;
import java.util.List;

import opus.inf.puc.rio.br.historic.CodeElement;




public class Refactoring {
	
	public final String refactoringType;
	public final String refactoringId;
	public final String refactoringDetail;
	public final String currentCommit;
	public final String project;
	
	private String previousCommit;
	private List<CodeElement> elements;
    
	
	

	public Refactoring(String id, 
			           String project, 
			           String commit, 
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
	
	public String getPreviousCommit() {
		return previousCommit;
	}



	public void setPreviousCommit(String previousCommit) {
		// TODO Auto-generated method stub
		if(previousCommit == null) {
			this.previousCommit = previousCommit;		
		}
	    
	}
	
	


	
	

}




