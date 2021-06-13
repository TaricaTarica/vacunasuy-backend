package webservicesoapTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import webservicesoap.DtMsjVacunatorio;
import webservicesoap.VacunatorioServicio;
import webservicesoap.VacunatorioServicioService;

public class VacunatorioServicioTest {

	@Test
	public void test() {
		VacunatorioServicio servicio = new VacunatorioServicioService().getVacunatorioServicioPort();
		List <Integer> cedulas = new ArrayList<Integer>();
		cedulas.add(4804);
		cedulas.add(508);
		DtMsjVacunatorio msj  =servicio.asignarVacunadores("2021-05-06", "hfx09", cedulas);
		
			System.out.println(msj.getMensaje());
	
		
		assertTrue (msj!=null);
	}

}
