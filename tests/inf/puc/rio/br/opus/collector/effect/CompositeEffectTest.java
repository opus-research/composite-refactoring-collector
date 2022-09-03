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

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class CompositeEffectTest {

    @Test
    public void collectCompositeEffectTest(){
        String[] connection = new String[]{"mongodb://localhost:27017"};
        CompositeRepository compositeRepository= new CompositeRepository(connection);
        CompositeEffectCollector collector = new CompositeEffectCollector(connection);

        CompositeRefactoring composite = compositeRepository.getCompositeById("okhttp-1346");
        CompositeEffect effect = collector.collectCompositeEffect(composite, null);

        assertEquals(effect.getId(), "effect-" + composite.getId());
        assertEquals(effect.getCodeSmellsBefore().size(), 4);
        assertEquals(effect.getCodeSmellsAfter().size(), 5);

        assertEquals(1, effect.getCodeSmellsBefore().stream().filter(smell -> smell.getName().equals("ComplexClass")).collect(Collectors.toList()).size());
        assertEquals(1, effect.getCodeSmellsBefore().stream().filter(smell -> smell.getName().equals("FeatureEnvy")).collect(Collectors.toList()).size());
        assertEquals(1, effect.getCodeSmellsBefore().stream().filter(smell -> smell.getName().equals("LongMethod")).collect(Collectors.toList()).size());
        assertEquals(1, effect.getCodeSmellsBefore().stream().filter(smell -> smell.getName().equals("IntensiveCoupling")).collect(Collectors.toList()).size());

        assertEquals(1, effect.getCodeSmellsAfter().stream().filter(smell -> smell.getName().equals("ComplexClass")).collect(Collectors.toList()).size());
        assertEquals(2, effect.getCodeSmellsAfter().stream().filter(smell -> smell.getName().equals("FeatureEnvy")).collect(Collectors.toList()).size());
        assertEquals(1, effect.getCodeSmellsAfter().stream().filter(smell -> smell.getName().equals("LongParameterList")).collect(Collectors.toList()).size());
        assertEquals(1, effect.getCodeSmellsAfter().stream().filter(smell -> smell.getName().equals("IntensiveCoupling")).collect(Collectors.toList()).size());

    }

}
