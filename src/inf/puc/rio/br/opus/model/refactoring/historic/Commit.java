package inf.puc.rio.br.opus.model.refactoring.historic;



import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Commit {
	
	@BsonProperty(value = "commit")
	private String commit;
	
	@BsonProperty(value = "previous_commit")
	private String previousCommit;
	
	@BsonProperty(value = "order_commit")
	private int orderCommit;
	
	
	public Commit(@JsonProperty("commit") String commit,
				  @JsonProperty("previous_commit") String previousCommit,
				  @JsonProperty("order_commit") int orderCommit) {
		
		this.commit = commit;
		this.previousCommit = previousCommit;
		this.orderCommit = orderCommit;
	}

	public Commit() {
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	public String getPreviousCommit() {
		return previousCommit;
	}

	public void setPreviousCommit(String previousCommit) {
		this.previousCommit = previousCommit;
	}

	public int getOrderCommit() {
		return orderCommit;
	}

	public void setOrderCommit(int orderCommit) {
		this.orderCommit = orderCommit;
	}
}
