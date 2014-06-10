package actions;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import javax.persistence.*;

import service.PlatformService;
import util.EntityManagerUtil;

public class AddGamePageAction extends ActionSupport {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	PlatformService ps = new PlatformService();
	
	List<Platform> pl = null;
	
	private static final long serialVersionUID = 1L;
	
	//Data coming from the form, automatically injected by STRUTS
	List<Platform> platforms;

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}

	//Default method invoked by STRUTS2
	public String execute() {
			pl = ps.getAll(em);
			return "success";
	}	
}