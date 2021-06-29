package negocio;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import datatypes.DTAgenda;
import entidades.Agenda;

@Local
public interface AgendaNegocioLocal {

	public void agregarAgenda(DTAgenda dtAgenda) throws Exception;
	public List<DTAgenda> listarAgenda();
	public List<DTAgenda> listarAgendasActivas();
	public void editarAgenda (DTAgenda dtAgenda) throws Exception;
	public void eliminarAgenda (DTAgenda dtAgenda) throws Exception;
	public Agenda obtenerAgendaActiva(long id, LocalDate fecha);
	public int countAgendasActivasHoy(long vacunaId);
	
	public List<DTAgenda> agendasVacunador(int ci);
}
