package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Reserva;

/**
 * Session Bean implementation class ReservaDato
 */
@Stateless
@LocalBean
public class ReservaDato implements ReservaDatoRemote, ReservaDatoLocal {

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

}
