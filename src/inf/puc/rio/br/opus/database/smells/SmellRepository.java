package inf.puc.rio.br.opus.database.smells;

import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;

import java.util.List;

public class SmellRepository extends Repository {

    public SmellRepository(String[] args){
        init(args);
    }

    public void insertAllSmells(List<CodeSmell> smellList) {
        smells().insertMany(smellList);
    }


}
