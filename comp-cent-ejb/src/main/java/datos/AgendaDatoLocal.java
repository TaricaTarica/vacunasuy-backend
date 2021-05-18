package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Agenda;

@Local
public interface AgendaDatoLocal {
	
	public void agregarAgenda(Agenda agenda);
	public List<Agenda> listarAgenda();
	public Agenda obtenerAgendaPorId(Long id);

}
