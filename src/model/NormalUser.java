package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("N")
@Table(name="NormalUser")
public class NormalUser extends SystemUser {
	
	public NormalUser() {}
	
	public NormalUser(String email, String password, String birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown) {
		super(email,password, birthdate, firstname, lastname, gender, job, residence, school, hometown);	
	}

}