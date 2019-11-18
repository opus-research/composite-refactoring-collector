package opus.inf.puc.rio.br.historic.collect.commit;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

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
	
	
	
	public CommitCollector(String projectName, String projectPath) {
		
		this.projectName = projectName;
		this.projectPath = projectPath;
		openProject();
	}
	
	public String getPreviousCommit(String commitHash){		
		
		return previousCommit;
	}
	
	private void openProject() {
		
		try {
				projectGit = Git.open(new File(projectPath));
			
				projectGit.checkout()
				.setCreateBranch(true)
				.setName("master")
				.call();
				
			} catch (GitAPIException
					| IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
	   
	}
	
	private void gitLog() {
		
		Iterable<RevCommit> logs;
		
		try {
			
			ObjectId objectId =  projectGit.getRepository().resolve(currentCommit);
			Iterable<RevCommit> commits = projectGit.log().add(objectId).call(); 

			List<RevCommit> commitList = new ArrayList<RevCommit>();  
			commits.iterator().forEachRemaining(n -> commitList.add(n));

	
			 for (RevCommit rev : commitList) {
			        System.out.print(rev.getName());
			        System.out.print(": ");
			        System.out.print(rev.getFullMessage());
			        System.out.println();
			        System.out.println(rev.getId().getName());
			        System.out.print(rev.getAuthorIdent().getName());
			        System.out.println(rev.getAuthorIdent().getEmailAddress());
			        System.out.println("-------------------------");
			      }
			 
			 
			
		} catch (GitAPIException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	     
	}
 
}
