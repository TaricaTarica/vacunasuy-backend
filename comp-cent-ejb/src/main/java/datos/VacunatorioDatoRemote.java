package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Vacunatorio;

@Remote
public interface VacunatorioDatoRemote {
	
	public void agregarVacunatorio(Vacunatorio vacunatorio);
	public List<Vacunatorio> listarVacunatorio();

}
