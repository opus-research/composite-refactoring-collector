package opus.inf.puc.rio.br.model.refactoring.historic;



import org.bson.codecs.pojo.annotations.BsonProperty;

public class CommitHistoric {

	@BsonProperty(value = "key")
	public final String key;
	
	@BsonProperty(value = "author_name")
	public final String authorName;
	
	@BsonProperty(value = "author_email")
	public final String authorEmail;
	
	@BsonProperty(value = "date_commit")
	public final String dateCommit;
	
	@BsonProperty(value = "order_commit")
	public final int orderCommit;
	
	public CommitHistoric(String key,
			      String authorName,
			      String authorEmail,
			      String dateCommit,
			      int orderCommit) {
	
		this.key = key;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.dateCommit = dateCommit;
		this.orderCommit = orderCommit;
	}
	
	
	
	
	
	
}
