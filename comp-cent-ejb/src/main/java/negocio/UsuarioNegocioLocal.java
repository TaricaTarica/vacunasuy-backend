package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTAdministrador;
import datatypes.DTAutoridad;
import datatypes.DTCiudadano;
import datatypes.DTContrasenia;
import entidades.Usuario;

@Local
public interface UsuarioNegocioLocal {

	public void registrarUsuario(Usuario user) throws Exception;

	public List<DTCiudadano> mostrarCiudadanos();

	public void actualizarDatos(Usuario user) throws Exception;

	public List<DTAutoridad> mostrarAutoridades();

	public List<DTAdministrador> mostrarAdministradores();

	public DTAdministrador obtenerAdministrador(int cedula) throws Exception;

	public void eliminarUsuario(int cedula) throws Exception;

	public void editarContraseniaUsuario(DTContrasenia editarContrasenia) throws Exception;

	public DTAutoridad obtenerAutoridad(int cedula) throws Exception;

}
