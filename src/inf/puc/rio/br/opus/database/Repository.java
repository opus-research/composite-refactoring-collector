package inf.puc.rio.br.opus.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.project.Project;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Repository {

    private MongoCollection<Refactoring> refactorings;
    private MongoCollection<Project> projects;
    private MongoCollection<CompositeRefactoring> composites;
    private MongoCollection<OuputOrganic> smells;
    private MongoDatabase database;

    public void init(String[] args) {
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
        database = mongoClient.getDatabase("refactoringsdb").withCodecRegistry(pojoCodecRegistry);

        // get a handle to the "people" collection
        //MongoCollection<Refactoring> collection = database.getCollection("composites", CompositeRefactoring.class);


    }

    protected MongoCollection<Refactoring> refactorings(){
        if(refactorings == null){
            refactorings = database.getCollection("refactorings", Refactoring.class);
        }
        return refactorings;
    }

    protected MongoCollection<Project> projects(){
        if(projects == null){
            projects = database.getCollection("projects", Project.class);
        }
        return projects;
    }

    protected MongoCollection<CompositeRefactoring> composites(){
        if(composites == null){
            composites = database.getCollection("composites", CompositeRefactoring.class);
        }
        return composites;
    }

    protected MongoCollection<OuputOrganic> smells(){
        if(smells == null){
            smells = database.getCollection("smells", OuputOrganic.class);
        }
        return smells;
    }

}
