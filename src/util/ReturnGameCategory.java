package util;

import model.Game;

// this method returns a nice formatted game category given the game.
public class ReturnGameCategory {
	private String category;
	
	public String gameCategory(Game game){
		
		switch(game.getDescription()){
			case "model.CardGame": category = "Classic Game / Card Game"; break;
			case "model.BoardGame": category = "Classic Game / Board Game"; break;
			case "model.Sport": category = "Classic Game / Sport"; break;
			case "model.Videogame": category = "Videogame"; break;	
		}
		return category;
	}
}
