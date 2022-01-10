package opus.inf.puc.rio.br.database.smells;

import opus.inf.puc.rio.br.database.Repository;
import opus.inf.puc.rio.br.model.smell.CodeSmell;

import java.util.List;

public class SmellRepository extends Repository {

    public SmellRepository(String[] args){
        init(args);
    }

    public void insertAllSmells(List<CodeSmell> smellList) {
        smells().insertMany(smellList);
    }


}
