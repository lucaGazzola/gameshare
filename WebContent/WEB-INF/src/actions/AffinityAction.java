package actions;

import util.AffinityCalculator;

import com.opensymphony.xwork2.ActionSupport;

public class AffinityAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	
	public String execute(){
		// popola il database ad ogni avvio dell'applicazione
		AffinityCalculator ac = new AffinityCalculator();
		ac.calculateAffinities();
		return "success";
	}

}