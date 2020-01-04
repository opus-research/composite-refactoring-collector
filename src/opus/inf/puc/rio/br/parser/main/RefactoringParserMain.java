      package opus.inf.puc.rio.br.parser.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import opus.inf.puc.rio.br.historic.CodeElement;
import opus.inf.puc.rio.br.historic.Commit;
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
    	commitCollector = new CommitCollector(projectName, "C:\\Users\\anaca\\OneDrive\\PUC-Rio\\OPUS\\CompositeRefactoring\\ICPC2020\\Projects\\presto");
    }
    
	public static void main(String[] args) {
		
		RefactoringParserMain parserMain = new RefactoringParserMain("presto", "presto.csv");
		
	    List<Refactoring> refactorings = parserMain.getRefactorings();
	    ObjectMapper mapper = new ObjectMapper();
	    
	    try {
			mapper.writeValue(new File("presto.json"), refactorings);
		
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	       
		
		//Refactoring ID
		refId =  projectName + "_" + refId;
		
		
		//GetCommit
	    Commit commitObj = commitCollector.getPreviousCommit(commit);
		
	    //Get Refactoring
		ref = new Refactoring(refId, projectName, commitObj, refactoringType, details);
		
		
		//GetCodeElements
	    refParser = new RefactoringParser();
		List<CodeElement> elements = refParser.getCodeElements(refactoringType, details);
		ref.setCodeElements(elements);
		
		
        return ref; 
	   
	}
	
	
	

}
