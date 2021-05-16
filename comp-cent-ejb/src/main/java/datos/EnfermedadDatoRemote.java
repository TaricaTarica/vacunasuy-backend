package datos;

import java.util.List;

import javax.ejb.Remote;


import entidades.Enfermedad;
import entidades.Vacuna;


@Remote
public interface EnfermedadDatoRemote {
	public List<Enfermedad> listarEnfermedades ();
	public void agregarEnfermedad(Enfermedad enfermedad);
	public Enfermedad buscarEnfermedad(String nombre);
	public Boolean existeEnfermedad(String nombre);
}
