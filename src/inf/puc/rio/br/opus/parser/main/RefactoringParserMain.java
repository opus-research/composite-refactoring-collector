package inf.puc.rio.br.opus.parser.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.model.refactoring.historic.Commit;
import inf.puc.rio.br.opus.model.refactoring.historic.collect.commit.CommitCollector;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.databind.ObjectMapper;

import inf.puc.rio.br.opus.model.refactoring.miner.RefMinerOutput;
import inf.puc.rio.br.opus.model.refactoring.miner.RefactoringRefMinerOutput;
import inf.puc.rio.br.opus.parser.refactoring.RefactoringParser;

public class RefactoringParserMain {
	
	private List<Refactoring> refactorings = new ArrayList<Refactoring>();
	private RefactoringParser refParser;
    private CommitCollector commitCollector;
    private String projectName; 
    private String projectPath;
    
    public RefactoringParserMain(String projectName, String projectPath, String branch) {
    	this.projectName = projectName; 
    	this.projectPath = projectPath;
    	this.refParser = new RefactoringParser();
    	commitCollector = new CommitCollector(projectName, projectPath, branch);
    }
    
    public RefactoringParserMain() {
		this.refParser = new RefactoringParser();
    }
    
	public static void main(String[] args) {

		String projectName = "meyer-control";
        String projectPath = "C:\\Users\\anaca\\OneDrive\\PUC-Rio\\OPUS\\CompositeRefactoring\\ICSE2023\\projects\\source-code\\projects\\meyer-control";
		RefactoringParserMain parserMain = new RefactoringParserMain(projectName, projectPath, "master");
		
        List<Refactoring> refactorings = parserMain.getRefactoringsFromRefMinerJson("refactorings\\" + projectName + "-refactorings.json");

		parserMain.writeRefactoringsToJson(projectName + "-refactorings.json", refactorings);
	}
	

	
	public List<Refactoring> parserRefactoringsFromRefMinerOutput(List<RefactoringRefMinerOutput> refactoringsOutput){
		List<Refactoring> refs = new ArrayList<Refactoring>();
		
		for(RefactoringRefMinerOutput refOutput : refactoringsOutput) {
			
			String refId = refOutput.project + "_" + String.valueOf(refs.size());

			Commit commit = new Commit(refOutput.commit,"", 0);
			Refactoring ref = new Refactoring(null, refId, refOutput.project, commit, refOutput.getType(), refOutput.getDescription());

			//GetCodeElements
			List<CodeElement> elements = refParser.getCodeElements(refOutput.getType(), refOutput.getDescription());
			ref.setElements(elements);

			refs.add(ref);
			
		}
		
		return refs; 
		
	}
	
	
	private List<Refactoring> getRefactoringsFromRefMinerJson(String path) {
		
	    RefMinerOutput refMinerOutput = new RefMinerOutput();
	    ObjectMapper mapper = new ObjectMapper();
	    List<Refactoring> refs = new ArrayList<Refactoring>();
	    
	    try {
			refMinerOutput = mapper.readValue(new File(path), RefMinerOutput.class);
			
			refMinerOutput.getCommits().forEach( commit -> {
				String commitHash = commit.getSha1();
				
				commit.getRefactorings().forEach( ref -> {
					
					 String refType = ref.getType();

                    for (String refactoringType : refParser.getRefactorings()) {

                        if(refactoringType.trim().equals(refType)){
                            String details = ref.getDescription();
                            Refactoring refactoring = this.getRefactoring(String.valueOf(refs.size()), commitHash, refType, details);
                            refs.add(refactoring);
                        }
                    }

				});
			});

		
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return refs;
	}
	
	
	private void writeRefactoringsToJson() {
		RefactoringParserMain parserMain = new RefactoringParserMain("presto", "presto.csv", "");
		
	    List<Refactoring> refactorings = parserMain.getRefactorings();
	    ObjectMapper mapper = new ObjectMapper();
	    
	    try {
			mapper.writeValue(new File("presto.json"), refactorings);
		
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeRefactoringsToJson(String jsonName, List<Refactoring> refactorings) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.writeValue(new File(jsonName), refactorings);

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
		ref = new Refactoring(null, refId, projectName, commitObj, refactoringType, details);
		
		
		//GetCodeElements
		List<CodeElement> elements = refParser.getCodeElements(refactoringType, details);
		ref.setElements(elements);
		
		
        return ref; 
	   
	}
	
	
	

}
