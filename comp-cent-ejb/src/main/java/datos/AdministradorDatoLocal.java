package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Administrador;

@Local
public interface AdministradorDatoLocal {
	
	public void guardarAdministrador(Administrador administrador);
	
	public void editarAdministrador(Administrador administrador);
	
	public List<Administrador> obtenerAdministradores();
	
	public Administrador obtenerAdministradorPorCI(int ci);

}
