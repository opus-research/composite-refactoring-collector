package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.junit.Test;

import opus.inf.puc.rio.br.model.refactoring.historic.Commit;
import opus.inf.puc.rio.br.model.refactoring.historic.collect.commit.CommitCollector;


public class CommitCollectorTest {
	
	
	/**
	 * Current = a5a7f852e45c7cadc8d1524bd4d14a1e39785aa5
	 * Previous = 0bb0526b70870d57cbac9fcc8c4a7346a4ce5879
	 * 
	 * Current = e6007c622f334dc46e159448cfad6ed6c4d4c7fd -- Missing Commit 
	 * Previous = ccb73a7dc6bac0f497b04e325089ef334039ac1e
	 * 
	 * Current = d93f77b2aac1b22c733adb372f7e246fafd6a4ef -- Missing Commit 
	 * Previous = 32f9682f7258371e212e18f428062ff230d110d7
	 * 
	 * Current  = c946700398fc43a437d124f027a9bd3ba25bcafc
	 * Previous = 16be1426aeb34352ba5d97811f3a721b11e3ae00
	 * 
	 * */
	
	
	@Test
	public void shouldGetBranch() throws NoHeadException, GitAPIException, IOException {
		
	    	CommitCollector collector = new CommitCollector("refactoring-toy-example-1", 
	    			 "/home/opus/eclipse-workspace/RefactoringMiner/build/distributions/RefactoringMiner-1.0/bin/refactoring-toy-example-1");
	    	 
	    	collector.printCommits();
	 }
	
	
	
    @Test
	public void shouldGetPreviousCommit() {
	
    	 CommitCollector collector = new CommitCollector("refactoring-toy-example-1", 
    			 "C:\\Users\\anaca\\eclipse-workspace\\refactoring-toy-example");
    	 
    	 
    	 Commit commit = collector.getPreviousCommit("a5a7f852e45c7cadc8d1524bd4d14a1e39785aa5"); 	
    	 
      	 assertEquals("0bb0526b70870d57cbac9fcc8c4a7346a4ce5879", commit.previousCommit); 
    	 
    	 
    	 commit = collector.getPreviousCommit("e6007c622f334dc46e159448cfad6ed6c4d4c7fd");  //Missing Commit 
    	 assertEquals("", commit.previousCommit);
    	 
    	 
    	 commit = collector.getPreviousCommit("d93f77b2aac1b22c733adb372f7e246fafd6a4ef"); 	//Missing Commit 
    	 assertEquals("", commit.previousCommit); 
   	 
    	 
    	 commit = collector.getPreviousCommit("c946700398fc43a437d124f027a9bd3ba25bcafc"); 	
    	 assertEquals("16be1426aeb34352ba5d97811f3a721b11e3ae00", commit.previousCommit);
    	 
    	
	}

}
