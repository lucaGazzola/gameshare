package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.NormalUser;
import model.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import util.EntityManagerUtil;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterUserAction extends ActionSupport implements ServletRequestAware {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	User u;
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	private String firstname;
	private String lastname;
	private String hometown;
	private String birthdate;
	private String residence;
	private String email;
	private String password;
	private char gender;
	private String job;
	private String school;
	private Pattern pattern;
	private Matcher matcher;
    private File userImage;
    private String userImageFileName;
    private String imagePath;
    private HttpServletRequest servletRequest;    
	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	private boolean containsIllegals(String toExamine) {
	    Pattern pattern = Pattern.compile("[~#*+%{}<>\\[\\]|\"\\_^]");
	    Matcher matcher = pattern.matcher(toExamine);
	    return matcher.find();
	}
	
	private boolean checkIllegalFields(){
		if(this.containsIllegals(firstname) || this.containsIllegals(email) || this.containsIllegals(lastname) || this.containsIllegals(job) || this.containsIllegals(school) || this.containsIllegals(hometown) || this.containsIllegals(residence) || this.containsIllegals(birthdate) || this.containsIllegals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean validate(String mail) {
		 
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(mail);
		return matcher.matches();
 
	}
	


	//Default method invoked by STRUTS2
	public String execute() {
		
		String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
		
		if(this.checkIllegalFields()){
			addActionError(getText("error.invalidCharactersError"));
			return "invalidCharactersError";
		}
		
		if(password.length() < 5){
			addActionError(getText("error.passwordTooShort"));
			return "passwordTooShort";
		}
		
		if(!this.validate(email)){
			addActionError(getText("error.invalidEmailAddress"));
			return "invalidEmailAddress";
		}
		
		if(!birthdate.matches(datePattern)){
			addActionError(getText("error.invalidDateFormat"));
			return "invalidDateFormat";
		}
		
		if (!(gender == 'M') && !(gender == 'F')){
			addActionError(getText("error.missingGender"));
			return "missingGender";
		}
		
		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)em.createQuery("SELECT p FROM NormalUser p where p.email = :value").setParameter("value", email).getResultList();
		if(results.isEmpty()){

			//date construction
			DateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
			Date date = null;
			try {
				date = formatter.parse(birthdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String encodedPassword = DigestUtils.md5Hex(password) ;
			
			//user object creation
			u = new NormalUser(email, encodedPassword, date, firstname, lastname, gender, job, residence, school, hometown);
			
			//persist user
			em.persist(u);
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			
			//aggiungo messaggio di successo
			addActionMessage("You are now registered in GameShare, login with your credentials! Enjoy, play and share!");

			// salvo l'immagine 
	        try {
	        	String filePath;
	        	if(imagePath == null)
	        		filePath = servletRequest.getSession().getServletContext().getRealPath("/");
	        	else
	        		filePath = imagePath;
	            File fileToCreate = new File(filePath + "images\\profile_images\\", u.getID_user()+"-profile.jpg");
	            FileUtils.copyFile(this.userImage, fileToCreate);
	            return "success";
	            
	        } catch (Exception e) {
	            addActionError("Missing profile picture");
	            return "errorPictureMissing";
	        }
		}else{
			addActionError(getText("error.userRegistered"));
			return "errorDuplicate";
		}

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.servletRequest = arg0;
	}

	public File getUserImage() {
		return userImage;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
