package datos;

import javax.ejb.Local;

import entidades.SocioLogistico;

@Local
public interface SocioLogisticoDatoLocal {
	
	public void agregarSocioLogistico(SocioLogistico socio);
	
	public void editarSocioLogistico(SocioLogistico socio);
	
	public void eliminarSocioLosgistico(SocioLogistico socio);
	
	public Boolean existeSocioLogistico(String codigo);
	
	public SocioLogistico obtenerSocioLogistico(String codigo);
	
	public SocioLogistico obtenerSocioLogisticoPorId(long id);
	
}
