package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@TableGenerator(name="AcceptLockGen",pkColumnName="key",pkColumnValue="ID_AcceptLock",initialValue=0,table="counters",valueColumnName="value")
@Table(name="LOCK_")
public class AcceptLock implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@Id @Column(name="ID_AcceptLock")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="AcceptLockGen") 
    private long ID_AcceptLock;
	
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Game game;
    
    public AcceptLock(){    	
    }
    	
	public AcceptLock(User user, Game game) {
		super();
		this.user = user;
		this.game = game;
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

	public long getID_AcceptLock() {
		return ID_AcceptLock;
	}

	public void setID_AcceptLock(long iD_AcceptLock) {
		ID_AcceptLock = iD_AcceptLock;
	}

}