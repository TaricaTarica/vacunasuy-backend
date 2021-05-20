package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTPlanVacunacion;

@Local
public interface PlanVacunacionNegocioLocal {

	
	public List<DTPlanVacunacion> listarPlanesDeVacunacion();

	public void agregarPlanVacunacion(DTPlanVacunacion plan) throws Exception;
	
	public List<String> nombresPlanes();
	
	public DTPlanVacunacion obtenerPlanVacunacion(String nombre) throws Exception;

	 

}
