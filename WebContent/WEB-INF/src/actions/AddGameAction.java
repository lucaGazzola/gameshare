package actions;


import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import util.EntityManagerUtil;

public class AddGameAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	Game g;
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private enum games {VIDEOGAME,CARD,SPORT,BOARD};

	private String description;
	private String name;
	private games gameType;
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


	public games getGameType() {
		return gameType;
	}


	public void setGameType(games gameType) {
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
			switch(gameType){
			case VIDEOGAME:
				g = new Videogame(name,description,priceRange, online, videogameType);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			case CARD:
				g = new CardGame(name, description, priceRange, duration, requiredPlayers, suggestedPlayers, deck);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			case SPORT:
				g = new Sport(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			case BOARD:
				g = new BoardGame(name, description, priceRange, duration, requiredPlayers, suggestedPlayers);
			
				em.persist(g);
				em.getTransaction().begin();
				em.getTransaction().commit();
			break;
			}
			return "success";
		}else{
			addActionError(getText("error.missingField"));
			return "errorField";
		}	
	}	
}