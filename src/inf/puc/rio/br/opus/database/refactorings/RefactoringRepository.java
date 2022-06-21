package inf.puc.rio.br.opus.database.refactorings;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import org.bson.types.ObjectId;


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

	public Refactoring getRefactoringById(String refactoringId) {

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("refactoringId", refactoringId.trim());
		return refactorings().find(searchQuery).first();

	}

	//db.findListOfIdsDemo.find({_id: {$in: documentIds }}).pretty();
	public List<Refactoring> getRefactorings(List<String> refactoringIDs) {
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject queryIn = new BasicDBObject();
		queryIn.put("$in", refactoringIDs.toString());
		searchQuery.put("refactoringId", queryIn);

		FindIterable<Refactoring> refactoringsIterable = refactorings().find(searchQuery);

		return getRefactoringsFromIterable(refactoringsIterable);
	}



	private List<Refactoring> getRefactoringsFromIterable(FindIterable<Refactoring> refactoringsIterable){

		MongoCursor<Refactoring> refactoringsCursor = refactoringsIterable.iterator();

		List<Refactoring> refactorings = new ArrayList<>();
		while(refactoringsCursor.hasNext()) {
			Refactoring refactoring = refactoringsCursor.next();
			refactorings.add(refactoring);
		}

		return refactorings;
	}
}
