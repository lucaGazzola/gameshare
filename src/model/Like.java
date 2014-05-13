package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="LIKE") 
public class Like {
    @EmbeddedId
    private LikePK ID_like;
    
    @Column(name = "play")
    private boolean play;
    
    @Column(name = "review")
    private String review;
    
    @Column(name = "score")
    private int score;
    
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



// chiave primaria composta da 2 chiavi esterne
@Embeddable
class LikePK {
    @Column(name = "ID_user", nullable = false)
    private long ID_user;

	@Column(name = "ID_game", nullable = false)
    private long ID_game;
	
	// costruttore
	public LikePK(long ID_user, long ID_game){
		this.ID_user = ID_user;
		this.ID_game = ID_game;
	};
	
	// override equals
	public boolean equals(Object object) {
        if (object instanceof LikePK) {
        	LikePK pk = (LikePK)object;
        	return this.ID_game == pk.ID_game && this.ID_user == pk.ID_user;
        }
        else return false;
	};
	
	// override hashcode
	public int hashCode() {
        return (int)this.ID_game + (int)this.ID_user;
    }
	
	// getters and setters
    public long getID_user() {
		return ID_user;
	}

	public void setID_user(int iD_user) {
		ID_user = iD_user;
	}

	public long getID_game() {
		return ID_game;
	}

	public void setID_game(int iD_game) {
		ID_game = iD_game;
	}
}