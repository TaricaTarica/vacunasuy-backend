package negocio;

import javax.ejb.Remote;

import datatypes.DTCiudadano;

@Remote
public interface CiudadanoNegocioRemote {
	public void agregarCiudadano(DTCiudadano dtCiudadano);
	public DTCiudadano obtenerCiudadano(int ci);
}
