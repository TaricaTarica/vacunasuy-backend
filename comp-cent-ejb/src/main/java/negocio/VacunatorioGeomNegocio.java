package negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datos.VacunatorioGeomDatoLocal;

/**
 * Session Bean implementation class VacunatorioGeomNegocio
 */
@Stateless
@LocalBean
public class VacunatorioGeomNegocio implements VacunatorioGeomNegocioLocal {

    @EJB
    VacunatorioGeomDatoLocal vgdl;
	
    public VacunatorioGeomNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void agregarCoordenadas(long idVacunatorio, String lat, String lon) {
    	vgdl.agregarCoordenadas(idVacunatorio, lat, lon);
    }
    
    @Override
    public List<Integer> vacunatoriosCercanos(String lat, String lon){
    	return vgdl.vacunatoriosCercanos(lat, lon);
    }
    
    

}
