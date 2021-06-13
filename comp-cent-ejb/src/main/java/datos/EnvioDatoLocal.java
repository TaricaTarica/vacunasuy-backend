package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Envio;
import enumeradores.EstadoEnvio;

@Local
public interface EnvioDatoLocal {
	public void guardarEnvio(Envio envio);
	public void editarEnvio(Envio envio);
	public Envio obtenerEnvio(long id);
	public List<Envio> listarEnvios();
	public List<Envio> listarEnviosPorSocioLogistico(String cod);
}
