package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@TableGenerator(name="userAffiniytGen",pkColumnName="key",pkColumnValue="ID_userAffinity",initialValue=0,table="counters",valueColumnName="value")
public class UserAffinity implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@Id @Column(name="ID_userAffinity")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userAffinityGen") 
    private long ID_userAffinity;
	
	public UserAffinity() {
		
	}
	
	public UserAffinity(User firstUser, User secondUser, boolean value) {
		super();
		this.firstUser = firstUser;
		this.secondUser = secondUser;
		this.value = value;
	}

	@ManyToOne
    private User firstUser;

	@ManyToOne
    private User secondUser;
    
    @Column(name = "value")
    private boolean value;

	public User getFirstUser() {
		return firstUser;
	}

	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
	}

	public User getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

   
}
