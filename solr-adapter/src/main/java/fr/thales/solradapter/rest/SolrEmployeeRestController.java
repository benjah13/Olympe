package fr.thales.solradapter.rest;

import fr.thales.solradapter.service.SolrEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/solr")
public class SolrEmployeeRestController {

    @Autowired
    private SolrEmployeeService solrEmployeeService;

    @RequestMapping
    public String index(){
        return "Hello World!";
    }



    @RequestMapping("/employee")
    String employee(@RequestParam(value = "agency", required=false) final String agency,
                    @RequestParam(value = "tgi", required=false) final String tgi,
                    @RequestParam(value = "firstName", required=false) final String firstName,
                    @RequestParam(value = "lastName", required=false) final String lastName,
                    @RequestParam(value = "birthday", required=false) final String birthday,
                    @RequestParam(value = "mail", required=false) final String mail,
                    @RequestParam(value = "client", required=false) final String client,
                    @RequestParam(value = "seniority", required=false) final String seniority,
                    @RequestParam(value = "description", required=false) final String description,
                    @RequestParam(value = "job", required=false) final String job,
                    @RequestParam(value = "lowSkills", required=false) final String lowSkills,
                    @RequestParam(value = "mediumSkills", required=false) final String mediumSkills,
                    @RequestParam(value = "highSkills", required=false) final String highSkills,
                    @RequestParam(value = "expertSkills", required=false) final String expertSkills,
                    @RequestParam(value = "mediumLangs", required=false) final String mediumLangs,
                    @RequestParam(value = "expertLangs", required=false) final String expertLangs,
                    @RequestParam(value = "educationTitle", required=false) final String educationTitle,
                    @RequestParam(value = "educationSchool", required=false) final String educationSchool,
                    @RequestParam(value = "educationYear", required=false) final String educationYear,
                    @RequestParam(value = "responseKeyWord", required=false) final String responseKeyWord) {

        Map<String, String> filterMap = new HashMap<>();

        if(tgi != null){
            filterMap.put("tgi", tgi);
        }
        if(firstName != null){
            filterMap.put("firstName", firstName);
        }
        if(lastName != null){
            filterMap.put("lastName", lastName);
        }
        if(birthday != null){
            filterMap.put("birthday", birthday);
        }
        if(mail != null){
            filterMap.put("mail", mail);
        }
        if(agency != null){
            filterMap.put("agency", agency);
        }
        if(client != null){
            filterMap.put("client", client);
        }
        if(description != null){
            filterMap.put("description", description);
        }
        if(job != null){
            filterMap.put("job", job);
        }
        if(lowSkills != null){
            filterMap.put("lowSkills", lowSkills);
        }
        if(mediumSkills != null){
            filterMap.put("mediumSkills", mediumSkills);
        }
        if(highSkills != null){
            filterMap.put("highSkills", highSkills);
        }
        if(expertSkills != null){
            filterMap.put("expertSkills", expertSkills);
        }
        if(mediumLangs != null){
            filterMap.put("mediumLangs", mediumLangs);
        }
        if(expertLangs != null){
            filterMap.put("expertLangs", expertLangs);
        }
        if(educationTitle != null){
            filterMap.put("educationTitle", educationTitle);
        }
        if(educationSchool != null){
            filterMap.put("educationSchool", educationSchool);
        }
        if(educationYear != null){
            filterMap.put("educationYear", educationYear);
        }
        if(seniority != null){
            filterMap.put("seniority", seniority);
        }

        return solrEmployeeService.search(filterMap, responseKeyWord);
    }

}
