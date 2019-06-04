import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jsonfile.JsonFileManager;
import solr.QueryManager;
import solr.SolrParameters;
import types.EmployeeQueryManager;

public class main {

	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, URISyntaxException {

		SolrParameters solrparameters = new SolrParameters();
		QueryManager queryManager = new QueryManager();
		HashMap<String,Object> jsonQueryContent = new HashMap<String,Object>();
		
		System.out.println("==================================================" );

		// Found the files
		File dir = new File(solrparameters.searchDirectory);
		File[] matches = dir.listFiles(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith(solrparameters.extension);
			}
		});

		for(File file : matches)
		{
			System.out.println(" found file : "+ file);
			JsonFileManager jsonfile = new JsonFileManager(file);
			System.out.println("==================================================" );
			jsonfile.printfile();
			System.out.println("==================================================" );
			try {
				jsonQueryContent = jsonfile.parse();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("==================================================" );
			EmployeeQueryManager employeeQueryManager = new EmployeeQueryManager(jsonQueryContent);
			String query = employeeQueryManager.generateParameters();
			System.out.println("==================================================" );
			String answer = queryManager.performQuery(query);
			System.out.println(answer);
			System.out.println("==================================================" );
			System.out.println("" + queryManager.getNumberOfResponse(answer) + " matching profiles found ! ");
			System.out.println("==================================================" );
			System.out.println(employeeQueryManager.formatAnswer(answer));
			System.out.println("==================================================" );

		}



	}

}
