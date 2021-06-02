package negocio;

import javax.ejb.Local;

@Local
public interface SessionBeanLocal {
	
	public boolean iniciarSesion(int ci, String pass);
	
}
