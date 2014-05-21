package actions;

import model.CardGame;
import model.Like;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ViewGameAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	private int id_game;
	private CardGame game;
	private List<Like> likeList;
	private int numPlay;
	private int numLike;
	
	public String execute(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		game = em.createQuery("SELECT cg FROM CardGame cg WHERE cg.ID_game = :id",CardGame.class)
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
		
		
		EntityManagerUtil.closeEntityManager(em);
		return "success";
	}
	
	
	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public CardGame getGame() {
		return game;
	}

	public void setGame(CardGame game) {
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
}
