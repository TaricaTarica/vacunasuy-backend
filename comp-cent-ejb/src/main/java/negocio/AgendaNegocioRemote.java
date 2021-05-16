package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTAgenda;

@Remote
public interface AgendaNegocioRemote {

	public void agregarAgenda(DTAgenda dtAgenda);
	public List<DTAgenda> listarAgenda();
	
}
