package datos;

import javax.ejb.Remote;

import entidades.Vacuna;

@Remote
public interface vacunaDatoRemote {

	
	public void addVacuna(Vacuna vac);
}
