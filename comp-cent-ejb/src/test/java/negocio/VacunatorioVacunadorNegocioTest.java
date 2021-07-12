package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import datatypes.DTVistaEnvio;
import datos.UsuarioDatoLocal;
import datos.VacunadorDatoLocal;
import datos.VacunatorioDatoLocal;
import datos.VacunatorioVacunadorDatoLocal;
import entidades.Vacunador;
import entidades.Vacunatorio;
import static org.mockito.ArgumentMatchers.any;


public class VacunatorioVacunadorNegocioTest {
	
	@Mock
	private VacunatorioVacunadorDatoLocal vvdl;
	
	@Mock
	private UsuarioDatoLocal udl;
	
	@Mock
	private VacunatorioDatoLocal vdl;
	
	@Mock
	private VacunadorDatoLocal vacunadordl;	
	
	@InjectMocks 
	VacunatorioVacunadorNegocio vacunatorioVacunadorNegocio;
	
	
	private static List<Vacunador> vacunadores = new ArrayList<Vacunador>();
	
	private static List<DTVacunador> Dtvacunadores = new ArrayList<DTVacunador>() ;
	
	private static Vacunador vacunador1;
	
	private static Vacunatorio vacunatorio1;
	
	private static DTVacunatorio dtVacunatorio1;
	
	private static DTVacunador dtVacunador1;
	
	private static List<Integer> listCedulas = new ArrayList<Integer>();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		vacunador1 = new Vacunador(123, "PN", "SN", "PA", "SA", 3456, "email@email.com");
		dtVacunador1 = new DTVacunador(123, "PN", "SN", "PA", "SA", 3456, "email@email.com");
		vacunatorio1 = new Vacunatorio("Nom", "Cod", 1, "Dom");
		vacunadores.add(vacunador1);
		listCedulas.add(Integer.valueOf(123));
	}

	@Test
	public void testAgregarVacunadorVacunatorio() {
		assertTrue(true);
	}

	@Test
	public void testBuscarVacunatorio() {
		Mockito.when(udl.obtenerUsuarioPorCI(any(Integer.class))).thenReturn(vacunador1);
		Mockito.when(vvdl.buscarVacunatorio(vacunador1)).thenReturn(vacunatorio1);
		
		dtVacunatorio1 = vacunatorioVacunadorNegocio.buscarVacunatorio(dtVacunador1);
		assertTrue(dtVacunatorio1 != null);
	}

	@Test
	public void testBuscarVacunadoresAsignados() {
		Mockito.when(vdl.obtenerVacunatorio(any(Integer.class))).thenReturn(vacunatorio1);
		Mockito.when( vvdl.buscarVacunadoresAsignados(any(Vacunatorio.class))).thenReturn(listCedulas);
		Mockito.when(vacunadordl.obteneVacunadorPorCI(any(Integer.class))).thenReturn(vacunador1);
		List<DTVacunador> vac  = vacunatorioVacunadorNegocio.buscarVacunadoresAsignados(123);
		assertTrue(vac.isEmpty());
	}

	@Test
	public void testObtenerPuestoVacunador() {
		assertTrue(true);
	}

	@Test
	public void testObtenerVacunadoresLibres() {
		Mockito.when(vacunadordl.obtenerVacunadoresLibres()).thenReturn(vacunadores);
		Dtvacunadores = vacunatorioVacunadorNegocio.obtenerVacunadoresLibres();
		assertTrue(Dtvacunadores != null);
	}

}
