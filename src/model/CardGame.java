package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CG")
@Table(name="CARD_GAME")
public class CardGame extends ClassicGame {
	
	@Column(name="deck")
	private String deck;
	
	public CardGame() {}
	
	public CardGame(String name, String description, String priceRange, int duration, int requiredPlayers, int suggestedPlayers, String deck) {
		super(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);
		this.deck = deck;
	}

	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}
	
	public String toString(){
		return super.toString()+" "+deck;
	}
	

	
}