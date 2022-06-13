package inf.puc.rio.br.opus.collector.effect;

import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.utils.AnalysisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class EffectCollectorTest {

    @Test
    public void hasOverrideCodeElementTest(){
        String methodName;
        CodeSmell smell1 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, Handler, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20");

        CodeSmell smell2 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20");


        CodeSmell smell3 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.teste(Project, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20");

        List<CodeSmell> smells = new ArrayList<>();
        smells.add(smell1);
        smells.add(smell2);
        smells.add(smell3);


        List<String> methodNames = smells.stream().map(CodeSmell::getCodeElement).collect(Collectors.toList());

        assertEquals(true, AnalysisUtils.hasOverrideCodeElement(methodNames));

    }
}
