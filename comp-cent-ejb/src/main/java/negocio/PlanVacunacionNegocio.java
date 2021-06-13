package negocio;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTEnfermedad;
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
public class PlanVacunacionNegocio implements PlanVacunacionNegocioLocal {

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
		    DTEnfermedad enfermedad = new DTEnfermedad(enfermedadDatoLocal.buscarEnfermedad(plan.getEnfermedad().getNombre()));
		    planVac.setEnfermedad(enfermedad);
		    List<Vacuna> vacunas = plan.getVacunas();
		    List<DTVacuna> dtVacunas = new ArrayList<DTVacuna>();
		    for (Vacuna vac: vacunas) {
		    	DTVacuna vacuna = new DTVacuna(vac);
		    	dtVacunas.add(vacuna);
		    }
		    planVac.setVacunas(dtVacunas);
		    lista.add(planVac);
		 }
		return lista;
	}
	
	@Override
	public void agregarPlanVacunacion(DTPlanVacunacion plan) throws Exception {
		
		if (datoLocal.existePlanVacunacion(plan.getNombre()))
				throw new Exception("\nYa existe un plan con el nombre ingresado");
		else {
			
			PlanVacunacion planVac = new PlanVacunacion(plan);
			Enfermedad enf = enfermedadDatoLocal.buscarEnfermedad(plan.getEnfermedad().getNombre());
			planVac.setEnfermedad(enf);
			List<DTVacuna> Dtvacunas = plan.getVacunas();
			List<Vacuna> vacunas = new ArrayList<Vacuna>();
			for (DTVacuna vac: Dtvacunas) {
				vacunas.add(vacunaDatoLocal.obtenerVacuna(vac.getNombre()));
			}
			planVac.setVacunas(vacunas);
			datoLocal.agregarPlanVacunacion(planVac);
			
			
		}
	}
	
	@Override
	public List<String> nombresPlanes() {
		List<DTPlanVacunacion> planes = listarPlanesDeVacunacion();
		List<String> nombresplanes = new ArrayList<String>();
		planes.forEach((p)->{nombresplanes.add(p.getNombre());});
		return nombresplanes;
	}
	
	@Override
	public DTPlanVacunacion obtenerPlanVacunacion(String nombre) throws Exception {
		if (datoLocal.existePlanVacunacion(nombre)) {
			PlanVacunacion planVacunacion = datoLocal.obtenerPlanVacunacion(nombre);
			DTPlanVacunacion dtPlanVacunacion = new DTPlanVacunacion(planVacunacion);
			DTEnfermedad enfermedad = new DTEnfermedad(planVacunacion.getEnfermedad());
			    dtPlanVacunacion.setEnfermedad(enfermedad);
			    List<Vacuna> vacunas = planVacunacion.getVacunas();
			    List<DTVacuna> dtVacunas = new ArrayList<DTVacuna>();
			    for (Vacuna vac: vacunas) {
			    	DTVacuna vacuna = new DTVacuna(vac);
			    	dtVacunas.add(vacuna);
			    }
			    dtPlanVacunacion.setVacunas(dtVacunas);
			    return dtPlanVacunacion;
		}
		else {
			throw new Exception("\nNo existe un plan con el nombre ingresado");
		}
	}
	
	@Override
	public void editarPlanVacunacion(DTPlanVacunacion plan) throws Exception {
				
					
					PlanVacunacion planVacunacion = datoLocal.obtenerPlanVacunacionPorId(plan.getId());
				
				if (planVacunacion != null) {
					
					Enfermedad enf = enfermedadDatoLocal.buscarEnfermedad(plan.getEnfermedad().getNombre());
					planVacunacion.setEnfermedad(enf);
					
					List<DTVacuna> Dtvacunas = plan.getVacunas();
					List<Vacuna> vacunas = new ArrayList<Vacuna>();
					for (DTVacuna vac: Dtvacunas) {
						vacunas.add(vacunaDatoLocal.obtenerVacuna(vac.getNombre()));
					}
					planVacunacion.setVacunas(vacunas);
					
					planVacunacion.setNombre(plan.getNombre());
					planVacunacion.setEdadMinima(plan.getEdadMinima());
					planVacunacion.setEdadMaxima(plan.getEdadMaxima());
					planVacunacion.setPoblacionObjetivo(plan.getPoblacionObjetivo());
					
					datoLocal.editarPlanVacunacion(planVacunacion);
					
				}else {
					throw new Exception("\nNo se encontro un plan con el id ingresado");
					
				}
				
		}
	
	@Override
	public void eliminarPlanVacunacion(DTPlanVacunacion plan) throws Exception {
		
		PlanVacunacion planVacunacion = datoLocal.obtenerPlanVacunacionPorId(plan.getId());
		if (planVacunacion != null) {
			
			if(planVacunacion.getAgendas().isEmpty()) {
				datoLocal.eliminarPlanVacunacion(planVacunacion);
			}else {
				throw new Exception("\nNo se puede eliminar el plan, porque tiene agendas asociadas");
			}
			
		}else {
			throw new Exception("\nNo se encontro un plan con el id ingresado");
			
		}
	}

}

