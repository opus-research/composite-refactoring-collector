package opus.inf.puc.rio.br.refactoring.parser;

import java.util.List;

import opus.inf.puc.rio.br.historic.CodeElement;

public abstract class RefactoringParser {
	
	
	private List<CodeElement> elements;
    protected String refactoringDetails;
	
	
	
	
	public List<CodeElement> getCodeElements(String refactoring type, String details){
		try {

			if (refactoringType != null) {
				if (refactoringType.trim().equals("Rename Method")) {
					getElementRenameMethod();
				} else if (refactoringType.trim().equals("Extract Method")) {
					getElementExtractMethod();
				} else if (refactoringType.trim().equals("Move Method")) {
					getElementMoveMethod();
				} else if (refactoringType.trim().equals("Inline Method")) {
					getElementInlineMethod();
				} else if (refactoringType.trim().equals("Pull Up Method")) {
					getElementPullUpMethod();
				} else if (refactoringType.trim().equals("Push Down Method")) {
					getElementPushDownMethod();
				} else if (refactoringType.trim().equals("Push Down Attribute")) {
					getElementPushDownAttribute();
				} else if (refactoringType.trim().equals("Pull Up Attribute")) {
					getElementPullUpAttribute();
				} else if (refactoringType.trim().equals("Move Attribute")) {
					getElementMoveAttribute();
				} else if (refactoringType.trim().equals("Move Class")) {
					getElementMoveClass();
				} else if (refactoringType.trim().equals("Rename Class")) {
					getElementRenameClass();
				} else if (refactoringType.trim().equals("Rename Package")) {
					getElementRenamePackage();
				} else if (refactoringType.trim().equals("Extract Superclass")) {
					getElementExtractSuperClass();
				} else if (refactoringType.trim().equals("Extract Interface")) {
					getElementExtractInterface();
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(refactoringType + " : " + e.getMessage());
		}
	}

	

} 