package actions;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import org.apache.commons.codec.digest.DigestUtils;
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

	public String logout(){
		// rimuovo dalla session user e playgamelist
		if(session.remove("loggedInUser") != null && session.remove("playGameList") != null){
			return "successLogout";
		}
		else{
			addActionError("Logout error");
			return "errorLogout";
		}
	}
	//Default method invoked by STRUTS2
	public String login() {
		if (!email.equals("") && !password.equals("")){
			List<User> results = (List<User>)em.createQuery("SELECT p FROM NormalUser p where p.email = :value",User.class).setParameter("value", email).getResultList();
			if(!results.isEmpty()){
				u = results.get(0);
				if(DigestUtils.md5Hex(password).equals(u.getPassword())){
					user = u;
					//inserisco l'utente nella session
					session.put("loggedInUser", user);
					
					//inserisco nella session la lista dei played games
					List<Game> playGameList = 
							(List<Game>)em.createQuery("SELECT l.game FROM Like l WHERE l.user.ID_user = :id_user AND l.play = 'TRUE'",Game.class)
							.setParameter("id_user", user.getID_user())
							.getResultList();
					session.put("playGameList", playGameList);
					
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