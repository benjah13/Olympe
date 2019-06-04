package jsonfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import solr.QueryManager;
import types.Employee;

public class JsonFileManager {

	protected File file;
	protected QueryManager queryManager = new QueryManager();

	public JsonFileManager(File file) throws FileNotFoundException, IOException {
		this.file = file;
	}
	public void printfile() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}

	}
	public HashMap<String,Object> parse() throws FileNotFoundException, IOException, ParseException {
		// parsing file "JSONExample.json" 
		Object obj = new JSONParser().parse(new FileReader(file.getPath())); 
		HashMap<String,Object> map = new HashMap<String,Object>();
		// typecasting obj to JSONObject 
		JSONObject jo = (JSONObject) obj; 

		for (String key : queryManager.getMapping().keySet()) {
			map.put(key, jo.get(key));
		}	
		
	
		return map;
	}






}
