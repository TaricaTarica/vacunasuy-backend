package negocio;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTDepartamento;
import datatypes.DTPlanVacunacion;
import datatypes.DTUbicacion;
import datos.DepartamentoDatoLocal;
import entidades.Departamento;
import entidades.Ubicacion;
import entidades.Vacunatorio;

public class DepartamentoNegocioTest {
	@Mock
	private DepartamentoDatoLocal md;
	@InjectMocks
	private DepartamentoNegocio dn;
	
	private static ArrayList<Departamento> departamentos;
	private static List<Ubicacion> ubicaciones;
	private static Ubicacion ubicacion;
	private static Departamento departamento;
	private static Vacunatorio vacunatorio;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		departamento = new Departamento();
		departamentos = new ArrayList<Departamento>();
		ubicacion = new Ubicacion();
		vacunatorio = Mockito.mock(Vacunatorio.class);
		ubicacion.setVacunatorio(vacunatorio);
		ubicacion.setDescripcion("prueba");
		ubicacion.setId(1);
		ubicaciones = new ArrayList<Ubicacion>();
		ubicaciones.add(ubicacion);
		departamento.setUbicaciones(ubicaciones);
		departamentos.add(departamento);
		
		
	}

	@Test
	public void testObtenerDepartamentos() {
		Mockito.when(md.obtenerDepartamentos()).thenReturn(departamentos);
		List<DTDepartamento> dptos = dn.obtenerDepartamentos();
		assertEquals(departamentos.size(),dptos.size());
		
	}
	
	@Test
	public void testObtenerDepartamentoUbicaciones() {
		Mockito.when(md.obtenerDepartamentoUbicaciones("prueba")).thenReturn(ubicaciones);
		List<DTUbicacion> ubis = dn.obtenerDepartamentoUbicaciones("prueba");
		assertEquals(ubicaciones.size(),ubis.size());
	}
	
	@Test
	public void testObtenerDepartamentoUbicacion() {
		Mockito.when(md.obtenerDepartamentoUbicacion("prueba", "prueba")).thenReturn(ubicacion);
		DTUbicacion ubi = dn.obtenerDepartamentoUbicacion("prueba", "prueba");
		assertEquals(ubicacion.getDescripcion(),ubi.getDescription());
	}
	
	@Test
	public void testObtenerDepartamentoPorUbicacion() {
		Mockito.when(md.obtenerDepartamentos()).thenReturn(departamentos);
		DTDepartamento dpto = dn.obtenerDepartamentoPorUbicacion(1);
		assertTrue(dpto!=null);
		
	}
	
}
