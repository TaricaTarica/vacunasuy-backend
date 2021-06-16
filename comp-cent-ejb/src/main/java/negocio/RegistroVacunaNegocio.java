package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import datatypes.DTCertificado;
import datatypes.DTVacuna;
import datos.RegistroVacunaDatoLocal;
import datos.VacunaDatoLocal;
import entidades.RegistroVacuna;
import entidades.Vacuna;
import enumeradores.Sexo;

/**
 * Session Bean implementation class RegistroVacunaNegocio
 */
@Stateless
@LocalBean
public class RegistroVacunaNegocio implements RegistroVacunaNegocioLocal {

	@EJB
	private RegistroVacunaDatoLocal registroVacunaDatoLocal;
	@EJB
	private VacunaDatoLocal vacunaDatoLocal;

    /**
     * Default constructor. 
     */
    public RegistroVacunaNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DTCertificado> obtenerCertificados(String ci){
    	List<RegistroVacuna> listRegVac = registroVacunaDatoLocal.obtenerRegistroPorCi(Integer.valueOf(ci));
    	List<DTCertificado> listCert = new ArrayList<DTCertificado>();
    	if (listRegVac != null) {
        	for (RegistroVacuna regVac: listRegVac) {
        		Vacuna vac = regVac.getVacuna();
        		DTCertificado dtCert = new DTCertificado();
        		dtCert.setFechaVacuna(regVac.getFecha().toString());
        		dtCert.setIdVacuna(String.valueOf(vac.getId()));
        		dtCert.setNombreVacuna(vac.getNombre());
        		dtCert.setLaboratorioVacuna(vac.getLaboratorio());
        		dtCert.setCodigoVacuna(vac.getCodigo());
        		dtCert.setCantDosis(String.valueOf(vac.getDosis()));
        		dtCert.setPeriodoInmunidad(String.valueOf(vac.getPeriodoInmune()));
        		dtCert.setIdEnfermedad(String.valueOf(vac.getEnfermedad().getId()));
        		dtCert.setNombreEnfermedad(vac.getEnfermedad().getNombre());
        		listCert.add(dtCert);
        		
        	}
    	}
    	return listCert;
    }

    public List<RegistroVacuna> listarRegistros(){
    	List<RegistroVacuna> registros = registroVacunaDatoLocal.obtenerRegistro();
		return registros;
    }
    
    public List<Integer> obtenerCantVac(DTVacuna vacuna, int anio) {
    	Vacuna vac = vacunaDatoLocal.obtenerVacunaPorId(vacuna.getId());
    	List<Integer> listaCantidadXMes = new ArrayList<Integer>();
    	for (int i=1; i<=12; i++){
    		listaCantidadXMes.add(registroVacunaDatoLocal.cantRegistroPorMes(vac, i, anio));
    	} ;
    	return listaCantidadXMes;
    }
    
    public List<Integer> cantRegistroPorSexo(DTVacuna vacuna, int anio) {
    	Vacuna vac = vacunaDatoLocal.obtenerVacunaPorId(vacuna.getId());
    	List<Integer> listaCantidadXSexo = new ArrayList<Integer>();
    	listaCantidadXSexo.add(registroVacunaDatoLocal.cantRegistroPorSexo(vac, Sexo.Mujer, anio));
    	listaCantidadXSexo.add(registroVacunaDatoLocal.cantRegistroPorSexo(vac, Sexo.Hombre, anio));
    	return listaCantidadXSexo;
    }
    
    public List<Integer> cantRegistroPorEdad(DTVacuna vacuna, int anio){
    	Vacuna vac = vacunaDatoLocal.obtenerVacunaPorId(vacuna.getId());
    	List<Integer> listaCantidadXEdad = new ArrayList<Integer>();
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 0, 11, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 12, 18, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 19, 25, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 26, 40, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 41, 60, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 61, 75, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 75, 150, anio));
    	return listaCantidadXEdad;
    }
    
}
