package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;


import datatypes.DTVacuna;
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
    
    public void agregarVacuna(DTVacuna dtvacuna) {
    	Vacuna vacuna = new Vacuna(dtvacuna);
    	this.puenteDatos.agregarVacuna(vacuna);
    	
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
}