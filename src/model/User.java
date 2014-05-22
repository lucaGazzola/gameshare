package model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@TableGenerator(name="userGen",pkColumnName="key",pkColumnValue="ID_user",initialValue=0,table="counters",valueColumnName="value")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="USER_TYPE")
@Table(name="USER_")
@MappedSuperclass
public class User {
	
	@Id @Column(name="ID_user")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userGen") 
	private long ID_user;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@OneToMany(mappedBy="user")
	private Collection<Like> likes;
	
	@OneToMany(mappedBy="sourceUser")
	private Collection<Friendship> sentRequests;
	
	@OneToMany(mappedBy="targetUser")
	private Collection<Friendship> receivedRequests;
	
	
	
	public User(){}
	
	public User(String email, String password, String firstname, String lastname) {
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Collection<Like> getLikes() {
		return likes;
	}

	public void setLikes(Collection<Like> likes) {
		this.likes = likes;
	}

	public Collection<Friendship> getSentRequests() {
		return sentRequests;
	}

	public void setSentRequests(Collection<Friendship> sentRequests) {
		this.sentRequests = sentRequests;
	}

	public Collection<Friendship> getReceivedRequests() {
		return receivedRequests;
	}

	public void setReceivedRequests(Collection<Friendship> receivedRequests) {
		this.receivedRequests = receivedRequests;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", ID_user="
				+ ID_user + "]";
	}
	
	

}
