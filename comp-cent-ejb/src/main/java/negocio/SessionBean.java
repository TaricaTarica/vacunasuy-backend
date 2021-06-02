package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class sessionBean
 */
@Singleton
@LocalBean
public class SessionBean implements SessionBeanLocal {
	
	
	@EJB
	private UsuarioNegocio usuarioNegocio;
	
	

    /**
     * Default constructor. 
     */
    public SessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
	public boolean iniciarSesion(int ci, String pass) {
    	if (usuarioNegocio.autenticarUsuario(ci, pass))
    		return true;
    	else
    		return false;
    }
    

}
