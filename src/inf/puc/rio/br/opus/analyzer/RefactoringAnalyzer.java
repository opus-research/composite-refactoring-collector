package inf.puc.rio.br.opus.analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.refactoring.historic.CodeElement;
import inf.puc.rio.br.opus.collector.RefactoringCollector;
import inf.puc.rio.br.opus.model.refactoring.miner.CommitRefMinerOutput;
import inf.puc.rio.br.opus.model.refactoring.miner.RefMinerOutput;
import inf.puc.rio.br.opus.model.refactoring.miner.RefactoringRefMinerOutput;
import inf.puc.rio.br.opus.parser.main.RefactoringParserMain;
import inf.puc.rio.br.opus.utils.CsvWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map.Entry;

public class RefactoringAnalyzer {
	
	public static void main(String[] args) throws IOException {

		RefactoringAnalyzer analyzer = new RefactoringAnalyzer();
        analyzer.getRefactoredClassesTask();
		//analyzer.getRefactoringsFromRefMiner("C:\\Users\\anaca\\Executaveis\\RefactoringMiner-2.0.0\\"
		//		+ "RefactoringMiner-2.0.0\\build\\distributions\\RefactoringMiner-1.0\\"
		//		+ "RefactoringMiner-1.0\\bin\\refactoring-toy-example",
		//		"36287f7c3b09eff78395267a3ac0d7da067863fd");
	}
	
	private void getRefactoredClassesTask() {
		RefactoringCollector collector = new RefactoringCollector();
		RefactoringParserMain parser = new RefactoringParserMain();
		
		List<RefactoringRefMinerOutput> refsOutput = collector.getRefactoringsFromRefMinerOutput("C:\\Users\\anaca\\Downloads\\spring-boot-refactorings.json");
		
	    List<Refactoring> refs = parser.parserRefactoringsFromRefMinerOutput(refsOutput);
		
	    List<RefactoredClass> refactoredClasses = this.getGroupsOfRefactoredClasses(refs);

        List<RefactoredClass> mostCommonRefactoredClasses = this.getMostCommonRefactoredClasses(refactoredClasses);
	    //Rank the most common refactored classes
	    this.writeGroupsOfRefactoredClassesFormat2(mostCommonRefactoredClasses);
	}

    public List<String> convertRefactoringListInText(List<Refactoring> refactorings){
		List<String> refactoringsTextList = refactorings.stream()
											.map(refactoring -> refactoring.getRefactoringType())
											.collect(Collectors.toList());
		return refactoringsTextList;
	}

	private List<RefactoredClass> getMostCommonRefactoredClasses(List<RefactoredClass> refactoredClasses){

        List<RefactoredClass> mostCommonRefactoredClasses = refactoredClasses.stream()
                .sorted(Comparator.comparingInt(RefactoredClass::getNumberOfRefactorings)
				.reversed())
                .collect(Collectors.toList());

        return mostCommonRefactoredClasses;
    }

    
    
	private void writeGroupsOfRefactoredClasses(Map<String, Set<Refactoring>> groupsOfRefactoredClasses) {
		// TODO Auto-generated method stub
		CsvWriter csv = new CsvWriter("groupsOfRefactoredClasses-presto.csv", ',', Charset.forName("ISO-8859-1"));
		try {
			csv.write("Class");
			csv.write("Number of Refactorings");
			csv.write("Refactoring ID");
			csv.write("Refactoring Type");
			csv.write("Commit");
			csv.endRecord();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		groupsOfRefactoredClasses.entrySet().forEach(refClass -> {

			try {
				
				
				Set<Refactoring> refsSet = groupsOfRefactoredClasses.get(refClass.getKey());
				for (Refactoring ref : refsSet) {
					
					// System.out.println(ref.getRefactoringType());
					
								//Refactored Class
								csv.write(refClass.getKey());
								
								
								//Number of Refactorings 
								int numberOfRefs = refsSet.size();
								csv.write(String.valueOf(numberOfRefs));
								
								//Refactoring ID 
								csv.write(ref.getRefactoringId());
								
								//Refactoring Type
								csv.write(ref.getRefactoringType());
								
								//Commit
								csv.write(ref.getCurrentCommit().commit);
								csv.endRecord();
									
				}
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		csv.close();
		
	}

	private void writeGroupsOfRefactoredClassesFormat2(List<RefactoredClass> groupsOfRefactoredClasses) {
		// TODO Auto-generated method stub
		CsvWriter csv = new CsvWriter("groupsOfRefactoredClasses-spring.csv", ',', Charset.forName("ISO-8859-1"));
		try {
			csv.write("Class");
			csv.write("Number of Refactorings");
			csv.write("Refactoring ID");
			csv.write("Refactoring Type");
			csv.write("Commit");
			csv.write("Refactoring Details");
			csv.endRecord();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		groupsOfRefactoredClasses.forEach(refClass -> {

			try {

				csv.write(refClass.getClassName());


				//Number of Refactorings
				int numberOfRefs = refClass.getRefactorings().size();
				csv.write(String.valueOf(numberOfRefs));
				csv.write(""); // refId
				csv.write(""); // refType
				csv.write(""); // commit
				csv.write(""); // refDetails
				csv.endRecord();
				for (Refactoring ref : refClass.getRefactorings()) {

					// System.out.println(ref.getRefactoringType());

					//Refactored Class
					csv.write("");


					//Number of Refactorings
					csv.write(String.valueOf(""));

					//Refactoring ID
					csv.write(ref.getRefactoringId());

					//Refactoring Type
					csv.write(ref.getRefactoringType());

					//Commit
					csv.write(ref.getCurrentCommit().commit);

					//Refactoring Details
					csv.write(ref.getRefactoringDetail());
					csv.endRecord();

				}


			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		csv.close();

	}


	public void writeGroupsOfRefactoredClassesByCommits(Map<String, Set<Refactoring>> groupsOfRefactoredClasses) {
		// TODO Auto-generated method stub
		   String commits = "27c35db739b0146b2a5e96314d1165517a10a256, 5149d92be7295862532a7e4dc2db38641294e94e, "
		   		+ "dd7f571d2d27c049384c14d72fdf3cbdef346c0d, 3379b4f4979bb482bd185774207ed31fcde2da3d, "
		   		+ "2376361ed289157843fd8c20a24832a29be15013, 4705a17147b325f4933066652403009bf80e0e70, "
		   		+ "d8b8a0d733be4c64e3afa73c17ee05d1ccb7dd42, 57b570494bd8348d76af6c8a4d5384435b3ad18f,"
		   		+ " 997e8aa4cd2fbf9821285b60d03b10e971b90398";

		   List<String> commitList = new ArrayList<String>(Arrays.asList(commits.split(",")));
		   CsvWriter csv = new CsvWriter("groupsOfRefactoredClasses-presto-by-commits.csv", ',', Charset.forName("ISO-8859-1"));
		   
		   try {
				csv.write("Class");
				csv.write("Number of Refactorings");
				csv.write("Refactoring ID");
				csv.write("Refactoring Type");
				csv.write("Commit");
				csv.endRecord();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(String commit : commitList) {
				
				System.out.println(commit);
				groupsOfRefactoredClasses.entrySet().forEach(refClass -> {
	
					try {
						
						Set<Refactoring> refsSet = groupsOfRefactoredClasses.get(refClass.getKey());
						
						for (Refactoring ref : refsSet) {
						
							if(ref.getCurrentCommit().equals(commit.trim())) {
								
								// System.out.println(ref.getRefactoringType());
								
								//Refactored Class
								csv.write(refClass.getKey());
								
								//Number of Refactorings 
								int numberOfRefs = refsSet.size();
								csv.write(String.valueOf(numberOfRefs));
								
								//Refactoring ID 
								csv.write(ref.getRefactoringId());
								
								//Refactoring Type
								csv.write(ref.getRefactoringType());
								
								//Commit
								csv.write(ref.getCurrentCommit().commit);
								csv.endRecord();
										
							}			
											
						}
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
				});
			}

			csv.close();
	}

	public List<String> getRefactoringsFromRefMiner(String pathProject, String commit){

		RefactoringCollector collector = new RefactoringCollector();
		
		String resultRefMiner = collector.executeRefMiner(pathProject, commit);
		List<String> refactoringsList = new ArrayList<>();
		//convert string to json
		//get refactorings from json

		ObjectMapper mapper = new ObjectMapper();

		try {

			RefMinerOutput refInfo = mapper.readValue(resultRefMiner, new TypeReference<RefMinerOutput>(){});
			List<CommitRefMinerOutput> commitOutputs = refInfo.getCommits();

			for(CommitRefMinerOutput commitOutput : commitOutputs){

				if(commitOutput.getRefactorings() != null && commitOutput.getRefactorings().size() > 1) {
					for (RefactoringRefMinerOutput refactoringOutput : commitOutput.getRefactorings()) {

						if(Refactoring.equalsToRefactoringType(refactoringOutput.getType())){
							refactoringsList.add(refactoringOutput.getType());
						}

					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return refactoringsList;

	}



	
	private Map<String, Set<Refactoring>> getRefsByRefactoredClasses(
			Map<String, Long> rankingOfRefactoredClasses,
			List<Refactoring> refs) {
		// TODO Auto-generated method stub, 
		
		
		Map<String, Set<Refactoring>> refsByRefactoredClasses = new HashMap<String, Set<Refactoring>>();
		
		for (Entry<String, Long> refactoreClass : rankingOfRefactoredClasses.entrySet()) {

			Set<Refactoring> refsList = new HashSet<Refactoring>();
			
			for (Refactoring ref : refs) {

				if (ref.getElements() != null) {
					for (CodeElement elem : ref.getElements()) {
						
						if (elem.className != null) {

							if (elem.className.equals(refactoreClass.getKey())) {

								refsList.add(ref);
							}
						}
					}
				}
			}
			
			refsByRefactoredClasses.put(refactoreClass.getKey(), refsList);
			
		}
		
		return refsByRefactoredClasses;
		
	
	}

	private List<Refactoring> getRefactoringsFromJson(String jsonPath) {

		List<Refactoring> refsList = new ArrayList<Refactoring>();
		ObjectMapper mapper = new ObjectMapper();

		try {

			Refactoring[] refs = mapper.readValue(new File(jsonPath),Refactoring[].class);

			refsList = Arrays.asList(refs);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return refsList;

	}



	private List<RefactoredClass> getGroupsOfRefactoredClasses(List<Refactoring> refs) {

		Map<String, Set<Refactoring>> groupsOfRefactoredClasses =
				new HashMap<String, Set<Refactoring>>();
		List<RefactoredClass> refactoredClasses = new ArrayList<>();
		for (Refactoring ref : refs) {

			if (ref.getElements() != null) {
				
				for (CodeElement elem : ref.getElements()) {

					if (elem.className != null) {

						if (!elem.className.isEmpty()) {
							
							if(groupsOfRefactoredClasses.containsKey(elem.className)) {
								
								groupsOfRefactoredClasses.get(elem.className).add(ref);

							}else {
								groupsOfRefactoredClasses.put(elem.className, new HashSet<Refactoring>());
								groupsOfRefactoredClasses.get(elem.className).add(ref);
							}
							
						}
					}
				}
			}

		}

        for (Entry<String, Set<Refactoring>> groupRefactoredClass : groupsOfRefactoredClasses.entrySet()) {
            RefactoredClass refactoredClass = new RefactoredClass(groupRefactoredClass.getKey(), groupRefactoredClass.getValue());
            refactoredClasses.add(refactoredClass);
        }

		return refactoredClasses;

	}

	


}
