package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTAgenda;
import datatypes.DTVacunatorio;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
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
	
	@Override
	public List<String> nombresVacunatorios() {
		
		List<DTVacunatorio> vacunatorio = listarVacunatorio();
		List<String> nombres = new ArrayList<String>();
		vacunatorio.forEach((v)->{nombres.add(v.getNombre());});
		return nombres;
    }
	@Override
	public DTAgenda obtenerAgendaActiva(long idVacunatorio) {
		Vacunatorio vacunatorio = vacunatorioLocal.obtenerVacunatorio(idVacunatorio);
		if(vacunatorio !=  null) {
			DTAgenda retorno = null;
			List<Agenda> agendas = vacunatorio.getAgendas();
			LocalDate fechaActual = LocalDate.now();
			for(Agenda a: agendas) {
				if((fechaActual.isAfter(a.getInicio()) || fechaActual.isEqual(a.getInicio()))  
						&& (fechaActual.isBefore(a.getFin()) || fechaActual.isEqual(a.getFin()))) {
					retorno = new DTAgenda(a);
				}
			}
			return retorno;
		}
		else {
			return null;
		}
	}
	
}
