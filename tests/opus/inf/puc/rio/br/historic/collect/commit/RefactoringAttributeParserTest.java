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
       // assertEquals("privatepasswordString", elements.attributeName);
        assertEquals("comcouchbaseclientcoremessageclusterOpenBucketRequest", elements.get(0).className);
		
        //assertEquals("privatepasswordString", elements.attributeName);
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
		
        assertEquals("privateresetTypeResetType", elements.get(1).attributeName);
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
				"Move Attribute	builder : DefaultCoreEnvironment.Builder in method "
				+ "public connect() : void from class com.couchbase.client.core.ThreadCleanupTest");

		List<CodeElement> elements = parserEV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldInlineVariable(){	
		
		RefactoringParser parserIV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	addrs : InetAddress[] in method package NetworkAddress(input String, reverseDns boolean) "
				+ "from class com.couchbase.client.core.utils.NetworkAddress");

		List<CodeElement> elements = parserIV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
    
	// ------------------------ PATTERN 3 ----------------------------------//
	@Test
	public void shouldParameterizeVariable(){	
		
		RefactoringParser parserPV = new RefactoringAttributeParser("Move Attribute",
				"Move Attribute	stream : DCPStream to connection : DCPConnection "
				+ "in method private handleDCPRequest(ctx ChannelHandlerContext, connection DCPConnection, msg FullBinaryMemcacheResponse) : void "
				+ "in class com.couchbase.client.core.endpoint.dcp.DCPHandler");

		List<CodeElement> elements = parserPV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldRenameVariable(){	
		RefactoringParser parserRV = new RefactoringAttributeParser("Rename Variable",
				"MRename Variable	newStreamId : int to streamId : int in method public addStream(connectionName String) : int"
				+ " in class com.couchbase.client.core.endpoint.dcp.DCPConnectiont");

		List<CodeElement> elements = parserRV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldRenameParameter(){	
		RefactoringParser parserRP = new RefactoringAttributeParser("Rename Parameter",
				"Rename Parameter	id : int to name : String in method public DCPConnection(env CoreEnvironment, name String, bucket1 String) "
				+ "in class com.couchbase.client.core.endpoint.dcp.DCPConnection");

		List<CodeElement> elements = parserRP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldReplaceVariable(){	
		RefactoringParser parserRV = new RefactoringAttributeParser("Replace Variable",
				"Replace Variable With Attribute executor : Executor to disruptorExecutor : ExecutorService "
				+ "in method public CouchbaseCluster(environment Environment) "
				+ "in class com.couchbase.client.core.cluster.CouchbaseCluster");

		List<CodeElement> elements = parserRV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldSplitVariable(){	
		RefactoringParser parserSV = new RefactoringAttributeParser("Split Variable",
				"Split Variable config : ReferenceConfig<?> to [proxiesOfType : ConcurrentMap<String,Object>, key : String] "
				+ "in method public get(referenceConfig ReferenceConfig<T>) : T in class org.apache.dubbo.bootstrap.ReferenceConfigCache					");

		List<CodeElement> elements = parserSV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldChangeVariableType(){	
		RefactoringParser parserCV = new RefactoringAttributeParser("Change Variable Type",
				"Change Variable Type	dst : Ref to dst : DhtRef in method private resolve(ref DhtRef, depth int, loose RefList<DhtRef>) : DhtRef "
				+ "in class org.eclipse.jgit.storage.dht.DhtRefDatabase");

		List<CodeElement> elements = parserCV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldChangeParameterType(){	
		RefactoringParser parserCP = new RefactoringAttributeParser("Change Parameter Type",
				"Change Parameter Type	environment : CoreEnvironment to ctx : CoreContext"
				+ " in method public KeyValueFeatureHandler(ctx CoreContext) "
				+ "in class com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler");																																					

		List<CodeElement> elements = parserCP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldSplitParameter(){	
		RefactoringParser parserSP = new RefactoringAttributeParser("Split Parameter",
				"Split Parameter value : String to [content : String, group : String] "
				+ "in method public ConfigChangedEvent(key String, group String, content String) "
				+ "in class org.apache.dubbo.common.config.configcenter.ConfigChangedEvent");																				

		List<CodeElement> elements = parserSP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldMergeVariable(){	
		RefactoringParser parserMV = new RefactoringAttributeParser("Merge Variable",
				"Merge Variable	[type : int	position : int	packedSize : long	inflatedSize : long] "
				+ "to b : GitStore.ObjectInfo.Builder in method private insertStream(type int	inflatedSize long	in InputStream) : ObjectId"
				+ " in class org.eclipse.jgit.storage.dht.DhtInserter");

		List<CodeElement> elements = parserMV.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldMergeParameter(){	
		RefactoringParser parserMP = new RefactoringAttributeParser("Merge Parameter",
				"Merge Parameter	[bucket : String, rawConfig : String] to ctx : ProposedBucketConfigContext "
				+ "in method public proposeBucketConfig(ctx ProposedBucketConfigContext) : void "
				+ "in class com.couchbase.client.core.config.DefaultConfigurationProvider");																							

		List<CodeElement> elements = parserMP.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	// ------------------------ PATTERN 4 ----------------------------------//

	@Test
	public void shouldRenameAttribute(){	
		RefactoringParser parserRA = new RefactoringAttributeParser("Rename Attribute",
				"Rename Attribute stream : Observable<DCPRequest> to connection : DCPConnection "
				+ "in class com.couchbase.client.core.message.dcp.StreamRequestResponse");

		List<CodeElement> elements = parserRA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	@Test
	public void shouldMergeAttribute(){	
		RefactoringParser parserMA = new RefactoringAttributeParser("Merge Attribute",
				"Merge Attribute	[env : CoreEnvironment, responseBuffer : RingBuffer<ResponseEvent>] to ctx : CoreContext "
				+ "in class com.couchbase.client.core.service.AbstractDynamicService");																																	

		List<CodeElement> elements = parserMA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldSplitAttribute(){	
		RefactoringParser parserSA = new RefactoringAttributeParser("Split Attribute",
				"Split Attribute value : String to [content : String, group : String] "
				+ "in class org.apache.dubbo.common.config.configcenter.ConfigChangedEvent");																																									

		List<CodeElement> elements = parserSA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	@Test
	public void shouldChangeAttributeType(){	
		RefactoringParser parserCA = new RefactoringAttributeParser("Change Attribute Type",
				"Change Attribute Type	userAgent : String to ctx : CoreContext in class "
				+ "com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler");

		List<CodeElement> elements = parserCA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	// ------------------------ PATTERN 5 ----------------------------------//
	@Test
	public void shouldReplaceAttribute(){	
		RefactoringParser parserRA = new RefactoringAttributeParser("Replace Attribute",
				"Replace Attribute private file : RandomAccessFile "
				+ "from class org.eclipse.jgit.internal.storage.file.PackInserter.Reader.StreamLoader with private packOut : PackStream "
				+ "from class org.eclipse.jgit.internal.storage.file.PackInserter");

		List<CodeElement> elements = parserRA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}
	
	
	// ------------------------ PATTERN 6 ----------------------------------//
	@Test
	public void shouldExtractAttribute(){
		RefactoringParser parserEA = new RefactoringAttributeParser("Extract Attribute",
				"Extract Attribute	private CHARSET : Charset in class com.couchbase.client.core.endpoint.config.ConfigHandlerTest");

		List<CodeElement> elements = parserEA.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	// ------------------------ PATTERN 7 ----------------------------------//
	@Test
	public void shouldChangeReturnType(){	
		RefactoringParser parserCR = new RefactoringAttributeParser("Change Return Type",
				"Change Return Type	Builder to SELF in method public requestBufferWaitStrategy(waitStrategy WaitStrategyFactory) : SELF "
				+ "in class com.couchbase.client.core.env.DefaultCoreEnvironment.Builder");																																										

		List<CodeElement> elements = parserCR.getCodeElements();

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	
	}
	
	

	
	
	

	
	

}
