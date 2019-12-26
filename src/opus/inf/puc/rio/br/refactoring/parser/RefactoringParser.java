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

	public List<CodeElement> getCodeElements(String refactoringType, String details) {

		attributeParser = new RefactoringAttributeParser(refactoringType, details);
		methodParser = new RefactoringMethodParser(refactoringType, details);
		classParser = new RefactoringClassParser(refactoringType, details);
		System.out.println("estou aqui");
		System.out.println(refactoringType);

		try {

			if (refactoringType != null) {

				// ---------------ATTRIBUTE-----------------------------
				if (refactoringType.trim().equals("Move Attribute")
						|| refactoringType.trim().equals("Pull Up Attribute")
						|| refactoringType.trim().equals("Push Down Attribute")) {

					attributeParser.getAttributePattern1();
					return attributeParser.elements;
				}

				if (refactoringType.trim().equals("Extract Variable")
						|| refactoringType.trim().equals("Inline Variable")) {
					attributeParser.getAttributePattern2();
					return attributeParser.elements;
				}

				if (refactoringType.trim().equals("Parameterize Variable")
						|| refactoringType.trim().equals("Rename Variable")
						|| refactoringType.trim().equals("Rename Parameter")
						|| refactoringType.trim().equals("Replace Variable")
						|| refactoringType.trim().equals("Split Variable")
						|| refactoringType.trim().equals("Change Variable Type")
						|| refactoringType.trim().equals("Change Parameter Type")
						|| refactoringType.trim().equals("Split Parameter")
						|| refactoringType.trim().equals("Merge Variable")
						|| refactoringType.trim().equals("Merge Parameter")) {
					attributeParser.getAttributePattern3();
					return attributeParser.elements;
				}
				if (refactoringType.trim().equals("Rename Attribute")
						|| refactoringType.trim().equals("Merge Attribute")
						|| refactoringType.trim().equals("Split Attribute")
						|| refactoringType.trim().equals("Change Attribute")) {
					attributeParser.getAttributePattern4();
					return attributeParser.elements;
				}
				if (refactoringType.trim().equals("Replace Attribute")) {
					attributeParser.getAttributePattern5();
					return attributeParser.elements;
				}
				if (refactoringType.trim().equals("Extract Attribute")) {
					attributeParser.getAttributePattern6();
					return attributeParser.elements;
				}
				if (refactoringType.trim().equals("Change Return Type")) {
					attributeParser.getAttributePattern7();
					return attributeParser.elements;
				}

				// ---------------METHOD -----------------------------
				if (refactoringType.trim().equals("Rename Method")) {
					methodParser.getMethodPattern1();
					return methodParser.elements;
				}
				if (refactoringType.trim().equals("Inline Method")) {
					methodParser.getMethodPattern2();
					return methodParser.elements;
				}
				if (refactoringType.trim().equals("Extract Method")) {
					
					methodParser.getMethodPattern3();

					System.out.println(methodParser.elements.size());
					return methodParser.elements;
				}
				if (refactoringType.trim().equals("Move Method") || refactoringType.trim().equals("Pull Up Method")
						|| refactoringType.trim().equals("Push Down Method")) {
					methodParser.getMethodPattern4();
					return methodParser.elements;
				}

				// ---------------CLASS -----------------------------
				if (refactoringType.trim().equals("Move Clss")) {
					classParser.getClassPattern1();
					return classParser.elements;
				}
				if (refactoringType.trim().equals("Rename Class")) {
					classParser.getClassPattern2();
					return classParser.elements;
				}
				if (refactoringType.trim().equals("Extract Superclass")
						|| refactoringType.trim().equals("Extract Interface")
						|| refactoringType.trim().equals("Extract Class")
						|| refactoringType.trim().equals("Extract Subclass")) {
					classParser.getClassPattern3();
					return classParser.elements;
				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(refactoringType + " : " + e.getMessage());
		}

		return elements;
	}

}