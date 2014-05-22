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
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	
	private String game;
	List<Game> similarGames;
	
	
	public List<Game> getSimilarGames() {
		return similarGames;
	}

	public String getGame() {
		return game;
	}


	public void setGame(String game) {
		this.game = game;
	}


	//Default method invoked by STRUTS2
	public String execute() {
		String nextGame;
		Game g;
		if (!game.equals("")){
			similarGames = new ArrayList<Game>();
			List<Game> gamesList = (List<Game>) em.createQuery("SELECT p FROM Game p",Game.class).getResultList();
			Iterator<Game> it = gamesList.iterator();
			while(it.hasNext()) {
				g = it.next();
				nextGame = g.getName();		
				if(StringUtils.getLevenshteinDistance(nextGame, game) <= 2){
					similarGames.add(g);
				}
			}
			return "success";
		}else{
			addActionError(getText("error.missingField"));
			return "errorMissingField";
		}	
	}	
}