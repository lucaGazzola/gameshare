package actions;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class AddAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private String firstname;
	private String lastname;
	private String address;
	
	NormalUser u;
	CardGame g;
	Like l;
	LikePK lpk;
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
		
		
		//test insert per user e game
		g = new CardGame("briscola", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		em.persist(g);
		Date now = new Date();
		u = new NormalUser("franco@franco", "prolol", now, "luca", "franchi", 'M', "troz", "sov", "bicocca", "frenk");
		em.persist(u);
		//fine test insert
		lpk = new LikePK(1,1);
		l = new Like();
		l.setID_like(lpk);
		l.setPlay(true);
		l.setReview("fwdadwad");
		l.setScore(5);
		em.persist(l);
		
		if (!firstname.equals("") && !lastname.equals("")){
			if(!(b.isPresent(firstname, lastname))){
				c = new Contact(firstname, lastname, address);
				b.add(c);
				em.persist(c);
				em.getTransaction().begin();
				em.getTransaction().commit();
				
				
				//test query per user e game
				List<CardGame> list = (List<CardGame>) em.createQuery("SELECT p FROM CardGame p",CardGame.class).getResultList();
				Iterator<CardGame> it = list.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				} 
				
				List<NormalUser> listu = (List<NormalUser>) em.createQuery("SELECT p FROM NormalUser p",NormalUser.class).getResultList();
				Iterator<NormalUser> itu = listu.iterator();
				while(itu.hasNext()) {
					System.out.println(itu.next());
				} 
				//fine test query
				
				
				
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
