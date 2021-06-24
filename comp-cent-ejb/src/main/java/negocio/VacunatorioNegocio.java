package negocio;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


import datatypes.DTAgenda;
import datatypes.DTAsignarVacunadores;
import datatypes.DTUbicacion;
import datatypes.DTVacunatorio;
import datos.UbicacionDatoLocal;
import datos.VacunatorioDatoLocal;
import datos.VacunatorioVacunadorDatoLocal;
import entidades.Agenda;
import entidades.Ubicacion;
import entidades.Vacunador;
import entidades.Vacunatorio;

/**
 * Session Bean implementation class VacunatorioNegocio
 */
@Stateless
@LocalBean
public class VacunatorioNegocio implements VacunatorioNegocioLocal {

	@Resource
	TimerService timerService;
	
	@EJB
	private VacunatorioDatoLocal vacunatorioLocal; 
	
	@EJB
	private UbicacionDatoLocal ubicacionLocal; 
	
	@EJB
	private VacunatorioVacunadorDatoLocal vvLocal; 
	
    /**
     * Default constructor. 
     */
    public VacunatorioNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio) throws Exception{
		if (vacunatorioLocal.existeVacunatorio(dtVacunatorio.getCodigo()))
			throw new Exception("\nYa existe un vacunatorio con el codigo ingresado");
		else if (ubicacionLocal.obtenerUbicacionPorId(dtVacunatorio.getUbicacion().getId()).getVacunatorio() != null) {
			throw new Exception("\nYa existe un vacunatorio en la ubicacion seleccionada");
		}
	else {
		Vacunatorio vacunatorio = new Vacunatorio(dtVacunatorio);
		Ubicacion ubi = this.ubicacionLocal.obtenerUbicacionPorId(dtVacunatorio.getUbicacion().getId());
		
		vacunatorio.agregarUbicacion(ubi);
		this.vacunatorioLocal.agregarVacunatorio(vacunatorio);
		ubi.setVacunatorio(vacunatorio);
		this.ubicacionLocal.actualizarVacunatorio(ubi);
	}
	}
	
	public List<DTVacunatorio> listarVacunatorio(){
		List <Vacunatorio> vacunatorio = (ArrayList<Vacunatorio>)(this.vacunatorioLocal.listarVacunatorio());
		List <DTVacunatorio> dtVacunatorio = new ArrayList<DTVacunatorio>();
		vacunatorio.forEach((v)->{DTVacunatorio dtVac = new DTVacunatorio(v); dtVac.setUbicacion(new DTUbicacion(ubicacionLocal.obtenerUbicacionVacunatorio(v.getId())));dtVacunatorio.add(dtVac);});
		
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
				else{
					if(fechaActual.isBefore(a.getFin())) {
						retorno = new DTAgenda(a);
					}
				}
			}

			return retorno;
		}
		else {
			return null;
		}
	}
	
	@Override
	public DTVacunatorio obtenerVacunatorioPorCodigo(String codigo) throws Exception {
	if (vacunatorioLocal.existeVacunatorio(codigo)) {
		Vacunatorio vacunatorio = vacunatorioLocal.obtenerVacunatorioPorCodigo(codigo);
		DTVacunatorio dtVacunatorio = new DTVacunatorio(vacunatorio);
		
		    return dtVacunatorio;
	}
	else {
		throw new Exception("\nNo existe un Vacunatorio con el codigo ingresado");
	}
	}

	@Override
	public void editarVacunatorio(DTVacunatorio vacunatorioSeleccionado) throws Exception {
		
		int cantVacunadoresAsignados = vvLocal.obtenerVacunatoriosVacunadores(vacunatorioSeleccionado.getId()).size();
		if (cantVacunadoresAsignados>vacunatorioSeleccionado.getCantidadPuestos()) {
			throw new Exception("\nLa cantidad de puestos no puede ser menor a la cantidad de vacunadores asignados actualmente: " + cantVacunadoresAsignados);
		}else {
		Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(vacunatorioSeleccionado.getId());
		vac.setCantidadPuestos(vacunatorioSeleccionado.getCantidadPuestos());
		vac.setCodigo(vacunatorioSeleccionado.getCodigo());
		vac.setNombre(vacunatorioSeleccionado.getNombre());
		vac.setDominio(vacunatorioSeleccionado.getDominio());
	
		vacunatorioLocal.editarVacunatorio(vac);
		}
			
	}

	@Override
	public void eliminarVacunatorio(DTVacunatorio vacunatorio) throws Exception {
		Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(vacunatorio.getId());
		if (vac != null) {
			if (vac.getAgendas().isEmpty()) {
				//vac.eliminarUbicacion();
				//ubicacionLocal.eliminarVacunatorio(vac.getId());
			//	Ubicacion ubi = this.ubicacionLocal.obtenerUbicacionPorId(vacunatorio.getUbicacion().getId());
			//	ubi.setVacunatorio(new Vacunatorio());
			//	this.ubicacionLocal.actualizarVacunatorio(ubi);
				vacunatorioLocal.eliminarVacunatorio(vac);
			}else 
				throw new Exception("\nNo se puede eliminar el vacunatorio, porque tiene agendas asociadas");
			
		
		}else {
			throw new Exception("\nNo se encontro un vacunatorio con el id ingresado");
		}
			
		
	}
	public void setTimer(long interval) {
    	timerService.createTimer(interval, "Seteando timer");
    }
   
    
 }

