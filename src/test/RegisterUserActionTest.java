package test;

import java.util.Date;



import actions.*;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class RegisterUserActionTest extends StrutsTestCase{
	
	public void testFieldErrorMessage() throws Exception {
		
		Date now = new Date();
		
    	request.setParameter("email", "");
    	request.setParameter("password", "frenk");
    	request.setParameter("firstname", "test");
    	request.setParameter("lastname", "test");
    	request.setParameter("gender", "f");
    	request.setParameter("job", "test");
    	request.setParameter("hometown", "test");
    	request.setParameter("school", "test");
    	request.setParameter("residence", "test");
    	//request.setParameter("birthdate","1111/22/22");   
    	
    	
    	ActionProxy proxy = getActionProxy("/register");

    	RegisterUserAction action = (RegisterUserAction) proxy.getAction();
    	
    	action.setBirthdate(now);

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been errorField", "errorField", result);
        
        //assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", action.getFieldErrors().size() == 1);
		//assertTrue("Problem field email not present in fieldErrors but it should have been", action.getFieldErrors().containsKey("email") );

    }

    public void testRegisterCorrect() throws Exception {
    	
		Date now = new Date();
    	
    	request.setParameter("email", "Bruc");
    	request.setParameter("password", "test");
    	request.setParameter("firstname", "test");
    	request.setParameter("lastname", "test");
    	request.setParameter("gender", "f");
    	request.setParameter("job", "test");
    	request.setParameter("hometown", "test");
    	request.setParameter("school", "test");
    	request.setParameter("residence", "test");
    	//request.setParameter("birthdate","1111/22/22");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	RegisterUserAction action = (RegisterUserAction) proxy.getAction();
    	
    	action.setBirthdate(now);

        String result = proxy.execute();

        //assertTrue("Problem There were errors present in fieldErrors but there should not have been any errors present", action.getFieldErrors().size() == 0);
        assertEquals("Result returned form executing the action was not success but it should have been.", "success", result);

    }

}
