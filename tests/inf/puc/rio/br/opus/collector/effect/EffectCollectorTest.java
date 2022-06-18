package inf.puc.rio.br.opus.collector.effect;

import inf.puc.rio.br.opus.database.effect.RefEffectCollector;
import inf.puc.rio.br.opus.database.refactorings.RefactoringRepository;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;
import inf.puc.rio.br.opus.model.effect.RefactoringEffect;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.utils.AnalysisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class EffectCollectorTest {



    @Test
    public void isNotSameCodeElementTest(){
        String methodName;
        CodeSmell smell1 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, Handler, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);

        CodeSmell smell2 = new CodeSmell(null, "FeatureEnvy",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);


        CodeSmell smell3 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.teste(Project, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);

        List<CodeSmell> smells = new ArrayList<>();
        smells.add(smell1);
        smells.add(smell2);
        smells.add(smell3);


        List<String> methodNames = smells.stream().map(CodeSmell::getCodeElement).collect(Collectors.toList());

        assertEquals(false, AnalysisUtils.isSameCodeElementName(methodNames));

    }


    @Test
    public void isNotSameCodeElementTest2(){
        String methodName;
        CodeSmell smell1 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, Handler, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);

        CodeSmell smell2 = new CodeSmell(null, "FeatureEnvy",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);

        List<CodeSmell> smells = new ArrayList<>();
        smells.add(smell1);
        smells.add(smell2);


        List<String> methodNames = smells.stream().map(CodeSmell::getCodeElement).collect(Collectors.toList());

        assertEquals(false, AnalysisUtils.isSameCodeElementName(methodNames));

    }

    @Test
    public void isSameCodeElementTest(){
        String methodName;
        CodeSmell smell1 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, Handler, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);


        CodeSmell smell2 = new CodeSmell(null, "LongMethod",
                "ant",
                "org.apache.tools.ant.helper.ProjectHelperImpl2.parse(Project, Handler, RootHandler)",
                "0020d1a16ba4207289d2380dc6981c85455b617f",
                "Organic",
                "MLOC > 500.0, startingLine: 19, EndingLine: 20", null);

        List<CodeSmell> smells = new ArrayList<>();
        smells.add(smell1);
        smells.add(smell2);


        List<String> methodNames = smells.stream().map(CodeSmell::getCodeElement).collect(Collectors.toList());

        assertEquals(true, AnalysisUtils.isSameCodeElementName(methodNames));

    }


    @Test
    public void hasRefactoringEffect(){
        String[] connection = new String[]{"mongodb://localhost:27017"};
        RefactoringRepository refRepository= new RefactoringRepository(connection);
        RefEffectCollector collector = new RefEffectCollector(connection);

        Refactoring refactoring = refRepository.getRefactoringById("ant_5899");

        RefactoringEffect effect = collector.getRefEffectByRefactoring(refactoring);
        
    }
}
