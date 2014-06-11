package actions;




import java.util.ArrayList;
import java.util.List;
import java.io.File;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import model.*;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import service.GameService;
import service.PlatformService;
import util.EntityManagerUtil;

public class AddGameAction extends ActionSupport implements ServletRequestAware  {

	EntityManager em = EntityManagerUtil.getEntityManager();
	GameService gs = new GameService();
	
    private File gameImage;
    private String gameImageFileName;
    private HttpServletRequest servletRequest;    
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private String description;
	private String name;
	private String gameType;
	private String priceRange;
	
	//Videogame attributes
	private String online;
	private String videogameType;
	private boolean PC;
	private boolean PS;
	private boolean XBox;
	private boolean Wii;
	
	
	//Classic Game attributes
	private String duration;
	private String suggestedPlayers;
	private String requiredPlayers;
	
	//Card Game attributes
	private String deck;
	
	//Default method invoked by STRUTS2
	public String execute() {
		
		int sp, rp, d;
		PlatformService ps = new PlatformService();
		boolean onlineVideogame = false;
		String priceRangePattern = "\\d{1,4}-\\d{1,4}";
		
		if(gameType == null){
			addActionError(getText("error.missingGameType"));
			return "missingGameType";			
		}
			
			
		if (name.equals("") || priceRange.equals("")){
			addActionError(getText("error.missingField"));
			return "errorField";
		}
		
		if(!priceRange.matches(priceRangePattern)){
			addActionError(getText("error.invalidPriceRange"));
			return "invalidPriceRange";
		}
		
		@SuppressWarnings("unchecked")
		List<Game> results = (List<Game>)em.createQuery("SELECT p FROM Game p where p.name = :value").setParameter("value", name).getResultList();
		if(!results.isEmpty()){
			addActionError(getText("error.duplicate"));
			return "duplicate";
		}
			
		Game g = null;
		
		switch(gameType){
		case "videogame":
			
			if(online == null){
				addActionError(getText("error.missingOnlineField"));
				return "missingOnlineField";
			}else if(online.equals("true")){
				onlineVideogame = true;
			}else if(online.equals("false")){
				onlineVideogame = false;
			}
			
			g = new Videogame(name,description,priceRange, onlineVideogame, videogameType);
		
			List<Platform> pl = new ArrayList<Platform>();
						
			if(PC)
				pl.add(ps.findByName("PC", em));
			if(XBox)
				pl.add(ps.findByName("XBox", em));
			if(PS)
				pl.add(ps.findByName("PS", em));
			if(Wii)
				pl.add(ps.findByName("Wii", em));
			
			((Videogame) g).setPlatforms(pl);
			
			
			em.persist(g);
			em.getTransaction().begin();
			em.getTransaction().commit();
		break;
		case "card":
			
			if(suggestedPlayers.equals("") || requiredPlayers.equals("") || duration.equals("") || deck.equals("")){
				addActionError(getText("error.missingField"));
				return "errorField";
			}
				
			
			sp = Integer.parseInt(suggestedPlayers);
			rp = Integer.parseInt(requiredPlayers);
			d = Integer.parseInt(duration);
			
			g = new CardGame(name, description, priceRange, d, rp, sp, deck);
		
			em.persist(g);
			em.getTransaction().begin();
			em.getTransaction().commit();
		break;
		case "sport":
			
			if(suggestedPlayers.equals("") || requiredPlayers.equals("") || duration.equals("")){
				addActionError(getText("error.missingField"));
				return "errorField";
			}
			
			sp = Integer.parseInt(suggestedPlayers);
			rp = Integer.parseInt(requiredPlayers);
			d = Integer.parseInt(duration);
			
			g = new Sport(name, description, priceRange, d, rp, sp);
		
			em.persist(g);
			em.getTransaction().begin();
			em.getTransaction().commit();
		break;
		case "board":
			
			if(suggestedPlayers.equals("") || requiredPlayers.equals("") || duration.equals("")){
				addActionError(getText("error.missingField"));
				return "errorField";
			}
			
			sp = Integer.parseInt(suggestedPlayers);
			rp = Integer.parseInt(requiredPlayers);
			d = Integer.parseInt(duration);
			
			g = new BoardGame(name, description, priceRange, d, rp, sp);
		
			em.persist(g);
			em.getTransaction().begin();
			em.getTransaction().commit();
		break;
		}
		
		gs.save(g, em);
		
		// salvo l'immagine 
        try {
            String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
            File fileToCreate = new File(filePath + "images\\game_images\\", g.getID_game()+"-game.jpg");
            FileUtils.copyFile(this.gameImage, fileToCreate);
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            return "errorField";
        }
		
		return "success";	
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}	

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

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getVideogameType() {
		return videogameType;
	}

	public void setVideogameType(String videogameType) {
		this.videogameType = videogameType;
	}

	public boolean isPC() {
		return PC;
	}

	public void setPC(boolean pC) {
		PC = pC;
	}

	public boolean isPS() {
		return PS;
	}

	public void setPS(boolean pS) {
		PS = pS;
	}

	public boolean isXBox() {
		return XBox;
	}

	public void setXBox(boolean xBox) {
		XBox = xBox;
	}

	public boolean isWii() {
		return Wii;
	}

	public void setWii(boolean wii) {
		Wii = wii;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSuggestedPlayers() {
		return suggestedPlayers;
	}

	public void setSuggestedPlayers(String suggestedPlayers) {
		this.suggestedPlayers = suggestedPlayers;
	}

	public String getRequiredPlayers() {
		return requiredPlayers;
	}

	public void setRequiredPlayers(String requiredPlayers) {
		this.requiredPlayers = requiredPlayers;
	}

	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}


	public File getGameImage() {
		return gameImage;
	}


	public String getGameImageFileName() {
		return gameImageFileName;
	}


	public void setGameImage(File gameImage) {
		this.gameImage = gameImage;
	}


	public void setGameImageFileName(String gameImageFileName) {
		this.gameImageFileName = gameImageFileName;
	}

}