package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.NotificacionToken;
import entidades.Usuario;

@Local
public interface NotificacionTokenDatoLocal {
	
	public void saveUserToken(NotificacionToken notificacionToken);
	
	public List<NotificacionToken> getUserTokens(Usuario usuario);

	Boolean existeNoficacionToken(NotificacionToken notificacionToken);

}
