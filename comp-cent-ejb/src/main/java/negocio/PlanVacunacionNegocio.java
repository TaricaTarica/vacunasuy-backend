package negocio;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import datatypes.DTPlanVacunacion;
import datatypes.DTVacuna;
import datos.EnfermedadDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.VacunaDatoLocal;
import entidades.Enfermedad;
import entidades.PlanVacunacion;
import entidades.Vacuna;

/**
 * Session Bean implementation class PlanVacunacionNegocio
 */
@Stateless
@LocalBean
public class PlanVacunacionNegocio implements PlanVacunacionNegocioRemote, PlanVacunacionNegocioLocal {

	@EJB
	private PlanVacunacionDatoLocal datoLocal;
	
	@EJB
	private EnfermedadDatoLocal enfermedadDatoLocal;
	
	@EJB
	private VacunaDatoLocal vacunaDatoLocal;
	
	
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
		
		if (datoLocal.existePlanVacunacion(plan.getNombre()))
				throw new Exception("\nPlan ya existe en el sistema");
		else {
			
			PlanVacunacion planVac = new PlanVacunacion(plan);
			Enfermedad enf = enfermedadDatoLocal.buscarEnfermedad(plan.getEnfermedad().getNombre());
			planVac.setEnfermedad(enf);
			List<DTVacuna> vacunas = plan.getVacunas();
			for (DTVacuna vac: vacunas) {
				Vacuna vacuna = vacunaDatoLocal.obtenerVacuna(vac.getNombre());
				planVac.setVacunas(vacuna);
			}
			
			datoLocal.agregarPlanVacunacion(planVac);
			
			
		}
	}
		
		
	}


