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
                    @RequestParam(value = "seniority", required=false) final String seniority,
                    @RequestParam(value = "expertSkills", required=false) final String expertSkills,
                    @RequestParam(value = "responseKeyWord", required=false) final String responseKeyWord) {

        Map<String, String> filterMap = new HashMap<>();

        if(agency != null){
            filterMap.put("agency", agency);
        }
        if(seniority != null){
            filterMap.put("seniority", seniority);
        }
        if(seniority != null){
            filterMap.put("expertSkills", expertSkills);
        }

        return solrEmployeeService.search(filterMap, responseKeyWord);
    }

}
