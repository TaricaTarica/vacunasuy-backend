package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTEnfermedad;
import datos.EnfermedadDatoLocal;
import entidades.Enfermedad;



/**
 * Session Bean implementation class EnfermedadNegocio
 */
@Stateless
@LocalBean
public class EnfermedadNegocio implements EnfermedadNegocioRemote, EnfermedadNegocioLocal {

	@EJB
	private EnfermedadDatoLocal datoLocal;
	
	
	
    public EnfermedadNegocio() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<DTEnfermedad> listarEnfermedades() {
		List<Enfermedad> enfermedades = datoLocal.listarEnfermedades();
		List<DTEnfermedad> lista = new ArrayList<DTEnfermedad>();
		for (Enfermedad enf:enfermedades) {
		    DTEnfermedad enfermedad = new DTEnfermedad(enf);
		    lista.add(enfermedad);
		    }
		return lista;
	}

	@Override
	public void agregarEnfermedad(String nombre) throws Exception {
		if (datoLocal.existeEnfermedad(nombre))
				throw new Exception("\nEnfermedad ya existe en el sistema");
		else {
			LocalDate date1 = LocalDate.now();
			Enfermedad enf = new Enfermedad(nombre,date1);
			datoLocal.agregarEnfermedad(enf);	
		}
		
	}

	@Override
	public DTEnfermedad buscarEnfermedad(String nombre) throws Exception {
		
		if (datoLocal.existeEnfermedad(nombre)) {
			DTEnfermedad enfermedad =  new DTEnfermedad(datoLocal.buscarEnfermedad(nombre)); 
			return enfermedad;
		}
		else {
			throw new Exception("\nEnfermedad no encontrada en el sistema");
		}
			
	}

	@Override
	public void cargarBase() {
		datoLocal.cargarBase();
		
	}

}
