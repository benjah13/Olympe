package fr.thales.solradapter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.thales.solradapter.model.Employee;
import fr.thales.solradapter.model.InputKeyWord;
import fr.thales.solradapter.model.ResponseKeyWord;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static fr.thales.solradapter.conf.ApplicationConfiguration.SOLR_URL;


@Service
public class SolrEmployeeService {

    @Autowired
    private SolrEmployeeMapperService solrEmployeeMapperService;

    public String search(Map<String, String> filterMap, String responseKeyWord) {

        QueryResponse queryResponse = executeQuery(filterMap);

        return buildResponse(queryResponse, responseKeyWord);
    }

    private String buildResponse(QueryResponse queryResponse, String responseKeyWord) {

        String result = null;

        if(responseKeyWord != null){
            if(responseKeyWord.equals(ResponseKeyWord.HOWMANY.getValue())){
                result = String.valueOf(queryResponse.getResults().getNumFound());
            }
        }
        else{
            List<Employee> employees = solrEmployeeMapperService.toEmployeeList(queryResponse.getResults());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                result = objectMapper.writeValueAsString(employees);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private QueryResponse executeQuery(Map<String, String> filterMap) {

        QueryResponse result = null;

        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_URL).build();
        SolrQuery solrQuery = buildSolrQuery(filterMap);

        try {
            result = solrClient.query(solrQuery);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private SolrQuery buildSolrQuery(Map<String, String> filterMap) {

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");

        for(Map.Entry<String, String> entry : filterMap.entrySet()){
            addFilter(solrQuery, entry.getKey(), entry.getValue());
        }

        solrQuery.setStart(0);
        solrQuery.setRows(10);

        return solrQuery;
    }

    private void addFilter(SolrQuery solrQuery, String filterName, String filterValue) {
        if(filterValue != null){
            solrQuery.addFilterQuery(filterName + ":" + addFilterValue(filterValue));
        }
    }

    private String addFilterValue(String filterValue) {

        String result = null;

        if (filterValue.contains(InputKeyWord.AND.getValue())){
            result = "(" + filterValue.replace(
                    InputKeyWord.AND.getValue(),
                    InputKeyWord.AND.getConvertValue()) + ")";
        }
        else if (filterValue.contains(InputKeyWord.OR.getValue())){
            result = "(" + filterValue.replace(
                    InputKeyWord.OR.getValue(),
                    InputKeyWord.OR.getConvertValue()) + ")";
        }
        else{
            result = filterValue;
        }

        return result;
    }

}
