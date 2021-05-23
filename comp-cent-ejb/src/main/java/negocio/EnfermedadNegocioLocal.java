package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTEnfermedad;
import datatypes.DTVacuna;

@Local
public interface EnfermedadNegocioLocal {
	public List<DTEnfermedad> listarEnfermedades ();
	public void agregarEnfermedad(String nombre) throws Exception;
	public DTEnfermedad buscarEnfermedad(String nombre) throws Exception;
	public List<DTVacuna> listarVacunasPorEnfermedad (String nombreEnfermedad) throws Exception;
	public List<String> listarPoblacionObjetivo();
	public void eliminarEnfermedad(String nombre) throws Exception;
}
