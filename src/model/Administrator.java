package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("AU")
@Table(name="ADMINISTRATOR")
public class Administrator extends SystemUser {
	
	public Administrator() {}
	
	public Administrator(String email, String password, Date birthdate, String firstname, String lastname, char gender, String job, String residence, String school, String hometown) {
		super(email, password, birthdate, firstname, lastname, gender, job, residence, school, hometown);	
	}

}