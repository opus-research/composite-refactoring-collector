package opus.inf.puc.rio.br.parser;

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
    
    private RefactoringParserMain() {
    	commitCollector = new CommitCollector("projectName", "projectPath");
    }
    
	public static void main(String[] args) {
		
		
		
		
		
	}
	
	
	private List<Refactoring> getRefactorings(String refactoringPath) {
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
			fileReader = new FileReader(refactoringPath);

			CSVParser csvFileParser;
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			csvRecords = csvFileParser.getRecords();

			Refactoring refact = null;

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = (CSVRecord) csvRecords.get(i);
				String commit = record.get(COMMIT_KEY);
				
				System.out.println(refactoringPath);
				String refactoringType = record.get(REFACT_KEY);
				
				
				String details = record.get(ELEMENT_KEY);
				String project = "";
				
				
				refact = getRefactoring(project, String.valueOf(i), commit, refactoringType, details);
				
				refactorings.add(refact);
				
				/*if(refactoringType.equals("Extract And Move Method")){
					
					//Get Extract Method
					numberRef = i;
					
					Refactoring refactEM = new Refactoring(commit, "Extract Method", detail, refId);
					
					refactEM.setSpecialExtractMethod();
					refactEM.addRevision(revision);
					refactorings.add(refactEM);
					
					//Get Move Method
					numberRef++;
					refId = revision.revisionId + "_" + numberRef;
					Refactoring refactMM = new Refactoring(commit, "Move Method", detail, refId);
					
					refactMM.setSpecialMoveMethod();
					refactMM.addRevision(revision);
					refactorings.add(refactMM);
				}*/
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return refactorings;

	}
	
	private Refactoring getRefactoring(String project, String refId, String commit,
			String refactoringType, String details){
	    
		Refactoring ref = null;
	       
		
		//GetRefactoringType
		//GetCommit
		//GetDetails 
		refId =  project + "_" + refId;
		ref = new Refactoring(refId, project, commit, refactoringType, details);
		
		//GetCodeElements
	    refParser = new RefactoringParser();
		List<CodeElement> elements = refParser.getCodeElements(refactoringType, details);
		ref.setCodeElements(elements);
		
		
		//GetLastCommit
		
	    String previousCommit = commitCollector.getPreviousCommit(commit);
		ref.setPreviousCommit(previousCommit); 
		
        return ref; 
	   
	}
	
	
	

}
