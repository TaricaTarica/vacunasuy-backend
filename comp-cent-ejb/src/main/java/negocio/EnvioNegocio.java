package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import datatypes.DTEnvio;
import datatypes.DTLote;
import datatypes.DTSocioLogistico;
import datatypes.DTStockVacuna;
import datatypes.DTVacuna;
import datatypes.DTVacunatorio;
import datos.EnvioDatoLocal;
import datos.LoteDatoLocal;
import datos.SocioLogisticoDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Envio;
import entidades.Lote;
import entidades.SocioLogistico;
import entidades.Vacuna;
import entidades.Vacunatorio;
import enumeradores.EstadoEnvio;

/**
 * Session Bean implementation class EnvioNegocio
 */
@Stateless
@LocalBean
public class EnvioNegocio implements EnvioNegocioLocal {
	
	@EJB
	private EnvioDatoLocal envioLocal;
	
	@EJB
	private LoteDatoLocal loteLocal;
	
	@EJB
	private VacunatorioDatoLocal vacunatorioLocal;
	
	@EJB
	private SocioLogisticoDatoLocal socioLocal;
	
    /**
     * Default constructor. 
     */
    public EnvioNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public List<DTEnvio> listarEnvios(){
    	List<Envio> envios = envioLocal.listarEnvios();
    	List<DTEnvio> lista = new ArrayList<DTEnvio>(); 
    	for(Envio en: envios) {
    		DTEnvio envio = new DTEnvio(en);
    		lista.add(envio);
    	}
    	return lista;
    	
    }
    
    @Override
	public List<DTEnvio> listarEnviosPorSocioLogistico(String cod){
    	List<Envio> envios =  envioLocal.listarEnviosPorSocioLogistico(cod);
		List<DTEnvio> lista = new ArrayList<DTEnvio>();
		for(Envio en: envios) {
    		DTEnvio envio = new DTEnvio(en);
    		lista.add(envio);
    	}
    	return lista;
    }
    
    public void cambiarEstadoEnvio(EstadoEnvio estado, long idEnvio) {
    	Envio envio = envioLocal.obtenerEnvio(idEnvio);
    	envio.setEstado(estado);
    	envioLocal.editarEnvio(envio);
    }
    
    @Override
    public void AgregarEnvio(DTEnvio envio, DTLote lote,  DTVacunatorio vacunatorio, DTSocioLogistico dtSocio ) throws Exception {

    	Envio env = new Envio(envio);
    	Lote l = loteLocal.obtenerLote(lote.getNombre());
    	env.setLote(l);
    	SocioLogistico s = socioLocal.obtenerSocioLogistico(dtSocio.getCodigo());
    	env.setSocioLogistico(s);
    	Vacunatorio v = vacunatorioLocal.obtenerVacunatorio(vacunatorio.getId());
    	env.setVacunatorio(v);
    	envioLocal.guardarEnvio(env);
    }
    
	@Override
	public List<String> listarEstado () {
		
		List<String> estados = Stream.of(EstadoEnvio.values())
                .map(Enum::name)
                .collect(Collectors.toList());
		
		return estados;
    }
	
	@Override
	public List<DTLote> listarLotePendientesDeEnviar () {
		List<Lote> lotesAux2 = loteLocal.listarLotes();
		List<DTLote> lotes = new ArrayList<DTLote>();
		for(Lote l :lotesAux2) {
			if(!envioLocal.ExisteLote(l)) {
				DTLote dtLote = new DTLote(l);
				lotes.add(dtLote);
			}
		}
		return lotes;
    }
	
	@Override
	public List<DTStockVacuna> stockEnviado(long idVacunatorio, LocalDate fecha) {
		
		List<Envio> envios = envioLocal.cantVacEnviado(idVacunatorio, fecha);
		List<DTStockVacuna> listStock = new ArrayList<DTStockVacuna>();
		for (Envio env: envios) {
			if (existeVacuna(listStock,env.getLote().getVacuna())){
				int i = 0;
				while (listStock.get(i).getVacunaId() != env.getLote().getVacuna().getId()) {
					i++;
				}
				listStock.get(i).setCant(listStock.get(i).getCant() + env.getLote().getCantVacunas());
			} else {
				listStock.add(new DTStockVacuna(env.getLote().getVacuna().getId(),
						env.getLote().getVacuna().getCodigo(),env.getLote().getVacuna().getNombre(),
						env.getLote().getVacuna().getLaboratorio(), env.getLote().getVacuna().getEnfermedad().getNombre(),
						env.getLote().getCantVacunas()));
			}
		}
		return listStock;
	}
	
	private Boolean existeVacuna(List<DTStockVacuna> list, Vacuna vacuna) {
		for (DTStockVacuna vac : list) {
			if (vac.getVacunaId() == vacuna.getId()) {
				return true;
			}
		}
		return false;
	}

}
