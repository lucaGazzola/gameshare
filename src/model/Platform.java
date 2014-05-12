package model;

import java.util.Collection;

import javax.persistence.*;

@Entity(name="Contact") 
@TableGenerator(name="platformGen",pkColumnName="key",pkColumnValue="ID_platform",initialValue=0,table="counters",valueColumnName="value")
public class Platform {
	
	@Column(name="name")
	private String name;

	@Id @Column(name="ID_platform")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="platformGen") 
	private long ID_platform;
	
	@ManyToMany(mappedBy="platforms")
	private Collection<Game> games;
	
	public Platform() {}
	
	public Platform(String name) {
		this.name = name;
	}

	public long getID_platform() {
		return ID_platform;
	}

	public void setID_platform(long iD_platform) {
		ID_platform = iD_platform;
	}
	
	public Collection<Game> getGames() {
		return games;
	}

	public void setGames(Collection<Game> games) {
		this.games = games;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
