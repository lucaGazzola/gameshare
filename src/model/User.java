package model;

import javax.persistence.*;

@Entity
@TableGenerator(name="userGen",pkColumnName="key",pkColumnValue="ID_user",initialValue=0,table="counters",valueColumnName="value")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="USER_TYPE")
@Table(name="USER")
public class User {
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Id @Column(name="ID_user")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userGen") 
	private long ID_user;
	
	public User() {}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public long getID_user() {
		return ID_user;
	}

	public void setID_user(long iD_user) {
		ID_user = iD_user;
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
