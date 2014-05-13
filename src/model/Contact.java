package model;


import javax.persistence.*;

@Entity(name="CONTACT") 
@TableGenerator(name="contactGen",pkColumnName="key",pkColumnValue="contactID",initialValue=0,table="counters",valueColumnName="value")
public class Contact {
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="address")
	private String address;
	
	@Id @Column(name="contactID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="contactGen") 
	private long id;
	
	public Contact() {}
	
	public Contact(String firstname, String lastname, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}
		
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
	public String getAddress(){
		return this.address;
	}
	
}
