package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.PlanVacunacion;

@Local
public interface PlanVacunacionDatoLocal {

	void agregarPlanVacunacion(PlanVacunacion plan);

	public List<PlanVacunacion> listarPlanesDeVacunacion();

	public Boolean existePlanVacunacion(String nombre);
	
	public PlanVacunacion obtenerPlanVacunacion(String nombre);
	
	public PlanVacunacion obtenerPlanVacunacionPorId(long id);

	public void editarPlanVacunacion(PlanVacunacion plan);

	public void eliminarPlanVacunacion(PlanVacunacion plan);

}
