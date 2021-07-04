package datos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.RegistroVacuna;
import entidades.Vacuna;
import enumeradores.Sexo;

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
    
    @Override
    public int cantRegistroPorSexo(Vacuna vacuna, Sexo sexo, int anio) {
    	LocalDate fechaIni = LocalDate.of(anio, 1, 1);
    	LocalDate fechaFin = LocalDate.of(anio, 12, 31);
    	List<RegistroVacuna> listRegistros = em.createQuery("Select rv from RegistroVacuna rv where rv.vacuna.id = :id and rv.fecha between :fechaIni and :fechaFin",RegistroVacuna.class)
        		.setParameter("id", vacuna.getId())
        		.setParameter("fechaIni",fechaIni)
        		.setParameter("fechaFin",fechaFin).getResultList();
    	int cant = 0;
    	for (RegistroVacuna rv : listRegistros) {
    		if (rv.getCiudadano().getSexo() == sexo) {
    			cant ++;
    		}
    	}
    	return cant;
    }
    
    @Override
    public int cantRegistroPorEdad(Vacuna vacuna, int edadMin, int edadMax, int anio) {
    	LocalDate fechaIni = LocalDate.of(anio, 1, 1);
    	LocalDate fechaFin = LocalDate.of(anio, 12, 31);
    	List<RegistroVacuna> listRegistros = em.createQuery("Select rv from RegistroVacuna rv where rv.vacuna.id = :id and rv.fecha between :fechaIni and :fechaFin",RegistroVacuna.class)
        		.setParameter("id", vacuna.getId())
        		.setParameter("fechaIni",fechaIni)
        		.setParameter("fechaFin",fechaFin).getResultList();
    	int cant = 0;
    	LocalDate ahora = LocalDate.now();
    	for (RegistroVacuna rv : listRegistros) {
    		Period edad = Period.between(rv.getCiudadano().getFnac(), ahora);
    		if (edad.getYears() >= edadMin && edad.getYears() <= edadMax) {
    			cant ++;
    		}
    	}
    	return cant;
    }
    
    @Override
    public RegistroVacuna obtenerCertificadoReserva(long idReserva) {
    	List<RegistroVacuna> registros = this.obtenerRegistro();
    	RegistroVacuna retorno = null;
    	for(RegistroVacuna r: registros) {
    		if(r.getReserva().getId() == idReserva) {
    			retorno = r;
    		}
    	}
    	return retorno;
    }
}
