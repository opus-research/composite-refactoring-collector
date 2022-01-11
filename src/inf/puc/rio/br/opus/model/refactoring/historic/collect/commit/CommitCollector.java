package inf.puc.rio.br.opus.model.refactoring.historic.collect.commit;




import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.revwalk.RevCommit;

import inf.puc.rio.br.opus.model.refactoring.historic.Commit;


/**
 * Collect last commit and order of current commit
 * 
 * References: https://www.vogella.com/tutorials/JGit/article.html
 * */

public class CommitCollector {

	
	private Git projectGit;
	private String currentCommit;
	private String previousCommit;
	private String projectName;
	private String projectPath;
	private final static int PREVIOUS_COMMIT_INDEX = 1;
    private int order; 	
	
	public CommitCollector(String projectName, String projectPath) {
		
		this.projectName = projectName;
		this.projectPath = projectPath;
		openProject();
	}
	
	public Commit getPreviousCommit(String currentCommit){
		
		this.currentCommit = currentCommit;

		List<RevCommit> commits = gitLogFromCurrentCommit();
		this.order = commits.size();
        
        
		if(commits != null && commits.size() > 1) {
			RevCommit previousCommitObj = commits.get(PREVIOUS_COMMIT_INDEX);
			previousCommit = previousCommitObj.getName();
		}
		else {
			previousCommit = "";
		}
		
		Commit commit = new Commit(currentCommit, previousCommit, order);
		return commit;
	}
	
	public int getOrderCommit(String commit){
		this.currentCommit = commit;
		
		List<RevCommit> commits = gitLogFromCurrentCommit();
		this.order = commits.size();
		
		return this.order;
	}
	
	private void openProject() {
		
		try {
				projectGit = Git.open(new File(projectPath));
			
				projectGit.checkout()
				.setCreateBranch(false)
				.setName("master")
				.call();
				
			} catch (GitAPIException
					| IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
	   
	}
	
	public void printCommits() throws NoHeadException, GitAPIException, IOException {
		
		
		Iterable<RevCommit> commits = projectGit.log().all().call(); 

		List<RevCommit> commitList = new ArrayList<RevCommit>();  
		commits.iterator().forEachRemaining(n -> commitList.add(n));

		System.out.println(commitList.size());
	}
	
	
	
	
	
	private List<RevCommit> gitLogFromCurrentCommit() {
		
		
		List<RevCommit> commitList = new ArrayList<RevCommit>();  
		
		try {
			
			ObjectId objectId =  projectGit.getRepository().resolve(currentCommit);
			Iterable<RevCommit> commits = projectGit.log().add(objectId).call(); 		
			commits.iterator().forEachRemaining(n -> commitList.add(n));

//			for (RevCommit rev : commits) {
//				System.out.print(rev.getName());
//				System.out.print(": ");
//				System.out.print(rev.getFullMessage());
//				System.out.println();
//				System.out.println(rev.getId().getName());
//				System.out.print(rev.getAuthorIdent().getName());
//				System.out.println(rev.getAuthorIdent().getEmailAddress());
//				System.out.println("-------------------------");
//			}
 
			
		} catch (GitAPIException
				| IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
		
		
		
		return commitList;
		
	     
	}
 
}
