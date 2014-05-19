package actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.*;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class SearchGameAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	Game g;
	List<String> similarGames;
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Default method invoked by STRUTS2
	public String execute() {
		
		if (!name.equals("")){
			similarGames = new ArrayList<String>();
			String game;
			List<String> gamesList = (List<String>) em.createQuery("SELECT p.name FROM Game p",String.class).getResultList();
			Iterator<String> it = gamesList.iterator();
			while(it.hasNext()) {
				game = it.next();
				if(StringUtils.getLevenshteinDistance(game, name) < 2){
					similarGames.add(game);
				}
			}
			return "showList";
		}else{
			addActionError(getText("error.missingField"));
			return "errorMissingField";
		}	
	}	
}