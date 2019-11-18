package opus.inf.puc.rio.br.historic.collect.commit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommitCollectorTest {
	
	
	/**
	 * Current = df5619fea03be0805eea4934d44f7aaa6909ad36
	 * Previous = 614f6634885965fe7bf882215acdbac41fcb6107
	 * 
	 * Current = e6007c622f334dc46e159448cfad6ed6c4d4c7fd
	 * Previous = ccb73a7dc6bac0f497b04e325089ef334039ac1e
	 * 
	 * Current = d93f77b2aac1b22c733adb372f7e246fafd6a4ef
	 * Previous = 32f9682f7258371e212e18f428062ff230d110d7
	 * */
	
    @Test
	public void shouldGetPreviousCommit() {
	
    	 CommitCollector collector = new CommitCollector("refactoring-toy-example-1", 
    			 "/home/opus/eclipse-workspace/RefactoringMiner/build/distributions/RefactoringMiner-1.0/bin/refactoring-toy-example-1");
    	 
//    	 String previousCommit = collector.getPreviousCommit("df5619fea03be0805eea4934d44f7aaa6909ad36"); 		 
//    	 assertEquals("614f6634885965fe7bf882215acdbac41fcb6107", previousCommit); 
//    	 
//    	 
//    	 previousCommit = collector.getPreviousCommit("e6007c622f334dc46e159448cfad6ed6c4d4c7fd"); 	 
//    	 assertEquals("ccb73a7dc6bac0f497b04e325089ef334039ac1e", previousCommit); 
//    	 
//    	 
//    	 previousCommit = collector.getPreviousCommit("d93f77b2aac1b22c733adb372f7e246fafd6a4ef"); 	 
//    	 assertEquals("32f9682f7258371e212e18f428062ff230d110d7", previousCommit); 
//    	 
	}

}
