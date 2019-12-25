package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import opus.inf.puc.rio.br.historic.CodeElement;
import opus.inf.puc.rio.br.refactoring.Refactoring;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringMethodParser;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringParser;

public class RefactoringMethodParserTest {

	
	@Test
	public void shouldGetCodeElementFromRenameMethod(){
		
		
        RefactoringParser parserRM = new RefactoringMethodParser("Rename Method", "Rename Method	public shouldReplaceWithCAS() : void "
				+ "renamed to public shouldReplaceWithFailingCAS() : void "
				+ "in class com.couchbase.client.core.cluster.BinaryMessageTest");
		
		List<CodeElement> elements = parserRM.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("publicshouldReplaceWithCASvoid", elements.get(0).methodName);
        assertEquals("comcouchbaseclientcoreclusterBinaryMessageTest", elements.get(0).className);
		
        assertEquals("publicshouldReplaceWithFailingCASvoid", elements.get(1).methodName);
        assertEquals("comcouchbaseclientcoreclusterBinaryMessageTest", elements.get(1).className);
		
	}

	
	@Test
	public void shouldGetCodeElementFromInlineMethod(){
	
		
		RefactoringParser parserIM = new RefactoringMethodParser("Inline Method", 
                "Inline Method	public create(properties CoreProperties) : DefaultCoreEnvironment inlined to public create() :"
                + " DefaultCoreEnvironment in class  com.couchbase.client.core.cluster.BinaryMessageTest");
		
		List<CodeElement> elements = parserIM.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("publiccreatepropertiesCorePropertiesDefaultCoreEnvironment", elements.get(0).methodName);
        assertEquals("comcouchbaseclientcoreclusterBinaryMessageTest", elements.get(0).className);
		
        assertEquals("publiccreateDefaultCoreEnvironment", elements.get(1).methodName);
        assertEquals("comcouchbaseclientcoreclusterBinaryMessageTest", elements.get(1).className);
		
	}
	
	
	@Test
	public void shouldGetCodeElementFromMoveMethod(){
		

		RefactoringParser parserMM = new RefactoringMethodParser("Move Method", "Move Method	public bootstrapCarrierEnabled() : boolean "
						+ "from class com.couchbase.client.core.env.DynamicCoreProperties "
						+ "to public bootstrapCarrierEnabled() : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreEnvironment");
		
		
		List<CodeElement> elements = parserMM.getCodeElements();
        
        
        assertEquals(2, elements.size());
        assertEquals("publicbootstrapCarrierEnabledboolean", elements.get(0).methodName);
        assertEquals("comcouchbaseclientcoreenvDynamicCoreProperties", elements.get(0).className);
		
        assertEquals("publicbootstrapCarrierEnabledboolean", elements.get(1).methodName);
        assertEquals("comcouchbaseclientcoreenvDefaultCoreEnvironment", elements.get(1).className);
		
	}
	
	
	
	@Test 
	public void shouldGetCodeElementExtractMethod(){
		
		RefactoringParser parserEM = new RefactoringMethodParser("Extract Method", 
				        "Extract Method	protected doConnect(observable Subject<LifecycleState,LifecycleState>) : void "
						+ "extracted from public connect() : Observable<LifecycleState> "
						+ "in class com.couchbase.client.core.endpoint.AbstractEndpoint");
		
		List<CodeElement> elements = parserEM.getCodeElements();
        
        
        assertEquals(2, elements.size());
        assertEquals("protecteddoConnectobservableSubjectLifecycleStateLifecycleStatevoid", elements.get(1).methodName);
        assertEquals("comcouchbaseclientcoreendpointAbstractEndpoint", elements.get(1).className);
		
        assertEquals("publicconnectObservableLifecycleState", elements.get(0).methodName);
        assertEquals("comcouchbaseclientcoreendpointAbstractEndpoint", elements.get(0).className);
	
	}
	
	@Test
	public void shouldGetCodeElementPushDownMethod(){

		RefactoringParser parserDM = new RefactoringMethodParser("Push Down Method",
				"Push Down Method	private buildResetGroup(parent Composite) : void "
						+ "from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog "
						+ "to protected createCustomArea(parent Composite) : void "
						+ "from class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog");
		
		List<CodeElement> elements = parserDM.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("privatebuildResetGroupparentCompositevoid", elements.get(0).methodName);
        assertEquals("orgeclipseegituiinternaldialogsBranchSelectionDialog", elements.get(0).className);
		
        assertEquals("protectedcreateCustomAreaparentCompositevoid", elements.get(1).methodName);
        assertEquals("orgeclipseegituiinternaldialogsResetTargetSelectionDialog", elements.get(1).className);
	
	}
	
	
	@Test
	public void shouldGetCodeElementPullUpMethod(){

		RefactoringParser parserUM = new RefactoringMethodParser("Pull Up Method", "Pull Up Method	public key() : String "
						+ "from class com.couchbase.client.core.message.binary.GetRequest "
						+ "to public key() : String "
						+ "from class com.couchbase.client.core.message.binary.AbstractBinaryRequest");
       
		List<CodeElement> elements = parserUM.getCodeElements();
        
        assertEquals(2, elements.size());
        assertEquals("publickeyString", elements.get(0).methodName);
        assertEquals("comcouchbaseclientcoremessagebinaryGetRequest", elements.get(0).className);
		
        assertEquals("publickeyString", elements.get(1).methodName);
        assertEquals("comcouchbaseclientcoremessagebinaryAbstractBinaryRequest", elements.get(1).className);
	
	}
}
