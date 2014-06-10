package actions;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import service.GameService;
import util.EntityManagerUtil;

public class AcceptGameAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	
	//Data coming from the form, automatically injected by STRUTS
	private long id_game;
	private Game game;
	private String gameCategory;
	
	static int threshold = 1;

	//Default method invoked by STRUTS2
	public String execute() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		GameService gameService = new GameService();
		
		game = gameService.find(id_game, em);
		int acceptCount = game.getAcceptCount() + 1;
		game.setAcceptCount(acceptCount);
		if(acceptCount >= threshold){
			game.setPublished(true);
			gameService.update(game, em);
			return "accepted";
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