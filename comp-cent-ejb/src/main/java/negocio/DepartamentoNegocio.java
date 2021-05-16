package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datatypes.DTDepartamento;
import datatypes.DTUbicacion;
import datos.DepartamentoDatoLocal;
import entidades.Departamento;
import entidades.Ubicacion;

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
    	ArrayList<Departamento> departamentos = (ArrayList<Departamento>) md.obtenerDepartamentos();
    	ArrayList<DTDepartamento> dTDepartamentos = new ArrayList<DTDepartamento>();
    	departamentos.forEach( (d) -> { dTDepartamentos.add( new DTDepartamento(d.getDescripcion())) ; } );
		return dTDepartamentos;
	}

	@Override
	public DTDepartamento obtenerDepartamentoPorNombre(String nombre) {
		return new DTDepartamento(md.obtenerDepartamentoPorNombre(nombre).getDescripcion());
	}

	@Override
	public List<DTUbicacion> obtenerDepartamentoUbicaciones(String nombre) {
		ArrayList<Ubicacion> ubicaciones = (ArrayList<Ubicacion>) md.obtenerDepartamentoUbicaciones(nombre);
		ArrayList<DTUbicacion> dTUbicaciones = new ArrayList<DTUbicacion>();
		ubicaciones.forEach( (u) -> { dTUbicaciones.add( new DTUbicacion(u.getDescripcion())) ; } );
		return dTUbicaciones;
	}



}
