package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTEnfermedad;
import datatypes.DTVacuna;
import datos.EnfermedadDatoLocal;
import entidades.Enfermedad;
import entidades.Vacuna;
import enumeradores.PoblacionObjetivo;



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
	public List<DTVacuna> listarVacunasPorEnfermedad(String nombreEnfermedad) throws Exception {
		
		if (datoLocal.existeEnfermedad(nombreEnfermedad)) {
			List<DTVacuna> lista = new ArrayList<DTVacuna>();
			List<Vacuna> vacunas = (datoLocal.buscarEnfermedad(nombreEnfermedad)).getVacunas();
			if (vacunas!= null) {
				for (Vacuna vac:vacunas) {
				    DTVacuna vacuna = new DTVacuna(vac);
				    lista.add(vacuna);
				    }
			}
				
			return lista;
		}
		else 
			throw new Exception("\nEnfermedad no encontrada en el sistema");
	}
	
	@Override
	public List<String> listarPoblacionObjetivo () {
		
		List<String> poblacion = Stream.of(PoblacionObjetivo.values())
                .map(Enum::name)
                .collect(Collectors.toList());
		
		return poblacion;
    }

}
