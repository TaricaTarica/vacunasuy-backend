package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Agenda;

@Remote
public interface AgendaDatoRemote {

	public void agregarAgenda(Agenda agenda);
	public List<Agenda> listarAgenda();
	public Agenda obtenerAgendaPorId(Long id);
	public void editarAgenda(Agenda agenda);
	public void eliminarAgenda(Agenda agenda);
	
}
