package test;

import java.util.HashMap;
import java.util.Map;

import model.User;

import org.apache.struts2.StrutsTestCase;

import util.Populator;
import actions.LoginAction;

import com.opensymphony.xwork2.ActionProxy;


public class LoginActionTest extends StrutsTestCase{

	
	
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.popolate();
	}
	
	public void testFieldErrorMessage() throws Exception {
    	  	
    	ActionProxy proxy = getActionProxy("/login");
    	
    	LoginAction action = (LoginAction) proxy.getAction();
    	
    	action.setEmail("dwa");
    	action.setPassword("");
    	
    	String result = action.login();
        
        assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
        
        //assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", action.getFieldErrors().size() == 1);
		//assertTrue("Problem field email not present in fieldErrors but it should have been", action.getFieldErrors().containsKey("email") );

    }

    public void testLoginCorrect() throws Exception {
    	
    	Map<String,Object> sessionMock = new HashMap<String,Object>();
    	
    	ActionProxy proxy = getActionProxy("/login");
    	
    	LoginAction action = (LoginAction) proxy.getAction();
    	
    	action.setEmail("franco@franco.net");
    	action.setPassword("prolol");
    	action.setSession(sessionMock);
    	
    	String result = action.login();
    	User u = (User)sessionMock.get("loggedInUser");
    	String email = u.getEmail();

        //assertTrue("Problem There were errors present in fieldErrors but there should not have been any errors present", action.getFieldErrors().size() == 0);
        assertEquals("Result returned form executing the action was not success but it should have been.", "success", result);
        assertEquals("Email in session should have been franco@franco.net", "franco@franco.net", email);

    }

}
