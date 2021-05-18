package datos;

import java.util.List;

import javax.ejb.Local;
import entidades.Departamento;
import entidades.Ubicacion;

@Local
public interface DepartamentoDatoLocal {

	public List<Departamento> obtenerDepartamentos();
	    
    public List<Ubicacion> obtenerDepartamentoUbicaciones(String nombre);
    
    public Ubicacion obtenerDepartamentoUbicacion(String descDepartamento, String descUbicacion);

}
