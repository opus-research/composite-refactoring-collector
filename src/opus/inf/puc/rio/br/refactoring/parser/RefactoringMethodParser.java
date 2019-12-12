package opus.inf.puc.rio.br.refactoring.parser;

public class RefactoringMethodParser extends RefactoringParser{
	//Rename Method  -> "Rename Method	public shouldReplaceWithCAS() : void 
		//renamed to public shouldReplaceWithFailingCAS() : void in class com.couchbase.client.core.cluster.BinaryMessageTest"
//		public void getElementRenameMethod(){
//			
//			int startIndexOrigin = refactoringDetail.indexOf("Rename Method ");
//			int lastIndexOrigin = refactoringDetail.indexOf("renamed to");
//			
//			String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "Rename Method ".length() ,
//					                                              lastIndexOrigin);
//			
//			int startIndexNew = refactoringDetail.indexOf("renamed to");
//			int lastIndexNew = refactoringDetail.indexOf("in class");
//			
//			
//			String methodNameNew = refactoringDetail.substring(startIndexNew + "renamed to".length() ,
//		  													   lastIndexNew);
//			
//			int startIndexClassName = refactoringDetail.indexOf("in class");
//			String className = refactoringDetail.substring(startIndexClassName + "in class".length());
//		
//		    mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//			
//		    methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//			
//			methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
//			
//			CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//			CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
//		    
//			mainElement = element1;
//		    
//			elements.add(element1);
//			elements.add(element2);
//			
//		}
//		
//		//Inline Method -> Inline Method	public create(properties CoreProperties) : DefaultCoreEnvironment 
//		// inlined to public create() : DefaultCoreEnvironment in class
//		public void getElementInlineMethod(){
//		    
//			int startIndexOrigin = refactoringDetail.indexOf("Inline Method ");
//			int lastIndexOrigin = refactoringDetail.indexOf("inlined to");
//			
//			String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "Inline Method ".length() ,
//					                                              lastIndexOrigin);
//			
//			int startIndexNew = refactoringDetail.indexOf("inlined to");
//			int lastIndexNew = refactoringDetail.indexOf("in class");
//			
//			
//			String methodNameNew = refactoringDetail.substring(startIndexNew + "inlined to".length() ,
//		  													   lastIndexNew);
//			
//			int startIndexClassName = refactoringDetail.indexOf("in class");
//			String className = refactoringDetail.substring(startIndexClassName + "in class".length());
//			
//			mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//			
//			methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//			
//			methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
//			
//			CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//			CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Extract Method	protected doConnect(observable Subject<LifecycleState,LifecycleState>) : void 
//		//extracted from public connect() : Observable<LifecycleState>
//		// in class com.couchbase.client.core.endpoint.AbstractEndpoint"
//		public void getElementExtractMethod(){
//			int startIndexNew = refactoringDetail.indexOf("Extract Method ");
//			int lastIndexNew = refactoringDetail.indexOf("extracted from");
//			
//			String methodNameNew = refactoringDetail.substring(startIndexNew + "Extract Method ".length() ,
//					                                           lastIndexNew);
//			
//			int startIndexOrigin = refactoringDetail.indexOf("extracted from");
//			int lastIndexOrigin = refactoringDetail.indexOf("in class");
//			
//			
//			String methodNameOrigin = refactoringDetail.substring(startIndexOrigin + "extracted from".length() ,
//		  													   lastIndexOrigin);
//			
//			int startIndexClassName = refactoringDetail.indexOf("in class");
//			String className = refactoringDetail.substring(startIndexClassName + "in class".length());
//			
//			mainElementCompletePath = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//			
//			methodNameOrigin = methodNameOrigin.replaceAll("[^a-zA-Z0-9]+","");
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//			
//			methodNameNew = methodNameNew.replaceAll("[^a-zA-Z0-9]+","");
//			
//			CodeElement element1 = new CodeElement(methodNameOrigin.trim(), null, className.trim());
//			CodeElement element2 = new CodeElement(methodNameNew.trim(), null, className.trim());
//		
//			mainElement = element1;
//			
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Move Method	public bootstrapCarrierEnabled() : boolean 
//		//from class com.couchbase.client.core.env.DynamicCoreProperties to public bootstrapCarrierEnabled() : 
//		//boolean from class com.couchbase.client.core.env.DefaultCoreEnvironment"
//		public void getElementMoveMethod(){
//			int methodStartIndex = refactoringDetail.indexOf("Move Method ");
//			int methodLastIndex = refactoringDetail.indexOf("from class");
//			
//			String methodName = refactoringDetail.substring(methodStartIndex + "Move Method ".length() ,
//					                                              methodLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//			int newMethodStartIndex = refactoringDetail.indexOf(" to ");
//			int newMethodLastIndex = refactoringDetail.lastIndexOf("from class");
//			String newMethodName = refactoringDetail.substring(newMethodStartIndex + " to ".length() ,
//	                										   newMethodLastIndex);
//
//			int newClassStartIndex = refactoringDetail.lastIndexOf("from class");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + "from class".length());
//			
//			mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());
//			
//			methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			newMethodName = newMethodName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
//			CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Push Down Method	private buildResetGroup(parent Composite) : void
//		// from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog
//		// to protected createCustomArea(parent Composite) : void from class
//		// org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
//		public void getElementPushDownMethod(){
//			int methodStartIndex = refactoringDetail.indexOf("Push Down Method ");
//			int methodLastIndex = refactoringDetail.indexOf("from class");
//			
//			String methodName = refactoringDetail.substring(methodStartIndex + "Push Down Method ".length() ,
//					                                              methodLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//			int newMethodStartIndex = refactoringDetail.indexOf(" to ");
//			int newMethodLastIndex = refactoringDetail.lastIndexOf("from class");
//			String newMethodName = refactoringDetail.substring(newMethodStartIndex + " to ".length() ,
//	                										   newMethodLastIndex);
//
//			int newClassStartIndex = refactoringDetail.lastIndexOf("from class");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + "from class".length());
//		
//			mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());
//			
//			methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			newMethodName = newMethodName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
//			CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Pull Up Method	public key() : String from class com.couchbase.client.core.message.binary.GetRequest 
//		//to public key() : String from class com.couchbase.client.core.message.binary.AbstractBinaryRequest"
//		public void getElementPullUpMethod(){
//			int methodStartIndex = refactoringDetail.indexOf("Pull Up Method ");
//			int methodLastIndex = refactoringDetail.indexOf("from class");
//			
//			String methodName = refactoringDetail.substring(methodStartIndex + "Pull Up Method ".length() ,
//					                                              methodLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//			int newMethodStartIndex = refactoringDetail.indexOf(" to ");
//			int newMethodLastIndex = refactoringDetail.lastIndexOf("from class");
//			String newMethodName = refactoringDetail.substring(newMethodStartIndex + " to ".length() ,
//	                										   newMethodLastIndex);
//
//			int newClassStartIndex = refactoringDetail.lastIndexOf("from class");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + "from class".length());
//			
//			mainElementCompletePath = new CodeElement(methodName.trim(), null, oldClassName.trim());
//			
//			methodName = methodName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			newMethodName = newMethodName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(methodName.trim(), null, oldClassName.trim());
//			CodeElement element2 = new CodeElement(newMethodName.trim(), null, newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
}
