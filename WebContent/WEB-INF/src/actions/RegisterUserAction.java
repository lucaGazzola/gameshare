package actions;

import java.util.Date;
import java.util.List;

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
	private Date birthdate;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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

	//Default method invoked by STRUTS2
	public String execute() {
		
		if (!email.equals("") && !password.equals("")){
	
			List<User> results = (List<User>)em.createQuery("SELECT p FROM NormalUser p where p.email = :value").setParameter("value", email).getResultList();
			if(results.isEmpty()){

				//user object creation
				u = new NormalUser(email, password, birthdate, firstname, lastname, gender, job, residence, school, hometown);
				
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
