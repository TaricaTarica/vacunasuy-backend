package negocio;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTRegistroVacuna;
import datos.CiudadanoDatoLocal;
import datos.RegistroVacunaDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunaDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Enfermedad;
import entidades.RegistroVacuna;
import entidades.Reserva;
import entidades.Vacuna;

import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroVacunaNegocioTest {
	@Mock
	private RegistroVacunaDatoLocal registroVacunaDatoLocal;
	@Mock
	private VacunaDatoLocal vacunaDatoLocal;
	@Mock
	private VacunatorioDatoLocal vacunatorioDatoLocal;
	@Mock
	private CiudadanoDatoLocal ciudadanoDatoLocal;
	@Mock
	private ReservaDatoLocal reservaDatoLocal;
	
	@InjectMocks
	private RegistroVacunaNegocio rvn;
	
	private static RegistroVacuna registro;
	private static DTRegistroVacuna dtRegistro;
	private static List<RegistroVacuna> registros;
	private static List<DTRegistroVacuna> dtRegistros;
	private static Vacuna vacuna;
	private static Enfermedad enfermedad;
	private static Reserva reserva;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		vacuna = new Vacuna();
		enfermedad = Mockito.mock(Enfermedad.class);
		reserva = Mockito.mock(Reserva.class);
		registro = new RegistroVacuna();
		registro.setFecha(LocalDate.now());
		vacuna.setEnfermedad(enfermedad);
		registro.setVacuna(vacuna);
		registro.setReserva(reserva);
		registros = new ArrayList<RegistroVacuna>();
		registros.add(registro);
		
	}

	@Test
	public void testObtenerCertificados() {
		Mockito.when(registroVacunaDatoLocal.obtenerRegistroPorCi(any(Integer.class))).thenReturn(registros);
		rvn.obtenerCertificados("1111111");
		assertEquals(registros.size(), rvn.obtenerCertificados("1111111").size());
	}

	@Test
	public void testListarRegistros() {
		Mockito.when(registroVacunaDatoLocal.obtenerRegistro()).thenReturn(registros);
		
		assertEquals(registros.size(),rvn.listarRegistros().size());
	}
	
	@Test
	public void testAltaRegistroVacuna() {
		fail("Not yet implemented");
	}
	/*
	@Test
	public void testObtenerCantVac() {
		fail("Not yet implemented");
	}

	@Test
	public void testCantRegistroPorSexo() {
		fail("Not yet implemented");
	}

	@Test
	public void testCantRegistroPorEdad() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountVacunadosHoy() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountVacunadosPorMes() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountVacunadosPorDepartamento() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerCertificadoReserva() {
		fail("Not yet implemented");
	}

	@Test
	public void testCantVacHastaFecha() {
		fail("Not yet implemented");
	}
*/
}
