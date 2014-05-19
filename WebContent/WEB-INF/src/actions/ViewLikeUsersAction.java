package actions;

import java.util.List;

import javax.persistence.EntityManager;

import util.EntityManagerUtil;
import model.SystemUser;

import com.opensymphony.xwork2.ActionSupport;

public class ViewLikeUsersAction extends ActionSupport {
	private static final long serialVersionUID = -7535988682705910155L;

	private EntityManager em = EntityManagerUtil.getEntityManager();
	private int id_game;
	private List<SystemUser> userList;
	
//	public String viewPlayUsers() throws Exception{
//		setUserList((List<SystemUser>) em
//				.createQuery("SELECT su FROM Like l JOIN SystemUser su ON l.id_user = su.id_user WHERE l.id_game = :id_game AND l.play = 1",SystemUser.class)
//				.setParameter("id_game", id_game)
//				.getResultList());
//		
//		System.out.println("sono nel metodo viewPlayUsers()");
//		return "success";
//	}

	//Default method invoked by STRUTS2
	public String execute() throws Exception{
		System.out.println("sono nel metodo execute di view like users action");
		
//		setUserList((List<SystemUser>) em
//		.createQuery("SELECT su FROM Like l JOIN SystemUser su ON l.id_user = su.id_user WHERE l.id_game = :id_game",SystemUser.class)
//		.setParameter("id_game", id_game)
//		.getResultList());
		
		return "success";
	}

	public List<SystemUser> getUserList() {
		return userList;
	}

	public void setUserList(List<SystemUser> userList) {
		this.userList = userList;
	}
	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}
}
