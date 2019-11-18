package opus.inf.puc.rio.br.refactoring.parser;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringAttributeParser {
	
	// "Push Down Attribute	private resetType : ResetType from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog 
		// to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
//		public void getElementPushDownAttribute(){
//			int attributeStartIndex = refactoringDetail.indexOf("Push Down Attribute ");
//			int attributeLastIndex = refactoringDetail.indexOf("from class");
//			// "Push Down Attribute	private resetType : ResetType from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog 
//			// to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
//			public void getElementPushDownAttribute(){
//				int attributeStartIndex = refactoringDetail.indexOf("Push Down Attribute ");
//				int attributeLastIndex = refactoringDetail.indexOf("from class");
//				
//				String attributeName = refactoringDetail.substring(attributeStartIndex + "Push Down Attribute ".length() ,
//																attributeLastIndex);
//				
//				int oldClassStartIndex = refactoringDetail.indexOf("from class");
//				int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//				
//				
//				String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//																  oldClassLastIndex);
//				
//			
//				int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//				
//				String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//				
//				mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				
//				
//				CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//			
//				mainElement = element1;
//				elements.add(element1);
//				elements.add(element2);
//			}
//			
//			// "Pull Up Attribute	private password : 
//			// String from class com.couchbase.client.core.message.cluster.OpenBucketRequest 
//			//to class com.couchbase.client.core.message.AbstractCouchbaseRequest"
//			public void getElementPullUpAttribute(){
//				int attributeStartIndex = refactoringDetail.indexOf("Pull Up Attribute ");
//				int attributeLastIndex = refactoringDetail.indexOf("from class");
//				
//				String attributeName = refactoringDetail.substring(attributeStartIndex + "Pull Up Attribute ".length() ,
//																attributeLastIndex);
//				
//				int oldClassStartIndex = refactoringDetail.indexOf("from class");
//				int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//				
//				
//				String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//																  oldClassLastIndex);
//				
//			
//				int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//				
//				String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//			
//				mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				
//				CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//			
//				mainElement = element1;
//				elements.add(element1);
//				elements.add(element2);
//			}
//			
//			//"Move Attribute	public SSL_ENABLED : boolean
//			//from class com.couchbase.client.core.env.DefaultCoreProperties 
//			//to class com.couchbase.client.core.env.DefaultCoreEnvironment"
//			public void getElementMoveAttribute(){
//				int attributeStartIndex = refactoringDetail.indexOf("Move Attribute ");
//				int attributeLastIndex = refactoringDetail.indexOf("from class");
//				
//				String attributeName = refactoringDetail.substring(attributeStartIndex + "Move Attribute ".length() ,
//																attributeLastIndex);
//				
//				int oldClassStartIndex = refactoringDetail.indexOf("from class");
//				int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//				
//				
//				String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//																  oldClassLastIndex);
//				
//			
//				int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//				
//				String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//				
//				mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				
//				CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//			
//				mainElement = element1;
//				
//				elements.add(element1);
//				elements.add(element2);
//			}
//			String attributeName = refactoringDetail.substring(attributeStartIndex + "Push Down Attribute ".length() ,
//															attributeLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//		
//			int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//			
//			mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			
//			CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		// "Pull Up Attribute	private password : 
//		// String from class com.couchbase.client.core.message.cluster.OpenBucketRequest 
//		//to class com.couchbase.client.core.message.AbstractCouchbaseRequest"
//		public void getElementPullUpAttribute(){
//			int attributeStartIndex = refactoringDetail.indexOf("Pull Up Attribute ");
//			int attributeLastIndex = refactoringDetail.indexOf("from class");
//			
//			String attributeName = refactoringDetail.substring(attributeStartIndex + "Pull Up Attribute ".length() ,
//															attributeLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//		
//			int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//		
//			mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Move Attribute	public SSL_ENABLED : boolean
//		//from class com.couchbase.client.core.env.DefaultCoreProperties 
//		//to class com.couchbase.client.core.env.DefaultCoreEnvironment"
//		public void getElementMoveAttribute(){
//			int attributeStartIndex = refactoringDetail.indexOf("Move Attribute ");
//			int attributeLastIndex = refactoringDetail.indexOf("from class");
//			
//			String attributeName = refactoringDetail.substring(attributeStartIndex + "Move Attribute ".length() ,
//															attributeLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//		
//			int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//			
//			mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//		
//			mainElement = element1;
//			
//			elements.add(element1);
//			elements.add(element2);
//		}
	
	public void ExtractVariable() {
		
	} 
	
	public void InlineVariable() {
		
	}
	
	public void ParameterizeVariable () {
		
	} 
	
	public void RenameVariable() {
		
	} 
	
	public void RenameParameter() {
		
	}  
	
	public void RenameAttribute() {
		
	} 

	public void getReplaceVariableWithAttribute() {}
	public void getReplaceAttribute() {}
	public void getMergeVariable() {}
	public void getMergeParameter() {}
	public void getMergeAttribute() {}
	public void getSplitVariable() {} 
	public void getSplitParameter() {} 
	public void getSplitAttribute() {} 
	public void getChangeVariableType() {}
	public void getChangeParameterType() {} 
	public void getChangeReturnType() {} 
	public void getChangeAttributeType() {} 
	public void getExtractAttribute() {}
	

}
