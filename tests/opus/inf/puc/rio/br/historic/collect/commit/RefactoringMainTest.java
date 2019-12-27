package opus.inf.puc.rio.br.historic.collect.commit;

import java.util.List;

import org.junit.Test;

import opus.inf.puc.rio.br.parser.main.RefactoringParserMain;
import opus.inf.puc.rio.br.refactoring.Refactoring;

public class RefactoringMainTest {
	
	
	
	@Test
	public void shouldGetRefactorings() {
		
	 RefactoringParserMain parserMain = new RefactoringParserMain("dubbo-test", "dubbo-teste.csv");
		
	  List<Refactoring> refactorings = parserMain.getRefactorings();
		
	}

}
