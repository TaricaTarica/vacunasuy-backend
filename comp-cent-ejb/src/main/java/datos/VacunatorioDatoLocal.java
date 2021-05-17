package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Vacunatorio;

@Local
public interface VacunatorioDatoLocal {
	
	public void agregarVacunatorio(Vacunatorio vacunatorio);
	public List<Vacunatorio> listarVacunatorio();

}
