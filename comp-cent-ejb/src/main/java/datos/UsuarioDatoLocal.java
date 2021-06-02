package datos;

import javax.ejb.Local;

import entidades.Usuario;

@Local
public interface UsuarioDatoLocal {

	public Boolean existeUsuario(int ci);

	public Usuario obtenerUsuarioPorCI(int ci);

	public void eliminarUsuario(int ci);

	public void editarUsuario(Usuario usuario);

}
