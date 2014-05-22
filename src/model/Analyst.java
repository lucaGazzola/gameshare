package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AN")
@Table(name="ANALYST")
public class Analyst extends User{
	
	public Analyst() {}
	
	public Analyst(String email, String password, String firstname, String lastname) {
		super(email,password,firstname,lastname);	
	}
}
