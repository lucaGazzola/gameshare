package actions;

import model.Game;
import model.Like;
import model.SystemUser;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	public String execute(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		game = em.createQuery("SELECT g FROM Game g WHERE g.ID_game = :id",Game.class)
				.setParameter("id",id_game)
				.getSingleResult();
		likeList = (List<Like>) em.createQuery("SELECT l FROM Like l WHERE l.ID_like.ID_game = :id",Like.class)
				.setParameter("id",id_game)
				.getResultList();
		
		Iterator<Like> it = likeList.iterator();
		numLike = 0;
		numPlay = 0;
		while(it.hasNext()) {
			numLike++;
			if(it.next().isPlay()) numPlay++;
		} 
		
		TypedQuery<Object[]> query = em.createQuery(
			      "SELECT su.firstname, su.lastname, l.review FROM Like l JOIN SystemUser su ON l.ID_user = su.ID_user WHERE l.ID_like.ID_game = :id",
			      Object[].class);
		query.setParameter("id",id_game);
		user_reviewList = query.getResultList();
		
		
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
}
