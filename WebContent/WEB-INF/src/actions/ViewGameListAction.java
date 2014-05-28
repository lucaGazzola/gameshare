package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.persistence.EntityManager;

import model.Game;
import service.GameService;
import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ViewGameListAction extends ActionSupport {
	private static final long serialVersionUID = -7535988682705914155L;
	private GameService gameService = new GameService();
	private List<Game> gameList;
	private List<Game> boardgameList;
	private List<Game> cardgameList;
	private List<Game> sportList;
	private List<Game> videogameList;
	
	public String execute() throws Exception{
		//istanzio entity manager
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		try{
			gameList = gameService.findAll(em);
		}catch(Exception e){
			System.out.println("Error while retrieving game list: "+e.getMessage());
		}

		
		//separo nelle varie liste i game in base alla loro categoria
		if (!gameList.isEmpty()){
			Game tempGame;
			Iterator<Game> it = gameList.iterator();
			cardgameList = new ArrayList<Game>();
			boardgameList = new ArrayList<Game>();
			sportList = new ArrayList<Game>();
			videogameList = new ArrayList<Game>();
			while(it.hasNext()) {
				tempGame = it.next();
				switch(tempGame.getClass().getName()){
					case "model.CardGame": cardgameList.add(tempGame); break;
					case "model.BoardGame": boardgameList.add(tempGame); break;
					case "model.Sport": sportList.add(tempGame); break;
					case "model.Videogame": videogameList.add(tempGame); break;	
				}
			}
		}
		
		//chiudo entity manager
		EntityManagerUtil.closeEntityManager(em);
		return "success";
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}

	public List<Game> getBoardgameList() {
		return boardgameList;
	}

	public void setBoardgameList(List<Game> boardgameList) {
		this.boardgameList = boardgameList;
	}

	public List<Game> getCardgameList() {
		return cardgameList;
	}

	public void setCardgameList(List<Game> cardgameList) {
		this.cardgameList = cardgameList;
	}

	public List<Game> getSportList() {
		return sportList;
	}

	public void setSportList(List<Game> sportList) {
		this.sportList = sportList;
	}

	public List<Game> getVideogameList() {
		return videogameList;
	}

	public void setVideogameList(List<Game> videogameList) {
		this.videogameList = videogameList;
	}
}
