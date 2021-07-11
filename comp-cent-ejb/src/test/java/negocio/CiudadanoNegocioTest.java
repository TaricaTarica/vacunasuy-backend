package negocio;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTAgenda;
import datatypes.DTCiudadano;
import datos.CiudadanoDatoLocal;
import entidades.Administrador;
import entidades.Ciudadano;

public class CiudadanoNegocioTest {
	@Mock
	private CiudadanoDatoLocal cdl;
	@Mock
	private CiudadanoNegocioLocal cnl;
	
	@InjectMocks
	private CiudadanoNegocio ciudadanoNegocio;
	
	private static DTCiudadano dtCiudadano;
	private static Ciudadano ciudadano;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		dtCiudadano = new DTCiudadano();
		dtCiudadano.setFnac("1996-01-01");
	}

	@Test
	public void testAgregarCiudadano() {
		Mockito.doNothing().when(cnl).agregarCiudadano(Mockito.isA(DTCiudadano.class));
		cnl.agregarCiudadano(dtCiudadano);
		ciudadanoNegocio.agregarCiudadano(dtCiudadano);
		Mockito.verify(cnl ,Mockito.times(1)).agregarCiudadano(dtCiudadano);
	}

	@Test
	public void testObtenerCiudadano() {
		ciudadano = new Ciudadano();
		ciudadano.setCi(12345678);
		ciudadano.setFnac(LocalDate.now());
		Mockito.when(cdl.obtenerCiudadano(12345678)).thenReturn(ciudadano);
				
				
				DTCiudadano ciu = ciudadanoNegocio.obtenerCiudadano(12345678);
				assertEquals(ciudadano.getCi(),ciu.getCi());
	}

	@Test
	public void testExisteCiudadano() {
		Boolean b = true;
		Mockito.when(cdl.existeCiudadano(12345678)).thenReturn(b);
		
		Boolean t = ciudadanoNegocio.existeCiudadano(12345678);
		assertEquals(b,t);
	}

}
