package inf.puc.rio.br.opus.database.smells;

import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.smell.organic.CodeSmellOrganic;

import java.util.List;

public class SmellRepository extends Repository {

    public SmellRepository(String[] args){
        init(args);
    }

    public void insertAllSmells(List<CodeSmellOrganic> smellList) {
        smells().insertMany(smellList);
    }


}
