package negocio;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import datatypes.DTPlanVacunacion;

import datos.PlanVacunacionDatoLocal;

import entidades.PlanVacunacion;

/**
 * Session Bean implementation class PlanVacunacionNegocio
 */
@Stateless
@LocalBean
public class PlanVacunacionNegocio implements PlanVacunacionNegocioRemote, PlanVacunacionNegocioLocal {

	@EJB
	private PlanVacunacionDatoLocal datoLocal;
	
	
    public PlanVacunacionNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public List<DTPlanVacunacion> listarPlanesDeVacunacion() {
		List<PlanVacunacion> planes = datoLocal.listarPlanesDeVacunacion();
		List<DTPlanVacunacion> lista = new ArrayList<DTPlanVacunacion>();
		for (PlanVacunacion plan:planes) {
		    DTPlanVacunacion planVac = new DTPlanVacunacion(plan);
		    lista.add(planVac);
		    }
		return lista;
	}
	
	@Override
	public void agregarPlanVacunacion(DTPlanVacunacion plan) throws Exception {
		/*
		if (datoLocal.existeEnfermedad(nombre))
				throw new Exception("\nEnfermedad ya existe en el sistema");
		else {
			LocalDate date1 = LocalDate.now();
			Enfermedad enf = new Enfermedad(nombre,date1);
			datoLocal.agregarEnfermedad(enf);	
		}
		*/
		
	}

}
