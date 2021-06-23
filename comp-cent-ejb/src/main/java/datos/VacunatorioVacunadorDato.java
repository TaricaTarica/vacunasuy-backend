package datos;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Vacunador;
import entidades.Vacunatorio;
import entidades.VacunatorioVacunador;

/**
 * Session Bean implementation class VacunadorVacunatorioDato
 */
@Stateless
@LocalBean
public class VacunatorioVacunadorDato implements VacunatorioVacunadorDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public VacunatorioVacunadorDato() {
        // TODO Auto-generated constructor stub
    }

	public void agregarVacunadorVacunatorio(VacunatorioVacunador vacunatorioVacunador) {
		em.persist(vacunatorioVacunador);
	}
	
	public void quitarVacunadorVacunatorio(VacunatorioVacunador vacunatorioVacunador) {
		em.remove(vacunatorioVacunador);
	}
	
	public Vacunatorio buscarVacunatorio(Vacunador vacunador) {
		return em.createQuery("SELECT vv FROM VacunatorioVacunador vv "
				+ "WHERE vv.vacunador.ci = :ciVacunador", Vacunatorio.class)
				.setParameter("ciVacunador", vacunador.getCi()).getSingleResult();
	}
	
	public Boolean existeVacunatorio(long id) {
		return (em.createQuery("Select v from VacunatorioVacunador v where v.vacunatorio.id = :id")
				.setParameter("id", id).getResultList().size() > 0);
		
	}
	
	public List<VacunatorioVacunador> obtenerVacunatoriosVacunadores(long id) {
		return em.createQuery("Select v from VacunatorioVacunador v where v.vacunatorio.id = :id", VacunatorioVacunador.class)
				.setParameter("id", id).getResultList();
		
	}
	
	public List<Integer> buscarVacunadoresAsignados(Vacunatorio vacunatorio){
		return em.createQuery("SELECT vv.vacunador.ci FROM VacunatorioVacunador vv "
				+ "WHERE vv.vacunatorio.id = :idVacunatorio", Integer.class)
				.setParameter("idVacunatorio", vacunatorio.getId()).getResultList();
	}
	
	//public void EliminarVacunatorioAsignaciones(long id) {
	//	em.createQuery("delete from VacunatorioVacunador where vacunatorio.id = :id").setParameter("id", id).executeUpdate();
	//}
	
	
}
