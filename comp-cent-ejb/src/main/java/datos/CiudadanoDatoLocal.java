package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Ciudadano;

@Local
public interface CiudadanoDatoLocal {

	public void agregarCiudadano(Ciudadano ciudadano);

	public Ciudadano obtenerCiudadano(int ci);

	public List<Ciudadano> obtenerCiudadanos();

	public void editarCiudadano(Ciudadano ciudadano);
	
	public boolean existeCiudadano(int ci);

}
