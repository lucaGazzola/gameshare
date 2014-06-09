package test;





import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;







import model.Like;
import model.User;






import org.apache.struts2.StrutsTestCase;
import org.springframework.mock.web.MockHttpSession;

import service.GameService;
import service.LikeService;
import service.UserService;
import util.EntityManagerUtil;
import util.Populator;
import actions.VoteAction;

import com.opensymphony.xwork2.ActionProxy;

public class VoteGameActionTest extends StrutsTestCase{
	
	EntityManager em = EntityManagerUtil.getEntityManager();
	GameService gs = new GameService();
	UserService us = new UserService();
	LikeService ls = new LikeService();
	User u = us.findByEmail("gina@gmail.com", em);
	Map<String,Object> s = null;
	
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.popolate();
        request.setParameter("id_game","1");
    	request.setParameter("isPlay", "1"); 	
    	//request.getSession().setAttribute("loggedInUser", u);
    	s = new HashMap<String,Object>();
    	s.put("loggedInUser", u);
    	
	}
	
	public void testAlreadyVoted() throws Exception {
		
		request.setParameter("vote","4");
    	
    	ActionProxy proxy = getActionProxy("/voteGame");
    	
    	VoteAction action = (VoteAction) proxy.getAction();
    	action.setSession(s);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been success", "success", result);
        Like l = ls.findLike(((User) request.getSession().getAttribute("loggedInUser")).getID_user(), Integer.parseInt(request.getParameter("id_game")), em);
        assertEquals("query result should have been Counter-Strike but it wasn't",l.getScore(),4);
        
    }
	
}