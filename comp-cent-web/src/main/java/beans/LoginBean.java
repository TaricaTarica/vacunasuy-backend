package beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("loginBean")
@SessionScoped
public class LoginBean {

	private String usuario;
	private String contrasenia;
	private String mensaje;	
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String login() {
		return "";
	}

}
