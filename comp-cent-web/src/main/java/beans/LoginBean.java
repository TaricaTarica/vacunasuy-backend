package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import entidades.Usuario;
import negocio.AdministradorNegocioLocal;
import negocio.AutoridadNegocioLocal;
import negocio.SessionBeanLocal;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private SessionBeanLocal sessionBeanLocal;
	@EJB
	private AdministradorNegocioLocal  administradorLocal;
	@EJB
	private AutoridadNegocioLocal  autoridadLocal;
	
	private int ci;
	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}



	private String contrasenia;
	private String mensaje;	
	private String sessionToken;
	private String url;
	
	
	private Usuario currentUser;
	
	private static HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	public String login() {
		
//		FacesContext fc = FacesContext.getCurrentInstance();
//		ExternalContext ec = fc.getExternalContext();
//		
//		
//		try {
//	        ec.redirect(url);
//	} catch (IOException ex) {
//	        Logger.getLogger(Navigation.class.getName()).log(Level.SEVERE, null, ex);
//	}
//			
		
		
		boolean res = sessionBeanLocal.iniciarSesion(ci, contrasenia);
		String redirect = "";
		if (res) {
			if (administradorLocal.obtenerAdministradorPorCi(ci)!=null) {
				currentUser = administradorLocal.obtenerAdministradorPorCi(ci);
				redirect ="/administrador/home?faces-redirect=true";
			}else if(autoridadLocal.obtenerAutoridadPorCi(ci)!= null) {
				currentUser = autoridadLocal.obtenerAutoridadPorCi(ci);
				redirect ="/autoridad/home?faces-redirect=true";
			}
			// guardo el usuario logueado en sesión
			session.setAttribute("currentUser", currentUser);
//			System.out.println("usuario y contraseña Correcta");
			return redirect;
		} else {
			this.mensaje = "Usuario inexistente o las credenciales son incorrectas.";
			System.out.println("no se pudo entrar al login");
			return "login?faces-redirect=true";
			
		}
		
	}
	
	
	
	public String logout() {
		currentUser = null;
		session.removeAttribute("currentUser");
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String redirectUri = "login.xhtml";
		if (origRequest.getRequestURI().contains("administrador") || origRequest.getRequestURI().contains("autoridad"))
			redirectUri = "../"+redirectUri;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUri);
			FacesContext.getCurrentInstance().responseComplete();
			return "login";
		} catch (IOException e) {
			//e.printStackTrace();
			return "login";
		}
	}


}
