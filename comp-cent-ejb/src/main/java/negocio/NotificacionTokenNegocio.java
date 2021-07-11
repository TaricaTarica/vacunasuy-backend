package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import datatypes.DTNotificacionToken;
import datos.NotificacionTokenDatoLocal;
import datos.UsuarioDatoLocal;
import entidades.NotificacionToken;
import entidades.Usuario;

/**
 * Session Bean implementation class NotificacionTokenNegocio
 */
@Stateless
@LocalBean
public class NotificacionTokenNegocio implements NotificacionTokenNegocioLocal {

	@EJB
	private NotificacionTokenDatoLocal notificacionTokenDato;
	
	@EJB
	private UsuarioDatoLocal usuariosDato;
    /**
     * Default constructor. 
     */
    public NotificacionTokenNegocio() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void saveUserToken(DTNotificacionToken dTnotificacionToken) {
		// TODO Auto-generated method stub
		NotificacionToken notificacionToken = new NotificacionToken();
		notificacionToken.setToken(dTnotificacionToken.getToken());
		Usuario usuario = usuariosDato.obtenerUsuarioPorCI(dTnotificacionToken.getCedula());
		if ( usuario == null ) {
			throw new RuntimeException("Usuario no existe");
		}
		notificacionToken.setUsuario(usuario);
		if (!notificacionTokenDato.existeNoficacionToken(notificacionToken)) {
			notificacionTokenDato.saveUserToken(notificacionToken);
		}
	}
    

	@Override
	public List<String> getUserTokens(int ci) {
		// TODO Auto-generated method stub
		List<String> tokensList = new ArrayList<String>();
		List<NotificacionToken> list =  notificacionTokenDato.getUserTokens(usuariosDato.obtenerUsuarioPorCI(ci));
		for (NotificacionToken nt : list) {
			tokensList.add(nt.getToken());
		}
		return tokensList;
	}


    

}
