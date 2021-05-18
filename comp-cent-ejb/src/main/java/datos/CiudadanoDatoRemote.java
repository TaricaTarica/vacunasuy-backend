package datos;

import javax.ejb.Remote;

import entidades.Ciudadano;

@Remote
public interface CiudadanoDatoRemote {

	void agregarCiudadano(Ciudadano ciudadano);

	public Ciudadano obtenerCiudadano(int ci);
}
