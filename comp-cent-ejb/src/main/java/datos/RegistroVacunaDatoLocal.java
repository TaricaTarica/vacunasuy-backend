package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.RegistroVacuna;

@Local
public interface RegistroVacunaDatoLocal {

	public void agregarRegistroVacuna(RegistroVacuna regVac);
	
	public List<RegistroVacuna> obtenerRegistroPorCi (int ci);
	
}
