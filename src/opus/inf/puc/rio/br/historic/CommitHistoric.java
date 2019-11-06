package opus.inf.puc.rio.br.historic;

public class CommitHistoric {

	public final String key;
	public final String authorName;
	public final String authorEmail;
	public final String dateCommit;
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
