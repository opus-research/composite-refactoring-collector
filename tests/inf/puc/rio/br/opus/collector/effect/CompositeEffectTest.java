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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CompositeEffectTest {

    @Test
    public void collectCompositeEffectTest(){
        String[] connection = new String[]{"mongodb://localhost:27017"};
        CompositeRepository compositeRepository= new CompositeRepository(connection);
        CompositeEffectCollector collector = new CompositeEffectCollector(connection);

        CompositeRefactoring composite = compositeRepository.getCompositeById("okhttp-1346");
        CompositeEffect effect = collector.collectCompositeEffect(composite);

        System.out.println(composite.getType());
        /*
        //PreviousCommit
        CodeSmell smellPM1 = new CodeSmell("1b",
                "FeatureEnvy",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "f1eacbff7ec5912d041184e1b35aa4e5468ea4ba", "","", null);

        CodeSmell smellPM2 = new CodeSmell("2b",
                "LongMethod",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "f1eacbff7ec5912d041184e1b35aa4e5468ea4ba",  "","", null);

        CodeSmell smellPM3 = new CodeSmell("3b",
                "IntensiveCoupling",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "f1eacbff7ec5912d041184e1b35aa4e5468ea4ba",  "","", null);

        //CurrentCommit
        CodeSmell smellCM1 = new CodeSmell("1b",
                "FeatureEnvy",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "3355d0c99bb946a6441f08fe6fd1c9881a9ea96a", "","", null);

        CodeSmell smellCM2 = new CodeSmell("3b",
                "IntensiveCoupling",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.getResponse()",
                "3355d0c99bb946a6441f08fe6fd1c9881a9ea96a",  "","", null);

        CodeSmell smellCM3 = new CodeSmell("4a",
                "FeatureEnvy",
                "okhttp",
                "libcore.net.http.HttpURLConnectionImpl.execute([boolean])",
                "3355d0c99bb946a6441f08fe6fd1c9881a9ea96a",  "","", null);



       // Mocar esses metodos getSmellsOfMethodByCommit

        assertEquals(effect.getCompositeId(), composite.getId());
        assertEquals(effect.getSmellsBefore(), 5);
        assertEquals(effect.getSmellsAfter(), 4);

        assertEquals(true, effect.getSmellsBefore().stream().filter(smellId -> smellId.equals("1b")));
        assertEquals(true, effect.getSmellsBefore().stream().filter(smellId -> smellId.equals("2b")));
        assertEquals(true, effect.getSmellsBefore().stream().filter(smellId -> smellId.equals("3b")));

        assertEquals(true, effect.getSmellsAfter().stream().filter(smellId -> smellId.equals("1b")));
        assertEquals(true, effect.getSmellsAfter().stream().filter(smellId -> smellId.equals("3b")));
        assertEquals(true, effect.getSmellsAfter().stream().filter(smellId -> smellId.equals("4a")));
       */
    }

}
