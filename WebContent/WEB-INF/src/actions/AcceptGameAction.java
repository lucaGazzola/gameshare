package actions;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class AcceptGameAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	String gameName;
	Game g;
	static int threshold = 1;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	//Default method invoked by STRUTS2
	public String execute() {
		if (!gameName.equals("")){
			List<Game> results =  (List<Game>)em.createQuery("SELECT p FROM Game p WHERE p.name = :value",Game.class).setParameter("value", gameName).getResultList();
			g = results.get(0);
			g.setAcceptCount(g.getAcceptCount()+1);
			if(g.getAcceptCount() >= threshold){
				g.setPublished(true);
			}
			em.getTransaction().begin();
			em.getTransaction().commit();
			return "success";
		}else{
			addActionError(getText("error.missingField"));
			return "errorField";
		}	
	}	
}