package negocio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import javax.ws.rs.core.Response;

import org.springframework.web.util.UriComponentsBuilder;

import datatypes.DTAgenda;
import datatypes.DTAsignarVacunadores;
import datatypes.DTVacunatorio;
import datos.UbicacionDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
import entidades.Ubicacion;
import entidades.Vacunador;
import entidades.Vacunatorio;


/**
 * Session Bean implementation class VacunatorioNegocio
 */
@Stateless
@LocalBean
public class VacunatorioNegocio implements VacunatorioNegocioRemote, VacunatorioNegocioLocal {

	@Resource
	TimerService timerService;
	
	@EJB
	private VacunatorioDatoLocal vacunatorioLocal; 
	
	@EJB
	private UbicacionDatoLocal ubicacionLocal; 
	
    /**
     * Default constructor. 
     */
    public VacunatorioNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio) throws Exception{
		if (vacunatorioLocal.existeVacunatorio(dtVacunatorio.getCodigo()))
			throw new Exception("\nYa existe un vacunatorio con el codigo ingresado");
	else {
		Vacunatorio vacunatorio = new Vacunatorio(dtVacunatorio);
		Ubicacion ubi = this.ubicacionLocal.obtenerUbicacionPorId(dtVacunatorio.getUbicacion().getId());
		vacunatorio.setUbicacion(ubi);
		this.vacunatorioLocal.agregarVacunatorio(vacunatorio);
		ubi.setVacunatorio(vacunatorio);
		this.ubicacionLocal.actualizarVacunatorio(ubi);
		
	}
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
			
		Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(vacunatorioSeleccionado.getId());
		vac.setCantidadPuestos(vacunatorioSeleccionado.getCantidadPuestos());
		vac.setCodigo(vacunatorioSeleccionado.getCodigo());
		vac.setNombre(vacunatorioSeleccionado.getNombre());
	
		vacunatorioLocal.editarVacunatorio(vac);
			
	}

	@Override
	public void eliminarVacunatorio(DTVacunatorio vacunatorio) throws Exception {
		Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(vacunatorio.getId());
		if (vac != null) {
			if (vac.getAgendas().isEmpty()) {
				Ubicacion ubi = this.ubicacionLocal.obtenerUbicacionPorId(vacunatorio.getUbicacion().getId());
				ubi.eliminarVacunatorio();
				this.ubicacionLocal.actualizarVacunatorio(ubi);
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
    
    @Schedule(second="59", minute="*/3", hour="0-23", dayOfWeek="*", month="*", year="*", info="TimerSocioLogistico")
    private void asignarVacunadores(final Timer t) {
    	
    	List<Integer> vacunadores = new ArrayList<Integer>();
    		vacunadores.add(4804);
    		vacunadores.add(4805);
    		String fecha = "2021-06-20";
    	DTAsignarVacunadores vac = new DTAsignarVacunadores(fecha,vacunadores);
    	
    	//String url = "http://localhost:8080/periferico-vacunatorio/rest/vacunatorio/asignarVacunadores";
    	
    	// Cliente para la conexión
        Client client = ClientBuilder.newClient();
       /*UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("fecha", "2021-06-19")
                .queryParam("cedula", 56789);
     */
    // Definición de URL
       WebTarget target = client.target("https://periferico-vacunatorio.herokuapp.com/periferico-vacunatorio/rest/vacunatorio" + "/asignarVacunadores");
    
       /* 
     // Definición de URL
        WebTarget target = client.target(builder.buildAndExpand().toUri());
        
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("puesto" + response);
 	*/
        // Recogemos el resultado en una variable String
       String response1 = target.request().post(Entity.entity(vac, MediaType.APPLICATION_JSON), String.class);
      System.out.println("response: "+ response1);
	
    	
    }
    
    }

