package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="CLASSIC_GAME_TYPE")
@Table(name="CLASSIC_GAME")
public class ClassicGame extends Game{

	@Column(name="duration")
	private int duration;
	
	@Column(name="requiredPlayers")
	private int requiredPlayers;
	
	@Column(name="suggestedPlayers")
	private int suggestedPlayers;
	
	public ClassicGame() {}
	
	public ClassicGame(String name, String description, String priceRange, int duration, int requiredPlayers, int suggestedPlayers) {
		super(name, description, priceRange);
		this.duration = duration;
		this.requiredPlayers = requiredPlayers;
		this.suggestedPlayers = suggestedPlayers;	
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRequiredPlayers() {
		return requiredPlayers;
	}

	public void setRequiredPlayers(int requiredPlayers) {
		this.requiredPlayers = requiredPlayers;
	}

	public int getSuggestedPlayers() {
		return suggestedPlayers;
	}

	public void setSuggestedPlayers(int suggestedPlayers) {
		this.suggestedPlayers = suggestedPlayers;
	}


		

}
