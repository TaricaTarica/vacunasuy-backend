package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.web.util.UriComponentsBuilder;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import datatypes.DTVacunatorioVacunador;
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
	
	@EJB
	private UsuarioDatoLocal udl;
	
	@EJB
	private VacunatorioDatoLocal vdl;
	
	@EJB
	private VacunadorDatoLocal vacunadordl;
	
    /**
     * Default constructor. 
     */
    public VacunatorioVacunadorNegocio() {
        // TODO Auto-generated constructor stub
    }

    public void agregarVacunadorVacunatorio(DTVacunatorioVacunador dtVacunatorioVacunador) throws Exception {
    
    	Vacunatorio vacunatorio = vdl.obtenerVacunatorio(dtVacunatorioVacunador.getDtVacunatorio().getId());
    	List<Integer> cedulas = new ArrayList<Integer>();
    	for(DTVacunador v : dtVacunatorioVacunador.getDtVacunador()) {
    		cedulas.add(v.getCi());
    	}
    	if (vvdl.existeVacunatorio(dtVacunatorioVacunador.getDtVacunatorio().getId())){
    		List<VacunatorioVacunador> vv = vvdl.obtenerVacunatoriosVacunadores(dtVacunatorioVacunador.getDtVacunatorio().getId());
    		for (VacunatorioVacunador v : vv) {
    			vvdl.quitarVacunadorVacunatorio(v);
    		}
    	}
    	
    	// Cliente para la conexión
        Client client = ClientBuilder.newClient();
       
    // Definición de URL
       WebTarget target = client.target(dtVacunatorioVacunador.getDtVacunatorio().getDominio() + "/asignarVacunadores");
   try { 
        // Recogemos el resultado en una variable String
       Boolean response = target.request().post(Entity.entity(cedulas, MediaType.APPLICATION_JSON), Boolean.class);
  
       if (!response) {
       		
       		throw new Exception("\n No se ingresaron vacunadores");
       	}else {
    	
	    	for(DTVacunador v : dtVacunatorioVacunador.getDtVacunador()) {
	    	Vacunador vacunador = vacunadordl.obteneVacunadorPorCI(v.getCi());
	    	cedulas.add(v.getCi());
	    	VacunatorioVacunador vacunatorioVacunador = new VacunatorioVacunador(vacunatorio,vacunador);
	    	vvdl.agregarVacunadorVacunatorio(vacunatorioVacunador);
	    	}
       	}
   	}  catch (Exception e) {
   		throw new Exception(e.getMessage());
   }    
    	 
    
}
       
    
    
    public DTVacunatorio buscarVacunatorio(DTVacunador dtVacunador) {
		Vacunador vacunador = (Vacunador) udl.obtenerUsuarioPorCI(dtVacunador.getCi());
		return new DTVacunatorio(vvdl.buscarVacunatorio(vacunador));
	}
	
    public List<DTVacunador> buscarVacunadoresAsignados(long id){
    	Vacunatorio vacunatorio = vdl.obtenerVacunatorio(id);
    	List<Vacunador> vacunadores = new ArrayList<Vacunador>();
    	List<Integer> listCedulas = vvdl.buscarVacunadoresAsignados(vacunatorio);
    	for(Integer i : listCedulas) {
    		vacunadores.add(vacunadordl.obteneVacunadorPorCI(i));
    	}
    	List<DTVacunador> listDTVacunadores = new ArrayList<DTVacunador>();
    	for (Vacunador vac : vacunadores) {
    		DTVacunador dtVacunador = new DTVacunador(vac);
    		listDTVacunadores.add(dtVacunador);
    	}
		return listDTVacunadores;
	}
    
    public Integer obtenerPuestoVacunador(DTVacunador dtVacunador,DTVacunatorio dtVacunatorio) {
    	// Cliente para la conexión
        Client client = ClientBuilder.newClient();
       UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(dtVacunatorio.getDominio() + "/obtenerPuesto")
                //.queryParam("fecha", fecha.toString())
                .queryParam("cedula", dtVacunador.getCi());
       // Definición de URL
       WebTarget target = client.target(builder.buildAndExpand().toUri());
       
       String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
       return Integer.parseInt(response);
    }
      
    public List<DTVacunador> obtenerVacunadoresLibres(){
    	List<Vacunador> vacunadores = vacunadordl.obtenerVacunadoresLibres();  
    	List<DTVacunador> lista = new ArrayList<DTVacunador>();
    	for (Vacunador v : vacunadores) {
    		DTVacunador vacunador = new DTVacunador(v);
    		lista.add(vacunador);
    	}
    	return lista;
      }
       
    
    
}
