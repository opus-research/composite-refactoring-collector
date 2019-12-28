package opus.inf.puc.rio.br.parser.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import opus.inf.puc.rio.br.historic.CodeElement;
import opus.inf.puc.rio.br.historic.collect.commit.CommitCollector;
import opus.inf.puc.rio.br.refactoring.Refactoring;
import opus.inf.puc.rio.br.refactoring.parser.RefactoringParser;

public class RefactoringParserMain {
	
	
	private List<Refactoring> refactorings = new ArrayList<Refactoring>();
	private RefactoringParser refParser;
    private CommitCollector commitCollector; 
    private String projectName; 
    private String projectPath;
    
    public RefactoringParserMain(String projectName, String projectPath) {
    	this.projectName = projectName; 
    	this.projectPath = projectPath;
    //	commitCollector = new CommitCollector(projectName, projectName);
    }
    
	public static void main(String[] args) {
		
		RefactoringParserMain parserMain = new RefactoringParserMain("dubbo-test", "dubbo-test.csv");
		
	    List<Refactoring> refactorings = parserMain.getRefactorings();
	    
	    refactorings.forEach( ref -> {
			  System.out.println("Refactoring ");
			  System.out.println(ref.refactoringType);
			  
			  ref.getElements().forEach( elem -> {
				  System.out.println(elem.className);
			  });
			  
			  System.out.println();
			  
		  });
		
		
	}
	
	
	public List<Refactoring> getRefactorings() {
		//for 
		  //GetLine 
		    //GetRefactoring() 
		    //refs.add(ref)
		String COMMIT_KEY = "CommitId";
		String REFACT_KEY = "RefactoringType";
		String ELEMENT_KEY = "RefactoringDetail";
		String[] FILE_HEADER_MAPPING = { COMMIT_KEY, REFACT_KEY, ELEMENT_KEY };

		List csvRecords;
		CSVFormat csvFileFormat = CSVFormat.newFormat(';').withHeader(
								  FILE_HEADER_MAPPING);
		FileReader fileReader;
		List<Refactoring> refactorings = new ArrayList<Refactoring>();
		try {
			fileReader = new FileReader(projectPath);

			CSVParser csvFileParser;
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			csvRecords = csvFileParser.getRecords();

			Refactoring refact = null;

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = (CSVRecord) csvRecords.get(i);
				String commit = record.get(COMMIT_KEY);
				
				System.out.println(projectPath);
				String refactoringType = record.get(REFACT_KEY);
				
				
				String details = record.get(ELEMENT_KEY);
				String project = "";
				
				
				refact = getRefactoring(String.valueOf(i), commit, refactoringType, details);
				
				refactorings.add(refact);
				
			
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return refactorings;

	}
	
	private Refactoring getRefactoring(String refId, String commit,
			String refactoringType, String details){
	    
		Refactoring ref = null;
	       
		
		//GetRefactoringType
		//GetCommit
		//GetDetails 
		refId =  projectName + "_" + refId;
		ref = new Refactoring(refId, projectName, commit, refactoringType, details);
		
		//GetCodeElements
	    refParser = new RefactoringParser();
		List<CodeElement> elements = refParser.getCodeElements(refactoringType, details);
		ref.setCodeElements(elements);
		
		
		//GetLastCommit
		
//	    String previousCommit = commitCollector.getPreviousCommit(commit);
//		ref.setPreviousCommit(previousCommit); 
		
        return ref; 
	   
	}
	
	
	

}
