package datos;

import javax.ejb.Remote;

import entidades.PlanVacunacion;

@Remote
public interface PlanVacunacionDatoRemote {
	public PlanVacunacion obtenerPlanVacunacion(String nombre);
}
