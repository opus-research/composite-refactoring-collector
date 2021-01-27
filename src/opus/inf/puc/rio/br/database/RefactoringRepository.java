package opus.inf.puc.rio.br.database;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import opus.inf.puc.rio.br.model.refactoring.Refactoring;


public class RefactoringRepository {
	
	
	//https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
	// https://www.baeldung.com/java-mongodb
	//https://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		System.out.println("server connection successfully done");
		
		//Connecting with database
		MongoDatabase db = mongoClient.getDatabase("refactorings");
        System.out.println("Connect to database successfully");
        
        MongoCollection<Refactoring> refactorings = db.getCollection("single-refactorings", Refactoring.class);
       
        List<Refactoring> refList = new ArrayList<Refactoring>();
        
        
        refactorings.insertMany(refList);
	}
	
	private static void connect() {
	
		
	}

}
