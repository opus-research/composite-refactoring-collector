package inf.puc.rio.br.opus.collector.effect;

import inf.puc.rio.br.opus.database.composites.CompositeRepository;
import inf.puc.rio.br.opus.database.effect.CompositeEffectCollector;
import inf.puc.rio.br.opus.database.effect.RefEffectCollector;
import inf.puc.rio.br.opus.database.refactorings.RefactoringRepository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.effect.CompositeEffect;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import org.junit.Test;

public class CompositeEffectTest {

    @Test
    public void collectCompositeEffectTest(){
        String[] connection = new String[]{"mongodb://localhost:27017"};
        CompositeRepository compositeRepository= new CompositeRepository(connection);
        CompositeEffectCollector collector = new CompositeEffectCollector(connection);

        CompositeRefactoring refactoring = compositeRepository.getCompositeById("ant_5899");

        //PreviousCommit
        CodeSmell smellPM1 = new CodeSmell("1",
                "FeatureEnvy",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "f1eacbff7ec5912d041184e1b35aa4e5468ea4ba", "","", null);

        CodeSmell smellPM2 = new CodeSmell("2",
                "LongMethod",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "f1eacbff7ec5912d041184e1b35aa4e5468ea4ba",  "","", null);

        CodeSmell smellPM3 = new CodeSmell("3",
                "IntensiveCoupling",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "f1eacbff7ec5912d041184e1b35aa4e5468ea4ba",  "","", null);

        //CurrentCommit
        CodeSmell smellCM1 = new CodeSmell("1",
                "FeatureEnvy",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "3355d0c99bb946a6441f08fe6fd1c9881a9ea96a", "","", null);

        CodeSmell smellCM2 = new CodeSmell("3",
                "IntensiveCoupling",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "3355d0c99bb946a6441f08fe6fd1c9881a9ea96a",  "","", null);

        CodeSmell smellCM3 = new CodeSmell("4",
                "FeatureEnvy",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.execute([boolean])",
                "3355d0c99bb946a6441f08fe6fd1c9881a9ea96a",  "","", null);

        CompositeEffect effect = collector.collectRefEffect(refactoring);
    }
}
