package datos;

import java.util.List;

import javax.ejb.Local;


import entidades.Enfermedad;



@Local
public interface EnfermedadDatoLocal {
	public List<Enfermedad> listarEnfermedades ();
	public void agregarEnfermedad(Enfermedad enfermedad);
	public Enfermedad buscarEnfermedad(String nombre);
	public Boolean existeEnfermedad(String nombre);
	public void eliminarEnfermedad(Enfermedad enfermedad);
}
