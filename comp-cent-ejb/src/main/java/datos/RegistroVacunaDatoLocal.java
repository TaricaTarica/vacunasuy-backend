package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.RegistroVacuna;
import entidades.Vacuna;

@Local
public interface RegistroVacunaDatoLocal {

	public void agregarRegistroVacuna(RegistroVacuna regVac);
	
	public List<RegistroVacuna> obtenerRegistroPorCi (int ci);
	
	public List<RegistroVacuna> obtenerRegistro();
	
	public int cantRegistroPorMes(Vacuna vacuna, int mes, int anio);
	
}
