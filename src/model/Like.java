package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@TableGenerator(name="likeGen",pkColumnName="key",pkColumnValue="ID_like",initialValue=0,table="counters",valueColumnName="value")
@Table(name="LIKE_")
public class Like implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@Id @Column(name="ID_like")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="likeGen") 
    private long ID_like;
	
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Game game;
    
    @Column(name = "play")
    private boolean play;
    
    @Column(name = "review", columnDefinition = "TEXT")
    private String review;
    
    @Column(name = "score")
    private int score;
    
    public Like(){    	
    }
    	
	public Like(User user, Game game, boolean play, String review, int score) {
		super();
		this.user = user;
		this.game = game;
		this.play = play;
		this.review = review;
		this.score = score;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public long getID_like() {
		return ID_like;
	}

	public void setID_like(long iD_like) {
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
