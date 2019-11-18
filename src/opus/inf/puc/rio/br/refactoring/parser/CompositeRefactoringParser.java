package opus.inf.puc.rio.br.refactoring.parser;

import opus.inf.puc.rio.br.historic.CodeElement;

public class CompositeRefactoringParser {

	
	//"Extract And Move Method	public write(f File, body String) : void 
	//extracted from protected write(f File, body String) : void in class org.eclipse.jgit.junit.LocalDiskRepositoryTestCase 
	//& moved to class org.eclipse.jgit.junit.JGitTestUtil"
//	public void setSpecialExtractMethod() {
//		// TODO Auto-generated method stub
//		int startIndexNew = refactoringDetail.indexOf("Extract And Move Method ");
//		int lastIndexNew = refactoringDetail.indexOf("extracted from");
//		
//		String methodNameNew = refactoringDetail.substring(startIndexNew + "Extract And Move Method ".length() ,
//				                                           lastIndexNew);
//		
//		int startIndexOrigin = refactoringDetail.indexOf("extracted from");
//		int lastIndexOrigin = refactoringDetail.indexOf("in class");
//		
//		
//		String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "extracted from".length() ,
//	  													      lastIndexOrigin);
//		
//		int startIndexClassName = refactoringDetail.indexOf("in class");
//		int lastIndexClassName = refactoringDetail.indexOf("&");
//		
//		String className = refactoringDetail.substring(startIndexClassName + "in class".length(), 
//				                                       lastIndexClassName);
//		
//        mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//        
//		methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
//		className = className.replaceAll("[^a-zA-Z0-9]+","");
//		
//		methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
//	
//		
//		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
//	
//	    
//		mainElement = element1;
//		
//		elements.add(element1);
//		elements.add(element2);
//	}
//
//	//"Extract And Move Method	public write(f File, body String) : void 
//    //extracted from protected write(f File, body String) : void in class org.eclipse.jgit.junit.LocalDiskRepositoryTestCase 
//    //& moved to class org.eclipse.jgit.junit.JGitTestUtil"
//	public void setSpecialMoveMethod() {
//		// TODO Auto-generated method stub
//		int methodStartIndex = refactoringDetail.indexOf("Extract And Move Method ");
//		int methodLastIndex = refactoringDetail.indexOf("extracted from");
//		
//		String methodName = refactoringDetail.substring(methodStartIndex + "Extract And Move Method ".length() ,
//				                                              methodLastIndex);
//		
//		int oldClassStartIndex = refactoringDetail.indexOf("in class");
//		int oldClassLastIndex = refactoringDetail.indexOf("moved to class");
//		
//		
//		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "in class".length() ,
//														  oldClassLastIndex);
//		
//		int newClassStartIndex = refactoringDetail.lastIndexOf("moved to class");
//		
//		String newClassName = refactoringDetail.substring(newClassStartIndex + "moved to class".length());
//		
//		mainElementCompletePath =  new CodeElement(methodName.trim(), null, oldClassName.trim());
//		
//		methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
//		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//		
//		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//		
//		
//		CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
//		CodeElement element2 = new CodeElement(methodName.trim(), null, newClassName.trim());
//	
//		mainElement = element1;
//		elements.add(element1);
//		elements.add(element2);
//	}
}
