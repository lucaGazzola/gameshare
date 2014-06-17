package test;



import java.io.File;

import javax.persistence.EntityManager;

import model.User;

import org.apache.struts2.StrutsTestCase;

import service.UserService;
import util.EntityManagerUtil;
import util.Populator;
import actions.RegisterUserAction;

import com.opensymphony.xwork2.ActionProxy;

public class RegisterUserActionTest extends StrutsTestCase{
	
	EntityManager em = EntityManagerUtil.getEntityManager();
	UserService us = new UserService();
	
	public void setUp() throws Exception{
		super.setUp();
		Populator pop = new Populator();
		pop.delete();
		pop.popolate();
    	request.setParameter("email", "franco@franchi.net");
    	request.setParameter("password", "frenko");
    	request.setParameter("firstname", "test");
    	request.setParameter("lastname", "test");
    	request.setParameter("gender", "M");
    	request.setParameter("job", "test");
    	request.setParameter("hometown", "test");
    	request.setParameter("school", "test");
    	request.setParameter("residence", "test");
    	request.setParameter("birthdate","11-11-1111"); 
	}
	
	public void testAlreadyInDatabase() throws Exception {
		
		request.setParameter("email", "franco@franco.net");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been errorDuplicate", "errorDuplicate", result);
        User u = us.findByEmail("franco@franco.net",em);
        assertEquals("query result should have been franco@franco.net but it wasn't",u.getEmail(),"franco@franco.net");
        
    }
	
	public void testPasswordTooShort() throws Exception {
		
		request.setParameter("password", "fren");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been passwordTooShort", "passwordTooShort", result);
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testEmptyPasswordField() throws Exception {
		
		request.setParameter("password", "");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been passwordTooShort", "passwordTooShort", result);
  
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testEmptyEmailField() throws Exception {
		
		request.setParameter("email", "");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been invalidEmailAddress", "invalidEmailAddress", result);
  
        User u = us.findByEmail("",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testEmptyBirthdateField() throws Exception {
		
		request.setParameter("birthdate", "");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been invalidDateFormat", "invalidDateFormat", result);
  
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testGenderNotSelected() throws Exception {
		
		request.setParameter("gender", "");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been missingGender", "missingGender", result);
  
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testEmptyOptionalFields() throws Exception {
		String path = getClass().getClassLoader().getResource(".").getPath();
        File userImage = new File(path+"\\..\\..\\WebContent\\images\\test.jpg");

		request.setParameter("imagePath",path+"..\\..\\WebContent\\");
    	request.setParameter("firstname", "");
    	request.setParameter("lastname", "");
    	request.setParameter("job", "");
    	request.setParameter("hometown", "");
    	request.setParameter("school", "");
    	request.setParameter("residence", "");
    	
    	ActionProxy proxy = getActionProxy("/register");
    	RegisterUserAction action = (RegisterUserAction) proxy.getAction() ;
		action.setUserImage(userImage);
    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been success", "success", result);
  
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been franco@franchi.net but it wasn't",u.getEmail(),"franco@franchi.net");
	}
	
	public void testEverythingCorrect() throws Exception {
		String path = getClass().getClassLoader().getResource(".").getPath();
        File userImage = new File(path+"\\..\\..\\WebContent\\images\\test.jpg");

		request.setParameter("imagePath",path+"..\\..\\WebContent\\");    	
    	ActionProxy proxy = getActionProxy("/register");
    	RegisterUserAction action = (RegisterUserAction) proxy.getAction() ;
		action.setUserImage(userImage);
    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been success", "success", result);
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been franco@franchi.net but it wasn't",u.getEmail(),"franco@franchi.net");
    }
	
	public void testBirthdateBadFormat() throws Exception {
		
		request.setParameter("birthdate", "11-11-11");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been invalidDateFormat", "invalidDateFormat", result);
        User u = us.findByEmail("franco@franchi.net",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testInvalidCharactersMandatory() throws Exception {
		
		request.setParameter("email", "franco@frenko.com{");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been invalidCharactersError", "invalidCharactersError", result);
  
        User u = us.findByEmail("franco@frenko.com{",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testInvalidCharactersOptional() throws Exception {
		
		request.setParameter("job", "test}");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been invalidCharactersError", "invalidCharactersError", result);
  
        User u = us.findByEmail("franco@franchi",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
	public void testBadEmailFormat() throws Exception {
		
		request.setParameter("email", "luca@luca");
    	
    	ActionProxy proxy = getActionProxy("/register");

    	String result = proxy.execute();
        
        assertEquals("Result returned from executing the action should have been invalidEmailAddress", "invalidEmailAddress", result);
  
        User u = us.findByEmail("luca@luca",em);
        assertEquals("query result should have been empty but it wasn't",null,u);
    }
	
}
