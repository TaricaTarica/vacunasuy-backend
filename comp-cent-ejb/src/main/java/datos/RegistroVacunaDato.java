package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.RegistroVacuna;
import entidades.Vacuna;

/**
 * Session Bean implementation class RegistroVacunaDato
 */
@Stateless
@LocalBean
public class RegistroVacunaDato implements RegistroVacunaDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public RegistroVacunaDato() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void agregarRegistroVacuna(RegistroVacuna regVac) {
		em.persist(regVac);
	}
    
    @Override
	public List<RegistroVacuna> obtenerRegistroPorCi (int ci) {
    	
		List<RegistroVacuna> listRegVac = new ArrayList<RegistroVacuna>();
		for	(RegistroVacuna rv :em.createQuery("Select rv from RegistroVacuna rv where rv.ciudadano.ci = :ci",RegistroVacuna.class).setParameter("ci", ci).getResultList()) {
			listRegVac.add(rv);
		}
		return listRegVac;	
		    	
	}
    
    
    @Override
	public List<RegistroVacuna> obtenerRegistro(){
    	ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
    	for(Object obj : em.createQuery("Select r from RegistroVacuna r").getResultList()) {
    		RegistroVacuna r = (RegistroVacuna) obj;
    		lista.add(r);
    	}
    	return lista;
    }
    
    @Override
	public int cantRegistroPorMes(Vacuna vacuna, int mes, int anio){
    	LocalDate fechaIni = LocalDate.of(anio, mes, 1);
    	LocalDate fechaFin = LocalDate.now();
    	if (mes == 12) {
    		fechaFin = LocalDate.of(anio + 1, 1, 1);
    	} else {
    		fechaFin = LocalDate.of(anio, mes + 1, 1);
    	}
    	List<RegistroVacuna> listRegistros = em.createQuery("Select rv from RegistroVacuna rv where rv.vacuna.id = :id and rv.fecha between :fechaIni and :fechaFin",RegistroVacuna.class)
    		.setParameter("id", vacuna.getId())
    		.setParameter("fechaIni",fechaIni)
    		.setParameter("fechaFin",fechaFin).getResultList();
    	if (listRegistros == null) {
    		return 0;
    	} else {
    		return listRegistros.size();
    	}
    }
    
}
