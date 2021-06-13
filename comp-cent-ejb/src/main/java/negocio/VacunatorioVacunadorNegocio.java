package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import datos.UsuarioDatoLocal;
import datos.VacunadorDatoLocal;
import datos.VacunatorioDatoLocal;
import datos.VacunatorioVacunadorDatoLocal;
import entidades.Vacunador;
import entidades.Vacunatorio;
import entidades.VacunatorioVacunador;

/**
 * Session Bean implementation class VacunatorioVacunadorNegocio
 */
@Stateless
@LocalBean
public class VacunatorioVacunadorNegocio implements VacunatorioVacunadorNegocioLocal {

	@EJB
	private VacunatorioVacunadorDatoLocal vvdl;
	
	private UsuarioDatoLocal udl;
	
	private VacunatorioDatoLocal vdl;
	
	private VacunadorDatoLocal vacunadordl;
	
    /**
     * Default constructor. 
     */
    public VacunatorioVacunadorNegocio() {
        // TODO Auto-generated constructor stub
    }

    public void agregarVacunadorVacunatorio(DTVacunatorioVacunador dtVacunatorioVacunador) {
    	Vacunatorio vacunatorio = vdl.obtenerVacunatorio(dtVacunatorioVacunador.getDtVacunatorio().getId());
    	Vacunador vacunador = vacunadordl.obteneVacunadorPorCI(dtVacunatorioVacunador.getDtVacunador().getCi());
    	VacunatorioVacunador vacunatorioVacunador = new VacunatorioVacunador(vacunatorio,vacunador,dtVacunatorioVacunador.getFecha());
    	vvdl.agregarVacunadorVacunatorio(vacunatorioVacunador);
    }
    
    public DTVacunatorio buscarVacunatorio(DTVacunador dtVacunador, LocalDate fecha) {
		Vacunador vacunador = (Vacunador) udl.obtenerUsuarioPorCI(dtVacunador.getCi());
		return new DTVacunatorio(vvdl.buscarVacunatorio(vacunador, fecha));
	}
	
    public List<DTVacunador> buscarVacunadoresAsignados(DTVacunatorio dtVacunatorio, LocalDate fecha){
    	Vacunatorio vacunatorio = vdl.obtenerVacunatorio(dtVacunatorio.getId());
    	List<Vacunador> listVacunadores = vvdl.buscarVacunadoresAsignados(vacunatorio, fecha);
    	List<DTVacunador> listDTVacunadores = new ArrayList<DTVacunador>();
    	for (Vacunador vac : listVacunadores) {
    		DTVacunador dtVacunador = new DTVacunador(vac);
    		listDTVacunadores.add(dtVacunador);
    	}
		return listDTVacunadores;
	}
    
}
