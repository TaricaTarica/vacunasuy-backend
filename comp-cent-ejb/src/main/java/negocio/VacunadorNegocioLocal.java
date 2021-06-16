package negocio;

import javax.ejb.Local;

@Local
public interface VacunadorNegocioLocal {
	
	public boolean esVacunador(int ci);
}
