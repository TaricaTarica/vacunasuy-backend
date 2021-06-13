package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTSocioLogistico;

@Local
public interface SocioLogisticoNegocioLocal {

	public void agregarSocioLogistico(DTSocioLogistico dtSocio) throws Exception;
	
	public void editarSocioLogistico(DTSocioLogistico dtSocio) throws Exception;
	
	public void eliminarSocioLosgistico(DTSocioLogistico dtSocio) throws Exception;
	
	public Boolean existeSocioLogistico(String codigo);
	
	public DTSocioLogistico obtenerSocioLogistico(String codigo) throws Exception;
	
	public List<DTSocioLogistico> listarSocioLogistico();
	
}
