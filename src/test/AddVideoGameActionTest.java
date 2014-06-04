package test;



import javax.persistence.EntityManager;

import model.Game;
import model.Platform;
import model.Videogame;




import org.apache.struts2.StrutsTestCase;

import service.GameService;
import service.PlatformService;
import util.EntityManagerUtil;
import util.Populator;

import com.opensymphony.xwork2.ActionProxy;

public class AddVideoGameActionTest extends StrutsTestCase{
	
	EntityManager em = EntityManagerUtil.getEntityManager();
	GameService gs = new GameService();
	PlatformService ps = new PlatformService();
	
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.popolate();
        gs.removeByName("World of Warcraft",em);
        request.setParameter("gameType","videogame");
        request.setParameter("name","World of Warcraft");
    	request.setParameter("description", "very good");
    	request.setParameter("priceRange", "30-40");
    	request.setParameter("videogameType", "mmorpg");
    	request.setParameter("PC", "true");
    	
	}
	
	public void testAlreadyInDatabase() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("name", "Counter-Strike");
    	
    	ActionProxy proxy = getActionProxy("/addGame");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been errorDuplicate", "duplicate", result);
        Game g = gs.findByName("Counter-Strike",em);
        assertEquals("query result should have been franco@franco.net but it wasn't",g.getName(),"Counter-Strike");
        
    }
	
	public void testEmptyName() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("name", "");
    	
    	ActionProxy proxy = getActionProxy("/addGame");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
        
    }

	public void testPriceRangeBadFormat() throws Exception {
	
		request.setParameter("online", "true");
		request.setParameter("priceRange", "11");
	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been invalidPriceRange", "invalidPriceRange", result);
    
	}
	
	public void testOnlineNotSelected() throws Exception {
	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been missingOnlineField", "missingOnlineField", result);
    
	}
	
	public void testEmptyPriceRange() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("priceRange", "");
		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
    
	}
	
	public void testEmptyDescription() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("description", "");
		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
        Game g = gs.findByName("World of Warcraft",em);
        assertEquals("query result should have been World of Warcraft but it wasn't",g.getName(),"World of Warcraft");
    
	}
	
	public void testNoPlatformsSelected() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("PC", "false");
		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
        Game g = gs.findByName("World of Warcraft",em);
        assertEquals("query result should have been World of Warcraft but it wasn't",g.getName(),"World of Warcraft");
        assertEquals("there should have been no platforms linked to this game",((Videogame) g).getPlatforms().isEmpty(),true);

    
	}
	
	public void testOnePlatformSelected() throws Exception {
		
		request.setParameter("online", "true");
		
		Platform pc;
		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
        Game g = gs.findByName("World of Warcraft",em);
        assertEquals("query result should have been World of Warcraft but it wasn't",g.getName(),"World of Warcraft");
        pc = ps.findByName("PC",em);
        assertEquals("PC should have been selected as platform for this game",((Videogame) g).getPlatforms().contains(pc),true);

	}
	
	public void testMorePlatformSelected() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("PC", "false");
		request.setParameter("XBox", "true");
		request.setParameter("Wii", "true");
		
		Platform xbox;
		Platform wii;
		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
        Game g = gs.findByName("World of Warcraft",em);
        assertEquals("query result should have been World of Warcraft but it wasn't",g.getName(),"World of Warcraft");
        wii = ps.findByName("Wii",em);
        xbox = ps.findByName("XBox",em);
        assertEquals("Xbox should have been selected as platform for this game",((Videogame) g).getPlatforms().contains(xbox),true);
        assertEquals("Wii should have been selected as platform for this game",((Videogame) g).getPlatforms().contains(wii),true);
        
	}
	
	public void testNoTypeSelected() throws Exception {
		
		request.setParameter("online", "true");
		request.setParameter("videogameType", "");
		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
        Game g = gs.findByName("World of Warcraft",em);
        assertEquals("query result should have been World of Warcraft but it wasn't",g.getName(),"World of Warcraft");
        
	}
	
}