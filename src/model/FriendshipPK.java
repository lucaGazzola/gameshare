package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FriendshipPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Column(name = "ID_sourceUser", nullable = false)
    private long ID_sourceUser;

	@ManyToOne
	@Column(name = "ID_targetUser", nullable = false)
    private long ID_targetUser;
	
	public FriendshipPK(){}
	
	// costruttore
	public FriendshipPK(long ID_sourceUser, long ID_targetUser){
		this.ID_targetUser = ID_targetUser;
		this.ID_sourceUser = ID_sourceUser;
	};
	
	// override equals
	public boolean equals(Object object) {
        if (object instanceof FriendshipPK) {
        	FriendshipPK pk = (FriendshipPK) object;
        	return this.ID_sourceUser == pk.ID_sourceUser && this.ID_targetUser == pk.ID_targetUser;
        }
        else return false;
	};
	
	// override hashcode
	public int hashCode() {
        return (int)this.ID_sourceUser + (int)this.ID_targetUser;
    }

	public long getID_sourceUser() {
		return ID_sourceUser;
	}

	public void setID_sourceUser(long iD_sourceUser) {
		ID_sourceUser = iD_sourceUser;
	}

	public long getID_targetUser() {
		return ID_targetUser;
	}

	public void setID_targetUser(long iD_targetUser) {
		ID_targetUser = iD_targetUser;
	}
	
	
}

