package datos;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Reserva;
import enumeradores.EstadoReserva;

/**
 * Session Bean implementation class ReservaDato
 */
@Stateless
@LocalBean
public class ReservaDato implements ReservaDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ReservaDato() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Reserva> obtenerReservas() {
		// TODO Auto-generated method stub
		return em.createQuery("Select r from Reserva r", Reserva.class).getResultList();
	}

	@Override
	public void crearReserva(Reserva res) {
		em.persist(res);		
	}
	@Override
	public Reserva obtenerReserva(long id) {
		Reserva reserva = em.find(Reserva.class, id);
		return reserva;
	}
	@Override
	public void editarReserva(Reserva res) {
		em.merge(res);
	}
	
	@Override
	public Boolean existeReserva(long idAgenda) {
		return em.createQuery("Select r from Reserva r where r.agenda.id = :id", Reserva.class).setParameter("id", idAgenda).getResultList().size() > 0;
	}

	@Override
	public List<Reserva> obtenerReservasAgenda(LocalDate fecha ,long id) {
		return em.createQuery("Select r from Reserva r where r.agenda.id = :id and r.estado = :estado and r.fecha = :fecha", Reserva.class).setParameter("id", id)
				.setParameter("estado", EstadoReserva.Agendado)
				.setParameter("fecha", fecha)
				.getResultList();
		
	}
	
	@Override
	public List<Reserva> obtenerReservasPorUbicacion(long id) {
		return em.createQuery("Select r from Reserva r where r.ubicacion.id = :id and r.estado = :estado", Reserva.class).setParameter("id", id)
				.setParameter("estado", EstadoReserva.Pendiente)
				.getResultList();
		
	}
	
	@Override
	public Reserva obtenerUltimaReserva(long id, LocalDate fecha) {
	
		List<Reserva> reserva = em.createQuery("Select r from Reserva r where r.agenda.id = :id and r.fecha = :fecha order by r.hora desc", Reserva.class).setParameter("id", id)
				.setParameter("fecha", fecha)
				.getResultList();
		if (reserva.isEmpty()) {
			return null;
		}
		return reserva.get(0);
		
		
	}
	

	@Override
	public int obtenerCantidadUltimaHora(long id, LocalDate fecha, int hora) {
		return em.createQuery("Select r from Reserva r where r.agenda.id = :id and r.fecha = :fecha and r.hora = :hora", Reserva.class).setParameter("id", id)
				.setParameter("fecha", fecha)
				.setParameter("hora", hora)
				.getResultList().size();
		
	}
	
	@Override
	public int obtenerCantidadReservasDia(long id, LocalDate fecha) {
		return  em.createQuery("Select r from Reserva r where r.agenda.id = :id and r.fecha = :fecha", Reserva.class).setParameter("id", id)
				.setParameter("fecha", fecha)
				.getResultList().size();
		
	}

}
