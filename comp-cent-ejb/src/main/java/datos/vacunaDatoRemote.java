package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Vacuna;

@Remote
public interface vacunaDatoRemote {

	
	public void agregarVacuna(Vacuna vac);
	public List<Vacuna> obtenerVacunas();
}
