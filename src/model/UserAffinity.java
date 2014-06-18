package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@TableGenerator(name="userAffiniytGen",pkColumnName="key",pkColumnValue="ID_userAffinity",initialValue=0,table="counters",valueColumnName="value")
public class UserAffinity implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    private NormalUser firstUser;

	@ManyToOne
    private NormalUser secondUser;
    
    @Column(name = "value")
    private double value;

	@Id @Column(name="ID_userAffinity")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="userAffinityGen") 
    private long ID_userAffinity;
	
	public UserAffinity() {
		
	}
	
	public UserAffinity(NormalUser firstUser, NormalUser secondUser, double value) {
		super();
		this.firstUser = firstUser;
		this.secondUser = secondUser;
		this.value = value;
	}

	public NormalUser getFirstUser() {
		return firstUser;
	}

	public void setFirstUser(NormalUser firstUser) {
		this.firstUser = firstUser;
	}

	public NormalUser getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(NormalUser secondUser) {
		this.secondUser = secondUser;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public long getID_userAffinity() {
		return ID_userAffinity;
	}

	public void setID_userAffinity(long iD_userAffinity) {
		ID_userAffinity = iD_userAffinity;
	}
  
}
