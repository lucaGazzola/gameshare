package test;

import java.util.Map;

import javax.persistence.EntityManager;

import model.Game;
import model.Like;
import model.User;

import org.apache.struts2.StrutsTestCase;

import service.GameService;
import service.LikeService;
import service.UserService;
import util.EntityManagerUtil;
import util.Populator;
import actions.VoteAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class VoteGameActionTest extends StrutsTestCase{
	
	EntityManager em = EntityManagerUtil.getEntityManager();
	Game g;
	GameService gs = new GameService();
	UserService us = new UserService();
	LikeService ls = new LikeService();
	User u;
	Map<String,Object> s = null;
	
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.popolate();
    	request.setParameter("isPlay", "1"); 	
    	u = us.findByEmail("gina@gmail.com", em);
    	
	}
	
	public void testAlreadyVoted() throws Exception {
		
		request.setParameter("vote","4");
    	
    	ActionProxy proxy = getActionProxy("/voteGame");
    	
    	Game g = gs.findByName("Briscola", em);
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);
    	
    	VoteAction action = (VoteAction) proxy.getAction() ;
    	action.setGame(g);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been success", "success", result);
        
        Like l = ls.findLike(u.getID_user(), g.getID_game(), em);
        assertEquals("query result should have been 4 but it wasn't",l.getScore(),4);
        
    }
	
	public void testNotVoted() throws Exception {
		
		request.setParameter("vote","4");
		
    	ActionProxy proxy = getActionProxy("/voteGame");
    	
    	Game g = gs.findByName("Tennis", em);
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);
    	
    	VoteAction action = (VoteAction) proxy.getAction() ;
    	action.setGame(g);


    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been success", "success", result);
        
        Like l = ls.findLike(u.getID_user(), g.getID_game(), em);
        assertEquals("query result should have been 4 but it wasn't",l.getScore(),4);
        
    }
	
	public void testScoreNotSelected() throws Exception {
		
		request.setParameter("vote","");
		
    	ActionProxy proxy = getActionProxy("/voteGame");
    	
    	Game g = gs.findByName("Tennis", em);
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);
    	
    	VoteAction action = (VoteAction) proxy.getAction() ;
    	action.setGame(g);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been missingField", "missingField", result);
        
    }
	
	public void testNotPlayed() throws Exception {
		
		request.setParameter("vote","4");
		request.setParameter("isPlay", "0"); 
		
    	ActionProxy proxy = getActionProxy("/voteGame");
    	
    	Game g = gs.findByName("briscola", em);
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);
    	
    	VoteAction action = (VoteAction) proxy.getAction() ;
    	action.setGame(g);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been notPlayed", "notPlayed", result);
        
    }
	
}