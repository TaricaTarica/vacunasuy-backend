package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTAgenda;

@Local
public interface AgendaNegocioLocal {

	public void agregarAgenda(DTAgenda dtAgenda);
	public List<DTAgenda> listarAgenda();
	
}
