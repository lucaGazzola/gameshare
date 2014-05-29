package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MU")
@Table(name="MODERATOR")
public class Moderator extends SystemUser {
	
	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Moderator() {}
	
	public Moderator(String email, String password, Date birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown, String category) {
		super(email,password, birthdate, firstname, lastname, gender, job, residence, school, hometown);	
		this.category= category;
	}

}
