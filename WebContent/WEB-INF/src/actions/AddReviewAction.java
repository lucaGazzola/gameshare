package actions;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class AddReviewAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	long id_game;
	long id_user;
	int score;
	String review;
	Like l;
	static int threshold = 1;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public long getId_game() {
		return id_game;
	}

	public void setId_game(long id_game) {
		this.id_game = id_game;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public Like getL() {
		return l;
	}

	public void setL(Like l) {
		this.l = l;
	}

	//Default method invoked by STRUTS2
	public String execute() {
			List<Like> results =  (List<Like>)em.createQuery("SELECT l FROM Like l WHERE l.id_game = :value AND l.id_user = :value2",Like.class).setParameter("value", id_game).setParameter("value2", id_user).getResultList();
			l = results.get(0);
			if(!review.equals(""))
				l.setReview(review);
			l.setScore(score);
			em.getTransaction().begin();
			em.getTransaction().commit();
				
			return "success";
	}	
}