package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")
@Table(name="Moderator")
public class Moderator extends SystemUser {
	
	public Moderator() {}
	
	public Moderator(String email, String password, Date birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown) {
		super(email,password, birthdate, firstname, lastname, gender, job, residence, school, hometown);	
	}

}
