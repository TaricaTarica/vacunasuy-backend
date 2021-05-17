package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.PlanVacunacion;

@Local
public interface PlanVacunacionDatoLocal {

	void agregarPlanVacunacion(PlanVacunacion plan);

	List<PlanVacunacion> listarPlanesDeVacunacion();

	Boolean existePlanVacunacion(String nombre);

}
