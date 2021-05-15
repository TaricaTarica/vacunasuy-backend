package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Enfermedad;


@Remote
public interface EnfermedadDatoRemote {
	public List<Enfermedad> listarEnfermedades ();
	public void agregarEnfermedad(Enfermedad enfermedad);
	public Enfermedad buscarEnfermedad(String nombre);
	public Boolean existeEnfermedad(String nombre);
	public void cargarBase();
}
