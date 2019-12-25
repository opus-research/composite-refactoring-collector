package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.junit.Test;

import opus.inf.puc.rio.br.historic.CodeElement;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringAttributeParser;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringParser;


public class RefactoringAttributeParserTest {

	
	
	// ------------------------ PATTERN 1 ----------------------------------//
	
	@Test
	public void shouldGetCodeElementPullUpAttribute(){
	    
		RefactoringParser parserUA = new RefactoringAttributeParser("Pull Up Attribute",
				          "Pull Up Attribute	private password : String "
						+ "from class com.couchbase.client.core.message.cluster.OpenBucketRequest "
						+ "to class com.couchbase.client.core.message.AbstractCouchbaseRequest");
      
		List<CodeElement> elements = parserUA.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("privatepasswordString", elements.attributeName);
        assertEquals("comcouchbaseclientcoremessageclusterOpenBucketRequest", elements.get(0).className);
		
        assertEquals("privatepasswordString", elements.attributeName);
        assertEquals("comcouchbaseclientcoremessageAbstractCouchbaseRequest", elements.get(1).className);
	
	}
	
	@Test
	public void shouldGetCodeElementPushDownAttribute(){
	
		RefactoringParser parserDA = new RefactoringAttributeParser("Push Down Attribute",
				"Push Down Attribute	private resetType : ResetType "
						+ "from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog "
						+ "to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog");

		List<CodeElement> elements = parserDA.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("privateresetTypeResetType", elements.get(0).attributeName);
        assertEquals("orgeclipseegituiinternaldialogsBranchSelectionDialog", elements.get(0).className);
		
        assertEquals("privateresetTypeResetType", ref.getElements().get(1).attributeName);
        assertEquals("orgeclipseegituiinternaldialogsResetTargetSelectionDialog", elements.get(1).className);
	
	}
	
	@Test
	public void shouldGetCodeElementMoveAttribute(){
		
		RefactoringParser parserMM = new RefactoringAttributeParser("Move Attribute", 
				           "Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserMM.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
        assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
		
        assertEquals("publicSSLENABLEDboolean", elements.get(1).attributeName);
        assertEquals("comcouchbaseclientcoreenvDefaultCoreEnvironment", elements.get(1).className);
	
	}
	
	
	// ------------------------ PATTERN 2 ----------------------------------//
	@Test
	public void shouldExtractVariable(){	
		
		RefactoringParser parserEV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserEV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldInlineVariable(){	
		
		RefactoringParser parserIV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserIV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
    
	// ------------------------ PATTERN 3 ----------------------------------//
	@Test
	public void shouldParameterizeVariable(){	
		
		RefactoringParser parserPV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserPV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldRenameVariable(){	
		RefactoringParser parserRV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserRV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldRenameParameter(){	
		RefactoringParser parserRP = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserRP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldReplaceVariable(){	
		RefactoringParser parserRV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserRV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldSplitVariable(){	
		RefactoringParser parserSV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserSV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldChangeVariable(){	
		RefactoringParser parserCV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserCV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldChangeParameterType(){	
		RefactoringParser parserCP = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserCP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldSplitParameter(){	
		RefactoringParser parserSP = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserSP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldMergeVariable(){	
		RefactoringParser parserMV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserMV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldMergeParameter(){	
		RefactoringParser parserMP = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserMP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	// ------------------------ PATTERN 4 ----------------------------------//

	@Test
	public void shouldRenameAttribute(){	
		RefactoringParser parserRA = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserRA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldMergeAttribute(){	
		RefactoringParser parserMA = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserMA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldSplitAttribute(){	
		RefactoringParser parserSA = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserSA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldChangeAttribute(){	
		RefactoringParser parserCA = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserCA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	// ------------------------ PATTERN 5 ----------------------------------//
	@Test
	public void shouldReplaceAttribute(){	
		RefactoringParser parserRA = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserRA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	
	// ------------------------ PATTERN 6 ----------------------------------//
	@Test
	public void shouldExtractAttribute(){
		RefactoringParser parserEA = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserEA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	// ------------------------ PATTERN 7 ----------------------------------//
	@Test
	public void shouldChangeReturnType(){	
		RefactoringParser parserCR = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		List<CodeElement> elements = parserCR.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	

	
	
	

	
	

}
