package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Autoridad;

@Local
public interface AutoridadDatoLocal {
	
	public void guardarAutoridad(Autoridad autoridad);
	
	public void editarAutoridad(Autoridad autoridad);
	
	public List<Autoridad> obtenerAutoridades();
	
	public Autoridad obtenerAutoridadPorCI(int ci);

	public Boolean existeAutoridad(String nombre);	
}
