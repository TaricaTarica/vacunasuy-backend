package negocio;

import javax.ejb.Local;

import entidades.Autoridad;

@Local
public interface AutoridadNegocioLocal {
	public Autoridad obtenerAutoridadPorCi (int ci);
}
