package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTPlanVacunacion;

@Remote
public interface PlanVacunacionNegocioRemote {
	
	public List<DTPlanVacunacion> listarPlanesDeVacunacion();

	public void agregarPlanVacunacion(DTPlanVacunacion plan) throws Exception;
	
	public List<String> nombresPlanes();
	
	public DTPlanVacunacion obtenerPlanVacunacion(String nombre) throws Exception;
	

}
