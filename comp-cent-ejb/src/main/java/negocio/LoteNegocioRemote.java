package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTLote;

@Remote
public interface LoteNegocioRemote {
	public void eliminarLote(DTLote dtLote) throws Exception;

	public void editarLote(DTLote dtLote) throws Exception;

	public DTLote obtenerLote(String nombre) throws Exception;

	public void agregarLote(DTLote dtLote) throws Exception;

	public List<DTLote> listarLotes();
}
