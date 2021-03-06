package datos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Enfermedad;
import entidades.Proveedor;
import entidades.Vacuna;

/**
 * Session Bean implementation class vacunaDato
 */
@Stateless
@LocalBean
public class VacunaDato implements VacunaDatoLocal {

	
	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public VacunaDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void agregarVacuna(Vacuna vac) {
		em.persist(vac);
	}
    
    @Override
	public Vacuna obtenerVacuna (String nombre) {
		Vacuna vacuna =(Vacuna) em.createQuery("Select v from Vacuna v where v.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();	
		return vacuna;	
		    	
	}
    
    public Vacuna obtenerVacuna(long id) {
	    Vacuna vac = new Vacuna();
		vac = em.find(Vacuna.class, id);
		return vac;
    }
    
    public void agregarVacunas() {
    	
//    	Vacuna vac1 = new Vacuna("Vacuna1","XC1","LosPepes");
//    	Vacuna vac2 = new Vacuna("Vacuna2","JK2","LosPedros");
//    	Vacuna vac3 = new Vacuna("Vacuna3","PL4","LosRodo");
//    	Vacuna vac4 = new Vacuna("Vacuna4","JK5","LosClavos");
//    	Vacuna vac5 = new Vacuna("Vacuna5","YT7","LosMemes");
//    	em.persist(vac1);
//    	em.persist(vac2);
//    	em.persist(vac3);
//    	em.persist(vac4);
//    	em.persist(vac5);
    
    }

	@Override
	public List<Vacuna> obtenerVacunas() {
		// TODO Auto-generated method stub
		ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
		for (Object obj : em.createQuery("Select v from Vacuna v").getResultList()) {
			Vacuna v = (Vacuna) obj;
			lista.add(v);
		}
		return lista;
	}
	
	public Boolean existeVacuna(String nombre) {
		Boolean existe = (em.createQuery("Select v from Vacuna v where v.nombre = :nombre").setParameter("nombre", nombre).getResultList().size() > 0);	
		return existe;
	}
	
	 @Override
	    public void editarVacuna(Vacuna vacuna) {
		 em.merge(vacuna);
	 }
	 
	 @Override
	    public void eliminarVacuna(Vacuna vacuna) {
		 em.remove(vacuna);
	 }
	    		
	 @Override
	 	public Proveedor obtenerProveedorDeVacuna(String nomVac) {
		 try {
			 Vacuna vac = this.obtenerVacuna(nomVac);
			 return vac.getProveedor();
		 } catch (Exception e){
			 return null;
		 }
		 
	 }
	 @Override
	 	public Enfermedad obtenerEnfermedadDeVacuna(String nomVac) {
		 try {
			 Vacuna vac = this.obtenerVacuna(nomVac);
			 return vac.getEnfermedad();
		 } catch (Exception e){
			 return null;
		 }
	 }
	 
	 
	 @Override
	    public Vacuna obtenerVacunaPorId(long id) {
		 	Vacuna vac = em.find(Vacuna.class, id);
		 	return vac;
	 }
}