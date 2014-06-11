package actions;

import model.Game;
import model.Like;
import model.User;
import service.AcceptLockService;
import util.ReturnGameCategory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.struts2.interceptor.SessionAware;

import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ViewGameAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 5976515590599826089L;
	private int id_game;
	private Game game;
	private List<Like> likeList;
	private List<Object[]> user_reviewList;
	private int numPlay;
	private int numLike;
	private int isPlay;
	private int isLike;
	private int isAlreadyAccept;
	private int score;
	private String gameCategory;
	ReturnGameCategory util = new ReturnGameCategory();
	private User user;
	
	//usata per prelevare l'user loggato
	private Map<String,Object> session; 
	
	public String execute(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		try{
			// estraggo user dalla session
			user = (User)session.get("loggedInUser");
			// estraggo il game
			game = em.createQuery("SELECT g FROM Game g WHERE g.ID_game = :id",Game.class)
					.setParameter("id",id_game)
					.getSingleResult();
			gameCategory = util.gameCategory(game);
			
			// estraggo la lista dei like associati al game
			likeList = (List<Like>) em.createQuery("SELECT l FROM Like l WHERE l.game.ID_game = :id",Like.class)
					.setParameter("id",id_game)
					.getResultList();
			
			// conto il numero dei like e dei play
			Iterator<Like> it = likeList.iterator();
			numLike = likeList.size();
			numPlay = 0;
			isPlay = isLike = 0;
			while(it.hasNext()) {
				Like like = it.next();
				if(((User)like.getUser()).getID_user() == user.getID_user())
				{
					isLike=1; //dice se l'utente ha gia'�messo LIKE
					if(like.isPlay()){
						score = like.getScore();
						isPlay=1; //dice se l'utente ha gia'�messo PLAY
					}
				}
				
				if(like.isPlay()) numPlay++;
			} 
			
			// estraggo le REVIEW e i nomi utenti cui sono associati
			user_reviewList =  (List<Object[]>)em.createQuery(
				      "SELECT l.user.firstname, l.user.lastname, l.review, l.score FROM Like l WHERE l.game.ID_game = :id  AND l.review IS NOT NULL",
				      Object[].class)
				      .setParameter("id",id_game)
				      .getResultList();
			
			
			// verifico se ha gia' fatto accept sul gioco
			AcceptLockService acceptService = new AcceptLockService();
			isAlreadyAccept = 0;
			if(acceptService.findLock(user, game, em) != null){
				isAlreadyAccept = 1;
			}
		}catch(Exception e){
			System.out.println("Errore");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		System.out.println(game);
		EntityManagerUtil.closeEntityManager(em);
		return "success";
	}
	
	
	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Like> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Like> likeList) {
		this.likeList = likeList;
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


	public List<Object[]> getUser_reviewList() {
		return user_reviewList;
	}


	public void setUser_reviewList(List<Object[]> user_reviewList) {
		this.user_reviewList = user_reviewList;
	}


	public String getGameCategory() {
		return gameCategory;
	}


	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	public Map<String,Object> getSession(){
		return session;
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


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	public int getIsAlreadyAccept() {
		return isAlreadyAccept;
	}


	public void setIsAlreadyAccept(int isAlreadyAccept) {
		this.isAlreadyAccept = isAlreadyAccept;
	}

}
