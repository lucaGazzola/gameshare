package model;

import javax.persistence.*;

@Entity
@TableGenerator(name="userGen",pkColumnName="key",pkColumnValue="userID",initialValue=0,table="counters",valueColumnName="value")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="USER_TYPE")
@Table(name="USER")
public class User {
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Id @Column(name="userID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userGen") 
	private long id;
	
	public User() {}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
		
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPassword(){
		return this.password;
	}

}
