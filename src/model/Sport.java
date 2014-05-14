package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SP")
@Table(name="SPORT")
public class Sport extends ClassicGame {
	
	public Sport() {}
	
	public Sport(String name, String description, String priceRange, int duration, int requiredPlayers, int suggestedPlayers) {
		super(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);	
	}

}