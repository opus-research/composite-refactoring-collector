package inf.puc.rio.br.opus.model.refactoring.historic;



import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Commit {
	
	@BsonProperty(value = "commit")
	public final String commit;
	
	@BsonProperty(value = "previous_commit")
	public final String previousCommit;
	
	@BsonProperty(value = "order_commit")
	public final int orderCommit;
	
	
	public Commit(@JsonProperty("commit") String commit,
				  @JsonProperty("previousCommit") String previousCommit,
				  @JsonProperty("orderCommit") int orderCommit) {
		
		this.commit = commit;
		this.previousCommit = previousCommit;
		this.orderCommit = orderCommit;
	}
	
	
	
	
	

}
