package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@TableGenerator(name="friendshipGen",pkColumnName="key",pkColumnValue="ID_friendship",initialValue=0,table="counters",valueColumnName="value")
@Table(name="FRIENDSHIP_")
public class UserSimilarity implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@Id @Column(name="ID_friendship")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="friendshipGen") 
    private long ID_friendship;
	
	
	@ManyToOne
    private User sourceUser;

	@ManyToOne
    private User targetUser;
    
    @Column(name = "value")
    private int value;

    public UserSimilarity(){}
    
	public UserSimilarity(User sourceUser, User targetUser, boolean accepted) {
		super();
		this.sourceUser = sourceUser;
		this.targetUser = targetUser;
		this.value = value;
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public long getID_friendship() {
		return ID_friendship;
	}

	public void setID_friendship(long iD_friendship) {
		ID_friendship = iD_friendship;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

 
}
