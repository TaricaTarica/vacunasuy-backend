package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTEnfermedad;
import datatypes.DTVistaEnvio;
import datos.EnvioDatoLocal;
import enumeradores.EstadoEnvio;

public class VistaEnvioNegocioTest {
	
	@Mock
	private EnvioDatoLocal envioLocal;
	
	@InjectMocks
	VistaEnvioNegocio vistaEnvioNegocio;	
	
	private static List<DTVistaEnvio> envios;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		envios = new ArrayList<DTVistaEnvio>();
	}

	@Test
	public void testListarEnvios() {
		Mockito.when(envioLocal.ListarEnviosVista()).thenReturn(envios);
		assertTrue(vistaEnvioNegocio.listarEnvios().isEmpty());
	}

}
