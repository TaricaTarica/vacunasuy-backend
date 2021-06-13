package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Vacunatorio;

@Local
public interface VacunatorioDatoLocal {
	
	public void agregarVacunatorio(Vacunatorio vacunatorio);
	public List<Vacunatorio> listarVacunatorio();
	public Vacunatorio obtenerVacunatorio(long id);
	public Vacunatorio obtenerVacunatorioPorCodigo(String codigo);
	public Boolean existeVacunatorio(String codigo);
	public void editarVacunatorio(Vacunatorio vac);
	public void eliminarVacunatorio(Vacunatorio vac);

}
