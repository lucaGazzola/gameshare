package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LikePK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_user", nullable = false)
    private long ID_user;

	@Column(name = "ID_game", nullable = false)
    private long ID_game;
	
	public LikePK(){}
	
	// costruttore
	public LikePK(long ID_user, long ID_game){
		this.ID_user = ID_user;
		this.ID_game = ID_game;
	};
	
	// override equals
	public boolean equals(Object object) {
        if (object instanceof LikePK) {
        	LikePK pk = (LikePK) object;
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

