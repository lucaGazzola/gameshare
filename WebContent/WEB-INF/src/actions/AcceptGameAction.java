package actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import org.apache.struts2.interceptor.SessionAware;

import service.AcceptLockService;
import service.GameService;
import util.EntityManagerUtil;

public class AcceptGameAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	
	
	//Data coming from the form, automatically injected by STRUTS
	private long id_game;
	private Game game;
	private String gameCategory;
	private AcceptLockService als;
	
	static int threshold = 1;
	
	private Map<String,Object> session;
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	public Map<String,Object> getSession(){
		return session;
	}

	//Default method invoked by STRUTS2
	public String execute() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		GameService gameService = new GameService();
		
		if(als.findLock((User)session.get("loggedInUser"), game, em) == null){
			addActionError(getText("error.accepted"));
			return "accepted";
		}
		als.saveLock((User)session.get("loggedInUser"), game, em);
		//game = gameService.find(id_game, em);
		int acceptCount = game.getAcceptCount() + 1;
		game.setAcceptCount(acceptCount);
		if(acceptCount >= threshold){
			game.setPublished(true);
			gameService.update(game, em);
			return "published";
		}
		
		
		
		gameService.update(game, em);
		EntityManagerUtil.closeEntityManager(em);
		return "success";
	}

	public long getId_game() {
		return id_game;
	}

	public Game getGame() {
		return game;
	}

	public String getGameCategory() {
		return gameCategory;
	}

	public void setId_game(long id_game) {
		this.id_game = id_game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}	
}