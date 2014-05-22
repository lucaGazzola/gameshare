package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("SU")
@Table(name="SYSTEM_USER")
@MappedSuperclass
public class SystemUser extends User{

	@Temporal(TemporalType.DATE)
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="hometown")
	private String hometown;
	
	@Column(name="job")
	private String job;
	
	@Column(name="residence")
	private String residence;
	
	@Column(name="school")
	private String school;
	
	public SystemUser() {}
	
	public SystemUser(String email, String password, Date birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown) {
		super(email,password,firstname,lastname);
		this.birthdate = birthdate;
		this.gender = gender;
		this.hometown = hometown;
		this.school = school;
		this.residence = residence;
		this.job = job;
		
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstname() {
		return super.getFirstname();
	}

	public void setFirstname(String firstname) {
		super.setFirstname(firstname);
	}

	public String getLastname() {
		return super.getLastname();
	}

	public void setLastname(String lastname) {
		super.setLastname(lastname);
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return super.toString()+"SystemUser [birthdate=" + birthdate + ", firstname="
				+ super.getFirstname() + ", lastname=" + super.getLastname() + ", gender=" + gender
				+ ", hometown=" + hometown + ", job=" + job + ", residence="
				+ residence + ", school=" + school + "]";
	}
	
	
		

}
