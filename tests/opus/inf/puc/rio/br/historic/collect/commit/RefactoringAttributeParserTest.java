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
	public void shouldGetCodeElementPullUpAttribute() {

		RefactoringParser parserUA = new RefactoringParser();

		List<CodeElement> elements = parserUA.getCodeElements("Pull Up Attribute",
				"Pull Up Attribute	private password : String "
						+ "from class com.couchbase.client.core.message.cluster.OpenBucketRequest "
						+ "to class com.couchbase.client.core.message.AbstractCouchbaseRequest");

		assertEquals(2, elements.size());
		// assertEquals("privatepasswordString", elements.attributeName);
		assertEquals("comcouchbaseclientcoremessageclusterOpenBucketRequest", elements.get(0).className);

		// assertEquals("privatepasswordString", elements.attributeName);
		assertEquals("comcouchbaseclientcoremessageAbstractCouchbaseRequest", elements.get(1).className);

	}

	@Test
	public void shouldGetCodeElementPushDownAttribute() {

		RefactoringParser parserDA = new RefactoringParser();

		List<CodeElement> elements = parserDA.getCodeElements("Push Down Attribute",
				"Push Down Attribute	private resetType : ResetType "
						+ "from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog "
						+ "to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog");

		assertEquals(2, elements.size());
		assertEquals("privateresetTypeResetType", elements.get(0).attributeName);
		assertEquals("orgeclipseegituiinternaldialogsBranchSelectionDialog", elements.get(0).className);

		assertEquals("privateresetTypeResetType", elements.get(1).attributeName);
		assertEquals("orgeclipseegituiinternaldialogsResetTargetSelectionDialog", elements.get(1).className);

	}

	@Test
	public void shouldGetCodeElementMoveAttribute() {

		RefactoringParser parserMM = new RefactoringParser();

		List<CodeElement> elements = parserMM.getCodeElements("Move Attribute",
				"Move Attribute	public SSL_ENABLED : boolean "
						+ "from class com.couchbase.client.core.env.DefaultCoreProperties "
						+ "to class com.couchbase.client.core.env.DefaultCoreEnvironment");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

		assertEquals("publicSSLENABLEDboolean", elements.get(1).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreEnvironment", elements.get(1).className);

	}

	// ------------------------ PATTERN 2 ----------------------------------//
	@Test
	public void shouldExtractVariable() {

		RefactoringParser parserEV = new RefactoringParser();

		List<CodeElement> elements = parserEV.getCodeElements("Extract Variable",
				"Extract Variable	builder : DefaultCoreEnvironment.Builder in method "
						+ "public connect() : void from class com.couchbase.client.core.ThreadCleanupTest");

		assertEquals(1, elements.size());

		assertEquals("builderDefaultCoreEnvironmentBuilder", elements.get(0).attributeName);

		assertEquals("publicconnectvoid", elements.get(0).methodName);

		assertEquals("comcouchbaseclientcoreThreadCleanupTest", elements.get(0).className);

	}

	@Test
	public void shouldInlineVariable() {

		RefactoringParser parserIV = new RefactoringParser();
		 
		List<CodeElement> elements = parserIV.getCodeElements("Inline Variable",
		"Inline Variable addrs : InetAddress[] in method package NetworkAddress(input String, reverseDns boolean) "
		+ "from class com.couchbase.client.core.utils.NetworkAddress");
		 
		assertEquals(1, elements.size()); assertEquals("addrsInetAddress", elements.get(0).attributeName);
		assertEquals("NetworkAddressinputStringreverseDnsboolean", elements.get(0).methodName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);		 
	}

	// ------------------------ PATTERN 3 ----------------------------------//
	@Test
	public void shouldParameterizeVariable() {

		RefactoringParser parserPV = new RefactoringParser();

		List<CodeElement> elements = parserPV.getCodeElements("Parameterize Variable",
				"Parameterize Variable	stream : DCPStream to connection : DCPConnection "
						+ "in method private handleDCPRequest(ctx ChannelHandlerContext, connection DCPConnection, msg FullBinaryMemcacheResponse) : void "
						+ "in class com.couchbase.client.core.endpoint.dcp.DCPHandler");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	@Test
	public void shouldRenameVariable() {
		RefactoringParser parserRV = new RefactoringParser();

		List<CodeElement> elements = parserRV.getCodeElements("Rename Variable",
				"MRename Variable	newStreamId : int to streamId : int in method public addStream(connectionName String) : int"
						+ " in class com.couchbase.client.core.endpoint.dcp.DCPConnectiont");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	@Test
	public void shouldRenameParameter() {
		RefactoringParser parserRP = new RefactoringParser();

		List<CodeElement> elements = parserRP.getCodeElements("Rename Parameter",
				"Rename Parameter	id : int to name : String in method public DCPConnection(env CoreEnvironment, name String, bucket1 String) "
						+ "in class com.couchbase.client.core.endpoint.dcp.DCPConnection");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	@Test
	public void shouldReplaceVariable() {
		RefactoringParser parserRV = new RefactoringParser();

		List<CodeElement> elements = parserRV.getCodeElements("Replace Variable",
				"Replace Variable With Attribute executor : Executor to disruptorExecutor : ExecutorService "
						+ "in method public CouchbaseCluster(environment Environment) "
						+ "in class com.couchbase.client.core.cluster.CouchbaseCluster");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldSplitVariable() {
		RefactoringParser parserSV = new RefactoringParser();

		List<CodeElement> elements = parserSV.getCodeElements("Split Variable",
				"Split Variable config : ReferenceConfig<?> to [proxiesOfType : ConcurrentMap<String,Object>, key : String] "
						+ "in method public get(referenceConfig ReferenceConfig<T>) : T in class org.apache.dubbo.bootstrap.ReferenceConfigCache");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldChangeVariableType() {
		RefactoringParser parserCV = new RefactoringParser();
		List<CodeElement> elements = parserCV.getCodeElements("Change Variable Type",
				"Change Variable Type	dst : Ref to dst : DhtRef in method private resolve(ref DhtRef, depth int, loose RefList<DhtRef>) : DhtRef "
						+ "in class org.eclipse.jgit.storage.dht.DhtRefDatabase");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldChangeParameterType() {
		RefactoringParser parserCP = new RefactoringParser();
		List<CodeElement> elements = parserCP.getCodeElements("Change Parameter Type",
				"Change Parameter Type	environment : CoreEnvironment to ctx : CoreContext"
						+ " in method public KeyValueFeatureHandler(ctx CoreContext) "
						+ "in class com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldSplitParameter() {
		RefactoringParser parserSP = new RefactoringParser();

		List<CodeElement> elements = parserSP.getCodeElements("Split Parameter",
				"Split Parameter value : String to [content : String, group : String] "
						+ "in method public ConfigChangedEvent(key String, group String, content String) "
						+ "in class org.apache.dubbo.common.config.configcenter.ConfigChangedEvent");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldMergeVariable() {
		RefactoringParser parserMV = new RefactoringParser();

		List<CodeElement> elements = parserMV.getCodeElements("Merge Variable",
				"Merge Variable	[type : int	position : int	packedSize : long	inflatedSize : long] "
						+ "to b : GitStore.ObjectInfo.Builder in method private insertStream(type int	inflatedSize long	in InputStream) : ObjectId"
						+ " in class org.eclipse.jgit.storage.dht.DhtInserter");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldMergeParameter() {
		RefactoringParser parserMP = new RefactoringParser();

		List<CodeElement> elements = parserMP.getCodeElements("Merge Parameter",
				"Merge Parameter	[bucket : String, rawConfig : String] to ctx : ProposedBucketConfigContext "
						+ "in method public proposeBucketConfig(ctx ProposedBucketConfigContext) : void "
						+ "in class com.couchbase.client.core.config.DefaultConfigurationProvider");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	// ------------------------ PATTERN 4 ----------------------------------//

	@Test
	public void shouldRenameAttribute() {
		RefactoringParser parserRA = new RefactoringParser();

		List<CodeElement> elements = parserRA.getCodeElements("Rename Attribute",
				"Rename Attribute stream : Observable<DCPRequest> to connection : DCPConnection "
						+ "in class com.couchbase.client.core.message.dcp.StreamRequestResponse");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	@Test
	public void shouldMergeAttribute() {
		RefactoringParser parserMA = new RefactoringParser();

		List<CodeElement> elements = parserMA.getCodeElements("Merge Attribute",
				"Merge Attribute	[env : CoreEnvironment, responseBuffer : RingBuffer<ResponseEvent>] to ctx : CoreContext "
						+ "in class com.couchbase.client.core.service.AbstractDynamicService");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	@Test
	public void shouldSplitAttribute() {
		RefactoringParser parserSA = new RefactoringParser();

		List<CodeElement> elements = parserSA.getCodeElements("Split Attribute",
				"Split Attribute value : String to [content : String, group : String] "
						+ "in class org.apache.dubbo.common.config.configcenter.ConfigChangedEvent");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	@Test
	public void shouldChangeAttributeType() {
		RefactoringParser parserCA = new RefactoringParser();

		List<CodeElement> elements = parserCA.getCodeElements("Change Attribute Type",
				"Change Attribute Type	userAgent : String to ctx : CoreContext in class "
						+ "com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	// ------------------------ PATTERN 5 ----------------------------------//
	@Test
	public void shouldReplaceAttribute() {
		RefactoringParser parserRA = new RefactoringParser();

		List<CodeElement> elements = parserRA.getCodeElements("Replace Attribute",
				"Replace Attribute private file : RandomAccessFile "
						+ "from class org.eclipse.jgit.internal.storage.file.PackInserter.Reader.StreamLoader with private packOut : PackStream "
						+ "from class org.eclipse.jgit.internal.storage.file.PackInserter");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);
	}

	// ------------------------ PATTERN 6 ----------------------------------//
	@Test
	public void shouldExtractAttribute() {
		RefactoringParser parserEA = new RefactoringParser();

		List<CodeElement> elements = parserEA.getCodeElements("Extract Attribute",
				"Extract Attribute	private CHARSET : Charset in class com.couchbase.client.core.endpoint.config.ConfigHandlerTest");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

	// ------------------------ PATTERN 7 ----------------------------------//
	@Test
	public void shouldChangeReturnType() {
		RefactoringParser parserCR = new RefactoringParser();

		List<CodeElement> elements = parserCR.getCodeElements("Change Return Type",
				"Change Return Type	Builder to SELF in method public requestBufferWaitStrategy(waitStrategy WaitStrategyFactory) : SELF "
						+ "in class com.couchbase.client.core.env.DefaultCoreEnvironment.Builder");

		assertEquals(2, elements.size());
		assertEquals("publicSSLENABLEDboolean", elements.get(0).attributeName);
		assertEquals("comcouchbaseclientcoreenvDefaultCoreProperties", elements.get(0).className);

	}

}
