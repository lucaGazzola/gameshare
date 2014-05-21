package actions;

import javax.persistence.EntityManager;

import model.Game;
import model.Like;
import model.User;
import service.LikeService;
import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

// action dedicata a intercettare la volontà di un utente a mettere LIKE o PLAY ad un gioco
public class PlayLikeAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	private int id_game;
	private int id_user;
	User u;
	Game g;
	private LikeService likeService = new LikeService();
	
	public String likeGame(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		//creo oggetto like, con play=false, review vuota e score=-1
		u = em.find(User.class, id_user);
		g = em.find(Game.class, id_game);
		Like like = new Like(u, g, false, "", -1);
		likeService.saveLike(like, em);
		
		EntityManagerUtil.closeEntityManager(em);;
		return "success";
	}
	
	public String playGame(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		u = em.find(User.class, id_user);
		g = em.find(Game.class, id_game);
		//creo oggetto like, con play=true, review vuota e score=-1
		Like like = new Like(u, g, true, "", -1);
		likeService.saveLike(like, em);
		
		EntityManagerUtil.closeEntityManager(em);;
		return "success";
	}
	
	public String execute(){
//		EntityManager em = EntityManagerUtil.getEntityManager();
//		
//		EntityManagerUtil.closeEntityManager(em);
		return "success";
	}

	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}