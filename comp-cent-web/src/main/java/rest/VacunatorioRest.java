package rest;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.jws.WebMethod;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.util.UriComponentsBuilder;

import datatypes.DTRegistroVacuna;
import datatypes.DTReservaVacunatorio;


@RequestScoped
@Path("/vacunatorio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunatorioRest {

	public VacunatorioRest() throws NamingException {		

	}
	/*
	@WebMethod 
	public void altaRegistroVacuna(DTRegistroVacuna regVacuna) {
		registroNegocio.altaRegistroVacuna(regVacuna);
	}
	
	@WebMethod 
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (String fecha, long idVac){
		return reservaNegocio.obtenerReservasVacunatorio(LocalDate.parse(fecha), idVac);
	}*/
}
