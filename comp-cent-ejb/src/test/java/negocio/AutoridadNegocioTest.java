package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datos.AutoridadDatoLocal;
import entidades.Autoridad;

public class AutoridadNegocioTest {
	@Mock
	private AutoridadDatoLocal datoLocal ;
	
	@InjectMocks
	private AutoridadNegocio autoridadNegocio;
	
	private static Autoridad mockedAutoridad;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testObtenerAutoridadPorCi() {
		mockedAutoridad = Mockito.mock(Autoridad.class);
		Mockito.when(datoLocal.obtenerAutoridadPorCI(12345678)).thenReturn(mockedAutoridad);
				
				
				Autoridad autoridad = autoridadNegocio.obtenerAutoridadPorCi(12345678);
				assertEquals(mockedAutoridad, autoridad);
	}
}
