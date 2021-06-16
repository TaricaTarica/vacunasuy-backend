package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.RegistroVacuna;
import entidades.Vacuna;
import enumeradores.Sexo;

@Local
public interface RegistroVacunaDatoLocal {

	public void agregarRegistroVacuna(RegistroVacuna regVac);
	
	public List<RegistroVacuna> obtenerRegistroPorCi (int ci);
	
	public List<RegistroVacuna> obtenerRegistro();
	
	public int cantRegistroPorMes(Vacuna vacuna, int mes, int anio);

	public int cantRegistroPorSexo(Vacuna vacuna, Sexo sexo, int anio);
	
	public int cantRegistroPorEdad(Vacuna vacuna, int edadMin, int edadMax, int anio);
	
}
