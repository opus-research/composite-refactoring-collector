package inf.puc.rio.br.opus.database.composites;

import com.mongodb.BasicDBObject;
import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.database.refactorings.RefactoringRepository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;

import java.util.ArrayList;
import java.util.List;


public class CompositeRepository extends Repository {

	//https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
	// https://www.baeldung.com/java-mongodb
	//https://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/

	private RefactoringRepository refactoringRepository;
	public CompositeRepository(String[] args){

		init(args);
		refactoringRepository = new RefactoringRepository(args);
	}

	public void insertAllComposites(List<CompositeRefactoring> compositeList) {
		composites().insertMany(compositeList);
	}

	public List<CompositeRefactoring> getCompositesByProject(String projectName){

		List<CompositeRefactoring> composites = composites().find().into(new ArrayList<>());
		List<CompositeRefactoring> compositesOfProject = new ArrayList<>();

		for (CompositeRefactoring composite : composites) {
			List<Refactoring> refactorings = refactoringRepository.getRefactorings(composite.getRefactoringIDs());
			System.out.println("size " + refactorings.size());

			if(refactorings.get(0).getProject().equals(projectName)){
				CompositeRefactoring compositeOfProject = composite;
				compositeOfProject.setRefactorings(refactorings);
				compositesOfProject.add(compositeOfProject);

				System.out.println(refactorings.get(0).getProject());
			}
		}
		return compositesOfProject;
	}

	public List<CompositeRefactoring> getAllComposites(){

		List<CompositeRefactoring> composites = composites().find().into(new ArrayList<>());
		for (CompositeRefactoring composite : composites) {
			List<Refactoring> refactorings = refactoringRepository.getRefactorings(composite.getRefactoringIDs());
			composite.setRefactorings(refactorings);
		}
		return composites;
	}

	public CompositeRefactoring getCompositeById(String compositeId){

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", compositeId.trim());
		CompositeRefactoring composite =  composites().find(searchQuery).first();

		List<Refactoring> refactorings = refactoringRepository.getRefactorings(composite.getRefactoringIDs());
		composite.setRefactorings(refactorings);
		return composite;
	}


}
