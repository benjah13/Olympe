package fr.thales.solradapter.model;
import lombok.Data;

@Data
public class Employee {

    private String tgi;
    private String firstName;
    private String lastName;
    private String birthday;
    private String mail;
    private String agency;
    private String client;
    private String description;
    private String job;
    private String lowSkills;
    private String mediumSkills;
    private String highSkills;
    private String expertSkills;
    private String mediumLangs;
    private String expertLangs;
    private String educationTitle;
    private String educationSchool;
    private Long educationYear;
    private Long seniority;
}
