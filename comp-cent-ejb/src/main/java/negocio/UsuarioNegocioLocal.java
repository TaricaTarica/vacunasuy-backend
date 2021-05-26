package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTCiudadano;
import entidades.Usuario;

@Local
public interface UsuarioNegocioLocal {

	public void registrarUsuario(Usuario user) throws Exception;

	public List<DTCiudadano> mostrarCiudadanos();

	public void actualizarDatos(Usuario user) throws Exception;
	
	public boolean autenticarUsuario (int ci, String pass);

}
