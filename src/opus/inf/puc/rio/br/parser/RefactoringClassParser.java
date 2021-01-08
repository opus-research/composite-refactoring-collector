package opus.inf.puc.rio.br.parser;


import java.util.ArrayList;
import opus.inf.puc.rio.br.model.historic.CodeElement;

public class RefactoringClassParser extends RefactoringParser{
	
	
	public RefactoringClassParser(String refactoringType, String refactoringDetails) {
		this.refactoringType = refactoringType;
		this.refactoringDetails = refactoringDetails;
		this.elements = new ArrayList<CodeElement>();
		
	}

		//Move Class	com.couchbase.client.core.service.SelectionStrategy 
	// moved to com.couchbase.client.core.service.strategies.SelectionStrategy
		public void getClassPattern1(){
			int classStartIndex = refactoringDetails.indexOf("Move Class ");
			int classLastIndex = refactoringDetails.indexOf("moved to");
			
			String className = refactoringDetails.substring(classStartIndex + "Move Class ".length() ,
															classLastIndex);
			
			int newClassNameStartIndex = refactoringDetails.indexOf("moved to");
			
			String newClassName = refactoringDetails.substring(newClassNameStartIndex + "moved to".length());
			
			CodeElement mainElementCompletePath =  new CodeElement(null, null, className.trim());
			

			className = className.replaceAll("\"", "");
			newClassName = newClassName.replaceAll("\"", "");
					
			CodeElement element1 = new CodeElement(null, null, className.trim());
			element1.setSourceRefactoredCode(true);
			
			CodeElement element2 = new CodeElement(null, null, newClassName.trim());
			element2.setTargetRefactoredCode(true);
		
			CodeElement mainElement = element1;
			
			elements.add(element1);
			elements.add(element2);
		}
	
	   //"Rename Class	net.spy.memcached.MembaseClient renamed to com.couchbase.client.CouchbaseClient"
		public void getClassPattern2(){
			int classStartIndex = refactoringDetails.indexOf("Rename Class ");
			int classLastIndex = refactoringDetails.indexOf("renamed to");
			
			String className = refactoringDetails.substring(classStartIndex + "Rename Class ".length() ,
															classLastIndex);
			
			int newClassNameStartIndex = refactoringDetails.indexOf("renamed to");
			
			String newClassName = refactoringDetails.substring(newClassNameStartIndex + "renamed to".length());
			
			CodeElement mainElementCompletePath = new CodeElement(null, null, className.trim());
			
			className = className.replaceAll("\"", "");
			newClassName = newClassName.replaceAll("\"", "");
			
			CodeElement element1 = new CodeElement(null, null, className.trim());
			element1.setSourceRefactoredCode(true);
			
			CodeElement element2 = new CodeElement(null, null, newClassName.trim());
			element2.setTargetRefactoredCode(true);
		
			CodeElement mainElement = element1;
			
			elements.add(element1);
			elements.add(element2);
		}
		
		//"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse 
		// from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse, 
		// com.couchbase.client.core.message.binary.GetResponse, com.couchbase.client.core.message.binary.UpsertResponse, 
		// com.couchbase.client.core.message.cluster.SeedNodesResponse]"
		public void getClassPattern3(){
			
			int targetClassStartIndex = refactoringDetails.indexOf(refactoringType);
			int targetClassEndIndex; 
			String indicatorSourceClass;
			
			String sourceClass;
			String targetClass;
			
			if(refactoringDetails.contains("from classes")){
				targetClassEndIndex = refactoringDetails.indexOf("from classes");
				indicatorSourceClass = "from classes";
			}
			else {
				targetClassEndIndex = refactoringDetails.indexOf("from class ");
				indicatorSourceClass = "from class ";
			}
			
			
			targetClass = refactoringDetails.substring(targetClassStartIndex + refactoringType.length() , targetClassEndIndex);	
			int sourceClassStartIndex = targetClassEndIndex;
			
			sourceClass = refactoringDetails.substring(indicatorSourceClass.length() +  sourceClassStartIndex);
			
			targetClass = targetClass.replaceAll("\"", "");
			sourceClass = sourceClass.replaceAll("\"", "");
			
		    CodeElement element1 = new CodeElement(null, null, targetClass.trim());
		    element1.setTargetRefactoredCode(true);
		    
		    CodeElement element2 = new CodeElement(null, null, sourceClass.trim());
		    element2.setSourceRefactoredCode(true);
				
			elements.add(element1);
			elements.add(element2);
		}

	
	
	

}
