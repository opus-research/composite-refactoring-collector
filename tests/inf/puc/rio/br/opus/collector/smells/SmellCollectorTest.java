package inf.puc.rio.br.opus.collector.smells;

import inf.puc.rio.br.opus.database.composites.CompositeRepository;
import inf.puc.rio.br.opus.database.smells.SmellCollector;
import inf.puc.rio.br.opus.database.smells.SmellRepository;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SmellCollectorTest {


    @Test
    public void getAllSmellsTest(){
        SmellCollector collector = new SmellCollector();
        List<CodeSmell> smells = collector.getAllSmells("ant", "project-test");

        CodeSmell smell1 = smells.get(93);

        assertEquals("LazyClass", smell1.getName());
        assertEquals("org.apache.tools.ant.taskdefs.optional.rjunit.KeepAliveOutputStream", smell1.getCodeElement());
        assertEquals("ant", smell1.getProjectName());

        CodeSmell smell2 = smells.get(0);

        assertEquals("FeatureEnvy", smell2.getName());
        assertEquals("org.apache.tools.ant.helper.ProjectHelperImpl2.hookSpecialTasks([Project])", smell2.getCodeElement());

        assertEquals(2174, smells.size());
    }

    @Test
    public void getMethodByNameRegex(){
        String[] connection = new String[]{"mongodb://localhost:27017"};
        SmellRepository repository = new SmellRepository(connection);

        List<CodeSmell> smells = repository.getSmellsOfMethodByCommit("3355d0c99bb946a6441f08fe6fd1c9881a9ea96a",
                "libcore.net.http.HttpURLConnectionImpl.getResponse");

        assertNotEquals(smells.size(), 0);
    }




















}

