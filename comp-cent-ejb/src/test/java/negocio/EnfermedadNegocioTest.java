package negocio;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTAgenda;
import datatypes.DTEnfermedad;
import datatypes.DTVacuna;
import datos.EnfermedadDatoLocal;
import entidades.Enfermedad;
import entidades.Vacuna;
import entidades.Vacunatorio;
import enumeradores.PoblacionObjetivo;

import static org.mockito.ArgumentMatchers.any;

public class EnfermedadNegocioTest {
	@Mock
	private EnfermedadDatoLocal datoLocal;
	@Mock
	private EnfermedadNegocioLocal nLocal;
	@InjectMocks
	private EnfermedadNegocio en;
	
	private static List<Enfermedad> enfermedades;
	private static List<Vacuna> vacunas;
	private static Enfermedad enfermedad;
	private static List<String> enumeradores;
	private static DTEnfermedad dtEnfermedad;
	
	private static Vacuna vacuna;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		enfermedad = new Enfermedad();
		enfermedad.setFechaCreacion(LocalDate.now());
		vacuna = Mockito.mock(Vacuna.class);
		vacunas = new ArrayList<Vacuna>();
		vacunas.add(vacuna);
		enfermedad.setVacunas(vacunas);
		enfermedades = new ArrayList<Enfermedad>();
		enfermedades.add(enfermedad);
		
		enumeradores = Stream.of(PoblacionObjetivo.values())
                .map(Enum::name)
                .collect(Collectors.toList());
	}

	@Test
	public void testListarEnfermedades() {
		Mockito.when(datoLocal.listarEnfermedades()).thenReturn(enfermedades);
		List<DTEnfermedad> dtEnfermedades = en.listarEnfermedades();
		assertEquals(enfermedades.size(), dtEnfermedades.size());
	}

	@Test
	public void testAgregarEnfermedad() throws Exception {
		Mockito.doNothing().when(datoLocal).agregarEnfermedad(Mockito.isA(Enfermedad.class));
		datoLocal.agregarEnfermedad(Mockito.isA(Enfermedad.class));
		en.agregarEnfermedad("prueba");
		Mockito.verify(datoLocal ,Mockito.times(1)).agregarEnfermedad(Mockito.isA(Enfermedad.class));
	}
	
	@Test(expected = Exception.class)
	public void testAgregarEnfermedadException() throws Exception {
		Mockito.when(datoLocal.existeEnfermedad("prueba")).thenReturn(true);
		en.agregarEnfermedad("prueba");
	}
	
	@Test
	public void testBuscarEnfermedad() throws Exception {
		Mockito.when(datoLocal.existeEnfermedad("prueba")).thenReturn(true);
		Mockito.when(datoLocal.buscarEnfermedad("prueba")).thenReturn(enfermedad);
		DTEnfermedad dtEnf = en.buscarEnfermedad("prueba");
		assertTrue(dtEnf!=null);
	}
	
	@Test(expected = Exception.class)
	public void testBuscarEnfermedadTrowException() throws Exception {
		Mockito.when(datoLocal.existeEnfermedad("prueba")).thenReturn(false);
		
		DTEnfermedad enf = en.buscarEnfermedad("prueba");
		//assertTrue(dtEnf==null);
	}
	
	@Test
	public void testListarVacunasPorEnfermedad() throws Exception {
		Mockito.when(datoLocal.existeEnfermedad("prueba")).thenReturn(true);
		Mockito.when(datoLocal.buscarEnfermedad("prueba")).thenReturn(enfermedad);
		List<DTVacuna> vac = en.listarVacunasPorEnfermedad("prueba");
		assertTrue(vac!=null);
	}
	
	@Test(expected = Exception.class)
	public void testListarVacunasPorEnfermedadException() throws Exception {
		Mockito.when(datoLocal.existeEnfermedad("prueba")).thenReturn(false);
		List<DTVacuna> vac = en.listarVacunasPorEnfermedad("prueba");
		//assertTrue(vac!=null);
	}
	
	@Test
	public void testListarPoblacionObjetivo() {
		Mockito.when(nLocal.listarPoblacionObjetivo()).thenReturn(enumeradores);
		List<String> result = en.listarPoblacionObjetivo();
		assertEquals(enumeradores,result);

	}

	@Test
	public void testEliminarEnfermedad() throws Exception {
		Mockito.when(datoLocal.buscarEnfermedad("prueba")).thenReturn(enfermedad);
		Mockito.doNothing().when(datoLocal).eliminarEnfermedad(enfermedad);
		en.eliminarEnfermedad("prueba");
		Mockito.verify(datoLocal ,Mockito.times(1)).eliminarEnfermedad(enfermedad);
		
	}
	
	@Test(expected = Exception.class)
	public void testEliminarEnfermedadException() throws Exception {
		Mockito.when(datoLocal.buscarEnfermedad("prueba")).thenReturn(null);
		en.eliminarEnfermedad("prueba");
		
		
	}
	
	@Test
	public void testObtenerEnfermedadPorId() {
		Mockito.when(datoLocal.obtenerEnfermedadPorId(any(Long.class))).thenReturn(enfermedad);
		DTEnfermedad enf = en.obtenerEnfermedadPorId(any(Long.class));
		assertEquals(enfermedad.getFechaCreacion().toString(), enf.getFechaCreacion());
	}

	@Test
	public void testEditarEnfermedad() throws Exception {
		Mockito.when(datoLocal.obtenerEnfermedadPorId(any(Long.class))).thenReturn(enfermedad);
		Mockito.doNothing().when(datoLocal).editarEnfermedad(enfermedad);
		dtEnfermedad = new DTEnfermedad(enfermedad);
		en.editarEnfermedad(dtEnfermedad);
		Mockito.verify(datoLocal ,Mockito.times(1)).editarEnfermedad(enfermedad);
	}
	
	@Test(expected = Exception.class)
	public void testEditarEnfermedadException() throws Exception {
		Mockito.when(datoLocal.obtenerEnfermedadPorId(any(Long.class))).thenReturn(null);
		dtEnfermedad = new DTEnfermedad(enfermedad);
		en.editarEnfermedad(dtEnfermedad);
	}
}
