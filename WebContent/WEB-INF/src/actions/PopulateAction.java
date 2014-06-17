package actions;

import util.Populator;

import com.opensymphony.xwork2.ActionSupport;

public class PopulateAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;

	
	public String erase(){
		Populator pop = new Populator();
		pop.delete();
		return "success";
	}
	
	public String execute(){
		// popola il database ad ogni avvio dell'applicazione
		Populator pop = new Populator();
		pop.popolate();
		return "success";
	}

}
