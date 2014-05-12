package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
@Table(name="Administrator")
public class Administrator extends SystemUser {
	
	public Administrator() {}
	
	public Administrator(String email, String password, String birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown) {
		super(email,password, birthdate, firstname, lastname, gender, job, residence, school, hometown);	
	}

}