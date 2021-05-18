package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTVacunatorio;

@Remote
public interface VacunatorioNegocioRemote {

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio);
	public List<DTVacunatorio> listarVacunatorio();
	public List<String> nombresVacunatorios();
	
}
