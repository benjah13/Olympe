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
        result.setTgi(((List<String>) solrDocument.getFieldValue("tgi")).get(0));
        result.setAgency(((List<String>) solrDocument.getFieldValue("agency")).get(0));
        result.setLowSkills(((List<String>) solrDocument.getFieldValue("lowSkills")).get(0));
        result.setMediumSkills(((List<String>) solrDocument.getFieldValue("mediumSkills")).get(0));
        result.setHighSkills(((List<String>) solrDocument.getFieldValue("highSkills")).get(0));
        result.setExpertSkills(((List<String>) solrDocument.getFieldValue("expertSkills")).get(0));
        result.setMediumLangs(((List<String>) solrDocument.getFieldValue("mediumLangs")).get(0));
        result.setExpertLangs(((List<String>) solrDocument.getFieldValue("expertLangs")).get(0));
        result.setBirthday(((List<String>) solrDocument.getFieldValue("birthday")).get(0));
        result.setClient(((List<String>) solrDocument.getFieldValue("client")).get(0));
        result.setDescription(((List<String>) solrDocument.getFieldValue("description")).get(0));
        result.setEducationSchool(((List<String>) solrDocument.getFieldValue("educationSchool")).get(0));
        result.setEducationTitle(((List<String>) solrDocument.getFieldValue("educationTitle")).get(0));
        result.setEducationYear(((List<Long>) solrDocument.getFieldValue("educationYear")).get(0));
        result.setSeniority(((List<Long>) solrDocument.getFieldValue("seniority")).get(0));
        result.setJob(((List<String>) solrDocument.getFieldValue("job")).get(0));
        result.setMail(((List<String>) solrDocument.getFieldValue("mail")).get(0));

        //TODO

        return result;
    }
}
