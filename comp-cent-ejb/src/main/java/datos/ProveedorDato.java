package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Proveedor;

/**
 * Session Bean implementation class ProveedorDato
 */
@Stateless
@LocalBean
public class ProveedorDato implements ProveedorDatoRemote, ProveedorDatoLocal {
	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ProveedorDato() {
        // TODO Auto-generated constructor stub
    }
    public void agregarProveedor(Proveedor proveedor) {
    	em.persist(proveedor);
    }
    
    @Override
  	public List<Proveedor> obtenerProveedores(){
    	
//    	return em.createNamedQuery("Proveedor.obtenerProveedores", Proveedor.class).getResultList();
    	ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
    	for (Object obj : em.createQuery("Select p from Proveedor p").getResultList()) {
    		Proveedor p = (Proveedor) obj;
    		lista.add(p);
    	}
    	return lista;
    }
    
    
    public Proveedor obtenerProveedorPorNombre(String nombre) {
    	Query query = em.createQuery("from Proveedor p where p.nombre =: nombre");
    	query.setParameter("nombre", nombre);
    	return (Proveedor) query.getSingleResult();
    }
    
    @Override
	public Boolean existeProveedor(String nombre) {
    	Boolean existe = (em.createQuery("Select p from Proveedor p where p.nombre = :nombre").setParameter("nombre", nombre).getResultList().size() > 0);	
		return existe;
    }

}
