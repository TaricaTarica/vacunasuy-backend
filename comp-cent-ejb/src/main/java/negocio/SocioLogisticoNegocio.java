package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTSocioLogistico;
import datos.SocioLogisticoDatoLocal;
import entidades.SocioLogistico;

/**
 * Session Bean implementation class SocioLogisticoNegocio
 */
@Stateless
@LocalBean
public class SocioLogisticoNegocio implements SocioLogisticoNegocioLocal {

	@EJB
	SocioLogisticoDatoLocal socioDato;
    /**
     * Default constructor. 
     */
    public SocioLogisticoNegocio() {
        // TODO Auto-generated constructor stub
    }
    
	public void agregarSocioLogistico(DTSocioLogistico dtSocio) throws Exception {
		if (socioDato.existeSocioLogistico(dtSocio.getCodigo())) {
			throw new Exception("\nYa existe ese socio logistico");
		} else {
			socioDato.agregarSocioLogistico(socioDato.obtenerSocioLogistico(dtSocio.getCodigo()));
		}
	}
	
	public void editarSocioLogistico(DTSocioLogistico dtSocio) throws Exception {
		SocioLogistico socio = socioDato.obtenerSocioLogisticoPorId(dtSocio.getId());
		if ( socio != null) {
			socioDato.editarSocioLogistico(socio);
		} else {
			throw new Exception("\nNo existe el socio logistico");
		}
	}
	
	public void eliminarSocioLosgistico(DTSocioLogistico dtSocio) throws Exception {
		SocioLogistico socio = socioDato.obtenerSocioLogistico(dtSocio.getCodigo());
		if (socio != null)	{
			socioDato.eliminarSocioLosgistico(socio);;
		} else {
			throw new Exception("\nNo existe el socio logistico");
		}
	}
	
	public Boolean existeSocioLogistico(String codigo) {
		return socioDato.existeSocioLogistico(codigo);
	}
	
	public DTSocioLogistico obtenerSocioLogistico(String codigo) throws Exception {
		if (socioDato.existeSocioLogistico(codigo))	{
			return new DTSocioLogistico(socioDato.obtenerSocioLogistico(codigo));
		} else {
			throw new Exception("\nNo se encontro un socio logistico con el codigo ingresado");
		}
	}
	
}
