package inf.puc.rio.br.opus.collector.smells;

import inf.puc.rio.br.opus.database.smells.SmellCollector;
import inf.puc.rio.br.opus.minerator.smells.pmd.DuplicatedCodePMD;
import inf.puc.rio.br.opus.minerator.smells.pmd.PMDMinerator;
import inf.puc.rio.br.opus.minerator.smells.pmd.SmellPMD;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.parser.smell.SmellParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SmellCollectorTest {


    @Test
    public void collectSmellFromPMD(){
        SmellPMD pmd = new SmellPMD();

        pmd.collectSmells("fe764dadac081c9ce33d110dd3f813f7642c3d31", "C:\\Users\\anaca\\Documents\\Projetos\\fresco", "results-fresco.txt");
    }

    @Test
    public void collectDuplicatedCodeFromPMD(){
        PMDMinerator mineratorPMD = new PMDMinerator();
        String project = "activiti";
        String commit1 = "0b9636b3d7f0d2d8112bbbb8822d5ac08e15606d";

        SmellParser parser = new SmellParser();

        String output = mineratorPMD.execute(project, commit1);

        //Save Duplicated Code in List
        List<DuplicatedCodePMD> duplicatedCodePMDs = mineratorPMD.getDuplicatedMethods(output, project, commit1);

        assertNotNull(duplicatedCodePMDs);

        // Parser Duplicated Code
        List<CodeSmell> duplicatedMethods = parser.parserPMDSmellToOurModel(duplicatedCodePMDs);
        assertNotNull(duplicatedMethods);

    }


    @Test
    public void getAllSmellsTest(){
        SmellCollector collector = new SmellCollector();
        List<CodeSmell> smells = collector.getAllSmells("project-test");

        CodeSmell smell1 = smells.get(93);

        assertEquals("LazyClass", smell1.getName());
        assertEquals("org.apache.tools.ant.taskdefs.optional.rjunit.KeepAliveOutputStream", smell1.getCodeElement());


        CodeSmell smell2 = smells.get(0);

        assertEquals("FeatureEnvy", smell2.getName());
        assertEquals("org.apache.tools.ant.helper.ProjectHelperImpl2.hookSpecialTasks([Project])", smell2.getCodeElement());

        assertEquals(2174, smells.size());
    }


    @Test
    public void getMethodNameFromPMDFormat(){
        PMDMinerator mineratorPMD = new PMDMinerator();

        String output = mineratorPMD.parserMethodName("  public void init(String tag, final PerfListener perfListener) {");
        assertEquals(output,"init([String, PerfListener])");
    }

    @Test
    public void getClassPathFromPMDFormat() {
        PMDMinerator minerator = new PMDMinerator();
        String output = minerator.parserClassName("fresco",
                "Starting at line 280 of C:\\Users\\anaca\\Documents\\Projetos\\fresco\\drawee\\src\\test\\java\\com\\facebook\\drawee\\drawable\\FadeDrawableTest.java");

        assertEquals(output, "drawee.src.test.java.com.facebook.drawee.drawable.FadeDrawableTest");
    }

    @Test
    public void getDuplicatedMethods() {
        PMDMinerator minerator = new PMDMinerator();
        List<DuplicatedCodePMD> fresco = minerator.getDuplicatedMethods("src/test/resources/results-fresco-test.txt", "fresco", "");
        assertEquals(fresco.get(0).getClassNames().get(0), "imagepipeline.src.test.java.com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducerTest");
        assertEquals(fresco.get(0).getClassNames().get(1), "imagepipeline.src.test.java.com.facebook.imagepipeline.producers.ThrottlingProducerTest");
        assertEquals(fresco.get(0).getMethodNames().get(0), "testThrottling([])");
        assertEquals(fresco.get(0).getMethodNames().get(1), "testNoThrottlingAfterRequestsFinish([])");

        assertEquals(fresco.get(1).getClassNames().get(0), "memory-types.ashmem.src.test.java.com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStreamTest");
        assertEquals(fresco.get(1).getClassNames().get(1), "memory-types.nativememory.src.test.java.com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStreamTest");
        assertEquals(fresco.get(1).getClassNames().get(2), "memory-types.simple.src.test.java.com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStreamTest");
        assertEquals(fresco.get(1).getMethodNames().size(), 0);
    }
}







