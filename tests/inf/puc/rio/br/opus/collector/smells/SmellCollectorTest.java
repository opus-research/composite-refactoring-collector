package inf.puc.rio.br.opus.collector.smells;

import inf.puc.rio.br.opus.database.smells.SmellCollector;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmellCollectorTest {


    @Test
    public void getAllSmells(){
        SmellCollector collector = new SmellCollector(new String[]{""});
        List<CodeSmell> smells = collector.getAllSmells("project-test");

        CodeSmell smell1 = smells.get(5);

        assertEquals("ClassDataShouldBePrivate", smell1.getName());
        assertEquals("org.apache.tools.ant.helper.ProjectHelperImpl2", smell1.getCodeElement());


        CodeSmell smell2 = smells.get(3);

        assertEquals("LongMethod", smell2.getName());
        assertEquals("org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, Handler, RootHandler)", smell2.getCodeElement());

        assertEquals(1464, smells.size());
    }
}

