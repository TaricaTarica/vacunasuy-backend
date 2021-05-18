package negocio;

import javax.ejb.Local;

import datatypes.DTCiudadano;

@Local
public interface CiudadanoNegocioLocal {
	public void agregarCiudadano(DTCiudadano dtCiudadano);
	public DTCiudadano obtenerCiudadano(int ci);
}
