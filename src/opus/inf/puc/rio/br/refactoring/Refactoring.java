package opus.inf.puc.rio.br.refactoring;

import java.util.ArrayList;
import java.util.List;

import opus.inf.puc.rio.br.historic.CodeElement;




public class Refactoring {
	
	private String refactoringType;
	public final String refactoringId;
	private String refactoringDetail;
	private String commit;
	private List<CodeElement> elements;
	private CodeElement mainElement;
	private CodeElement mainElementCompletePath;
	private String currentCommit;
	private int orderCommit;
	private String previousCommit;

	
	

	public Refactoring(String commit, 
					   String refactoringType, 
				       String refactoringDetail, 
				       String refactoringId){
		
		this.commit = commit;
		this.refactoringType = refactoringType;
		this.refactoringDetail = refactoringDetail;
		this.elements = new ArrayList<>();
		this.refactoringId = refactoringId;
		
		
	}
	
	
	
	public void setCodeElements(){
	
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
		return commit;
	}
	
	

	//Rename Method  -> "Rename Method	public shouldReplaceWithCAS() : void 
	//renamed to public shouldReplaceWithFailingCAS() : void in class com.couchbase.client.core.cluster.BinaryMessageTest"
	public void getElementRenameMethod(){
		
		int startIndexOrigin = refactoringDetail.indexOf("Rename Method ");
		int lastIndexOrigin = refactoringDetail.indexOf("renamed to");
		
		String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "Rename Method ".length() ,
				                                              lastIndexOrigin);
		
		int startIndexNew = refactoringDetail.indexOf("renamed to");
		int lastIndexNew = refactoringDetail.indexOf("in class");
		
		
		String methodNameNew = refactoringDetail.substring(startIndexNew + "renamed to".length() ,
	  													   lastIndexNew);
		
		int startIndexClassName = refactoringDetail.indexOf("in class");
		String className = refactoringDetail.substring(startIndexClassName + "in class".length());
	
	    mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		
	    methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		
		methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
		
		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
	    
		mainElement = element1;
	    
		elements.add(element1);
		elements.add(element2);
		
	}
	
	//Inline Method -> Inline Method	public create(properties CoreProperties) : DefaultCoreEnvironment 
	// inlined to public create() : DefaultCoreEnvironment in class
	public void getElementInlineMethod(){
	    
		int startIndexOrigin = refactoringDetail.indexOf("Inline Method ");
		int lastIndexOrigin = refactoringDetail.indexOf("inlined to");
		
		String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "Inline Method ".length() ,
				                                              lastIndexOrigin);
		
		int startIndexNew = refactoringDetail.indexOf("inlined to");
		int lastIndexNew = refactoringDetail.indexOf("in class");
		
		
		String methodNameNew = refactoringDetail.substring(startIndexNew + "inlined to".length() ,
	  													   lastIndexNew);
		
		int startIndexClassName = refactoringDetail.indexOf("in class");
		String className = refactoringDetail.substring(startIndexClassName + "in class".length());
		
		mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		
		methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		
		methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
		
		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	//"Extract Method	protected doConnect(observable Subject<LifecycleState,LifecycleState>) : void 
	//extracted from public connect() : Observable<LifecycleState>
	// in class com.couchbase.client.core.endpoint.AbstractEndpoint"
	public void getElementExtractMethod(){
		int startIndexNew = refactoringDetail.indexOf("Extract Method ");
		int lastIndexNew = refactoringDetail.indexOf("extracted from");
		
		String methodNameNew = refactoringDetail.substring(startIndexNew + "Extract Method ".length() ,
				                                           lastIndexNew);
		
		int startIndexOrigin = refactoringDetail.indexOf("extracted from");
		int lastIndexOrigin = refactoringDetail.indexOf("in class");
		
		
		String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "extracted from".length() ,
	  													   lastIndexOrigin);
		
		int startIndexClassName = refactoringDetail.indexOf("in class");
		String className = refactoringDetail.substring(startIndexClassName + "in class".length());
		
		mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		
		methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		
		methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
		
		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
	
		mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
	}
	
	//"Move Method	public bootstrapCarrierEnabled() : boolean 
	//from class com.couchbase.client.core.env.DynamicCoreProperties to public bootstrapCarrierEnabled() : 
	//boolean from class com.couchbase.client.core.env.DefaultCoreEnvironment"
	public void getElementMoveMethod(){
		int methodStartIndex = refactoringDetail.indexOf("Move Method ");
		int methodLastIndex = refactoringDetail.indexOf("from class");
		
		String methodName = refactoringDetail.substring(methodStartIndex + "Move Method ".length() ,
				                                              methodLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("from class");
		int oldClassLastIndex = refactoringDetail.indexOf(" to ");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
														  oldClassLastIndex);
		
		int newMethodStartIndex = refactoringDetail.indexOf(" to ");
		int newMethodLastIndex = refactoringDetail.lastIndexOf("from class");
		String newMethodName = refactoringDetail.substring(newMethodStartIndex + " to ".length() ,
                										   newMethodLastIndex);

		int newClassStartIndex = refactoringDetail.lastIndexOf("from class");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + "from class".length());
		
		mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());
		
		methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		newMethodName = newMethodName.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
		CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	//"Push Down Method	private buildResetGroup(parent Composite) : void
	// from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog
	// to protected createCustomArea(parent Composite) : void from class
	// org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
	public void getElementPushDownMethod(){
		int methodStartIndex = refactoringDetail.indexOf("Push Down Method ");
		int methodLastIndex = refactoringDetail.indexOf("from class");
		
		String methodName = refactoringDetail.substring(methodStartIndex + "Push Down Method ".length() ,
				                                              methodLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("from class");
		int oldClassLastIndex = refactoringDetail.indexOf(" to ");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
														  oldClassLastIndex);
		
		int newMethodStartIndex = refactoringDetail.indexOf(" to ");
		int newMethodLastIndex = refactoringDetail.lastIndexOf("from class");
		String newMethodName = refactoringDetail.substring(newMethodStartIndex + " to ".length() ,
                										   newMethodLastIndex);

		int newClassStartIndex = refactoringDetail.lastIndexOf("from class");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + "from class".length());
	
		mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());
		
		methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		newMethodName = newMethodName.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
		CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	//"Pull Up Method	public key() : String from class com.couchbase.client.core.message.binary.GetRequest 
	//to public key() : String from class com.couchbase.client.core.message.binary.AbstractBinaryRequest"
	public void getElementPullUpMethod(){
		int methodStartIndex = refactoringDetail.indexOf("Pull Up Method ");
		int methodLastIndex = refactoringDetail.indexOf("from class");
		
		String methodName = refactoringDetail.substring(methodStartIndex + "Pull Up Method ".length() ,
				                                              methodLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("from class");
		int oldClassLastIndex = refactoringDetail.indexOf(" to ");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
														  oldClassLastIndex);
		
		int newMethodStartIndex = refactoringDetail.indexOf(" to ");
		int newMethodLastIndex = refactoringDetail.lastIndexOf("from class");
		String newMethodName = refactoringDetail.substring(newMethodStartIndex + " to ".length() ,
                										   newMethodLastIndex);

		int newClassStartIndex = refactoringDetail.lastIndexOf("from class");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + "from class".length());
		
		mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());
		
		methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		newMethodName = newMethodName.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
		CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	
	// "Push Down Attribute	private resetType : ResetType from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog 
	// to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
	public void getElementPushDownAttribute(){
		int attributeStartIndex = refactoringDetail.indexOf("Push Down Attribute ");
		int attributeLastIndex = refactoringDetail.indexOf("from class");
		
		String attributeName = refactoringDetail.substring(attributeStartIndex + "Push Down Attribute ".length() ,
														attributeLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("from class");
		int oldClassLastIndex = refactoringDetail.indexOf(" to ");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
														  oldClassLastIndex);
		
	
		int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
		
		mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
		
		attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		
		CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
		CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	// "Pull Up Attribute	private password : 
	// String from class com.couchbase.client.core.message.cluster.OpenBucketRequest 
	//to class com.couchbase.client.core.message.AbstractCouchbaseRequest"
	public void getElementPullUpAttribute(){
		int attributeStartIndex = refactoringDetail.indexOf("Pull Up Attribute ");
		int attributeLastIndex = refactoringDetail.indexOf("from class");
		
		String attributeName = refactoringDetail.substring(attributeStartIndex + "Pull Up Attribute ".length() ,
														attributeLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("from class");
		int oldClassLastIndex = refactoringDetail.indexOf(" to ");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
														  oldClassLastIndex);
		
	
		int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
	
		mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
		
		
		attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
		CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	//"Move Attribute	public SSL_ENABLED : boolean
	//from class com.couchbase.client.core.env.DefaultCoreProperties 
	//to class com.couchbase.client.core.env.DefaultCoreEnvironment"
	public void getElementMoveAttribute(){
		int attributeStartIndex = refactoringDetail.indexOf("Move Attribute ");
		int attributeLastIndex = refactoringDetail.indexOf("from class");
		
		String attributeName = refactoringDetail.substring(attributeStartIndex + "Move Attribute ".length() ,
														attributeLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("from class");
		int oldClassLastIndex = refactoringDetail.indexOf(" to ");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
														  oldClassLastIndex);
		
	
		int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
		
		mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
		
		attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
		CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
	
		mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
	}
	
	//Move Class	com.couchbase.client.core.service.SelectionStrategy 
	// moved to com.couchbase.client.core.service.strategies.SelectionStrategy
	public void getElementMoveClass(){
		int classStartIndex = refactoringDetail.indexOf("Move Class ");
		int classLastIndex = refactoringDetail.indexOf("moved to");
		
		String className = refactoringDetail.substring(classStartIndex + "Move Class ".length() ,
														classLastIndex);
		
		int newClassNameStartIndex = refactoringDetail.indexOf("moved to");
		
		String newClassName = refactoringDetail.substring(newClassNameStartIndex + "moved to".length());
		
		mainElementCompletePath =  new CodeElement(null, null, className.trim());
		
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(null, null, className.trim());
		CodeElement element2 = new CodeElement(null, null, newClassName.trim());
	
		mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
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
	
	//"Rename Class	net.spy.memcached.MembaseClient renamed to com.couchbase.client.CouchbaseClient"
	public void getElementRenameClass(){
		int classStartIndex = refactoringDetail.indexOf("Rename Class ");
		int classLastIndex = refactoringDetail.indexOf("renamed to");
		
		String className = refactoringDetail.substring(classStartIndex + "Rename Class ".length() ,
														classLastIndex);
		
		int newClassNameStartIndex = refactoringDetail.indexOf("renamed to");
		
		String newClassName = refactoringDetail.substring(newClassNameStartIndex + "renamed to".length());
		
		mainElementCompletePath = new CodeElement(null, null, className.trim());
		
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		CodeElement element1 = new CodeElement(null, null, className.trim());
		CodeElement element2 = new CodeElement(null, null, newClassName.trim());
	
		mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
	}
	
	//"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse 
	// from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse, com.couchbase.client.core.message.binary.GetResponse, com.couchbase.client.core.message.binary.UpsertResponse, com.couchbase.client.core.message.cluster.SeedNodesResponse]"
	public void getElementExtractSuperClass(){
		int classStartIndex = refactoringDetail.indexOf("Extract Superclass ");
		int classLastIndex = refactoringDetail.indexOf("from classes");
		
		String className = refactoringDetail.substring(classStartIndex + "Extract Superclass ".length() ,
													   classLastIndex);
	
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		
        CodeElement element1 = new CodeElement(null, null, className.trim());
		
        
		elements.add(element1);
		mainElementCompletePath = new CodeElement(null, null, className.trim());
		
		int extractedClassesStartIndex = refactoringDetail.indexOf("[");
		int extractedClassesLastIndex = refactoringDetail.indexOf("]");
		
		String extractedClassesList = refactoringDetail.substring(extractedClassesStartIndex + 1, 
																  extractedClassesLastIndex - 1);
		String[] extractedClasses = extractedClassesList.split(",");	
	    
		for(int i = 0; i < extractedClasses.length; i++) {
			
			String oldClassName = extractedClasses[i];
			
			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
			
			CodeElement element = new CodeElement(null, null, oldClassName.trim());
			elements.add(element);
			
		}	
		mainElement = element1;
	}
	
	//Extract Interface	com.couchbase.client.core.message.binary.BinaryStoreRequest 
	// from classes [com.couchbase.client.core.message.binary.InsertRequest,
	// com.couchbase.client.core.message.binary.InsertA]
	public void getElementExtractInterface(){
		int classStartIndex = refactoringDetail.indexOf("Extract Interface ");
		int classLastIndex = refactoringDetail.indexOf("from classes");
		
		String className = refactoringDetail.substring(classStartIndex + "Extract Interface ".length() ,
													   classLastIndex);
		
		className = className.replaceAll("[^a-zA-Z0-9]+","");
        CodeElement element1 = new CodeElement(null, null, className.trim());
		
        mainElementCompletePath = new CodeElement(null, null, className.trim());
	
        elements.add(element1);
		int extractedClassesStartIndex = refactoringDetail.indexOf("[");
		int extractedClassesLastIndex = refactoringDetail.indexOf("]");
		
		String extractedClassesList = refactoringDetail.substring(extractedClassesStartIndex + 1, 
															      extractedClassesLastIndex );
		String[] extractedClasses = extractedClassesList.split(",");	
	    
		
		for(int i = 0; i < extractedClasses.length; i++) {
			
			String oldClassName = extractedClasses[i];
			
			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
			
			CodeElement element = new CodeElement(null, null, oldClassName.trim());
			elements.add(element);
			
		}
		mainElement = element1;
	}

	//"Extract And Move Method	public write(f File, body String) : void 
	//extracted from protected write(f File, body String) : void in class org.eclipse.jgit.junit.LocalDiskRepositoryTestCase 
	//& moved to class org.eclipse.jgit.junit.JGitTestUtil"
	public void setSpecialExtractMethod() {
		// TODO Auto-generated method stub
		int startIndexNew = refactoringDetail.indexOf("Extract And Move Method ");
		int lastIndexNew = refactoringDetail.indexOf("extracted from");
		
		String methodNameNew = refactoringDetail.substring(startIndexNew + "Extract And Move Method ".length() ,
				                                           lastIndexNew);
		
		int startIndexOrigin = refactoringDetail.indexOf("extracted from");
		int lastIndexOrigin = refactoringDetail.indexOf("in class");
		
		
		String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "extracted from".length() ,
	  													      lastIndexOrigin);
		
		int startIndexClassName = refactoringDetail.indexOf("in class");
		int lastIndexClassName = refactoringDetail.indexOf("&");
		
		String className = refactoringDetail.substring(startIndexClassName + "in class".length(), 
				                                       lastIndexClassName);
		
        mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
        
		methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
		className = className.replaceAll("[^a-zA-Z0-9]+","");
		
		methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
	
		
		CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
		CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
	
	    
		mainElement = element1;
		
		elements.add(element1);
		elements.add(element2);
	}

	//"Extract And Move Method	public write(f File, body String) : void 
    //extracted from protected write(f File, body String) : void in class org.eclipse.jgit.junit.LocalDiskRepositoryTestCase 
    //& moved to class org.eclipse.jgit.junit.JGitTestUtil"
	public void setSpecialMoveMethod() {
		// TODO Auto-generated method stub
		int methodStartIndex = refactoringDetail.indexOf("Extract And Move Method ");
		int methodLastIndex = refactoringDetail.indexOf("extracted from");
		
		String methodName = refactoringDetail.substring(methodStartIndex + "Extract And Move Method ".length() ,
				                                              methodLastIndex);
		
		int oldClassStartIndex = refactoringDetail.indexOf("in class");
		int oldClassLastIndex = refactoringDetail.indexOf("moved to class");
		
		
		String oldClassName = refactoringDetail.substring(oldClassStartIndex + "in class".length() ,
														  oldClassLastIndex);
		
		int newClassStartIndex = refactoringDetail.lastIndexOf("moved to class");
		
		String newClassName = refactoringDetail.substring(newClassStartIndex + "moved to class".length());
		
		mainElementCompletePath =  new CodeElement(methodName.trim(), null, oldClassName.trim());
		
		methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
		oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
		
		
		CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
		CodeElement element2 = new CodeElement(methodName.trim(), null, newClassName.trim());
	
		mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}
	
	

}




