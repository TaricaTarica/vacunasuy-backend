package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Envio;

@Local
public interface EnvioDatoLocal {
	public void guardarEnvio(Envio envio);
	public void editarEnvio(Envio envio);
	public List<Envio> listarEnvios();

}
