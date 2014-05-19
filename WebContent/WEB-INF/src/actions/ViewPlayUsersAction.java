package actions;

import com.opensymphony.xwork2.ActionSupport;

public class ViewPlayUsersAction extends ActionSupport{
	private static final long serialVersionUID = 5976515590599826089L;
	
	public String execute(){
		System.out.println("view play users action");
		return "success";
	}

}
