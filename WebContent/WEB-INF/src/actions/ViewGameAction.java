package actions;

import model.Game;
import model.Like;
import util.ReturnGameCategory;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ViewGameAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	private int id_game;
	private Game game;
	private List<Like> likeList;
	private List<Object[]> user_reviewList;
	private int numPlay;
	private int numLike;
	private String gameCategory;
	ReturnGameCategory util = new ReturnGameCategory();
	
	public String execute(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		try{
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
			while(it.hasNext()) {
				if(it.next().isPlay()) numPlay++;
			} 
			
			// estraggo le REVIEW e i nomi utenti cui sono associati
			user_reviewList =  (List<Object[]>)em.createQuery(
				      "SELECT l.user.firstname, l.user.lastname, l.review, l.score FROM Like l WHERE l.game.ID_game = :id",
				      Object[].class)
				      .setParameter("id",id_game)
				      .getResultList();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
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
}
