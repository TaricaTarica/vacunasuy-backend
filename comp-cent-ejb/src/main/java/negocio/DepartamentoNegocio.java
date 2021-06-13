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
	public List<DTUbicacion> obtenerDepartamentoUbicaciones(String nombre) {
		List<Ubicacion> ubicaciones =  md.obtenerDepartamentoUbicaciones(nombre);
		List<DTUbicacion> dTUbicaciones = new ArrayList<DTUbicacion>();
		ubicaciones.forEach( (u) -> { dTUbicaciones.add( new DTUbicacion(u.getDescripcion(),u.getId())) ; } );
		return dTUbicaciones;
	}

	@Override
	public DTUbicacion obtenerDepartamentoUbicacion(String descDepartamento, String descUbicacion) {
		Ubicacion ubicacion = md.obtenerDepartamentoUbicacion(descDepartamento, descUbicacion);
		if(ubicacion != null) {
			DTUbicacion dtUbicacion = new DTUbicacion(ubicacion);
			return dtUbicacion;
		}
		else {
			return null;
		}
	}
	
	@Override
	public DTDepartamento obtenerDepartamentoPorUbicacion(long idUbicacion) {
		ArrayList<Departamento> departamentos = (ArrayList<Departamento>) md.obtenerDepartamentos();
		DTDepartamento departamento = new DTDepartamento();
		for (Departamento dpto : departamentos) {
			for (Ubicacion ubi: dpto.getUbicaciones()) {
				if (ubi.getId() == idUbicacion) {
					departamento.setDescripcion(dpto.getDescripcion());
				}
			}
		}
		return departamento;
		
	}

}
