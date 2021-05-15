package datos;

import javax.ejb.Local;

import entidades.Vacuna;

@Local
public interface vacunaDatoLocal {
	
	public void addVacuna(Vacuna vac);

}
