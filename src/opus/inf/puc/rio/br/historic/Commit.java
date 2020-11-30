package opus.inf.puc.rio.br.historic;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Commit {
	
	@BsonProperty(value = "commit")
	public final String commit;
	
	@BsonProperty(value = "previous_commit")
	public final String previousCommit;
	
	@BsonProperty(value = "order_commit")
	public final int orderCommit;
	
	
	public Commit(String commit, String previousCommit, int orderCommit) {
		
		this.commit = commit;
		this.previousCommit = previousCommit;
		this.orderCommit = orderCommit;
	}
	
	
	
	
	

}
