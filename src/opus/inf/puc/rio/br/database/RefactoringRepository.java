package opus.inf.puc.rio.br.database;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mongodb.DB;
//import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoIterable;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class RefactoringRepository {
	
	
	//https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
	// https://www.baeldung.com/java-mongodb
	//https://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/

	public static void main(String[] args) {
		MongoClient mongoClient;

		if (args.length == 0) {
			// connect to the local database server
			mongoClient = MongoClients.create();
		} else {
			mongoClient = MongoClients.create(args[0]);
		}

		// create codec registry for POJOs
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		// get handle to "mydb" database
		MongoDatabase database = mongoClient.getDatabase("refactoringsdb").withCodecRegistry(pojoCodecRegistry);

		// get a handle to the "people" collection
		MongoCollection<Refactoring> collection = database.getCollection("refactorings", Refactoring.class);

		// drop all the data in it
		collection.drop();
        List<Refactoring> refList = new ArrayList<Refactoring>();
		Refactoring refactoring = new Refactoring("1", "test", null,"em", "test");
        refList.add(refactoring);
        collection.insertMany(refList);
	}
	
	private static void connect() {
	
		
	}

}
