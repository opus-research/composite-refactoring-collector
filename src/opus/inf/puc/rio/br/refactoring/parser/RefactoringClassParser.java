package opus.inf.puc.rio.br.refactoring.parser;

import java.util.ArrayList;

import opus.inf.puc.rio.br.historic.CodeElement;

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
			
			
			CodeElement element1 = new CodeElement(null, null, className.trim());
			CodeElement element2 = new CodeElement(null, null, newClassName.trim());
		
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
			
			
			CodeElement element1 = new CodeElement(null, null, className.trim());
			CodeElement element2 = new CodeElement(null, null, newClassName.trim());
		
			CodeElement mainElement = element1;
			
			elements.add(element1);
			elements.add(element2);
		}
		
		//"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse 
		// from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse, com.couchbase.client.core.message.binary.GetResponse, com.couchbase.client.core.message.binary.UpsertResponse, com.couchbase.client.core.message.cluster.SeedNodesResponse]"
		public void getClassPattern3(){
			int classStartIndex = refactoringDetails.indexOf("Extract Superclass ");
			int classLastIndex = refactoringDetails.indexOf("from classes");
			
			String className = refactoringDetails.substring(classStartIndex + "Extract Superclass ".length() ,
														   classLastIndex);
		
			className = className.replaceAll("[^a-zA-Z0-9]+","");
			
	        CodeElement element1 = new CodeElement(null, null, className.trim());
			
	        
			elements.add(element1);
			CodeElement mainElementCompletePath = new CodeElement(null, null, className.trim());
			
			int extractedClassesStartIndex = refactoringDetails.indexOf("[");
			int extractedClassesLastIndex = refactoringDetails.indexOf("]");
			
			String extractedClassesList = refactoringDetails.substring(extractedClassesStartIndex + 1, 
																	  extractedClassesLastIndex - 1);
			String[] extractedClasses = extractedClassesList.split(",");	
		    
			for(int i = 0; i < extractedClasses.length; i++) {
				
				String oldClassName = extractedClasses[i];
				
				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
				
				CodeElement element = new CodeElement(null, null, oldClassName.trim());
				elements.add(element);
				
			}	
			CodeElement mainElement = element1;
		}

	
	
	

}
