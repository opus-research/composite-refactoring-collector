package inf.puc.rio.br.opus.database.smells;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import java.util.ArrayList;
import java.util.List;

public class SmellRepository extends Repository {

    public SmellRepository(String[] args){
        init(args);
    }

    public void insertAllSmells(List<CodeSmell> smellList) {
        smells().insertMany(smellList);
    }

    public List<CodeSmell> getSmellsOfClassByCommit(String commit, String className) {

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("commit", commit);
        searchQuery.put("codeElement", className);
        FindIterable<CodeSmell> smellsIterable =  smells().find(searchQuery);

        return getSmellsFromIterable(smellsIterable);
    }

    public List<CodeSmell> getSmellsOfMethodByCommit(String commit, String methodName) {

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("commit", commit);

        BasicDBObject regexQuery = new BasicDBObject();
        regexQuery.put("$regex", methodName);

        searchQuery.put("codeElement", regexQuery);

        FindIterable<CodeSmell> smellsIterable =  smells().find(searchQuery);

        return getSmellsFromIterable(smellsIterable);
    }

    private List<CodeSmell> getSmellsFromIterable(FindIterable<CodeSmell> smellsIterable){

        MongoCursor<CodeSmell> smellsCursor = smellsIterable.iterator();

        List<CodeSmell> smells = new ArrayList<>();
        while(smellsCursor.hasNext()) {
            CodeSmell smell = smellsCursor.next();
            smells.add(smell);
        }

        return smells;
    }
}
