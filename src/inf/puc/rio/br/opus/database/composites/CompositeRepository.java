package inf.puc.rio.br.opus.database.composites;

import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;

import java.util.List;


public class CompositeRepository extends Repository {

	//https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
	// https://www.baeldung.com/java-mongodb
	//https://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/

	public CompositeRepository(String[] args){
		init(args);
	}
	public void insertAllComposites(List<CompositeRefactoring> compositeList) {
		composites().insertMany(compositeList);
	}

}
