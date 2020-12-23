package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import opus.inf.puc.rio.br.model.historic.CodeElement;
import opus.inf.puc.rio.br.parser.RefactoringParser;


public class RefactoringClassParserTest {
	
	
	@Test
	public void shouldGetCodeElementMoveClass(){
		RefactoringParser parserMC = new RefactoringParser();
		
		List<CodeElement> elements = parserMC.getCodeElements("Move Class",
		          "Move Class	com.couchbase.client.core.service.SelectionStrategy "
				+ "moved to com.couchbase.client.core.service.strategies.SelectionStrategy");
        
        assertEquals(2, elements.size());
        assertEquals("com.couchbase.client.core.service.SelectionStrategy", elements.get(0).className);
		
        assertEquals("com.couchbase.client.core.service.strategies.SelectionStrategy", elements.get(1).className);
	}
	
	@Test
	public void shouldGetCodeElementRenameClass(){
		RefactoringParser parserRC = new RefactoringParser();
		
		List<CodeElement> elements = parserRC.getCodeElements("Rename Class",
				"Rename Class	net.spy.memcached.MembaseClient "
						+ "renamed to com.couchbase.client.CouchbaseClient");
        
        assertEquals(2, elements.size());
        assertEquals("net.spy.memcached.MembaseClient", elements.get(0).className);
		
        assertEquals("com.couchbase.client.CouchbaseClient", elements.get(1).className);
	}
	
	
	@Test
	public void shouldGetCodeElementExtractSuperclass(){
		RefactoringParser parserES = new RefactoringParser();
		
		List<CodeElement> elements = parserES.getCodeElements("Extract Superclass",
				"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse "
						+ "from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse,"
						+ "com.couchbase.client.core.message.binary.GetResponse,"
						+ "com.couchbase.client.core.message.binary.UpsertResponse,"
						+ "com.couchbase.client.core.message.cluster.SeedNodesResponse]");
        
        assertEquals(2, elements.size());
        assertEquals("com.couchbase.client.core.message.AbstractCouchbaseResponse", elements.get(0).className);
		
        assertEquals("[com.couchbase.client.core.message.binary.GetBucketConfigResponse,"
        		+ "com.couchbase.client.core.message.binary.GetResponse,"
        		+ "com.couchbase.client.core.message.binary.UpsertResponse,"
        		+ "com.couchbase.client.core.message.cluster.SeedNodesResponse]", elements.get(1).className);
      
	}
	
	@Test
	public void shouldGetCodeElementExtractInterface(){
		RefactoringParser parserEI = new RefactoringParser();
		
		List<CodeElement> elements = parserEI.getCodeElements("Extract Interface",
				"Extract Interface	com.couchbase.client.core.message.binary.BinaryStoreRequest"
						+ " from classes [com.couchbase.client.core.message.binary.InsertRequest,"
						+ "com.couchbase.client.core.message.binary.InsertA]");
        
        assertEquals(2, elements.size());
        assertEquals("com.couchbase.client.core.message.binary.BinaryStoreRequest", elements.get(0).className);
		
        assertEquals("[com.couchbase.client.core.message.binary.InsertRequest,"
                   + "com.couchbase.client.core.message.binary.InsertA]", elements.get(1).className);
  
	}
	
	
	@Test
	public void shouldGetCodeElementExtractClass(){
		RefactoringParser parserEI = new RefactoringParser();
		
		List<CodeElement> elements = parserEI.getCodeElements("Extract Class",
				"Extract Class com.couchbase.client.core.endpoint.dcp.DCPConnectionHandler "
				+ "from class com.couchbase.client.core.endpoint.dcp.DCPHandler");
        
        assertEquals(2, elements.size());
        assertEquals("com.couchbase.client.core.endpoint.dcp.DCPConnectionHandler", elements.get(0).className);
		
        assertEquals("com.couchbase.client.core.endpoint.dcp.DCPHandler", elements.get(1).className);
       
	}
	
	@Test
	public void shouldGetCodeElementExtractSubclass(){
		RefactoringParser parserEI = new RefactoringParser();
		
		List<CodeElement> elements = parserEI.getCodeElements("Extract Subclass",
				"Extract Subclass org.eclipse.jgit.lib.LocalObjectToPack "
				+ "from class org.eclipse.jgit.lib.ObjectToPack");
        
        assertEquals(2, elements.size());
        assertEquals("org.eclipse.jgit.lib.LocalObjectToPack", elements.get(0).className);
		
        assertEquals("org.eclipse.jgit.lib.ObjectToPack", elements.get(1).className);
      
	}
	
}
