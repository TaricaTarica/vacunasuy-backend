package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import datatypes.DTLote;
import datatypes.DTVacuna;

import datos.LoteDatoLocal;
import datos.VacunaDatoLocal;
import entidades.Lote;
import entidades.Vacuna;

/**
 * Session Bean implementation class LoteNegocio
 */
@Stateless
@LocalBean
public class LoteNegocio implements LoteNegocioRemote, LoteNegocioLocal {

	/* Para luego
	@EJB
	private LogisticaDistribucionLocal logisticaLocal;
	*/
	
	@EJB
	private LoteDatoLocal datoLocal;
	
	
	@EJB
	private VacunaDatoLocal vacunaDatoLocal;
	
    public LoteNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public List<DTLote> listarLotes() {
		List<Lote> lotes = datoLocal.listarLotes();
		List<DTLote> lista = new ArrayList<DTLote>();
		for (Lote lote:lotes) {
		    DTLote dtLote = new DTLote(lote);
		    DTVacuna vacuna = new DTVacuna(vacunaDatoLocal.obtenerVacuna(lote.getVacuna().getNombre()));
		    dtLote.setVacuna(vacuna);
		    lista.add(dtLote);
		 }
		return lista;
	}
	
	@Override
	public void agregarLote(DTLote dtLote) throws Exception {
		
		if (datoLocal.existeLote(dtLote.getNombre()))
				throw new Exception("\nYa existe un lote con el nombre ingresado");
		else {
			
			Lote lote = new Lote(dtLote);
			Vacuna vacuna = vacunaDatoLocal.obtenerVacuna(dtLote.getVacuna().getNombre());
			lote.setVacuna(vacuna);
			
			datoLocal.agregarLote(lote);
			
			
		}
	}
	
	
	@Override
	public DTLote obtenerLote(String nombre) throws Exception {
		if (datoLocal.existeLote(nombre)) {
			Lote lote = datoLocal.obtenerLote(nombre);
			DTLote dtLote = new DTLote(lote);
			DTVacuna vacuna = new DTVacuna(lote.getVacuna());
			    dtLote.setVacuna(vacuna);
			    return dtLote;
		}
		else {
			throw new Exception("\nNo existe un lote con el nombre ingresado");
		}
	}
	
	@Override
	public void editarLote(DTLote dtLote) throws Exception {
				
					Lote lote = datoLocal.obtenerLotePorId(dtLote.getId());
				
				if (lote != null) {
					
					Vacuna vacuna = vacunaDatoLocal.obtenerVacuna(dtLote.getVacuna().getNombre());
					lote.setVacuna(vacuna);
					
					
					lote.setNombre(dtLote.getNombre());
					lote.setFechaCreado(LocalDate.parse(dtLote.getFechaCreado()));
					lote.setCantVacunas(dtLote.getCantVacunas());
					
					datoLocal.editarLote(lote);
					
				}else {
					throw new Exception("\nNo se encontro un lote con el id ingresado");
					
				}
				
		}
	
	@Override
	public void eliminarLote(DTLote dtLote) throws Exception {
		
		Lote lote = datoLocal.obtenerLotePorId(dtLote.getId());
		if (lote != null) {
			
			if(lote.getLogistica() == null) {
				datoLocal.eliminarLote(lote);
			}else {
				throw new Exception("\nNo se puede eliminar el lote, porque tiene una Logistica de distribucion asociadas");
			}
			
		}else {
			throw new Exception("\nNo se encontro un lote con el id ingresado");
			
		}
	}

}
