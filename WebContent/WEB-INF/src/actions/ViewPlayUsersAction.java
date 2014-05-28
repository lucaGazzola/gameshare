package actions;

import java.util.List;

import javax.persistence.EntityManager;

import util.EntityManagerUtil;
import model.Game;
import model.User;

import com.opensymphony.xwork2.ActionSupport;

public class ViewPlayUsersAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	
	private int id_game;
	private Game game;
	private List<User> userList;
	
	public String execute(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		try{
			
			userList = ((List<User>) em
					.createQuery("SELECT l.user FROM Like l WHERE l.game.ID_game = :id_game AND l.play = 'TRUE'",User.class)
					.setParameter("id_game", id_game)
					.getResultList());
			
		}catch(Exception e){
			System.out.println("Exception while retrieving user list: "+ e.getMessage());
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
