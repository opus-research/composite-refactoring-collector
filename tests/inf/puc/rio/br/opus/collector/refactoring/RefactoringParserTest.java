package inf.puc.rio.br.opus.collector.refactoring;

import static org.junit.Assert.assertEquals;

import inf.puc.rio.br.opus.utils.AnalysisUtils;
import org.junit.Test;

import java.util.List;


public class RefactoringParserTest {


    @Test
    public void shouldGetParametersAsList(){
       List<String> parameterTypes1 = AnalysisUtils.getParametersAsAList("libcore.net.http.HttpURLConnectionImpl.package processAuthHeader(responseCode int, response ResponseHeaders, successorRequestHeaders RawHeaders)");

       List<String> parameterTypes2 = AnalysisUtils.getParametersAsAList("libcore.net.http.HttpURLConnectionImpl.private execute(readResponse boolean)");


       assertEquals(3, parameterTypes1.size());
       assertEquals("[int, ResponseHeaders, RawHeaders]", parameterTypes1.toString());

        assertEquals(1, parameterTypes2.size());
        assertEquals("[boolean]", parameterTypes2.toString());

    }
	
	/*
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

	 */

}
