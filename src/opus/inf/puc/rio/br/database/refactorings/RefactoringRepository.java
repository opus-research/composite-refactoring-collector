package opus.inf.puc.rio.br.database.refactorings;

import java.util.List;
import opus.inf.puc.rio.br.database.Repository;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;


public class RefactoringRepository extends Repository {
	
	
	//https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
	// https://www.baeldung.com/java-mongodb
	//https://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/

	public RefactoringRepository(String[] args){
		init(args);
	}
	public void insertAllRefactorings(List<Refactoring> refList) {
		refactorings().insertMany(refList);
	}

}
