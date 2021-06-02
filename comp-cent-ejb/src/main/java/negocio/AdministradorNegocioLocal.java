package negocio;

import javax.ejb.Local;

import entidades.Administrador;

@Local
public interface AdministradorNegocioLocal {
	public Administrador obtenerAdministradorPorCi (int ci);
}
