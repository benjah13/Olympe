package fr.thales.solradapter.service;

import fr.thales.solradapter.model.Employee;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SolrEmployeeMapperService {

    public List<Employee> toEmployeeList(SolrDocumentList solrDocumentList) {

        List<Employee> result = new ArrayList<>();

        Iterator<SolrDocument> iterator = solrDocumentList.iterator();
        while (iterator.hasNext()) {

            result.add(toEmployee(iterator.next()));
        }

        return result;
    }

    private Employee toEmployee(SolrDocument solrDocument) {

        Employee result = new Employee();

        result.setFirstName(((List<String>) solrDocument.getFieldValue("first_name")).get(0));
        result.setLastName(((List<String>) solrDocument.getFieldValue("last_name")).get(0));

        //TODO

        return result;
    }
}
