package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.struts2.interceptor.SessionAware;

import model.Game;
import service.GameService;
import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ViewGameListAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -7535988682705914155L;
	private GameService gameService = new GameService();
	private List<Game> gameList;
	private List<Game> boardgameList;
	private List<Game> cardgameList;
	private List<Game> sportList;
	private List<Game> videogameList;
	
	private List<Game> unaccepted_gameList;
	private List<Game> unaccepted_boardgameList;
	private List<Game> unaccepted_cardgameList;
	private List<Game> unaccepted_sportList;
	private List<Game> unaccepted_videogameList;
	
	private Map<String,Object> session;
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	public Map<String,Object> getSession(){
		return session;
	}
	
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
			
			unaccepted_gameList = new ArrayList<Game>();
			unaccepted_cardgameList = new ArrayList<Game>();
			unaccepted_boardgameList = new ArrayList<Game>();
			unaccepted_sportList = new ArrayList<Game>();
			unaccepted_videogameList = new ArrayList<Game>();
			
			while(it.hasNext()) {
				tempGame = it.next();
				switch(tempGame.getClass().getName()){
					case "model.CardGame": 
						if(tempGame.isPublished()) cardgameList.add(tempGame);
						else{
							unaccepted_cardgameList.add(tempGame);
							unaccepted_gameList.add(tempGame);
						}
						break;
					case "model.BoardGame": 
						if(tempGame.isPublished()) boardgameList.add(tempGame);
						else{
							unaccepted_boardgameList.add(tempGame);
							unaccepted_gameList.add(tempGame);
						}
						break;
					case "model.Sport": 
						if(tempGame.isPublished()) sportList.add(tempGame); 
						else{
							unaccepted_sportList.add(tempGame);
							unaccepted_gameList.add(tempGame);
						}
						break;
					case "model.Videogame":
						if(tempGame.isPublished()) videogameList.add(tempGame);
						else{
							unaccepted_videogameList.add(tempGame);
							unaccepted_gameList.add(tempGame);
						}
						break;	
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

	public List<Game> getUnaccepted_gameList() {
		return unaccepted_gameList;
	}

	public void setUnaccepted_gameList(List<Game> unaccepted_gameList) {
		this.unaccepted_gameList = unaccepted_gameList;
	}

	public List<Game> getUnaccepted_boardgameList() {
		return unaccepted_boardgameList;
	}

	public void setUnaccepted_boardgameList(List<Game> unaccepted_boardgameList) {
		this.unaccepted_boardgameList = unaccepted_boardgameList;
	}

	public List<Game> getUnaccepted_cardgameList() {
		return unaccepted_cardgameList;
	}

	public void setUnaccepted_cardgameList(List<Game> unaccepted_cardgameList) {
		this.unaccepted_cardgameList = unaccepted_cardgameList;
	}

	public List<Game> getUnaccepted_sportList() {
		return unaccepted_sportList;
	}

	public void setUnaccepted_sportList(List<Game> unaccepted_sportList) {
		this.unaccepted_sportList = unaccepted_sportList;
	}

	public List<Game> getUnaccepted_videogameList() {
		return unaccepted_videogameList;
	}

	public void setUnaccepted_videogameList(List<Game> unaccepted_videogameList) {
		this.unaccepted_videogameList = unaccepted_videogameList;
	}
}
