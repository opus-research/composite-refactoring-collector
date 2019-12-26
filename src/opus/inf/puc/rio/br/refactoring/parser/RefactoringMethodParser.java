package opus.inf.puc.rio.br.refactoring.parser;

import java.util.ArrayList;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringMethodParser extends RefactoringParser {
	
	
	public RefactoringMethodParser(String refactoringType, String refactoringDetails) {
		this.refactoringType = refactoringType;
		this.refactoringDetails = refactoringDetails;
		this.elements = new ArrayList<CodeElement>(); 
		
	}
	

	// Rename Method -> "Rename Method public shouldReplaceWithCAS() : void
	// renamed to public shouldReplaceWithFailingCAS() : void in class
	// com.couchbase.client.core.cluster.BinaryMessageTest"
	public void getMethodPattern1() {

		int startIndexOrigin = refactoringDetails.indexOf("Rename Method ");
		int lastIndexOrigin = refactoringDetails.indexOf("renamed to");

		String methodNameOrigin = refactoringDetails.substring(startIndexOrigin + "Rename Method ".length(),
				lastIndexOrigin);

		int startIndexNew = refactoringDetails.indexOf("renamed to");
		int lastIndexNew = refactoringDetails.indexOf("in class");

		String methodNameNew = refactoringDetails.substring(startIndexNew + "renamed to".length(), lastIndexNew);

		int startIndexClassName = refactoringDetails.indexOf("in class");
		String className = refactoringDetails.substring(startIndexClassName + "in class".length());

		CodeElement mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());


		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());

		CodeElement mainElement = element1;

		elements.add(element1);
		elements.add(element2);

	}

//		//Inline Method -> Inline Method	public create(properties CoreProperties) : DefaultCoreEnvironment 
//		// inlined to public create() : DefaultCoreEnvironment in class
	public void getMethodPattern2() {

		int startIndexOrigin = refactoringDetails.indexOf("Inline Method ");
		int lastIndexOrigin = refactoringDetails.indexOf("inlined to");

		String methodNameOrigin = refactoringDetails.substring(startIndexOrigin + "Inline Method ".length(),
				lastIndexOrigin);

		int startIndexNew = refactoringDetails.indexOf("inlined to");
		int lastIndexNew = refactoringDetails.indexOf("in class");

		String methodNameNew = refactoringDetails.substring(startIndexNew + "inlined to".length(), lastIndexNew);

		int startIndexClassName = refactoringDetails.indexOf("in class");
		String className = refactoringDetails.substring(startIndexClassName + "in class".length());

		CodeElement mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());

		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());

		CodeElement mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}

//		
//		//"Extract Method	protected doConnect(observable Subject<LifecycleState,LifecycleState>) : void 
//		//extracted from public connect() : Observable<LifecycleState>
//		// in class com.couchbase.client.core.endpoint.AbstractEndpoint"
	public void getMethodPattern3() {
		int startIndexNew = refactoringDetails.indexOf("Extract Method ");
		int lastIndexNew = refactoringDetails.indexOf("extracted from");

		String methodNameNew = refactoringDetails.substring(startIndexNew + "Extract Method ".length(), lastIndexNew);

		int startIndexOrigin = refactoringDetails.indexOf("extracted from");
		int lastIndexOrigin = refactoringDetails.indexOf("in class");

		String methodNameOrigin = refactoringDetails.substring(startIndexOrigin + "extracted from".length(),
				lastIndexOrigin);

		int startIndexClassName = refactoringDetails.indexOf("in class");
		String className = refactoringDetails.substring(startIndexClassName + "in class".length());

		CodeElement mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());


		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());

		CodeElement mainElement = element1;

		elements.add(element1);
		elements.add(element2);
		
		System.out.println(elements.size());

		
		
		
	}

//	Move Method	public bootstrapCarrierEnabled() : boolean from class com.couchbase.client.core.env.DynamicCoreProperties to public bootstrapCarrierEnabled() : boolean from class com.couchbase.client.core.env.DefaultCoreEnvironment
//	Push Down Method private buildResetGroup(parent Composite) : void from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog to protected createCustomArea(parent Composite) : void from class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog
//	Pull Up Method	public key() : String from class com.couchbase.client.core.message.binary.GetRequest  to public key() : String from class com.couchbase.client.core.message.binary.AbstractBinaryRequest

	public void getMethodPattern4() {
		int methodStartIndex = refactoringDetails.indexOf(refactoringType);
		int methodLastIndex = refactoringDetails.indexOf("from class");

		String methodName = refactoringDetails.substring(methodStartIndex + refactoringType.length(), methodLastIndex);

		int oldClassStartIndex = refactoringDetails.indexOf("from class");
		int oldClassLastIndex = refactoringDetails.indexOf(" to ");

		String oldClassName = refactoringDetails.substring(oldClassStartIndex + "from class".length(),
				oldClassLastIndex);

		int newMethodStartIndex = refactoringDetails.indexOf(" to ");
		int newMethodLastIndex = refactoringDetails.lastIndexOf("from class");
		String newMethodName = refactoringDetails.substring(newMethodStartIndex + " to ".length(), newMethodLastIndex);

		int newClassStartIndex = refactoringDetails.lastIndexOf("from class");

		String newClassName = refactoringDetails.substring(newClassStartIndex + "from class".length());

		CodeElement mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());


		CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
		CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());

		CodeElement mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}

}
