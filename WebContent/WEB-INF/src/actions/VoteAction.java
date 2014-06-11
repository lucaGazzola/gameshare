package actions;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.struts2.interceptor.SessionAware;

import model.Game;

import model.User;
import service.GameService;
import service.LikeService;
import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

// action dedicata a intercettare la volontà di un utente a mettere PLAY ad un gioco
public class VoteAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 5976515590599826089L;
	private LikeService likeService = new LikeService();
	private GameService gameService = new GameService();
	
	private Game game;
	
	//servono per il rendering della pagina "game"
	private int id_game;
	private List<Object[]> user_reviewList;
	private int numPlay;
	private int numLike;
	private String gameCategory;
	private int isPlay;
	private int isLike;
	private String vote;
	private int score;
	
	//usata per prelevare l'user loggato
	private Map<String,Object> session; 
	
	public String execute(){
		//istanzio entity manager
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		if(vote.equals("")){
			addActionError(getText("error.missingField"));
			return "missingField";
		}
		
		if(isPlay == 0){
			addActionError(getText("error.notPlayed"));
			return "notPlayed";
		}
		
		score = Integer.parseInt(vote);
		
		likeService.saveVote(id_game, ((User)session.get("loggedInUser")).getID_user(), score, em);

		// estraggo le REVIEW e i nomi utenti cui sono associati
		user_reviewList =  (List<Object[]>)em.createQuery(
			      "SELECT l.user.firstname, l.user.lastname, l.review, l.score FROM Like l WHERE l.game.ID_game = :id AND l.review IS NOT NULL",
			      Object[].class)
			      .setParameter("id",id_game)
			      .getResultList();
		
		//aggiorno i valori di game
		game = gameService.find(id_game, em);
		
		//chiudo entity manager
		EntityManagerUtil.closeEntityManager(em);
		return "success";
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	public Map<String,Object> getSession(){
		return session;
	}

	public List<Object[]> getUser_reviewList() {
		return user_reviewList;
	}

	public void setUser_reviewList(List<Object[]> user_reviewList) {
		this.user_reviewList = user_reviewList;
	}

	public int getNumPlay() {
		return numPlay;
	}

	public void setNumPlay(int numPlay) {
		this.numPlay = numPlay;
	}

	public int getNumLike() {
		return numLike;
	}

	public void setNumLike(int numLike) {
		this.numLike = numLike;
	}

	public String getGameCategory() {
		return gameCategory;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public int getIsPlay() {
		return isPlay;
	}

	public void setIsPlay(int isPlay) {
		this.isPlay = isPlay;
	}

	public int getIsLike() {
		return isLike;
	}

	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}