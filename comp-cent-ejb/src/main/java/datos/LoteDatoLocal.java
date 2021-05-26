package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Lote;
import entidades.Reserva;

@Local
public interface LoteDatoLocal {

	public void agregarLote(Lote lote);

	public List<Lote> listarLotes();

	public Lote obtenerLote(String nombre);

	public Boolean existeLote(String nombre);

	public void eliminarLote(Lote lote);

	public Lote obtenerLotePorId(long id);

	public void editarLote(Lote lote);

}
