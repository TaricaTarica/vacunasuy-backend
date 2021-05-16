package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Departamento;
import entidades.Vacuna;

/**
 * Session Bean implementation class DepartamentoDato
 */
@Stateless
@LocalBean
public class DepartamentoDato implements DepartamentoDatoRemote, DepartamentoDatoLocal {

	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;  
	
    /**
     * Default constructor. 
     */
    public DepartamentoDato() {
        // TODO Auto-generated constructor stub

    }
    
    @Override
    public void agregarDepartamento(Departamento dep) {
		em.persist(dep);
	}
    
    @Override
	public List<Departamento> obtenerDepartamentos(){
    	return em.createNamedQuery("Departamento.obtenerDepartamentos", Departamento.class).getResultList();
    }
    
    @Override
    public Departamento obtenerDepartamentoPorId(long id) {    	
		return em.find(Departamento.class, id);
    }
    
    @Override
    public Departamento obtenerDepartamentoPorNombre(String nombre) {
    	Query query = em.createQuery("from Departamento d where d.descripcion =: descripcion");
    	query.setParameter("descripcion", nombre);
		return (Departamento) query.getSingleResult();
    } 

}
