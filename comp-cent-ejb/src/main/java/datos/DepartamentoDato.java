package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Departamento;
import entidades.Ubicacion;

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
	public List<Departamento> obtenerDepartamentos(){
    	return em.createNamedQuery("Departamento.obtenerDepartamentos", Departamento.class).getResultList();
    }
    
    @Override
    public Departamento obtenerDepartamentoPorNombre(String nombre) {
    	Query query = em.createQuery("from Departamento d where d.descripcion =: descripcion");
    	query.setParameter("descripcion", nombre);
		return (Departamento) query.getSingleResult();
    } 
    
    @Override
    public List<Ubicacion> obtenerDepartamentoUbicaciones(String nombre) {
    	try {
    		Departamento dep =  this.obtenerDepartamentoPorNombre(nombre);
        	return dep.getUbicaciones();
    	} catch (Exception e) {
    		return new ArrayList<Ubicacion>();
    	}
    }
    @Override
    public Ubicacion obtenerDepartamentoUbicacion(String descDepartamento, String descUbicacion) {
    	List<Ubicacion> ubicaciones = this.obtenerDepartamentoUbicaciones(descDepartamento);
    	Ubicacion aRetornar = null;
    	if(ubicaciones != null) {
    		for(Ubicacion u: ubicaciones) {
    			if(u.getDescripcion().trim().equals(descUbicacion.trim())) {
    				aRetornar = u;
    			}
    		}
    		return aRetornar;
    	}
    	else {
    		return null;
    	}
    }



}
