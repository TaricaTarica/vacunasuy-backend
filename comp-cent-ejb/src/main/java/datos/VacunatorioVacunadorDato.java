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
	
	public Vacunatorio buscarVacunatorio(Vacunador vacunador, LocalDate fecha) {
		return em.createQuery("SELECT vv FROM VacunatorioVacunador vv "
				+ "WHERE vv.vacunador.ci = :ciVacunador AND vv.fecha = :fecha ", Vacunatorio.class)
				.setParameter("ciVacunador", vacunador.getCi())
				.setParameter("fecha", fecha).getSingleResult();
	}
	
	public List<Vacunador> buscarVacunadoresAsignados(Vacunatorio vacunatorio, LocalDate fecha){
		return em.createQuery("SELECT vv FROM VacunatorioVacunador vv "
				+ "WHERE vv.vacuntorio.id = :idVacunatorio AND vv.fecha = :fecha", Vacunador.class)
				.setParameter("idVacunatorio", vacunatorio.getId())
				.setParameter("fecha", fecha).getResultList();
	}
	
}
