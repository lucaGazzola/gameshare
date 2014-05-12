package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("B")
@Table(name="BOARD_GAME")
public class BoardGame extends ClassicGame {
	
	public BoardGame() {}
	
	public BoardGame(String name, String description, String priceRange, int duration, int requiredPlayers, int suggestedPlayers) {
		super(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);	
	}

}