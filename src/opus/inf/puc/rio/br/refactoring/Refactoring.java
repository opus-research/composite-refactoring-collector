package opus.inf.puc.rio.br.refactoring;

import java.util.ArrayList;
import java.util.List;

import opus.inf.puc.rio.br.historic.CodeElement;




public class Refactoring {
	
	private String refactoringType;
	public final String refactoringId;
	private String refactoringDetail;
	private List<CodeElement> elements;
	private CodeElement mainElement;
	private CodeElement mainElementCompletePath;
	private String currentCommit;
	private String previousCommit;
	private String sourceCodeElement;
	private String targetCodeElement;

	
	

	public Refactoring(String commit, 
					   String refactoringType, 
				       String refactoringDetail, 
				       String refactoringId){
		
		this.currentCommit = commit;
		this.refactoringType = refactoringType;
		this.refactoringDetail = refactoringDetail;
		this.elements = new ArrayList<>();
		this.refactoringId = refactoringId;
		
		
	}
	
	
	
	public void setCodeElements(){
	
		
	}
	


	public CodeElement getMainElementCompletePath() {
		// TODO Auto-generated method stub
		return mainElementCompletePath;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return refactoringType;
	}


	@Override
	public String toString() {
		return refactoringType;
	}
	
	public List<CodeElement> getElements(){
		return elements;
	}
	
	
	public CodeElement getMainElement() {
		return mainElement;
	}
	
	public String getCommit(){
		return currentCommit;
	}
	
	

	
	
	
	
	
	
	
	//"Rename Package	net.spy.memcached to com.couchbase.client"
	public void getElementRenamePackage(){
		int packageStartIndex = refactoringDetail.indexOf("Rename Package");
		int packageLastIndex = refactoringDetail.indexOf(" to ");
		
		String packageName = refactoringDetail.substring(packageStartIndex + "Rename Package".length() ,
				                                      packageLastIndex);
		
		int newPackageNameStartIndex = refactoringDetail.indexOf(" to ");
		
		String newPackageName = refactoringDetail.substring(newPackageNameStartIndex + " to ".length());
		
		mainElementCompletePath =  new CodeElement(null, null, null, packageName.trim());
		
        packageName = packageName.replaceAll("[^a-zA-Z0-9]+","");
		newPackageName = newPackageName.replaceAll("[^a-zA-Z0-9]+","");
		
		CodeElement element1 = new CodeElement(null, null, null, packageName.trim());
		CodeElement element2 = new CodeElement(null, null, null, newPackageName.trim());
	
		mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
	}
	
	


	
	

}




