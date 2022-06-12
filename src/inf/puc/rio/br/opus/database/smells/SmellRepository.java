package inf.puc.rio.br.opus.database.smells;

import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.smell.CodeSmell;

import java.util.List;

public class SmellRepository extends Repository {

    public SmellRepository(String[] args){
        init(args);
    }

    public void insertAllSmells(List<CodeSmell> smellList) {
        smells().insertMany(smellList);
    }


    public List<CodeSmell> getSmellsOfClassByCommit(String commit, String className) {
        return null;
    }

    public List<CodeSmell> getSmellsOfMethodByCommit(String commit, String methodName) {
        return null;
    }
}
