package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="LIKE_")
public class Like implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private LikePK ID_like;
    
    @Column(name = "play")
    private boolean play;
    
    @Column(name = "review", columnDefinition = "TEXT")
    private String review;
    
    @Column(name = "score")
    private int score;
    
    public Like(){
        	
    }   
    public Like(LikePK iD_like, boolean play, String review, int score) {
    	super();
    	ID_like = iD_like;
    	this.play = play;
    	this.review = review;
    	this.score = score;
    }
    	
	public LikePK getID_like() {
		return ID_like;
	}

	public void setID_like(LikePK iD_like) {
		ID_like = iD_like;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}   
}
