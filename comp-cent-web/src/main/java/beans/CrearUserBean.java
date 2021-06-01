package beans;



import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import datos.AdministradorDatoLocal;
import datos.AutoridadDatoLocal;
import entidades.Administrador;
import entidades.Autoridad;

@Named("crearUserBean")
@ViewScoped
public class CrearUserBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private AdministradorDatoLocal administradorLocal;
	
	@EJB
	private AutoridadDatoLocal autoridadLocal;
	
	
	Administrador administrador;
	
	 
		@PostConstruct
		public void init() {
			

		}
		
		public void agregarAdministrador() {
			Administrador admin = new Administrador();
			admin.setCi(123456);
			admin.setContrasenia("123456");
			administradorLocal.guardarAdministrador(admin);
			
			Autoridad aut = new Autoridad();
			aut.setCi(1234567);
			aut.setContrasenia("1234567");
			autoridadLocal.guardarAutoridad(aut);
			
		}
	
	
}
