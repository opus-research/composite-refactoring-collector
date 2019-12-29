package opus.inf.puc.rio.br.refactoring.parser;

import java.util.ArrayList;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringAttributeParser extends RefactoringParser {


	
	public RefactoringAttributeParser(String refactoringType, String refactoringDetails) {
		this.refactoringType = refactoringType;
		this.refactoringDetails = refactoringDetails;
		this.elements = new ArrayList<CodeElement>();
		
	}
	


//	Push Down Attribute	protected mPendingReleasables : Set<Releasable> from class com.facebook.drawee.components.DeferredReleaser to protected mPendingReleasables : Set<Releasable> from class com.facebook.drawee.components.DeferredReleaserLegacyImpl
//	Pull Up Attribute private statement : Statement from class com.couchbase.client.java.query.ParametrizedQuery to private statement : Statement from class com.couchbase.client.java.query.AbstractQuery
	public void getAttributePattern0() {
		
		String sourceAttributeName;
		String targetAttributeName;

		String sourceClassName;
		String targetClassName;

		int sourceAttributeStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int sourceAttributeEndIndex = refactoringDetails.indexOf("from class");

		sourceAttributeName = refactoringDetails.substring(refactoringType.length() + sourceAttributeStartIndex, sourceAttributeEndIndex);

		int sourceClassStartIndex = sourceAttributeEndIndex;
		int sourceClassEndIndex = refactoringDetails.indexOf(" to ");

		sourceClassName = refactoringDetails.substring("from class".length() + sourceClassStartIndex, sourceClassEndIndex);

		int targetAttributeStartIndex = sourceClassEndIndex;
		int targetAttributeEndIndex = refactoringDetails.lastIndexOf("from class");

		targetAttributeName = refactoringDetails.substring(" to ".length() + targetAttributeStartIndex, targetAttributeEndIndex);

		int targetClassStartIndex = targetAttributeEndIndex;
		targetClassName = refactoringDetails.substring("from class".length() + targetClassStartIndex);
		
		sourceAttributeName = sourceAttributeName.replaceAll("\"", "");
		sourceClassName = sourceClassName.replaceAll("\"", "");
		
		targetAttributeName = targetAttributeName.replaceAll("\"", "");
		targetClassName = targetClassName.replaceAll("\"", "");
		
		CodeElement element1 = new CodeElement(null, sourceAttributeName.trim(), sourceClassName.trim());
		CodeElement element2 = new CodeElement(null, targetAttributeName.trim(), targetClassName.trim());
		
		elements.add(element1);
		elements.add(element2);
		
	}
	
	
	
//	Move Attribute	public SSL_ENABLED : boolean from class com.couchbase.client.core.env.DefaultCoreProperties  to class com.couchbase.client.core.env.DefaultCoreEnvironment	
	public void getAttributePattern1() {
		int attributeStartIndex = refactoringDetails.indexOf(refactoringType);
		int attributeLastIndex = refactoringDetails.indexOf("from class");

		String attributeName = refactoringDetails.substring(attributeStartIndex + refactoringType.length(),
				attributeLastIndex);

		int oldClassStartIndex = refactoringDetails.indexOf("from class");
		int oldClassLastIndex = refactoringDetails.indexOf(" to ");

		String oldClassName = refactoringDetails.substring(oldClassStartIndex + "from class".length(),
				oldClassLastIndex);

		int newClassStartIndex = refactoringDetails.lastIndexOf(" to ");

		String newClassName = refactoringDetails.substring(newClassStartIndex + " to class".length());

		CodeElement mainElementCompletePath = new CodeElement(null, attributeName.trim(), oldClassName.trim());

		attributeName = attributeName.replaceAll("\"", "");
		oldClassName = oldClassName.replaceAll("\"", "");
		
		
		newClassName = newClassName.replaceAll("\"", "");
		
		CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
		CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());

		CodeElement mainElement = element1;
		elements.add(element1);
		elements.add(element2);
	}

//	Extract Variable builder : DefaultCoreEnvironment.Builder in method public connect() : void from class com.couchbase.client.core.ThreadCleanupTest
//	Inline Variable addrs : InetAddress[] in method package NetworkAddress(input String, reverseDns boolean) from class com.couchbase.client.core.utils.NetworkAddress
	public void getAttributePattern2() {
		String variableName;
		String methodName;
		String className;

		int variableStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int variableEndIndex = refactoringDetails.lastIndexOf("in method");

		variableName = refactoringDetails.substring(refactoringType.length() + variableStartIndex, variableEndIndex);
		
		int methodStartIndex = variableEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("from class");

		methodName = refactoringDetails.substring("in method".length() + methodStartIndex, methodEndIndex);
	
		int classIndex = methodEndIndex;

		className = refactoringDetails.substring("from class".length() + classIndex);
		
		methodName = methodName.replaceAll("\"", "");
		variableName = variableName.replaceAll("\"", "");
		
		className = className.replaceAll("\"", "");
		
		CodeElement element1 = new CodeElement(methodName.trim(), variableName.trim(), className.trim());
		elements.add(element1);
	}

	/*
	 * Parameterize Variable stream : DCPStream to connection : DCPConnection in
	 * method private handleDCPRequest(ctx ChannelHandlerContext, connection
	 * DCPConnection, msg FullBinaryMemcacheResponse) : void in class
	 * com.couchbase.client.core.endpoint.dcp.DCPHandler Rename Variable newStreamId
	 * : int to streamId : int in method public addStream(connectionName String) :
	 * int in class com.couchbase.client.core.endpoint.dcp.DCPConnection Rename
	 * Parameter id : int to name : String in method public DCPConnection(env
	 * CoreEnvironment, name String, bucket1 String) in class
	 * com.couchbase.client.core.endpoint.dcp.DCPConnection Replace Variable With
	 * Attribute executor : Executor to disruptorExecutor : ExecutorService in
	 * method public CouchbaseCluster(environment Environment) in class
	 * com.couchbase.client.core.cluster.CouchbaseCluster Split Variable config :
	 * ReferenceConfig<?> to [proxiesOfType : ConcurrentMap<String,Object>, key :
	 * String] in method public get(referenceConfig ReferenceConfig<T>) : T in class
	 * org.apache.dubbo.bootstrap.ReferenceConfigCache Change Variable Type dst :
	 * Ref to dst : DhtRef in method private resolve(ref DhtRef" depth int loose
	 * RefList<DhtRef>) : DhtRef in class
	 * org.eclipse.jgit.storage.dht.DhtRefDatabase Change Parameter Type environment
	 * : CoreEnvironment to ctx : CoreContext in method public
	 * KeyValueFeatureHandler(ctx CoreContext) in class
	 * com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler Split Parameter
	 * value : String to [content : String, group : String] in method public
	 * ConfigChangedEvent(key String, group String, content String) in class
	 * org.apache.dubbo.common.config.configcenter.ConfigChangedEvent Merge Variable
	 * [type : int" position : int packedSize : long inflatedSize : long] to b :
	 * GitStore.ObjectInfo.Builder in method private insertStream(type int
	 * inflatedSize long in InputStream) : ObjectId in class
	 * org.eclipse.jgit.storage.dht.DhtInserter Merge Parameter [bucket : String,
	 * rawConfig : String] to ctx : ProposedBucketConfigContext in method public
	 * proposeBucketConfig(ctx ProposedBucketConfigContext) : void in class
	 * com.couchbase.client.core.config.DefaultConfigurationProvider
	 */
	public void getAttributePattern3() {

		String sourceVariableName;
		String targetVariableName;

		String methodName;
		String className;

		int sourceVariableStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int sourceVariableEndIndex = refactoringDetails.lastIndexOf(" to ");

		sourceVariableName = refactoringDetails.substring(refactoringType.length() + sourceVariableStartIndex, sourceVariableEndIndex);

		int targetVariableStartIndex = sourceVariableEndIndex;
		int targetVariableEndIndex = refactoringDetails.lastIndexOf("in method");

		targetVariableName = refactoringDetails.substring(" to ".length() + targetVariableStartIndex, targetVariableEndIndex);
				
		int methodStartIndex = targetVariableEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("in class");

		methodName = refactoringDetails.substring("in method".length() + methodStartIndex, methodEndIndex);

		int classIndex = methodEndIndex;

		className = refactoringDetails.substring("in class".length() + classIndex);
		
		
		methodName = methodName.replaceAll("\"", "");
		sourceVariableName = sourceVariableName.replaceAll("\"", "");
		
		targetVariableName = targetVariableName.replaceAll("\"", "");
		className = className.replaceAll("\"", "");
		
		CodeElement element1 = new CodeElement(methodName.trim(), sourceVariableName.trim(), className.trim());
		CodeElement element2 = new CodeElement(methodName.trim(), targetVariableName.trim(), className.trim());
		
		elements.add(element1);
		elements.add(element2);
		
		
		
	}

	/*
	 * Rename Attribute stream : Observable<DCPRequest> to connection :
	 * DCPConnection in class
	 * com.couchbase.client.core.message.dcp.StreamRequestResponse Merge Attribute
	 * [env : CoreEnvironment, responseBuffer : RingBuffer<ResponseEvent>] to ctx :
	 * CoreContext in class com.couchbase.client.core.service.AbstractDynamicService
	 * Split Attribute value : String to [content : String, group : String] in class
	 * org.apache.dubbo.common.config.configcenter.ConfigChangedEvent Change
	 * Attribute Type userAgent : String to ctx : CoreContext in class
	 * com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler
	 */
	public void getAttributePattern4() {
		String sourceParameterName;
		String targetParameterName;

		String className;

		int sourceParameterStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int sourceParameterEndIndex = refactoringDetails.lastIndexOf(" to ");

		sourceParameterName = refactoringDetails.substring(refactoringType.length() + sourceParameterStartIndex, sourceParameterEndIndex);

		int targetParameterStartIndex = sourceParameterEndIndex;
		int targetParameterEndIndex = refactoringDetails.lastIndexOf("in class");

		targetParameterName = refactoringDetails.substring(" to ".length() + targetParameterStartIndex, targetParameterEndIndex);

		int classIndex = refactoringDetails.lastIndexOf("in class");

		className = refactoringDetails.substring("in class".length() + classIndex);

		sourceParameterName = sourceParameterName.replaceAll("\"", "");
		className = className.replaceAll("\"", "");
				
		targetParameterName = targetParameterName.replaceAll("\"", "");

		CodeElement element1 = new CodeElement(null, sourceParameterName.trim(), className.trim());
		CodeElement element2 = new CodeElement(null, targetParameterName.trim(), className.trim());
		
		elements.add(element1);
		elements.add(element2);
	}

	/*
	 * Replace Attribute private file : RandomAccessFile from class
	 * org.eclipse.jgit.internal.storage.file.PackInserter.Reader.StreamLoader with
	 * private packOut : PackStream from class
	 * org.eclipse.jgit.internal.storage.file.PackInserter
	 */
	public void getAttributePattern5() {

		String sourceAttributeName;
		String targetAttributeName;

		String sourceClassName;
		String targetClassName;

		int sourceAttributeStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int sourceAttributeEndIndex = refactoringDetails.indexOf("from class");

		sourceAttributeName = refactoringDetails.substring(refactoringType.length() + sourceAttributeStartIndex, sourceAttributeEndIndex);

		int sourceClassStartIndex = sourceAttributeEndIndex;
		int sourceClassEndIndex = refactoringDetails.indexOf(" with ");

		sourceClassName = refactoringDetails.substring("from class".length() + sourceClassStartIndex, sourceClassEndIndex);

		int targetAttributeStartIndex = sourceClassEndIndex;
		int targetAttributeEndIndex = refactoringDetails.lastIndexOf("from class");

		targetAttributeName = refactoringDetails.substring(" with ".length() + targetAttributeStartIndex, targetAttributeEndIndex);

		int targetClassStartIndex = targetAttributeEndIndex;
		targetClassName = refactoringDetails.substring("from class".length() + targetClassStartIndex);
		

		sourceAttributeName = sourceAttributeName.replaceAll("\"", "");
		sourceClassName = sourceClassName.replaceAll("\"", "");
				
		targetAttributeName = targetAttributeName.replaceAll("\"", "");
		targetClassName = targetClassName.replaceAll("\"", "");

		CodeElement element1 = new CodeElement(null, sourceAttributeName.trim(), sourceClassName.trim());
		CodeElement element2 = new CodeElement(null, targetAttributeName.trim(), targetClassName.trim());
		
		elements.add(element1);
		elements.add(element2);

	}

	/*
	 * Extract Attribute private CHARSET : Charset in class
	 * com.couchbase.client.core.endpoint.config.ConfigHandlerTest
	 */
	public void getAttributePattern6() {
	//	Pattern6 - refactoringType sourceAttributeName "in class" className  

		String sourceAttributeName;

		String sourceClassName;
	
		int sourceAttributeStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int sourceAttributeEndIndex = refactoringDetails.indexOf("in class");

		sourceAttributeName = refactoringDetails.substring(refactoringType.length() + sourceAttributeStartIndex, sourceAttributeEndIndex);

		int sourceClassStartIndex = sourceAttributeEndIndex;
		
		sourceClassName = refactoringDetails.substring("in class".length() + sourceClassStartIndex);


		sourceAttributeName = sourceAttributeName.replaceAll("\"", "");
		sourceClassName = sourceClassName.replaceAll("\"", "");
				

		CodeElement element1 = new CodeElement(null, sourceAttributeName.trim(), sourceClassName.trim());	
		elements.add(element1);
	
	}

	/*
	 * Change Return Type Builder to SELF in method public
	 * requestBufferWaitStrategy(waitStrategy WaitStrategyFactory) : SELF in class
	 * com.couchbase.client.core.env.DefaultCoreEnvironment.Builder
	 */
	public void getAttributePattern7() {
		//Pattern7 - refactoringType sourceClassType "to" targetClassType "in method" methodName "in class" className  
       
		String sourceClassName;
		String targetClassName;

		String methodName;
		String className;
		
		int sourceClassStartIndex = refactoringDetails.lastIndexOf(refactoringType);
		int sourceClassEndIndex = refactoringDetails.indexOf(" to ");

		sourceClassName = refactoringDetails.substring(refactoringType.length() + sourceClassStartIndex, sourceClassEndIndex);

		int targetClassStartIndex = sourceClassEndIndex;
		int targetClassEndIndex = refactoringDetails.indexOf("in method ");

		targetClassName = refactoringDetails.substring(" to ".length() + targetClassStartIndex, targetClassEndIndex);

		int methodNameStartIndex = targetClassEndIndex;
		int methodNameEndIndex= refactoringDetails.lastIndexOf("in class");

		methodName = refactoringDetails.substring("in method ".length() + methodNameStartIndex, methodNameEndIndex);

		int classStartIndex = methodNameEndIndex;
		className = refactoringDetails.substring("in class".length() + classStartIndex);
		

		methodName = methodName.replaceAll("\"", "");
		className = className.replaceAll("\"", "");
		
		CodeElement element1 = new CodeElement(methodName.trim(), null , className.trim());
		
		element1.setDetails(sourceClassName.trim() + " to " + targetClassName.trim());
		elements.add(element1);
	}

	

}
