package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTAgenda;

@Local
public interface AgendaNegocioLocal {

	public void agregarAgenda(DTAgenda dtAgenda) throws Exception;
	public List<DTAgenda> listarAgenda();
	public List<DTAgenda> listarAgendasActivas();
	public void editarAgenda (DTAgenda dtAgenda) throws Exception;
	public void eliminarAgenda (DTAgenda dtAgenda) throws Exception;
	
}
