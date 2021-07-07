package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTNotificacionToken;

@Local
public interface NotificacionTokenNegocioLocal {
	
	public void saveUserToken(DTNotificacionToken dTnotificacionToken);
	
	public List<String> getUserTokens(int ci);

}
