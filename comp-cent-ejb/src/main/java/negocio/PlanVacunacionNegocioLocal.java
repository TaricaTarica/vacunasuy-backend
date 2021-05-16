package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTPlanVacunacion;

@Local
public interface PlanVacunacionNegocioLocal {

	
	List<DTPlanVacunacion> listarPlanesDeVacunacion();

	void agregarPlanVacunacion(DTPlanVacunacion plan) throws Exception;

}
