package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import opus.inf.puc.rio.br.model.historic.CodeElement;
import opus.inf.puc.rio.br.parser.RefactoringParser;

public class RefactoringMethodParserTest {

	
	@Test
	public void shouldGetCodeElementFromRenameMethod(){
		
		
        RefactoringParser parserRM = new RefactoringParser();
		
		List<CodeElement> elements = parserRM.getCodeElements("Rename Method", "Rename Method	public shouldReplaceWithCAS() : void "
				+ "renamed to public shouldReplaceWithFailingCAS() : void "
				+ "in class com.couchbase.client.core.cluster.BinaryMessageTest");
        
        assertEquals(2, elements.size());
        assertEquals("public shouldReplaceWithCAS() : void", elements.get(0).methodName);
        assertEquals("com.couchbase.client.core.cluster.BinaryMessageTest", elements.get(0).className);
		
        assertEquals("public shouldReplaceWithFailingCAS() : void", elements.get(1).methodName);
        assertEquals("com.couchbase.client.core.cluster.BinaryMessageTest", elements.get(1).className);
		
	}

	
	@Test
	public void shouldGetCodeElementFromInlineMethod(){
	
		
		RefactoringParser parserIM = new RefactoringParser();
		
		List<CodeElement> elements = parserIM.getCodeElements("Inline Method", 
                "Inline Method	public create(properties CoreProperties) : DefaultCoreEnvironment inlined to public create() :"
                + " DefaultCoreEnvironment in class  com.couchbase.client.core.cluster.BinaryMessageTest");
        
        assertEquals(2, elements.size());
        assertEquals("public create(properties CoreProperties) : DefaultCoreEnvironment", elements.get(0).methodName);
        assertEquals("com.couchbase.client.core.cluster.BinaryMessageTest", elements.get(0).className);
		
        assertEquals("public create() : DefaultCoreEnvironment", elements.get(1).methodName);
        assertEquals("com.couchbase.client.core.cluster.BinaryMessageTest", elements.get(1).className);
		
	}
	
	
	@Test
	public void shouldGetCodeElementFromMoveMethod(){
		

		RefactoringParser parserMM = new RefactoringParser();
		
		
		List<CodeElement> elements = parserMM.getCodeElements("Move Method", "Move Method	public bootstrapCarrierEnabled() : boolean "
				+ "from class com.couchbase.client.core.env.DynamicCoreProperties "
				+ "to public bootstrapCarrierEnabled() : boolean "
				+ "from class com.couchbase.client.core.env.DefaultCoreEnvironment");
        
        
        assertEquals(2, elements.size());
        assertEquals("public bootstrapCarrierEnabled() : boolean", elements.get(0).methodName);
        assertEquals("com.couchbase.client.core.env.DynamicCoreProperties", elements.get(0).className);
		
        assertEquals("public bootstrapCarrierEnabled() : boolean", elements.get(1).methodName);
        assertEquals("com.couchbase.client.core.env.DefaultCoreEnvironment", elements.get(1).className);
		
	}
	
	
	
	@Test 
	public void shouldGetCodeElementExtractMethod(){
		
		RefactoringParser parserEM = new RefactoringParser();
		
		List<CodeElement> elements = parserEM.getCodeElements("Extract Method", 
		        "Extract Method	protected doConnect(observable Subject<LifecycleState,LifecycleState>) : void "
				+ "extracted from public connect() : Observable<LifecycleState> "
				+ "in class com.couchbase.client.core.endpoint.AbstractEndpoint");
        
        
        assertEquals(2, elements.size());
        assertEquals("protected doConnect(observable Subject<LifecycleState,LifecycleState>) : void", elements.get(1).methodName);
        assertEquals("com.couchbase.client.core.endpoint.AbstractEndpoint", elements.get(1).className);
		
        assertEquals("public connect() : Observable<LifecycleState>", elements.get(0).methodName);
        assertEquals("com.couchbase.client.core.endpoint.AbstractEndpoint", elements.get(0).className);
	}
	
	@Test
	public void shouldGetCodeElementPushDownMethod(){

		RefactoringParser parserDM = new RefactoringParser();
		
		List<CodeElement> elements = parserDM.getCodeElements("Push Down Method",
				"Push Down Method	private buildResetGroup(parent Composite) : void "
						+ "from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog "
						+ "to protected createCustomArea(parent Composite) : void "
						+ "from class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog");
        
        assertEquals(2, elements.size());
        assertEquals("private buildResetGroup(parent Composite) : void", elements.get(0).methodName);
        assertEquals("org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog", elements.get(0).className);
		
        assertEquals("protected createCustomArea(parent Composite) : void", elements.get(1).methodName);
        assertEquals("org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog", elements.get(1).className);
	
	}
	
	
	@Test
	public void shouldGetCodeElementPullUpMethod(){

		RefactoringParser parserUM = new RefactoringParser();
       
		List<CodeElement> elements = parserUM.getCodeElements("Pull Up Method", "Pull Up Method	public key() : String "
				+ "from class com.couchbase.client.core.message.binary.GetRequest "
				+ "to public key() : String "
				+ "from class com.couchbase.client.core.message.binary.AbstractBinaryRequest");
        
        assertEquals(2, elements.size());
        assertEquals("public key() : String", elements.get(0).methodName);
        assertEquals("com.couchbase.client.core.message.binary.GetRequest", elements.get(0).className);
		
        assertEquals("public key() : String", elements.get(1).methodName);
        assertEquals("com.couchbase.client.core.message.binary.AbstractBinaryRequest", elements.get(1).className);
	
	}
}
