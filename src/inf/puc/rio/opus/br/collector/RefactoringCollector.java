package inf.puc.rio.opus.br.collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import opus.inf.puc.rio.br.model.refactoring.Refactoring;
import opus.inf.puc.rio.br.model.refactoring.miner.CommitRefMinerOutput;
import opus.inf.puc.rio.br.model.refactoring.miner.RefMinerOutput;
import opus.inf.puc.rio.br.model.refactoring.miner.RefactoringRefMinerOutput;

public class RefactoringCollector {
	
	public List<RefactoringRefMinerOutput> getRefactoringsFromRefMinerOutput(String refMinerOutputPath){

		List<RefactoringRefMinerOutput> refactoringsList = new ArrayList<>();
		//convert string to json
		//get refactorings from json

		ObjectMapper mapper = new ObjectMapper();

		try {
			RefMinerOutput refInfo = mapper.readValue(new File(refMinerOutputPath), RefMinerOutput.class);
			List<CommitRefMinerOutput> commitOutputs = refInfo.getCommits();

			for(CommitRefMinerOutput commitOutput : commitOutputs){

				if(commitOutput.getRefactorings() != null && commitOutput.getRefactorings().size() > 1) {
					for (RefactoringRefMinerOutput refactoringOutput : commitOutput.getRefactorings()) {

						if(Refactoring.equalsToRefactoringType(refactoringOutput.getType())){
							
							refactoringOutput.commit = commitOutput.getSha1();
							refactoringOutput.project = commitOutput.getRepository();
							refactoringsList.add(refactoringOutput);
							
						}

					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return refactoringsList;

	}
	
	
    public String executeRefMiner(String pathProject, String commit) {
		
		String REF_MINER_PATH = "C:\\Users\\anaca\\Executaveis\\RefactoringMiner-2.0.1\\RefactoringMiner-2.0.1\\"
				+ "build\\distributions\\RefactoringMiner-2.0.1\\RefactoringMiner-2.0.1\\bin";
		//"" && ./RefactoringMiner -c " + pathProject + " " + commit"
	
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + REF_MINER_PATH + 
				" && RefactoringMiner -c " + pathProject + " " + commit);
		builder.redirectErrorStream(true);
		String line = null;
		String refactorings = "";
		try {
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));


			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				refactorings+=line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int jsonIndex = refactorings.indexOf("{");
		refactorings = refactorings.substring(jsonIndex);
		return refactorings;

	
	}


}
