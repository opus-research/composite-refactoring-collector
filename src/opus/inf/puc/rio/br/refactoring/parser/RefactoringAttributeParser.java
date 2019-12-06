package opus.inf.puc.rio.br.refactoring.parser;

import opus.inf.puc.rio.br.historic.CodeElement;

public class RefactoringAttributeParser {
	
	// "Push Down Attribute	private resetType : ResetType from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog 
		// to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
//		public void getElementPushDownAttribute(){
//			int attributeStartIndex = refactoringDetail.indexOf("Push Down Attribute ");
//			int attributeLastIndex = refactoringDetail.indexOf("from class");
//			// "Push Down Attribute	private resetType : ResetType from class org.eclipse.egit.ui.internal.dialogs.BranchSelectionDialog 
//			// to class org.eclipse.egit.ui.internal.dialogs.ResetTargetSelectionDialog"
//			public void getElementPushDownAttribute(){
//				int attributeStartIndex = refactoringDetail.indexOf("Push Down Attribute ");
//				int attributeLastIndex = refactoringDetail.indexOf("from class");
//				
//				String attributeName = refactoringDetail.substring(attributeStartIndex + "Push Down Attribute ".length() ,
//																attributeLastIndex);
//				
//				int oldClassStartIndex = refactoringDetail.indexOf("from class");
//				int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//				
//				
//				String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//																  oldClassLastIndex);
//				
//			
//				int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//				
//				String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//				
//				mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				
//				
//				CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//			
//				mainElement = element1;
//				elements.add(element1);
//				elements.add(element2);
//			}
//			
//			// "Pull Up Attribute	private password : 
//			// String from class com.couchbase.client.core.message.cluster.OpenBucketRequest 
//			//to class com.couchbase.client.core.message.AbstractCouchbaseRequest"
//			public void getElementPullUpAttribute(){
//				int attributeStartIndex = refactoringDetail.indexOf("Pull Up Attribute ");
//				int attributeLastIndex = refactoringDetail.indexOf("from class");
//				
//				String attributeName = refactoringDetail.substring(attributeStartIndex + "Pull Up Attribute ".length() ,
//																attributeLastIndex);
//				
//				int oldClassStartIndex = refactoringDetail.indexOf("from class");
//				int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//				
//				
//				String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//																  oldClassLastIndex);
//				
//			
//				int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//				
//				String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//			
//				mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				
//				CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//			
//				mainElement = element1;
//				elements.add(element1);
//				elements.add(element2);
//			}
//			
//			//"Move Attribute	public SSL_ENABLED : boolean
//			//from class com.couchbase.client.core.env.DefaultCoreProperties 
//			//to class com.couchbase.client.core.env.DefaultCoreEnvironment"
//			public void getElementMoveAttribute(){
//				int attributeStartIndex = refactoringDetail.indexOf("Move Attribute ");
//				int attributeLastIndex = refactoringDetail.indexOf("from class");
//				
//				String attributeName = refactoringDetail.substring(attributeStartIndex + "Move Attribute ".length() ,
//																attributeLastIndex);
//				
//				int oldClassStartIndex = refactoringDetail.indexOf("from class");
//				int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//				
//				
//				String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//																  oldClassLastIndex);
//				
//			
//				int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//				
//				String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//				
//				mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//				newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//				
//				
//				CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//				CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//			
//				mainElement = element1;
//				
//				elements.add(element1);
//				elements.add(element2);
//			}
//			String attributeName = refactoringDetail.substring(attributeStartIndex + "Push Down Attribute ".length() ,
//															attributeLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//		
//			int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//			
//			mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			
//			CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		// "Pull Up Attribute	private password : 
//		// String from class com.couchbase.client.core.message.cluster.OpenBucketRequest 
//		//to class com.couchbase.client.core.message.AbstractCouchbaseRequest"
//		public void getElementPullUpAttribute(){
//			int attributeStartIndex = refactoringDetail.indexOf("Pull Up Attribute ");
//			int attributeLastIndex = refactoringDetail.indexOf("from class");
//			
//			String attributeName = refactoringDetail.substring(attributeStartIndex + "Pull Up Attribute ".length() ,
//															attributeLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//		
//			int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//		
//			mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//		
//			mainElement = element1;
//			elements.add(element1);
//			elements.add(element2);
//		}
//		
//		//"Move Attribute	public SSL_ENABLED : boolean
//		//from class com.couchbase.client.core.env.DefaultCoreProperties 
//		//to class com.couchbase.client.core.env.DefaultCoreEnvironment"
//		public void getElementMoveAttribute(){
//			int attributeStartIndex = refactoringDetail.indexOf("Move Attribute ");
//			int attributeLastIndex = refactoringDetail.indexOf("from class");
//			
//			String attributeName = refactoringDetail.substring(attributeStartIndex + "Move Attribute ".length() ,
//															attributeLastIndex);
//			
//			int oldClassStartIndex = refactoringDetail.indexOf("from class");
//			int oldClassLastIndex = refactoringDetail.indexOf(" to ");
//			
//			
//			String oldClassName = refactoringDetail.substring(oldClassStartIndex + "from class".length() ,
//															  oldClassLastIndex);
//			
//		
//			int newClassStartIndex = refactoringDetail.lastIndexOf(" to ");
//			
//			String newClassName = refactoringDetail.substring(newClassStartIndex + " to class".length());
//			
//			mainElementCompletePath =  new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			oldClassName = oldClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			attributeName = attributeName.replaceAll("[^a-zA-Z0-9]+","");
//			newClassName = newClassName.replaceAll("[^a-zA-Z0-9]+","");
//			
//			
//			CodeElement element1 = new CodeElement(null, attributeName.trim(), oldClassName.trim());
//			CodeElement element2 = new CodeElement(null, attributeName.trim(), newClassName.trim());
//		
//			mainElement = element1;
//			
//			elements.add(element1);
//			elements.add(element2);
//		}
	/*
	  Extract Variable builder : DefaultCoreEnvironment.Builder in method public connect() : void from class com.couchbase.client.core.ThreadCleanupTest
	*/
	public void getExtractVariable() {
		String variableName;
		String methodName; 
		String className;
		
		int variableStartIndex = refactoringDetails.lastIndexOf("Extract Variable ");
		int variableEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
		variableName =  refactoringDetails.substring(variableStartIndex, variableEndIndex);
		
		
		int methodStartIndex = variableEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("from class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
		
	} 
	/*
	   Inline Variable addrs : InetAddress[] in method package NetworkAddress(input String, reverseDns boolean) from class com.couchbase.client.core.utils.NetworkAddress
	*/
	public void getInlineVariable() {
		
		String variableName;
		String methodName; 
		String className;
		
		int variableStartIndex = refactoringDetails.lastIndexOf("Inline Variable ");
		int variableEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
		variableName =  refactoringDetails.substring(variableStartIndex, variableEndIndex);
		
		
		int methodStartIndex = variableEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("from class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
	}
	
	/*
	  Parameterize Variable	stream : DCPStream to connection : DCPConnection in method private handleDCPRequest(ctx ChannelHandlerContext, connection DCPConnection, msg FullBinaryMemcacheResponse) : void in class com.couchbase.client.core.endpoint.dcp.DCPHandler
	*/
	public void getParameterizeVariable() {
		
		String sourceVariableName;
		String targetVariableName;
		
		String methodName; 
		String className;
		
		int sourceVariableStartIndex = refactoringDetails.lastIndexOf("Parameterize Variable ");
		int sourceVariableEndIndex = refactoringDetails.lastIndexOf("to"); 
		
		sourceVariableName =  refactoringDetails.substring(variableStartIndex, variableEndIndex);
		
		int targetVariableStartIndex = sourceVariableEndIndex;
		int targetVariableEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
	
		
		int methodStartIndex = targetVariableEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("in class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
	} 
	/*
	  Rename Variable newStreamId : int to streamId : int in method public addStream(connectionName String) : int in class com.couchbase.client.core.endpoint.dcp.DCPConnection
	*/
	public void getRenameVariable() {
		String sourceVariableName;
		String targetVariableName;
		
		String methodName; 
		String className;
		
		int sourceVariableStartIndex = refactoringDetails.lastIndexOf("Rename Variable ");
		int sourceVariableEndIndex = refactoringDetails.lastIndexOf("to"); 
		
		sourceVariableName =  refactoringDetails.substring(variableStartIndex, variableEndIndex);
		
		int targetVariableStartIndex = sourceVariableEndIndex;
		int targetVariableEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
	
		
		int methodStartIndex = targetVariableEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("in class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
		
	} 
	
	/*
	  Rename Parameter id : int to name : String in method public DCPConnection(env CoreEnvironment, name String, bucket String) in class com.couchbase.client.core.endpoint.dcp.DCPConnection
	*/
	public void getRenameParameter() {
		String sourceParameterName;
		String targetParameterName;
		
		String methodName; 
		String className;
		
		int sourceParameterStartIndex = refactoringDetails.lastIndexOf("Rename Parameter ");
		int sourceParameterEndIndex = refactoringDetails.lastIndexOf("to"); 
		
		sourceParameterName =  refactoringDetails.substring(sourceParameterStartIndex, targetParameterEndIndex);
		
		int targetParametertartIndex = sourceParameterEndIndex;
		int targetParameterEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
	        targetParameterName =  refactoringDetails.substring(targetParameterStartIndex, targetParameterEndIndex);
		
		int methodStartIndex = targetParameterEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("in class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
	}  
	
	/*
	   Rename Attribute stream : Observable<DCPRequest> to connection : DCPConnection in class com.couchbase.client.core.message.dcp.StreamRequestResponse		
	*/
	public void getRenameAttribute() {
		String sourceParameterName;
		String targetParameterName;
		
		String methodName; 
		String className;
		
		int sourceParameterStartIndex = refactoringDetails.lastIndexOf("Rename Attribute ");
		int sourceParameterEndIndex = refactoringDetails.lastIndexOf("to"); 
		
		sourceParameterName =  refactoringDetails.substring(sourceParameterStartIndex, targetParameterEndIndex);
		
		int targetParametertartIndex = sourceParameterEndIndex;
		int targetParameterEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
	        targetParameterName =  refactoringDetails.substring(targetParameterStartIndex, targetParameterEndIndex);
		
		int methodStartIndex = targetParameterEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("in class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
	} 
       
	/*
	   Replace Variable With Attribute executor : Executor to disruptorExecutor : ExecutorService in method public CouchbaseCluster(environment Environment) in class com.couchbase.client.core.cluster.CouchbaseCluster
	*/
	public void getReplaceVariableWithAttribute() {
	    
	       String sourceParameterName;
		String targetParameterName;
		
		String methodName; 
		String className;
		
		int sourceParameterStartIndex = refactoringDetails.lastIndexOf("Replace Variable With Attribute ");
		int sourceParameterEndIndex = refactoringDetails.lastIndexOf("to"); 
		
		sourceParameterName =  refactoringDetails.substring(sourceParameterStartIndex, targetParameterEndIndex);
		
		int targetParametertartIndex = sourceParameterEndIndex;
		int targetParameterEndIndex = refactoringDetails.lastIndexOf("in method"); 
		
	        targetParameterName =  refactoringDetails.substring(targetParameterStartIndex, targetParameterEndIndex);
		
		int methodStartIndex = targetParameterEndIndex;
		int methodEndIndex = refactoringDetails.lastIndexOf("in class");
		
                methodName = refactoringDetails.substring(methodStartIndex, methodEndIndex);
		
		int classIndex = methodEndIndex; 
		
                className = refactoringDetails.substring(classIndex);
	}
	
	/*
	   Replace Attribute	private file : RandomAccessFile from class org.eclipse.jgit.internal.storage.file.PackInserter.Reader.StreamLoader with private packOut : PackStream from class org.eclipse.jgit.internal.storage.file.PackInserter
	*/
	public void getReplaceAttribute() {}
	
	/*
	    Merge Variable [type : int"	position : int	packedSize : long	inflatedSize : long] to b : GitStore.ObjectInfo.Builder in method private insertStream(type int	inflatedSize long	in InputStream) : ObjectId in class org.eclipse.jgit.storage.dht.DhtInserter								
	*/
	public void getMergeVariable() {}
	
	/*
	  Merge Parameter [bucket : String, rawConfig : String] to ctx : ProposedBucketConfigContext in method public proposeBucketConfig(ctx ProposedBucketConfigContext) : void in class com.couchbase.client.core.config.DefaultConfigurationProvider																							
	*/
	public void getMergeParameter() {}
	
	/*
	  Merge Attribute [env : CoreEnvironment, responseBuffer : RingBuffer<ResponseEvent>] to ctx : CoreContext in class com.couchbase.client.core.service.AbstractDynamicService																																	 
	*/
	public void getMergeAttribute() {}
	
	/*
	  Split Variable config : ReferenceConfig<?> to [proxiesOfType : ConcurrentMap<String,Object>, key : String] in method public get(referenceConfig ReferenceConfig<T>) : T in class org.apache.dubbo.bootstrap.ReferenceConfigCache																																						
	*/
	public void getSplitVariable() {} 
	
	/*
	  Split Parameter value : String to [content : String, group : String] in method public ConfigChangedEvent(key String, group String, content String) in class org.apache.dubbo.common.config.configcenter.ConfigChangedEvent																																								
	*/
	public void getSplitParameter() {} 
	
	/*
	  Split Attribute value : String to [content : String, group : String] in class org.apache.dubbo.common.config.configcenter.ConfigChangedEvent																																									
	*/
	public void getSplitAttribute() {} 
	
	/*
	   Change Variable Type	dst : Ref to dst : DhtRef in method private resolve(ref DhtRef"	depth int	loose RefList<DhtRef>) : DhtRef in class org.eclipse.jgit.storage.dht.DhtRefDatabase																																														
	*/
	public void getChangeVariableType() {}
	
	/*
	   Change Parameter Type environment : CoreEnvironment to ctx : CoreContext in method public KeyValueFeatureHandler(ctx CoreContext) in class com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler																																																						
	*/
	public void getChangeParameterType() {} 
	
	/*
	   Change Return Type Builder to SELF in method public requestBufferWaitStrategy(waitStrategy WaitStrategyFactory) : SELF in class com.couchbase.client.core.env.DefaultCoreEnvironment.Builder																																																							
	*/
	public void getChangeReturnType() {} 
	
	/*
	  Change Attribute Type	userAgent : String to ctx : CoreContext in class com.couchbase.client.core.endpoint.kv.KeyValueFeatureHandler
	*/
	public void getChangeAttributeType() {} 
	
	/*
	  Extract Attribute private CHARSET : Charset in class com.couchbase.client.core.endpoint.config.ConfigHandlerTest	
	*/
	public void getExtractAttribute() {}
	

}
