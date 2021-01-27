package opus.inf.puc.rio.br.model.historic;



import org.bson.codecs.pojo.annotations.BsonProperty;

public class CodeElement {
	
	@BsonProperty(value = "method_name")
	public final String methodName;
	
	@BsonProperty(value = "attribute_name")
	public final String attributeName;
	
	@BsonProperty(value = "class_name")
	public final String className;
	
	@BsonProperty(value = "is_source_code")
	private boolean sourceRefactoredCode;
	
	@BsonProperty(value = "is_target_code")
	private boolean targetRefactoredCode; 
	
	@BsonProperty(value = "package_name")
	private String packageName;
	
	@BsonProperty(value = "details")
	private String details;
	
	
	public CodeElement(String methodName, String attributeName, String className) {
		
		this.methodName = methodName;
		this.attributeName = attributeName;
		this.className = className;
	}
	
	public String getPackageName() {
		// TODO Auto-generated method stub
		return packageName;
	}
	
	
	public void setPackageName(String packageName) {
		
		if(this.packageName == null){
			this.packageName = packageName;
		}
	}

	public boolean isSourceRefactoredCode() {
		return sourceRefactoredCode;
	}

	public void setSourceRefactoredCode(boolean sourceRefactoredCode) {
		this.sourceRefactoredCode = sourceRefactoredCode;
	}

	public boolean isTargetRefactoredCode() {
		return targetRefactoredCode;
	}

	public void setTargetRefactoredCode(boolean targetRefactoredCode) {
		this.targetRefactoredCode = targetRefactoredCode;
	}

	public void setDetails(String details) {
		
		if(this.details == null){
			this.details = details;
		}
	}
	
	public String getDetails() {
		return details;
	}
	
	
	
	
  
	
}
