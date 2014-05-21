package actions;

import javax.persistence.EntityManager;

import model.Like;
import model.LikePK;
import service.LikeService;
import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

// action dedicata a intercettare la volontà di un utente a mettere LIKE o PLAY ad un gioco
public class PlayLikeAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	private int id_game;
	private int id_user;
	private LikeService likeService = new LikeService();
	
	public String likeGame(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		//creo oggetto like, con play=false, review vuota e score=-1
		Like like = new Like(new LikePK(id_user, id_game), false, "", -1);
		likeService.saveLike(like, em);
		
		EntityManagerUtil.closeEntityManager(em);;
		return "success";
	}
	
	public String playGame(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		//creo oggetto like, con play=true, review vuota e score=-1
		Like like = new Like(new LikePK(id_user, id_game), true, "", -1);
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