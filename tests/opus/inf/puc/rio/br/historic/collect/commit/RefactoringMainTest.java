package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import opus.inf.puc.rio.br.model.refactoring.Refactoring;
import opus.inf.puc.rio.br.parser.main.RefactoringParserMain;

public class RefactoringMainTest {
	
	
	
	@Test
	public void shouldGetRefactorings() {
		
	 RefactoringParserMain parserMain = new RefactoringParserMain("dubbo-test", "dubbo-test.csv");
		
	  List<Refactoring> refactorings = parserMain.getRefactorings();
	  
	  refactorings.forEach( ref -> {
		  System.out.println("Refactoring ");
		  System.out.println(ref.refactoringType);
		  
		  ref.getElements().forEach( elem -> {
			  System.out.println(elem.className);
		  });
		  
		  System.out.println();
		  
	  });
	  
	  assertEquals(14, refactorings.size());
		
	}

}
