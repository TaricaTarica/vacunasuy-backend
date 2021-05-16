package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTEnfermedad;

@Local
public interface EnfermedadNegocioLocal {
	public List<DTEnfermedad> listarEnfermedades ();
	public void agregarEnfermedad(String nombre) throws Exception;
	public DTEnfermedad buscarEnfermedad(String nombre) throws Exception;
	public void cargarBase();
}
