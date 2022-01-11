package inf.puc.rio.br.opus.model.refactoring.historic;



import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeElement {

	public final String methodName;
	public final String attributeName;
	public final String className;
	
	@JsonProperty("sourceRefactoredCode")
	private boolean sourceRefactoredCode;
	
	@JsonProperty(value = "targetRefactoredCode")
	private boolean targetRefactoredCode; 
	
	@JsonProperty(value = "packageName")
	private String packageName;
	
	@JsonProperty(value = "details")
	private String details;
	
	
	public CodeElement(	@JsonProperty("methodName") String methodName,
					    @JsonProperty("attributeName") String attributeName,
					    @JsonProperty("className") String className) {
		
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
