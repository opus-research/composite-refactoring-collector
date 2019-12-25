package opus.inf.puc.rio.br.refactoring.parser;

import java.util.List;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringParser {

	protected List<CodeElement> elements;
	protected String refactoringDetails;
	protected String refactoringType;
	private RefactoringAttributeParser attributeParser;
	private RefactoringMethodParser methodParser;
	private RefactoringClassParser classParser;
	
	public RefactoringParser(String refactoringType, String details) {
		
		this.refactoringType = refactoringType;
		this.refactoringDetails = refactoringDetails;
	}

	public List<CodeElement> getCodeElements(){
		try {

			if (refactoringType != null) {
				
				//---------------ATTRIBUTE-----------------------------
				if (refactoringType.trim().equals("Move Attribute") ||
						refactoringType.trim().equals("Pull Up Attribute")	|| 
						refactoringType.trim().equals("Push Down Attribute")) {
						
						attributeParser.getAttributePattern1();
				} 
				
				if (refactoringType.trim().equals("Extract Variable") ||
						refactoringType.trim().equals("Inline Variable"))
						attributeParser.getAttributePattern2();
				} 
			
				if (refactoringType.trim().equals("Parameterize Variable") ||
						refactoringType.trim().equals("Rename Variable")   || 
						refactoringType.trim().equals("Rename Parameter")  || 
						refactoringType.trim().equals("Replace Variable")  || 
						refactoringType.trim().equals("Split Variable")    || 
						refactoringType.trim().equals("Change Variable Type")   ||
						refactoringType.trim().equals("Change Parameter Type")  ||
						refactoringType.trim().equals("Split Parameter")   ||
						refactoringType.trim().equals("Merge Variable")    || 
						refactoringType.trim().equals("Merge Parameter")) {
						attributeParser.getAttributePattern3();
				} 
				if (refactoringType.trim().equals("Rename Attribute") ||
				    refactoringType.trim().equals("Merge Attribute")  ||
					refactoringType.trim().equals("Split Attribute")  || 
					refactoringType.trim().equals("Change Attribute")) {
					attributeParser.getAttributePattern4();
				} 
				if (refactoringType.trim().equals("Replace Attribute")) {
					attributeParser.getAttributePattern5();
				}
				if (refactoringType.trim().equals("Extract Attribute")) {
					attributeParser.getAttributePattern6();
				}
				if (refactoringType.trim().equals("Change Return Type")) {
					attributeParser.getAttributePattern7();
				}
			


				

				//---------------METHOD -----------------------------
				if (refactoringType.trim().equals("Rename Method")) {
					methodParser.getMethodPattern1();
				} 
				if (refactoringType.trim().equals("Inline Method")) {
					methodParser.getMethodPattern2();
				}
				if (refactoringType.trim().equals("Extract Method")) {
					methodParser.getMethodPattern3();
				}
				if (refactoringType.trim().equals("Move Method") ||
					refactoringType.trim().equals("Pull Up Method")	|| 
					refactoringType.trim().equals("Push Down Method")) {
					methodParser.getMethodPattern4();
				} 
				
				
				//---------------CLASS -----------------------------
				if (refactoringType.trim().equals("Move Clss")) {
					classParser.getClassPattern1();
				} 
				if (refactoringType.trim().equals("Rename Class")) {
					classParser.getClassPattern2();
				}
				if (refactoringType.trim().equals("Extract Superclass") ||
					refactoringType.trim().equals("Extract Interface")	|| 
					refactoringType.trim().equals("Extract Class") || 
					refactoringType.trim().equals("Extract Subclass")) {
					classParser.getClassPattern3();
				} 

			
		}catch(IndexOutOfBoundsException e){
			System.out.println(refactoringType + " : " + e.getMessage());
	    }
      
		return elements;
	}

}