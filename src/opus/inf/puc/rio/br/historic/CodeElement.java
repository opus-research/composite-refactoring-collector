package opus.inf.puc.rio.br.historic;

public class CodeElement {
		
	public final String methodName;
	public final String attributeName;
	public final String className;
	
	private String packageName;
	
	
	public CodeElement(String methodName, String attributeName, String className) {
		
		this.methodName = methodName;
		this.attributeName = attributeName;
		this.className = className;
	}
	
	public CodeElement(String methodName, String attributeName,
			           String className, String packageName) {
		
		this.methodName = methodName;
		this.attributeName = attributeName;
		this.className = className;
		this.packageName = packageName;
	}

	public String getPackageName() {
		// TODO Auto-generated method stub
		return packageName;
	}
	
	
	
	
	
  
	
	
}
