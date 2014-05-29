package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class RegisterUserAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	User u;
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private String firstname;
	private String lastname;
	private String hometown;
	private String birthdate;
	private String residence;
	private String email;
	private String password;
	private char gender;
	private String job;
	private String school;
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public boolean containsIllegals(String toExamine) {
	    Pattern pattern = Pattern.compile("[~#@*+%{}<>\\[\\]|\"\\_^]");
	    Matcher matcher = pattern.matcher(toExamine);
	    return matcher.find();
	}

	//Default method invoked by STRUTS2
	public String execute() {
		
		String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
		
		
		if (!email.equals("") && !password.equals("") && birthdate.matches(datePattern) && (gender == 'M' || gender == 'F')){
			
			List<User> results = (List<User>)em.createQuery("SELECT p FROM NormalUser p where p.email = :value").setParameter("value", email).getResultList();
			if(results.isEmpty()){

				DateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
				Date date = null;
				try {
					date = formatter.parse(birthdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//user object creation
				u = new NormalUser(email, password, date, firstname, lastname, gender, job, residence, school, hometown);
				
				//persist user
				em.persist(u);
				em.getTransaction().begin();
				em.getTransaction().commit();
			
				return "success";
			}else{
				addActionError(getText("error.userRegistered"));
				return "errorDuplicate";
			}
		}else{
			addActionError(getText("error.missingField"));
			return "errorField";
		}	
	}	
}
