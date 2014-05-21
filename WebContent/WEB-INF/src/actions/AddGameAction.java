package actions;


import java.util.Hashtable;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import service.GameService;
import util.EntityManagerUtil;

public class AddGameAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	GameService gs = new GameService();
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private String description;
	private String name;
	private String gameType;
	private String priceRange;
	
	//Videogame attributes
	private boolean online;
	private String videogameType;
	
	//Classic Game attributes
	private int duration;
	private int suggestedPlayers;
	private int requiredPlayers;
	
	//Card Game attributes
	private String deck;
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getGameType() {
		return gameType;
	}


	public void setGameType(String gameType) {
		this.gameType = gameType;
	}


	public String getPriceRange() {
		return priceRange;
	}


	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}


	public boolean isOnline() {
		return online;
	}


	public void setOnline(boolean online) {
		this.online = online;
	}


	public String getVideogameType() {
		return videogameType;
	}


	public void setVideogameType(String videogameType) {
		this.videogameType = videogameType;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getSuggestedPlayers() {
		return suggestedPlayers;
	}


	public void setSuggestedPlayers(int suggestedPlayers) {
		this.suggestedPlayers = suggestedPlayers;
	}


	public int getRequiredPlayers() {
		return requiredPlayers;
	}


	public void setRequiredPlayers(int requiredPlayers) {
		this.requiredPlayers = requiredPlayers;
	}


	public String getDeck() {
		return deck;
	}


	public void setDeck(String deck) {
		this.deck = deck;
	}


	//Default method invoked by STRUTS2
	public String execute() {

		if (!name.equals("")){
			
			Game g = null;
			
			switch(gameType){
			case "videogame":
				g = new Videogame(name,description,priceRange, online, videogameType);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			case "card":
				g = new CardGame(name, description, priceRange, duration, requiredPlayers, suggestedPlayers, deck);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			case "sport":
				g = new Sport(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			case "board":
				g = new BoardGame(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			}
			
			gs.save(g, em);
			
			return "success";
			
			
		}else{
			addActionError(getText("error.missingField"));
			return "errorField";
		}	
	}	
}