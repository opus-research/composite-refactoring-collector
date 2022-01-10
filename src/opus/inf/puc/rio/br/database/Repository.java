package opus.inf.puc.rio.br.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import opus.inf.puc.rio.br.database.composites.CompositeRepository;
import opus.inf.puc.rio.br.model.compositeref.CompositeRefactoring;
import opus.inf.puc.rio.br.model.project.Project;
import opus.inf.puc.rio.br.model.refactoring.Refactoring;
import opus.inf.puc.rio.br.model.smell.CodeSmell;
import opus.inf.puc.rio.br.parser.CompositeRefactoringParser;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Repository {

    private MongoCollection<Refactoring> refactorings;
    private MongoCollection<Project> projects;
    private MongoCollection<CompositeRefactoring> composites;
    private MongoCollection<CodeSmell> smells;
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

    protected MongoCollection<opus.inf.puc.rio.br.model.smell.CodeSmell> smells(){
        if(smells == null){
            smells = database.getCollection("smells", opus.inf.puc.rio.br.model.smell.CodeSmell.class);
        }
        return smells;
    }

}
