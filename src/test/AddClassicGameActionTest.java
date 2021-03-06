package test;

import java.io.File;

import javax.persistence.EntityManager;

import model.Game;





import org.apache.struts2.StrutsTestCase;

import service.GameService;
import service.PlatformService;
import util.EntityManagerUtil;
import util.Populator;
import actions.AddGameAction;

import com.opensymphony.xwork2.ActionProxy;

public class AddClassicGameActionTest extends StrutsTestCase{
	
	EntityManager em = EntityManagerUtil.getEntityManager();
	GameService gs = new GameService();
	PlatformService ps = new PlatformService();
	
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.delete();
		pop.popolate();
        request.setParameter("name","Test");
    	request.setParameter("description", "very good");
    	request.setParameter("priceRange", "30-40");
    	request.setParameter("duration", "30");
    	request.setParameter("suggestedPlayers", "4");
    	request.setParameter("requiredPlayers", "2");
    	
	}
	
	public void testEmptyGameType() throws Exception {
		
    	ActionProxy proxy = getActionProxy("/addGame");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been missingGameType", "missingGameType", result);
        
    }
	
	public void testCardGameAlreadyPresent() throws Exception {
		
		request.setParameter("gameType", "card");
		request.setParameter("name", "Scopa");
    	
    	ActionProxy proxy = getActionProxy("/addGame");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been duplicate", "duplicate", result);
        Game g = gs.findByName("Scopa",em);
        assertEquals("query result should have been Scopa but it wasn't",g.getName(),"Scopa");
        
    }

	public void testCardGameEverythingCorrect() throws Exception {
	
		String path = getClass().getClassLoader().getResource(".").getPath();
        File gameImage = new File(path+"\\..\\..\\WebContent\\images\\test.jpg");

		request.setParameter("imagePath",path+"..\\..\\WebContent\\");
		request.setParameter("gameType", "card");
		request.setParameter("deck","hearthstone");
		
		System.out.println(path);
		
		ActionProxy proxy = getActionProxy("/addGame");
		AddGameAction action = (AddGameAction) proxy.getAction() ;
		action.setGameImage(gameImage);

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
		Game g = gs.findByName("Test",em);
	    assertEquals("query result should have been Test but it wasn't",g.getName(),"Test");
    
	}
	
	public void testCardGameInvalidCharacters() throws Exception {
		
		request.setParameter("name","Test[]#");
		request.setParameter("gameType", "card");
		request.setParameter("deck","hearthstone");
	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been invalidCharactersError", "invalidCharactersError", result);
    
	}
	
	public void testNumericFields() throws Exception {
		
		request.setParameter("suggestedPlayers", "asdd");
		request.setParameter("gameType", "card");
		request.setParameter("deck","hearthstone");
	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been notNumbers", "notNumbers", result);
    
	}
	
	public void testCardGameEmptyDurationField() throws Exception {
		
		request.setParameter("gameType", "card");
		request.setParameter("duration", "");
		request.setParameter("deck", "hearthstone");

	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
    
	}
	
	public void testCardGameEmptySuggestedPlayersField() throws Exception {
		
		request.setParameter("gameType", "card");
		request.setParameter("suggestedPlayers", "");
		request.setParameter("deck","hearthstone");
	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
    
	}
	
	public void testCardGameEmptyRequiredPlayersField() throws Exception {
		
		request.setParameter("gameType", "card");
		request.setParameter("requiredPlayers", "");
		request.setParameter("deck", "hearthstone");

		
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
    
	}
	
	public void testCardGameEmptyDeckField() throws Exception {
		
		request.setParameter("gameType", "card");
		request.setParameter("deck", "");
	
		ActionProxy proxy = getActionProxy("/addGame");

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
    
	}
	
public void testBoardGameAlreadyPresent() throws Exception {
		
		request.setParameter("gameType", "board");
		request.setParameter("name", "Monopoly");
    	
    	ActionProxy proxy = getActionProxy("/addGame");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been duplicate", "duplicate", result);
        Game g = gs.findByName("Monopoly",em);
        assertEquals("query result should have been Monopoly but it wasn't",g.getName(),"Monopoly");
        
    }

	public void testBoardGameEverythingCorrect() throws Exception {
	
		String path = getClass().getClassLoader().getResource(".").getPath();
        File gameImage = new File(path+"\\..\\..\\WebContent\\images\\test.jpg");

		request.setParameter("imagePath",path+"..\\..\\WebContent\\");
		request.setParameter("gameType", "board");
	
		ActionProxy proxy = getActionProxy("/addGame");
		AddGameAction action = (AddGameAction) proxy.getAction() ;
		action.setGameImage(gameImage);

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
		Game g = gs.findByName("Test",em);
	    assertEquals("query result should have been Test but it wasn't",g.getName(),"Test");
    
	}
	
	public void testSportAlreadyPresent() throws Exception {
		
		request.setParameter("gameType", "sport");
		request.setParameter("name", "Tennis");
    	
    	ActionProxy proxy = getActionProxy("/addGame");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been duplicate", "duplicate", result);
        Game g = gs.findByName("Tennis",em);
        assertEquals("query result should have been Tennis but it wasn't",g.getName(),"Tennis");
        
    }

	public void testSportEverythingCorrect() throws Exception {
	
		String path = getClass().getClassLoader().getResource(".").getPath();
        File gameImage = new File(path+"\\..\\..\\WebContent\\images\\test.jpg");

		request.setParameter("imagePath",path+"..\\..\\WebContent\\");
		request.setParameter("gameType", "sport");
	
		ActionProxy proxy = getActionProxy("/addGame");
		AddGameAction action = (AddGameAction) proxy.getAction() ;
		action.setGameImage(gameImage);

		String result = proxy.execute();
    
		assertEquals("Result returned from executing the action should have been success", "success", result);
		Game g = gs.findByName("Test",em);
	    assertEquals("query result should have been Test but it wasn't",g.getName(),"Test");
    
	}
	
}