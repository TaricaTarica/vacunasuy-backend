package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;


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
public class VacunaNegocio implements VacunaNegocioRemote, VacunaNegocioLocal {

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
    
    public void agregarVacuna(String nombre, String codigo, String laboratorio, Enfermedad enf, Proveedor pro) {
    	
    	Vacuna vac= new Vacuna();
    	vac.setNombre(nombre);
    	vac.setCodigo(codigo);
    	vac.setLaboratorio(laboratorio);
    	
    	
    	puenteDatos.agregarVacuna(vac);
    	
    }
    

    
    public DTVacuna obtenerVacuna(long id) {
	    	Vacuna vac = puenteDatos.obtenerVacuna(id);
	    	return new DTVacuna(vac.getNombre(), vac.getCodigo(), vac.getLaboratorio());
    }
    
    public List<DTVacuna> obtenerVacunas(){
    	
    	ArrayList<Vacuna> vacs = (ArrayList<Vacuna>)puenteDatos.obtenerVacunas();
    	ArrayList<DTVacuna> dtVacs =  new ArrayList<DTVacuna>();
    	for(Vacuna vac : vacs)
    	{
    		dtVacs.add(new DTVacuna(vac.getNombre(), vac.getCodigo(), vac.getLaboratorio()));
    	}
    	return dtVacs;
    }
    public void agregarVacunas() {
    	puenteDatos.agregarVacunas();
    }
    
    public void agregarVacuna(DTVacuna dtvacuna) throws Exception {
    	
    	if(puenteDatos.existeVacuna(dtvacuna.getNombre())) {
    		throw new Exception("\nYa existe una Vacuna con el nombre ingresado");
    	}else {
    		Vacuna vac = new Vacuna(dtvacuna);
    		Enfermedad enf = enfermedadDatoLocal.buscarEnfermedad(dtvacuna.getEnfermedad().getNombre());
    		vac.setEnfermedad(enf);
    		Proveedor pro = proveedorDatoLocal.obtenerProveedorPorNombre(dtvacuna.getProveedor().getNombre());
    		vac.setProveedor(pro);
    		System.out.println(enf.getNombre() + enf.getId());
    		System.out.println(pro.getNombre() + pro.getId());
        	this.puenteDatos.agregarVacuna(vac);
    		
    	}
    	
    }
}