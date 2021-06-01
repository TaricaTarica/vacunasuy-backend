package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTAgenda;

@Remote
public interface AgendaNegocioRemote {

	public void agregarAgenda(DTAgenda dtAgenda) throws Exception;
	public List<DTAgenda> listarAgenda();
	public List<DTAgenda> listarAgendasActivas();
	public void editarAgenda (DTAgenda dtAgenda) throws Exception;
	public void eliminarAgenda (DTAgenda dtAgenda) throws Exception;
	
}
