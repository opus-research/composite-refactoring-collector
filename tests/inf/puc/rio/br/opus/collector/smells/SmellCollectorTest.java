package inf.puc.rio.br.opus.collector.smells;

import inf.puc.rio.br.opus.database.smells.SmellCollector;
import inf.puc.rio.br.opus.minerator.smells.pmd.DuplicatedCodePMD;
import inf.puc.rio.br.opus.minerator.smells.pmd.PMDMinerator;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmellCollectorTest {


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







