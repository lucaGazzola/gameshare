package actions;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class LoginAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	User u;
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS

	private String email;
	private String password;

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