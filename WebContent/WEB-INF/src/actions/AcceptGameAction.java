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
	private String gameName;
	private String gameCategory;
	private AcceptLockService als;
	
	static int threshold = 3;
	
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
		als = new AcceptLockService();
		game = gameService.findByName(gameName, em);
		
		if(als.findLock((User)session.get("loggedInUser"), game, em) != null){
			addActionError(getText("error.lock"));
			return "lock";
		}
		
		if(game.isPublished()){
			addActionError(getText("error.alreadyPublished"));
			return "alreadyPublished";
		}
		
		als.saveLock((User)session.get("loggedInUser"), game, em);
		int acceptCount = game.getAcceptCount() + 1;
		game.setAcceptCount(acceptCount);
		if(acceptCount >= threshold){
			game.setPublished(true);
			gameService.update(game, em);
			System.out.println(acceptCount+" "+game.isPublished());
			EntityManagerUtil.closeEntityManager(em);
			return "published";
		}
		
		
		System.out.println(game.getAcceptCount());
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

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}	
}