package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTEnfermedad;



@Remote
public interface EnfermedadNegocioRemote {
	public List<DTEnfermedad> listarEnfermedades ();
	public void agregarEnfermedad(String nombre) throws Exception;
	public DTEnfermedad buscarEnfermedad(String nombre) throws Exception;
	public void cargarBase();
}
