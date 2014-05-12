package model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@DiscriminatorValue("V")
@Table(name="VIDEOGAME")
public class Videogame extends Game {
	
	@Column(name="online")
	private boolean online;
	
	@Column(name="type")
	private String type;
	
	@ManyToMany
	private Collection<Platform> platforms;
	
	public Videogame() {}
	
	public Videogame(String name, String description, String priceRange, int duration, int requiredPlayers, int suggestedPlayers, boolean online, String type) {
		super(name, description, priceRange);
		this.online = online;
		this.type = type;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(Collection<Platform> platforms) {
		this.platforms = platforms;
	}
	
}