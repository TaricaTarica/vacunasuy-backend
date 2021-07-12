package negocio;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTAgenda;
import datatypes.DTRegistroVacuna;
import datatypes.DTVacuna;
import datos.CiudadanoDatoLocal;
import datos.RegistroVacunaDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunaDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Ciudadano;
import entidades.Enfermedad;
import entidades.RegistroVacuna;
import entidades.Reserva;
import entidades.Usuario;
import entidades.Vacuna;
import enumeradores.Sexo;

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
	private static DTVacuna dtVacuna;
	private static Enfermedad enfermedad;
	private static Reserva reserva;
	private static Ciudadano usuario;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		usuario = new Ciudadano();
		usuario.setFnac(LocalDate.now());
		dtVacuna = Mockito.mock(DTVacuna.class);
		vacuna = new Vacuna();
		vacuna.setId(1);
		vacuna.setDosis(3);
		enfermedad = Mockito.mock(Enfermedad.class);
		reserva = new Reserva();
		registro = new RegistroVacuna();
		registro.setFecha(LocalDate.now());
		vacuna.setEnfermedad(enfermedad);
		registro.setVacuna(vacuna);
		registro.setReserva(reserva);
		registro.setCiudadano(usuario);
		registros = new ArrayList<RegistroVacuna>();
		registros.add(registro);
		dtRegistro = new DTRegistroVacuna(1111, registro.getVacuna().getId(),1,reserva.getId(),LocalDate.now().toString());
		dtRegistros = new ArrayList<DTRegistroVacuna>();
		dtRegistros.add(dtRegistro);
		
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
		Mockito.when(ciudadanoDatoLocal.obtenerCiudadano(any(Integer.class))).thenReturn(usuario);
		Mockito.when(reservaDatoLocal.obtenerReserva(any(Long.class))).thenReturn(reserva);
		Mockito.when(vacunaDatoLocal.obtenerVacunaPorId(any(Long.class))).thenReturn(vacuna);
		Mockito.doNothing().when(registroVacunaDatoLocal).agregarRegistroVacuna(any(RegistroVacuna.class));
		rvn.altaRegistroVacuna(dtRegistros);
		Mockito.verify(registroVacunaDatoLocal ,Mockito.times(1)).agregarRegistroVacuna(any(RegistroVacuna.class));
	}
	
	@Test
	public void testObtenerCantVac() {
		Integer numero= 0;
		Mockito.when(vacunaDatoLocal.obtenerVacunaPorId(any(Long.class))).thenReturn(vacuna);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorMes(any(Vacuna.class), any(Integer.class), any(Integer.class))).thenReturn(numero);
		
		assert(rvn.obtenerCantVac(dtVacuna, 2020) != null);
	}
	
	@Test
	public void testCantRegistroPorSexo() {
		Integer numero= 1;
		Mockito.when(vacunaDatoLocal.obtenerVacunaPorId(any(Long.class))).thenReturn(vacuna);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorSexo(any(Vacuna.class), any(Sexo.class), any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorSexo(any(Vacuna.class), any(Sexo.class), any(Integer.class))).thenReturn(numero);
		assert(rvn.cantRegistroPorSexo(dtVacuna, 2020) != null);
	}
	
	@Test
	public void testCantRegistroPorEdad() {
		Integer numero= 1;
		Mockito.when(vacunaDatoLocal.obtenerVacunaPorId(any(Long.class))).thenReturn(vacuna);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		Mockito.when(registroVacunaDatoLocal.cantRegistroPorEdad(any(Vacuna.class), any(Integer.class),any(Integer.class),  any(Integer.class))).thenReturn(numero);
		assert(rvn.cantRegistroPorEdad(dtVacuna, 2020).size()==7);

	}
	
	@Test
	public void testCountVacunadosHoy() {
		Mockito.when(registroVacunaDatoLocal.obtenerRegistro()).thenReturn(registros);
		assert(rvn.countVacunadosHoy(vacuna.getId())==1);
	}
	
	@Test
	public void testCountVacunadosPorMes() {
		Mockito.when(registroVacunaDatoLocal.obtenerRegistro()).thenReturn(registros);
		rvn.countVacunadosPorMes(registro.getVacuna().getId(), 2020);
	}
	/*
	@Test
	public void testCountVacunadosPorDepartamento() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void testObtenerCertificadoReserva() {
		Mockito.when(registroVacunaDatoLocal.obtenerCertificadoReserva(any(Long.class))).thenReturn(registro);
		assert(rvn.obtenerCertificadoReserva(1)!=null);
		
	}
	
	@Test
	public void testCantVacHastaFecha() {
		int numero= 2 ;
		Mockito.when(registroVacunaDatoLocal.cantVacHastaFecha(any(Long.class),any(LocalDate.class))).thenReturn(numero);
		assert (rvn.cantVacHastaFecha(vacuna.getId(), LocalDate.now()) == numero);
	}

}
