package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTVacunatorio;
import datos.VacunatorioDatoLocal;
import entidades.Vacunatorio;

/**
 * Session Bean implementation class VacunatorioNegocio
 */
@Stateless
@LocalBean
public class VacunatorioNegocio implements VacunatorioNegocioRemote, VacunatorioNegocioLocal {

	@EJB
	private VacunatorioDatoLocal vacunatorioLocal; 
	
    /**
     * Default constructor. 
     */
    public VacunatorioNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio){
		Vacunatorio vacunatorio = new Vacunatorio(dtVacunatorio);
		this.vacunatorioLocal.agregarVacunatorio(vacunatorio);
	}
	
	public List<DTVacunatorio> listarVacunatorio(){
		List <Vacunatorio> vacunatorio = (ArrayList<Vacunatorio>)(this.vacunatorioLocal.listarVacunatorio());
		List <DTVacunatorio> dtVacunatorio = new ArrayList<DTVacunatorio>();
		vacunatorio.forEach((v)->{dtVacunatorio.add(new DTVacunatorio(v));});
		return dtVacunatorio;
	}
	
}
