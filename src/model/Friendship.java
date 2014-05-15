package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="FRIENDSHIP_")
public class Friendship implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private LikePK ID_friendship;
    
    @Column(name = "accepted")
    private boolean accepted;

	public LikePK getID_friendship() {
		return ID_friendship;
	}

	public void setID_friendship(LikePK iD_friendship) {
		ID_friendship = iD_friendship;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
 
}
