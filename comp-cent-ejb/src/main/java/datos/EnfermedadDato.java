package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Enfermedad;



/**
 * Session Bean implementation class EnfermedadDato
 */
@Stateless
@LocalBean
public class EnfermedadDato implements EnfermedadDatoRemote, EnfermedadDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

		
	public EnfermedadDato() {
		
	 
    }
	
	@Override
	public void agregarEnfermedad(Enfermedad enfermedad) {
			em.persist(enfermedad);
				
	}
		
	@Override
	public List<Enfermedad> listarEnfermedades (){
		ArrayList<Enfermedad> lista = new ArrayList<Enfermedad>();
		for (Object obj : em.createQuery("Select e from Enfermedad e").getResultList()) {
			Enfermedad e = (Enfermedad) obj;
			lista.add(e);
		}

		return lista;
	}
	
	@Override
	public Enfermedad buscarEnfermedad (String nombre) {
		Enfermedad enfermedad =(Enfermedad) em.createQuery("Select e from Enfermedad e where e.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();	
		return enfermedad;	
		    	
	}
	
	
	@Override
	public Boolean existeEnfermedad(String nombre) {
		Boolean existe = (em.createQuery("Select e from Enfermedad e where e.nombre = :nombre").setParameter("nombre", nombre).getResultList().size() > 0);	
		return existe;

	}

	@Override
	public void cargarBase() {
		LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018, 10, 30);
        LocalDate date3 = LocalDate.of(2021, 01, 04);
        LocalDate date4 = LocalDate.of(2020, 07, 07);
        Enfermedad enf1 = new Enfermedad("Fiebre Amarilla",date1);
        Enfermedad enf2 = new Enfermedad("Gripe",date1);
        Enfermedad enf3 = new Enfermedad("Varicela",date2);
        Enfermedad enf4 = new Enfermedad("Paperas",date3);
        Enfermedad enf5 = new Enfermedad("Rubeola",date4);
        
       
        em.persist(enf1);
        em.persist(enf2);
        em.persist(enf3);
        em.persist(enf4);
        em.persist(enf5);
		
	}

}
