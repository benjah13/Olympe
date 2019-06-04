package types;

import java.util.List;

public class Employee {
	protected String tgi;
	protected String first_name;
	protected String last_name;
	protected int educationYear;
	protected int seniority;
	protected String birthday;
	protected String mail;
	protected String agency;
	protected String client;
	protected String description;
	protected String job;
	protected String lowSkills;
	protected String mediumSkills;
	protected String highSkills;
	protected String expertSkills;
	protected String mediumLangs;
	protected String expertLangs;
	protected String educationTitle;
	protected String educationSchool;
	

	public Employee() {
		super();
	}
	public Employee(String tgi, String first_name, String last_name, int educationYear, int seniority, String birthday,
			String mail, String agency, String client, String description, String job, String lowSkills,
			String mediumSkills, String highSkills, String expertSkills, String mediumLangs, String expertLangs,
			String educationTitle, String educationSchool) {
		super();
		this.tgi = tgi;
		this.first_name = first_name;
		this.last_name = last_name;
		this.educationYear = educationYear;
		this.seniority = seniority;
		this.birthday = birthday;
		this.mail = mail;
		this.agency = agency;
		this.client = client;
		this.description = description;
		this.job = job;
		this.lowSkills = lowSkills;
		this.mediumSkills = mediumSkills;
		this.highSkills = highSkills;
		this.expertSkills = expertSkills;
		this.mediumLangs = mediumLangs;
		this.expertLangs = expertLangs;
		this.educationTitle = educationTitle;
		this.educationSchool = educationSchool;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTgi() {
		return tgi;
	}
	public void setTgi(String tgi) {
		this.tgi = tgi;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getEducationYear() {
		return educationYear;
	}
	public void setEducationYear(int educationYear) {
		this.educationYear = educationYear;
	}
	public String getLowSkills() {
		return lowSkills;
	}
	public void setLowSkills(String lowSkills) {
		this.lowSkills = lowSkills;
	}
	public String getMediumSkills() {
		return mediumSkills;
	}
	public void setMediumSkills(String mediumSkills) {
		this.mediumSkills = mediumSkills;
	}
	public String getHighSkills() {
		return highSkills;
	}
	public void setHighSkills(String highSkills) {
		this.highSkills = highSkills;
	}
	public String getExpertSkills() {
		return expertSkills;
	}
	public void setExpertSkills(String expertSkills) {
		this.expertSkills = expertSkills;
	}
	public String getMediumLangs() {
		return mediumLangs;
	}
	public void setMediumLangs(String mediumLangs) {
		this.mediumLangs = mediumLangs;
	}
	public String getExpertLangs() {
		return expertLangs;
	}
	public void setExpertLangs(String expertLangs) {
		this.expertLangs = expertLangs;
	}
	public String getEducationTitle() {
		return educationTitle;
	}
	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle;
	}


	public String getEducationSchool() {
		return educationSchool;
	}
	public void setEducationSchool(String educationSchool) {
		this.educationSchool = educationSchool;
	}
}
