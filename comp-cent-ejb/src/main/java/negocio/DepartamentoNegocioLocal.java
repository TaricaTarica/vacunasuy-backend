package negocio;

import java.util.List;
import javax.ejb.Local;
import datatypes.DTDepartamento;
import datatypes.DTUbicacion;

@Local
public interface DepartamentoNegocioLocal {	

	public List<DTDepartamento> obtenerDepartamentos();

    public DTDepartamento obtenerDepartamentoPorNombre(String nombre);
    
    public List<DTUbicacion> obtenerDepartamentoUbicaciones(String nombre);
    
    
}
