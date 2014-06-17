package test;

import java.util.Map;

import javax.persistence.EntityManager;

import model.Game;
import model.User;

import org.apache.struts2.StrutsTestCase;

import service.AcceptLockService;
import service.GameService;
import service.UserService;
import util.EntityManagerUtil;
import util.Populator;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class AcceptGameActionTest extends StrutsTestCase{
	
	EntityManager em = EntityManagerUtil.getEntityManager();
	Game g;
	GameService gs = new GameService();
	UserService us = new UserService();
	User u;
	Map<String,Object> s = null;
	AcceptLockService als = new AcceptLockService();
			
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.delete();
		pop.popolate();
		request.setParameter("gameName","Counter-Strike");
    	u = us.findByEmail("gina@gmail.com", em);
    	
	}
	
	public void testAlreadyAccepted() throws Exception {
    	
    	ActionProxy proxy = getActionProxy("/acceptGame");
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);

    	als.saveLock(u, gs.findByName("Counter-Strike", em), em);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been lock","lock", result );
        
    }
	
	public void testNotAccepted() throws Exception {
    	
    	ActionProxy proxy = getActionProxy("/acceptGame");
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been success","success", result );
        assertEquals("Query result should have been 1",1, gs.findByName("Counter-Strike", em).getAcceptCount() );

        
    }
	
	public void testPublishing() throws Exception {
    	
    	ActionProxy proxy = getActionProxy("/acceptGame");
    	
    	g = gs.findByName("Counter-Strike", em);
    	g.setAcceptCount(2);
    	gs.update(g, em);
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);

    	String result = proxy.execute();
        
    	em.clear();
    	
        assertEquals("Result returned from executing the action should have been published","published", result );
        assertEquals("Query result should have been 3",3, gs.findByName("Counter-Strike", em).getAcceptCount() );
        assertEquals("Query result should have been true",true, gs.findByName("Counter-Strike", em).isPublished() );
        
    }
	
	public void testAlreadyPublished() throws Exception {
    	
    	ActionProxy proxy = getActionProxy("/acceptGame");
    	
    	g = gs.findByName("Counter-Strike", em);
    	g.setPublished(true);
    	gs.update(g, em);
    	
    	Map<String,Object> attributes = ActionContext.getContext().getSession();
    	attributes.put("loggedInUser", u);

    	String result = proxy.execute();
    	
        assertEquals("Result returned from executing the action should have been alreadyPublished","alreadyPublished", result );
        
    }
}