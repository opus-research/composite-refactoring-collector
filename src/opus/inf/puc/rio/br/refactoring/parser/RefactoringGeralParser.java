package opus.inf.puc.rio.br.refactoring.parser;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringGeralParser extends RefactoringParser {

	
	public RefactoringGeralParser(String refactoringType, String details) {
		super(refactoringType, details);
		// TODO Auto-generated constructor stub
	}

	//"Rename Package	net.spy.memcached to com.couchbase.client"
	public void getElementRenamePackage(){
		int packageStartIndex = refactoringDetails.indexOf("Rename Package");
		int packageLastIndex = refactoringDetails.indexOf(" to ");
		
		String packageName = refactoringDetails.substring(packageStartIndex + "Rename Package".length() ,
				                                      packageLastIndex);
		
		int newPackageNameStartIndex = refactoringDetails.indexOf(" to ");
		
		String newPackageName = refactoringDetails.substring(newPackageNameStartIndex + " to ".length());
		
		CodeElement mainElementCompletePath =  new CodeElement(null, null, null, packageName.trim());
		
        packageName = packageName.replaceAll("[^a-zA-Z0-9]+","");
		newPackageName = newPackageName.replaceAll("[^a-zA-Z0-9]+","");
		
		CodeElement element1 = new CodeElement(null, null, null, packageName.trim());
		CodeElement element2 = new CodeElement(null, null, null, newPackageName.trim());
	
		CodeElement mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
	}

}
