package datos;

import javax.ejb.Local;

import entidades.Ciudadano;

@Local
public interface CiudadanoDatoLocal {

	void agregarCiudadano(Ciudadano ciudadano);

	Ciudadano obtenerCiudadano(int ci);

}
