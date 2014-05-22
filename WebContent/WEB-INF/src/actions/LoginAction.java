package actions;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import org.apache.struts2.interceptor.SessionAware;

import util.EntityManagerUtil;

public class LoginAction extends ActionSupport implements SessionAware{

	EntityManager em = EntityManagerUtil.getEntityManager();
	User u;
	private static final long serialVersionUID = 1L;
	//Data coming from the form, automatically injected by STRUTS
	private User user;
	private String email;
	private String password;
	private Map<String,Object> session;
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	public Map<String,Object> getSession(){
		return session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//Default method invoked by STRUTS2
	public String execute() {
		
		if (!email.equals("") && !password.equals("")){
			List<User> results = (List<User>)em.createQuery("SELECT p FROM NormalUser p where p.email = :value",User.class).setParameter("value", email).getResultList();
			if(!results.isEmpty()){
				u = results.get(0);
				if(password.equals(u.getPassword())){
					user = u;
					session.put("loggedInUser", user);
					return "success";
				}else{
					addActionError(getText("error.wrongLogin"));
					return "errorWrongLogin";
				}
			}else{
				addActionError(getText("error.userNotRegistered"));
				return "errorUserNotRegistered";
			}
		}else{
			addActionError(getText("error.missingField"));
			return "errorField";
		}
		
	}
}