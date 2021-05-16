package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datatypes.DTDepartamento;
import datos.DepartamentoDatoLocal;
import entidades.Departamento;

/**
 * Session Bean implementation class DepartamentoNegocio
 */
@Stateless
@LocalBean
public class DepartamentoNegocio implements DepartamentoNegocioRemote, DepartamentoNegocioLocal {
	
	@Inject
	DepartamentoDatoLocal md;
    /**
     * Default constructor. 
     */
    public DepartamentoNegocio() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<DTDepartamento> obtenerDepartamentos() {
    	ArrayList<Departamento> Departamentos = (ArrayList<Departamento>) md.obtenerDepartamentos();
    	ArrayList<DTDepartamento> DTDepartamentos = new ArrayList<DTDepartamento>();
    	Departamentos.forEach( (d) -> { DTDepartamentos.add( new DTDepartamento(d.getDescripcion())) ; } );
		return DTDepartamentos;
	}

	@Override
	public DTDepartamento obtenerDepartamentoPorNombre(String nombre) {
		return new DTDepartamento(md.obtenerDepartamentoPorNombre(nombre).getDescripcion());
	}

}
