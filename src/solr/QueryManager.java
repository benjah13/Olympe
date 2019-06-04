package solr;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class QueryManager {

	protected HashMap<String,String> mapping;
	protected SolrParameters solr = new SolrParameters();

	public QueryManager(HashMap<String, String> mapping) {
		super();
		this.mapping = mapping;
	}

	public QueryManager() throws FileNotFoundException, IOException {
		super();
		this.mapping = generatemapping();
	}



	public HashMap<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(HashMap<String, String> mapping) {
		this.mapping = mapping;
	}

	/******************************** 
	 * MAPPING
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 ********************************/
	public HashMap<String,String> generatemapping() throws FileNotFoundException, IOException{
		File mappingFile = new File("./resources/mapping.txt");

		HashMap<String,String> map = new HashMap<String,String>();

		try (BufferedReader br = new BufferedReader(new FileReader(mappingFile.getPath()))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				String key = parts[1]; 
				String className = parts[0];
				map.put(key,className);		
			}
		} 

		return map;
	}
	public String performQuery(String parameters) throws IOException, URISyntaxException {
		String query = "http://"+solr.localHost+solr.port+solr.queryCore+parameters;
		System.out.println(query);
		String solrAnswer = "";
		URL url;

		try {
			// get URL content
			url = new URL(query);
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));

			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				solrAnswer += (inputLine) + "\n";
			}
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return solrAnswer;

	}

	public int getNumberOfResponse(String answer) {
		String pattern = "\"numFound\":";
		int indexstart = answer.indexOf(pattern);
		String troncatedString = answer.substring(indexstart + pattern.length(), answer.length() - 1);
		int indexStop = troncatedString.indexOf(",");
		String matchingNumberOfResponse = answer.substring(indexstart + pattern.length(), indexstart + pattern.length()+indexStop);
		return Integer.parseInt(matchingNumberOfResponse);
	}
	
	public String generateParameterForField(String field, String param) {
		int cpt=0;
		String parameters = "fq="+field  + SolrKeywords.DOTS;
		if (param.indexOf(SolrKeywords.AND) != -1) {
			String[] separated = param.split(SolrKeywords.AND);
			parameters+="(";

			for (String s : separated) {
				parameters+=s ;
				if(cpt != separated.length-1)
				{
					parameters+=SolrKeywords.SPACE+"AND"+SolrKeywords.SPACE;	
				}
				cpt+=1;
			}
			parameters+=")";
		} else if (param.indexOf(SolrKeywords.OR) != -1) {
			cpt=0;
			String[] separated = param.split(SolrKeywords.OR);
			parameters+="(";
			for (String s : separated) {
				parameters+=s ;
				if(cpt != separated.length-1)
				{
					parameters+=SolrKeywords.SPACE+"OR"+SolrKeywords.SPACE;	
				}
				cpt+=1;			}
			parameters+=")";
		}
		else {
			parameters+=param;	
		}

		return parameters + "&";
	}

}
