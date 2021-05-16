package datos;

import java.util.List;

import javax.ejb.Local;
import entidades.Departamento;
import entidades.Ubicacion;

@Local
public interface DepartamentoDatoLocal {
	
    public void agregarDepartamento(Departamento dep);

	public List<Departamento> obtenerDepartamentos();

    public Departamento obtenerDepartamentoPorId(long id);

    public Departamento obtenerDepartamentoPorNombre(String nombre);
    
    public List<Ubicacion> obtenerDepartamentoUbicaciones(String nombre);

}
