package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Lote;

@Remote
public interface LoteDatoRemote {
	public void agregarLote(Lote lote);

	public List<Lote> listarLotes();

	public Lote obtenerLote(String nombre);

	public Boolean existeLote(String nombre);

	public void eliminarLote(Lote lote);

	public Lote obtenerLotePorId(long id);

	public void editarLote(Lote lote);
}
