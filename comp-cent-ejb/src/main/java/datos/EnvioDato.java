package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import datatypes.DTLote;
import datatypes.DTSocioLogistico;
import datatypes.DTVacunatorio;
import datatypes.DTVistaEnvio;
import entidades.Envio;
import entidades.Lote;
import enumeradores.EstadoEnvio;

/**
 * Session Bean implementation class EnvioDato
 */
@Stateless
@LocalBean
public class EnvioDato implements EnvioDatoLocal {

	

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public EnvioDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void guardarEnvio(Envio envio) {
    	em.persist(envio);
    }

	@Override
	public void editarEnvio(Envio envio) {
		em.merge(envio);
	}
	
	
	@Override
	public List<Envio> listarEnvios(){
		ArrayList<Envio> lista = new ArrayList<Envio>();
		for (Object obj : em.createQuery("Select e from Envio e").getResultList()) {
			Envio e = (Envio) obj;
			lista.add(e);
		}

		return lista;
	}

	@Override
	public List<Envio> listarEnviosPorSocioLogistico(String cod){
		
		
		TypedQuery<Envio> query = em.createQuery("Select e from Envio e Where e.estado =:estado AND e.socioLogistico.codigo =:codigo", Envio.class);
		query.setParameter("codigo", cod);
		query.setParameter("estado", EstadoEnvio.Pendiente);
		
		return query.getResultList();
		
		//return  em.createQuery("Select e from Envio e", Envio.class).getResultList();
	}

	@Override
	public Envio obtenerEnvio(long id) {
		return em.find(Envio.class, id);
	}

	@Override
	public List<Lote> listarLotesPendientesDeEnviar(){
		
		List<Lote> lotes = new ArrayList<Lote>();
		TypedQuery<Envio> query = em.createQuery("Select e from Envio e", Envio.class);
		//query.setParameter("estado", EstadoEnvio.Pendiente); Where e.estado =:estado
		for (Object obj : query.getResultList()) {
			Envio e = (Envio) obj;
			lotes.add(e.getLote());
		}
		return lotes;
		
		//return  em.createQuery("Select e from Envio e", Envio.class).getResultList();
	}
	
	@Override
	public boolean ExisteLote(Lote lote) {
	
		Boolean existe = (em.createQuery("Select e from Envio e where e.lote.id= :lote").setParameter("lote", lote.getId()).getResultList().size() > 0);	
		return existe;
	}
	
	@Override
	public List<DTVistaEnvio> ListarEnviosVista(){
		List<DTVistaEnvio> lista = new ArrayList<DTVistaEnvio>();
		List<Envio> envios = listarEnvios();
		for(Envio v : envios) {
			DTVistaEnvio envio = new DTVistaEnvio(v.getId(), v.getEstado());
			DTVacunatorio vacunatorio = new DTVacunatorio(v.getVacunatorio());
			envio.setVacunatorio(vacunatorio);
			DTLote lote = new DTLote(v.getLote());
			envio.setLote(lote);
			DTSocioLogistico socioLogistico = new DTSocioLogistico(v.getSocioLogistico());
			envio.setSocioLogistico(socioLogistico);
			lista.add(envio);
			
		}
		return lista;
	}
	
	public List<Envio> cantVacEnviado(long idVacunatorio, int anio) {
		LocalDate fecha = LocalDate.of(anio, 12, 31);
		List<Envio> envios = em.createQuery("Select e from Envio e where e.vacunatorio.id = :idVacunatorio "
				+ "and e.fechaCreacion <= :fecha and e.estado = 'Entregado'", Envio.class)
				.setParameter("idVacunatorio", idVacunatorio)
				.setParameter("fecha",fecha)
				.getResultList();
		return envios;
	}
	
}
