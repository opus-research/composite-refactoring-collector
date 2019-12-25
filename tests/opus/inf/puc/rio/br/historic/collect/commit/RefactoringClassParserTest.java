package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import opus.inf.puc.rio.br.historic.CodeElement;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringClassParser;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringParser;


public class RefactoringClassParserTest {
	
	
	@Test
	public void shouldGetCodeElementMoveClass(){
		RefactoringParser parserMC = new RefactoringClassParser ("Move Class",
				          "Move Class	com.couchbase.client.core.service.SelectionStrategy "
						+ "moved to com.couchbase.client.core.service.strategies.SelectionStrategy");
		
		List<CodeElement> elements = parserMC.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("comcouchbaseclientcoreserviceSelectionStrategy", elements.get(0).className);
		
        assertEquals("comcouchbaseclientcoreservicestrategiesSelectionStrategy", elements.get(1).className);
	}
	
	@Test
	public void shouldGetCodeElementRenameClass(){
		RefactoringParser parserRC = new RefactoringClassParser("Rename Class",
				"Rename Class	net.spy.memcached.MembaseClient "
						+ "renamed to com.couchbase.client.CouchbaseClient");
		
		List<CodeElement> elements = parserRC.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("netspymemcachedMembaseClient", elements.get(0).className);
		
        assertEquals("comcouchbaseclientCouchbaseClient", elements.get(1).className);
	}
	
	
	@Test
	public void shouldGetCodeElementExtractSuperclass(){
		RefactoringParser parserES = new RefactoringClassParser("Extract Superclass",
				"Extract Superclass	com.couchbase.client.core.message.AbstractCouchbaseResponse "
						+ "from classes [com.couchbase.client.core.message.binary.GetBucketConfigResponse, "
						+ "com.couchbase.client.core.message.binary.GetResponse, "
						+ "com.couchbase.client.core.message.binary.UpsertResponse, "
						+ "com.couchbase.client.core.message.cluster.SeedNodesResponse]");
		
		List<CodeElement> elements = parserES.getCodeElements();
        
        assertEquals(5, elements.size());
        assertEquals("comcouchbaseclientcoremessageAbstractCouchbaseResponse", elements.get(0).className);
		
        assertEquals("comcouchbaseclientcoremessagebinaryGetResponse", elements.get(2).className);
       
        assertEquals("comcouchbaseclientcoremessagebinaryUpsertResponse", elements.get(3).className);
	}
	
	@Test
	public void shouldGetCodeElementExtractInterface(){
		RefactoringParser parserEI = new RefactoringClassParser("Extract Interface",
				"Extract Interface	com.couchbase.client.core.message.binary.BinaryStoreRequest"
						+ " from classes [com.couchbase.client.core.message.binary.InsertRequest, "
						+ "com.couchbase.client.core.message.binary.InsertA]");
		
		List<CodeElement> elements = parserEI.getCodeElements();
        
        assertEquals(3, elements.size());
        assertEquals("comcouchbaseclientcoremessagebinaryBinaryStoreRequest", elements.get(0).className);
		
        assertEquals("comcouchbaseclientcoremessagebinaryInsertRequest", elements.get(1).className);
        assertEquals("comcouchbaseclientcoremessagebinaryInsertA", elements.get(2).className);
	}
	
	
	@Test
	public void shouldGetCodeElementExtractClass(){
		RefactoringParser parserEI = new RefactoringClassParser("Extract Class",
				"Extract Class com.couchbase.client.core.endpoint.dcp.DCPConnectionHandler "
				+ "from class com.couchbase.client.core.endpoint.dcp.DCPHandler");
		
		List<CodeElement> elements = parserEI.getCodeElements();
        
        assertEquals(3, elements.size());
        assertEquals("comcouchbaseclientcoremessagebinaryBinaryStoreRequest", elements.get(0).className);
		
        assertEquals("comcouchbaseclientcoremessagebinaryInsertRequest", elements.get(1).className);
        assertEquals("comcouchbaseclientcoremessagebinaryInsertA", elements.get(2).className);
	}
	
	@Test
	public void shouldGetCodeElementExtractSubclass(){
		RefactoringParser parserEI = new RefactoringClassParser("Extract Subclass",
				"Extract Subclass org.eclipse.jgit.lib.LocalObjectToPack "
				+ "from class org.eclipse.jgit.lib.ObjectToPack	]");
		
		List<CodeElement> elements = parserEI.getCodeElements();
        
        assertEquals(3, elements.size());
        assertEquals("comcouchbaseclientcoremessagebinaryBinaryStoreRequest", elements.get(0).className);
		
        assertEquals("comcouchbaseclientcoremessagebinaryInsertRequest", elements.get(1).className);
        assertEquals("comcouchbaseclientcoremessagebinaryInsertA", elements.get(2).className);
	}
	
}
