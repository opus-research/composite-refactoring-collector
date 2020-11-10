package opus.inf.puc.rio.br.historic;

public class CodeElement {
		
	public final String methodName;
	public final String attributeName;
	public final String className;
	private boolean sourceRefactoredCode;
	private boolean targetRefactoredCode; 
	
	private String packageName;
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
