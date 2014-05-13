package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
@Table(name="ANALYST")
public class Analyst extends User{
	
	public Analyst() {}
	
	public Analyst(String email, String password) {
		super(email,password);	
	}
}
