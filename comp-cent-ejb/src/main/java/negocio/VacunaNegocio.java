package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datatypes.DTEnfermedad;
import datatypes.DTProveedor;
import datatypes.DTVacuna;
import datos.EnfermedadDatoLocal;
import datos.ProveedorDatoLocal;
import datos.VacunaDato;
import entidades.Enfermedad;
import entidades.Proveedor;
import entidades.Vacuna;

/**
 * Session Bean implementation class vacunaNegocio
 */
@Stateless
@LocalBean
public class VacunaNegocio implements VacunaNegocioLocal {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Inject
	private VacunaDato puenteDatos;
	@EJB
	private EnfermedadDatoLocal enfermedadDatoLocal;
	@EJB
	private ProveedorDatoLocal proveedorDatoLocal;
	
    /**
     * Default constructor. 
     */
    public VacunaNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void agregarVacuna(String nombre, String codigo, String laboratorio, Enfermedad enf, Proveedor pro, int dosis, int periodoInmune) {
    	
    	Vacuna vac= new Vacuna();
    	vac.setNombre(nombre);
    	vac.setCodigo(codigo);
    	vac.setLaboratorio(laboratorio);
    	vac.setDosis(dosis);
    	vac.setPeriodoInmune(periodoInmune);
    	
    	
    	puenteDatos.agregarVacuna(vac);
    	
    }
    

    @Override
    public DTVacuna obtenerVacuna(long id) {
	    	Vacuna vac = puenteDatos.obtenerVacuna(id);
	    	return new DTVacuna(vac.getNombre(), vac.getCodigo(), vac.getLaboratorio());
    }
    
    @Override
    public List<DTVacuna> obtenerVacunas(){
    	
    	ArrayList<Vacuna> vacs = (ArrayList<Vacuna>)puenteDatos.obtenerVacunas();
    	ArrayList<DTVacuna> dtVacs =  new ArrayList<DTVacuna>();
    	for(Vacuna vac : vacs)
    	{
    		dtVacs.add(new DTVacuna(vac));
    	}
    	return dtVacs;
    }
    
    @Override
    public void agregarVacunas() {
    	puenteDatos.agregarVacunas();
    }
    
    @Override
    public void agregarVacuna(DTVacuna dtvacuna) throws Exception {
    	
    	if(puenteDatos.existeVacuna(dtvacuna.getNombre())) {
    		throw new Exception("\nYa existe una Vacuna con el nombre ingresado");
    	}else {
    		Vacuna vac = new Vacuna(dtvacuna);
    		Enfermedad enf = enfermedadDatoLocal.buscarEnfermedad(dtvacuna.getEnfermedad().getNombre());
    		vac.setEnfermedad(enf);
    		Proveedor pro = proveedorDatoLocal.obtenerProveedorPorNombre(dtvacuna.getProveedor().getNombre());
    		vac.setProveedor(pro);
    		vac.setDosis(dtvacuna.getDosis());
    		vac.setPeriodoInmune(dtvacuna.getPeriodoInmune());
//    		System.out.println(enf.getNombre() + enf.getId());
//    		System.out.println(pro.getNombre() + pro.getId());
        	this.puenteDatos.agregarVacuna(vac);
    		
    	}
    	
    }
    
    public void editarVacuna(DTVacuna dtvacuna) throws Exception {
    	
    	Vacuna vacuna = puenteDatos.obtenerVacunaPorId(dtvacuna.getId());
    	
    	if(vacuna != null) {
    		
    		
    		System.out.println(dtvacuna.getEnfermedad().getNombre());	
    		
    		Enfermedad enf = enfermedadDatoLocal.buscarEnfermedad(dtvacuna.getEnfermedad().getNombre());
    		vacuna.setEnfermedad(enf);
    		Proveedor pro = proveedorDatoLocal.obtenerProveedorPorNombre(dtvacuna.getProveedor().getNombre());
    		vacuna.setProveedor(pro);
    		
    		vacuna.setNombre(dtvacuna.getNombre());
    		vacuna.setCodigo(dtvacuna.getCodigo());
    		vacuna.setLaboratorio(dtvacuna.getLaboratorio());
    		vacuna.setDosis(dtvacuna.getDosis());
    		vacuna.setPeriodoInmune(dtvacuna.getPeriodoInmune());
    		
    		puenteDatos.editarVacuna(vacuna);
    	}else {
			throw new Exception("\nNo se encontro una Vacuna con el id ingresado");
			
		}
			
    }
    
    public DTProveedor obtenerProveedorDeVacuna(String nombre) {
    	Vacuna vac = puenteDatos.obtenerVacuna(nombre);
    	DTProveedor dtPro = new DTProveedor(vac.getProveedor());
    	return dtPro;
    }
    
    public DTEnfermedad obtenerEnfermedadDeVacuna(String nombre) {
    	Vacuna vac = puenteDatos.obtenerVacuna(nombre);
    	DTEnfermedad dtEnf = new DTEnfermedad(vac.getEnfermedad());
    	return dtEnf;
    }
    
    @Override
	public void eliminarVacuna(String nombre) throws Exception{
    	Vacuna vac = puenteDatos.obtenerVacuna(nombre);
    	if(vac != null) {
    		puenteDatos.eliminarVacuna(vac);
    	}else {
			throw new Exception("\nNo se encontro un plan con el id ingresado");
			
		}
    }
    
    
    
}