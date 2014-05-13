package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("N")
@Table(name="NORMAL_USER")
public class NormalUser extends SystemUser {
	
	public NormalUser() {}
	
	public NormalUser(String email, String password, Date birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown) {
		super(email,password, birthdate, firstname, lastname, gender, job, residence, school, hometown);	
	}

}