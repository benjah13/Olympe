package solr;

public class SolrParameters {

	/**************************
	 * VARIABLES
	 **************************/
	
	public final int port = 8983;
	public final String localHost = "localhost:";
	public final String queryWord = "GET";
	public final String searchDirectory = "/Users/Ben/Desktop/json/";
	public final String extension = ".json";
	
	public final String queryCore = "/solr/employee/select?";
	/**************************
	 * CONSTRUCTORS
	 **************************/

	public SolrParameters() {
	}
	
}
