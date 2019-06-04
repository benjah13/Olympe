package types;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import solr.QueryManager;
import solr.SolrKeywords;

public class EmployeeQueryManager extends Employee{

	public String number;
	public QueryManager queryManager;

	public EmployeeQueryManager(String number) throws FileNotFoundException, IOException {
		super();
		this.number = number;
		queryManager = new QueryManager();
	}

	public EmployeeQueryManager() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	
	
	public EmployeeQueryManager( HashMap<String,Object> jsonQueryContent ) throws FileNotFoundException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		this.setToNull();
		queryManager = new QueryManager();
		
		for ( String key : jsonQueryContent.keySet() ) {
		    switch(key) {
		    case "first_name":
		    	first_name = (String) jsonQueryContent.get(key);
		    	break;
		    case "last_name":
		    	last_name = (String) jsonQueryContent.get(key);
		    	break;
		    case "seniority":
		    	Long senior = (Long) jsonQueryContent.get(key);
		    	if(senior!=null) {seniority = senior.intValue();}
		    	break;
		    case "birthday":
		    	birthday = (String) jsonQueryContent.get(key);
		    	break;
		    case "mail":
		    	mail = (String) jsonQueryContent.get(key);
		    	break;
		    case "agency":
		    	agency = (String) jsonQueryContent.get(key);
		    	break;
		    case "client":
		    	client = (String) jsonQueryContent.get(key);
		    	break;
		    case "tgi":
		    	tgi = (String) jsonQueryContent.get(key);
		    	break;
		    case "description":
		    	description = (String) jsonQueryContent.get(key);
		    	break;
		    case "job":
		    	job = (String) jsonQueryContent.get(key);
		    	break;
		    	
		    case "lowSkills":
		    	lowSkills = (String) jsonQueryContent.get(key);
		    	break;
		    case "mediumSkills":
		    	mediumSkills = (String) jsonQueryContent.get(key);
		    	break;
		    case "highSkills":
		    	highSkills = (String) jsonQueryContent.get(key);
		    	break;
		    case "expertSkills":
		    	expertSkills = (String) jsonQueryContent.get(key);
		    	break;
		    case "mediumLangs":
		    	mediumLangs = (String) jsonQueryContent.get(key);
		    	break;
		    case "expertLangs":
		    	expertLangs = (String) jsonQueryContent.get(key);
		    	break;
		    case "educationTitle":
		    	educationTitle = (String) jsonQueryContent.get(key);
		    	break;
		    case "educationYear":
		    	Long educYear = (Long) jsonQueryContent.get(key);
		    	if(educYear!=null) {educationYear = educYear.intValue();}		    	break;
		    case "educationSchool":
		    	educationSchool = (String) jsonQueryContent.get(key);
		    	break;
		    	
		    	
		    case "number":
			    	number = (String) jsonQueryContent.get(key);
			    	break;
		    }
		}
		printquery();
	}
	
	public void setToNull() {
		this.tgi =null;
	   this.first_name = null;
		this.last_name=null;
		this.seniority = -1;
		this.number = null;
		this.birthday=null;
		this.mail=null;
		this.client=null;
		this.agency=null;
		this.description=null;
		this.job=null;
		this.lowSkills=null;
		this.mediumSkills=null;
		this.highSkills=null;
		this.expertSkills=null;
		this.mediumLangs=null;
		this.expertLangs=null;
		this.educationTitle=null;
		this.educationYear=-1;
		this.educationSchool=null;

	
	
	}
	public void printquery() {
		System.out.println("number : " + this.getNumber());
		System.out.println("tgi : " + this.getTgi());
		System.out.println("firstName : " + this.getFirst_name());
		System.out.println("lastName : " + this.getLast_name());
		System.out.println("seniority : " + this.getSeniority());
		System.out.println("birthday : " + this.getBirthday());
		System.out.println("client : " + this.getClient());
		System.out.println("mail : " + this.getMail());
		System.out.println("agency : " + this.getAgency());
		System.out.println("description : " + this.getDescription());
		System.out.println("job : " + this.getJob());
		System.out.println("lowSkills : " + this.getLowSkills());
		System.out.println("mediumSkills : " + this.getMediumSkills());
		System.out.println("highSkills : " + this.getHighSkills());
		System.out.println("expertSkills : " + this.getExpertSkills());
		System.out.println("mediumLangs : " + this.getMediumLangs());
		System.out.println("expertLangs : " + this.getExpertLangs());
		System.out.println("educationTitle : " + this.getEducationTitle());
		System.out.println("educationYear : " + this.getEducationYear());
		System.out.println("educationSchool : " + this.getEducationSchool());


	}
	public String generateParameters() {
		String parameters = "";
		if (this.first_name != null) { parameters += queryManager.generateParameterForField("first_name",this.first_name);}
		if (this.last_name != null) { parameters += queryManager.generateParameterForField("last_name",this.last_name);}
		if (this.tgi != null) { parameters += queryManager.generateParameterForField("tgi",this.tgi);}
		if (this.birthday != null) { parameters += queryManager.generateParameterForField("birthday",this.birthday);}
		if (this.client != null) { parameters += queryManager.generateParameterForField("client",this.client);}
		if (this.mail != null) { parameters += queryManager.generateParameterForField("mail",this.mail);}
		if (this.agency != null) { parameters += queryManager.generateParameterForField("agency",this.agency);}
		if (this.description != null) { parameters += queryManager.generateParameterForField("description",this.description);}
		if (this.job != null) { parameters += queryManager.generateParameterForField("job",this.job);}
		if (this.lowSkills != null) { parameters += queryManager.generateParameterForField("lowSkills",this.lowSkills);}
		if (this.mediumSkills != null) { parameters += queryManager.generateParameterForField("mediumSkills",this.mediumSkills);}
		if (this.highSkills != null) { parameters += queryManager.generateParameterForField("highSkills",this.highSkills);}
		if (this.expertSkills != null) { parameters += queryManager.generateParameterForField("expertSkills",this.expertSkills);}
		if (this.mediumLangs != null) { parameters += queryManager.generateParameterForField("mediumLangs",this.mediumLangs);}
		if (this.expertLangs != null) { parameters += queryManager.generateParameterForField("expertLangs",this.expertLangs);}
		if (this.educationTitle != null) { parameters += queryManager.generateParameterForField("educationTitle",this.educationTitle);}
		if (this.educationSchool != null) { parameters += queryManager.generateParameterForField("educationSchool",this.educationSchool);}
		
		if (this.seniority != -1) { parameters += "fq=seniority"+SolrKeywords.DOTS+this.seniority+"&";}
		if (this.educationYear != -1) { parameters += "fq=educationYear"+SolrKeywords.DOTS+this.educationYear+"&";}

		if (this.number != null) {
			if(this.number != "all") {
				parameters += "rows="+this.number+"&";
			}
		}
		parameters += "q=*"+SolrKeywords.DOTS+"*";
		
		return parameters;
	}
	
	@SuppressWarnings("unchecked")
	public String formatAnswer(String answer) {
		String formattedAnswer = "";
		String pattern = "\"docs\":[";
		int indexstart = answer.indexOf(pattern);
		String troncatedString = answer.substring(indexstart + pattern.length(), answer.length() - 2);
		String[] separated = troncatedString.split("}");
		int cpt=0;
		for (String s : separated) {
			if (cpt!= separated.length-1) {
				String oneResult = s.substring(1,s.length()-1) + "}";	
				Gson gson = new Gson();
				
				Map<String,Object> map = new HashMap<String,Object>();
				map = (Map<String,Object>) gson.fromJson(oneResult, map.getClass());
			
				formattedAnswer += "first_name = " + map.get("first_name") + " last_name = " + map.get("last_name").toString()+ " expertLangs = " + map.get("expertLangs").toString()+ "\n";
			}
			cpt+=1;
			
		}
		return formattedAnswer;
	}
	
}
