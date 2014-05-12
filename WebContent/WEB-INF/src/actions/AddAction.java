package actions;

import com.opensymphony.xwork2.ActionSupport;

import model.Book;
import model.Contact;

import javax.persistence.*;

import util.EntityManagerUtil;

public class AddAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private String firstname;
	private String lastname;
	private String address;
	
	Book b = Book.getInstance();
	Contact c;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	//Default method invoked by STRUTS2
	public String execute() {
		if (!firstname.equals("") && !lastname.equals("")){
			if(!(b.isPresent(firstname, lastname))){
				c = new Contact(firstname, lastname, address);
				b.add(c);
				em.persist(c);
				em.getTransaction().begin();
				em.getTransaction().commit();
				return "success";
			}else{
				addActionError(getText("error.duplicate"));
				return "errorDuplicate";
			}
		}else{
			addActionError(getText("error.field"));
			return "errorField";
		}	
	}	
}
