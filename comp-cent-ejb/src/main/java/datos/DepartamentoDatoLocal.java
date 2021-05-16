package datos;

import java.util.List;

import javax.ejb.Local;
import entidades.Departamento;

@Local
public interface DepartamentoDatoLocal {
	
    public void agregarDepartamento(Departamento dep);

	public List<Departamento> obtenerDepartamentos();

    public Departamento obtenerDepartamentoPorId(long id);

    public Departamento obtenerDepartamentoPorNombre(String nombre);

}
