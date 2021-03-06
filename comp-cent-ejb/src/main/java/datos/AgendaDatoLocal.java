package datos;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import entidades.Agenda;

@Local
public interface AgendaDatoLocal {
	
	public void agregarAgenda(Agenda agenda);
	public List<Agenda> listarAgenda();
	public Agenda obtenerAgendaPorId(Long id);
	public void editarAgenda(Agenda agenda);
	public void eliminarAgenda(Agenda agenda);
	public Boolean agendaSuperpuesta(Agenda agenda);
	public Agenda obtenerAgendaActivaVacunatorio(long idVac, LocalDate fecha);
	public List<Agenda> obtenerAgendasFuturasVacunatorio(long idVac, LocalDate fecha);
	public List<Agenda> obtenerAgendasActivasYPasadasVacunatorio(long idVacunatorio);
	public Boolean existeAgendaActiva(long idVac, LocalDate fecha);

}
