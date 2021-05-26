package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import entidades.Usuario;
import negocio.AdministradorNegocioLocal;
import negocio.AutoridadNegocioLocal;
import negocio.SessionBeanLocal;

@Named("loginBean")
@ViewScoped
public class LoginBean implements Serializable {

	
	
	@EJB
	private SessionBeanLocal sessionBeanLocal;
	@EJB
	private AdministradorNegocioLocal  administradorLocal;
	@EJB
	private AutoridadNegocioLocal  autoridadLocal;
	
	private int ci;
	private String contrasenia;
	private String mensaje;	
	private String sessionToken;
	
	
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
	
	
	
	public String login() {
		boolean res = sessionBeanLocal.iniciarSesion(ci, contrasenia);
		if (res) {
			if (administradorLocal.obtenerAdministradorPorCi(ci)!=null) {
				currentUser = administradorLocal.obtenerAdministradorPorCi(ci);
			}else if(autoridadLocal.obtenerAutoridadPorCi(ci)!= null) {
				currentUser = autoridadLocal.obtenerAutoridadPorCi(ci);
			}
			// guardo el usuario logueado en sesión
			session.setAttribute("currentUser", currentUser);
			return "exito";
		} else {
			this.mensaje = "Usuario inexistente o las credenciales son incorrectas.";
			return "fallo";
			
		}
	}
	
	

}
