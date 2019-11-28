package opus.inf.puc.rio.br.refactoring.parser;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringClassParser {
	
	
	//Move Class	com.couchbase.client.core.service.SelectionStrategy 
		// moved to com.couchbase.client.core.service.strategies.SelectionStrategy
//		public void getElementMoveClass(){
//			int classStartIndex = refactoringDetail.indexOf("Move Class ");
//			int classLastIndex = refactoringDetail.indexOf("moved to");
//			
//			String className = refactoringDetail.substring(classStartIndex + "Move Class ".length() ,
//															classLastIndex);
//			
//			int newClassNameStartIndex = refactoringDetail.indexOf("moved to");
//			
//			String newClassName = refactoringDetail.substring(newClassNameStartIndex + "moved to".length());
//			
//			mainElementCompletePath =  new CodeElement(null, null, className.trim());
//			
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//			
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(null, null, className.trim());
//			CodeElement element2 = new CodeElement(null, null, newClassName.trim());
//		
//			mainElement = element1;
//			
//			elements.add(element1);
//			elements.add(element2);
//		}//"Rename Class	net.spy.memcached.MembaseClient renamed to com.couchbase.client.CouchbaseClient"
//		public void getElementRenameClass(){
//			int classStartIndex = refactoringDetail.indexOf("Rename Class ");
//			int classLastIndex = refactoringDetail.indexOf("renamed to");
//			
//			String className = refactoringDetail.substring(classStartIndex + "Rename Class ".length() ,
//															classLastIndex);
//			
//			int newClassNameStartIndex = refactoringDetail.indexOf("renamed to");
//			
//			String newClassName = refactoringDetail.substring(newClassNameStartIndex + "renamed to".length());
//			
//			mainElementCompletePath = new CodeElement(null, null, className.trim());
//			
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			CodeElement element1 = new CodeElement(null, null, className.trim());
//			CodeElement element2 = new CodeElement(null, null, newClassName.trim());
//		
//			mainElement = element1;
//			
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse 
//		// from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse, com.couchbase.client.core.message.binary.GetResponse, com.couchbase.client.core.message.binary.UpsertResponse, com.couchbase.client.core.message.cluster.SeedNodesResponse]"
//		public void getElementExtractSuperClass(){
//			int classStartIndex = refactoringDetail.indexOf("Extract Superclass ");
//			int classLastIndex = refactoringDetail.indexOf("from classes");
//			
//			String className = refactoringDetail.substring(classStartIndex + "Extract Superclass ".length() ,
//														   classLastIndex);
//		
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//			
//	        CodeElement element1 = new CodeElement(null, null, className.trim());
//			
//	        
//			elements.add(element1);
//			mainElementCompletePath = new CodeElement(null, null, className.trim());
//			
//			int extractedClassesStartIndex = refactoringDetail.indexOf("[");
//			int extractedClassesLastIndex = refactoringDetail.indexOf("]");
//			
//			String extractedClassesList = refactoringDetail.substring(extractedClassesStartIndex + 1, 
//																	  extractedClassesLastIndex - 1);
//			String[] extractedClasses = extractedClassesList.split(",");	
//		    
//			for(int i = 0; i < extractedClasses.length; i++) {
//				
//				String oldClassName = extractedClasses[i];
//				
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				CodeElement element = new CodeElement(null, null, oldClassName.trim());
//				elements.add(element);
//				
//			}	
//			mainElement = element1;
//		}
//		
//		//Extract Interface	com.couchbase.client.core.message.binary.BinaryStoreRequest 
//		// from classes [com.couchbase.client.core.message.binary.InsertRequest,
//		// com.couchbase.client.core.message.binary.InsertA]
//		public void getElementExtractInterface(){
//			int classStartIndex = refactoringDetail.indexOf("Extract Interface ");
//			int classLastIndex = refactoringDetail.indexOf("from classes");
//			
//			String className = refactoringDetail.substring(classStartIndex + "Extract Interface ".length() ,
//														   classLastIndex);
//			
//			className = className.replaceAll("[^a-zA-Z0-9]+","");
//	        CodeElement element1 = new CodeE//"Rename Class	net.spy.memcached.MembaseClient renamed to com.couchbase.client.CouchbaseClient"
//	        		public void getElementRenameClass(){
//	    		int classStartIndex = refactoringDetail.indexOf("Rename Class ");
//	    		int classLastIndex = refactoringDetail.indexOf("renamed to");
//	    		
//	    		String className = refactoringDetail.substring(classStartIndex + "Rename Class ".length() ,
//	    														classLastIndex);
//	    		
//	    		int newClassNameStartIndex = refactoringDetail.indexOf("renamed to");
//	    		
//	    		String newClassName = refactoringDetail.substring(newClassNameStartIndex + "renamed to".length());
//	    		
//	    		mainElementCompletePath = new CodeElement(null, null, className.trim());
//	    		
//	    		className = className.replaceAll("[^a-zA-Z0-9]+","");
//	    		newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//	    		
//	    		CodeElement element1 = new CodeElement(null, null, className.trim());
//	    		CodeElement element2 = new CodeElement(null, null, newClassName.trim());
//	    	
//	    		mainElement = element1;
//	    		
//	    		elements.add(element1);
//	    		elements.add(element2);
//	    	}
//	    	
//	    	//"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse 
//	    	// from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse, com.couchbase.client.core.message.binary.GetResponse, com.couchbase.client.core.message.binary.UpsertResponse, com.couchbase.client.core.message.cluster.SeedNodesResponse]"
//	    	public void getElementExtractSuperClass(){
//	    		int classStartIndex = refactoringDetail.indexOf("Extract Superclass ");
//	    		int classLastIndex = refactoringDetail.indexOf("from classes");
//	    		
//	    		String className = refactoringDetail.substring(classStartIndex + "Extract Superclass ".length() ,
//	    													   classLastIndex);
//	    	
//	    		className = className.replaceAll("[^a-zA-Z0-9]+","");
//	    		
//	            CodeElement element1 = new CodeElement(null, null, className.trim());
//	    		
//	            
//	    		elements.add(element1);
//	    		mainElementCompletePath = new CodeElement(null, null, className.trim());
//	    		
//	    		int extractedClassesStartIndex = refactoringDetail.indexOf("[");
//	    		int extractedClassesLastIndex = refactoringDetail.indexOf("]");
//	    		
//	    		String extractedClassesList = refactoringDetail.substring(extractedClassesStartIndex + 1, 
//	    																  extractedClassesLastIndex - 1);
//	    		String[] extractedClasses = extractedClassesList.split(",");	
//	    	    
//	    		for(int i = 0; i < extractedClasses.length; i++) {
//	    			
//	    			String oldClassName = extractedClasses[i];
//	    			
//	    			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//	    			
//	    			CodeElement element = new CodeElement(null, null, oldClassName.trim());
//	    			elements.add(element);
//	    			
//	    		}	
//	    		mainElement = element1;
//	    	}
//	    	
//	    	//Extract Interface	com.couchbase.client.core.message.binary.BinaryStoreRequest 
//	    	// from classes [com.couchbase.client.core.message.binary.InsertRequest,
//	    	// com.couchbase.client.core.message.binary.InsertA]
//	    	public void getElementExtractInterface(){
//	    		int classStartIndex = refactoringDetail.indexOf("Extract Interface ");
//	    		int classLastIndex = refactoringDetail.indexOf("from classes");
//	    		
//	    		String className = refactoringDetail.substring(classStartIndex + "Extract Interface ".length() ,
//	    													   classLastIndex);
//	    		
//	    		className = className.replaceAll("[^a-zA-Z0-9]+","");
//	            CodeElement element1 = new CodeElement(null, null, className.trim());
//	    		
//	            mainElementCompletePath = new CodeElement(null, null, className.trim());
//	    	
//	            elements.add(element1);
//	    		int extractedClassesStartIndex = refactoringDetail.indexOf("[");
//	    		int extractedClassesLastIndex = refactoringDetail.indexOf("]");
//	    		
//	    		String extractedClassesList = refactoringDetail.substring(extractedClassesStartIndex + 1, 
//	    															      extractedClassesLastIndex );
//	    		String[] extractedClasses = extractedClassesList.split(",");	
//	    	    
//	    		
//	    		for(int i = 0; i < extractedClasses.length; i++) {
//	    			
//	    			String oldClassName = extractedClasses[i];
//	    			
//	    			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//	    			
//	    			CodeElement element = new CodeElement(null, null, oldClassName.trim());
//	    			elements.add(element);
//	    			
//	    		}
//	    		mainElement = element1;
//	    	}lement(null, null, className.trim());
//			
//	        mainElementCompletePath = new CodeElement(null, null, className.trim());
//		
//	        elements.add(element1);
//			int extractedClassesStartIndex = refactoringDetail.indexOf("[");
//			int extractedClassesLastIndex = refactoringDetail.indexOf("]");
//			
//			String extractedClassesList = refactoringDetail.substring(extractedClassesStartIndex + 1, 
//																      extractedClassesLastIndex );
//			String[] extractedClasses = extractedClassesList.split(",");	
//		    
//			
//			for(int i = 0; i < extractedClasses.length; i++) {
//				
//				String oldClassName = extractedClasses[i];
//				
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				CodeElement element = new CodeElement(null, null, oldClassName.trim());
//				elements.add(element);
//				
//			}
//			mainElement = element1;
//		}
	
	/*Extract Class	com.couchbase.client.core.endpoint.dcp.DCPConnectionHandler from class com.couchbase.client.core.endpoint.dcp.DCPHandler																																																				*/
	public void getExtractClass() {}
	
	/*Extract Subclass	org.eclipse.jgit.lib.LocalObjectToPack from class org.eclipse.jgit.lib.ObjectToPack*/
	public void getExtractSubClass() {}
	
	
	

}
