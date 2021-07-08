package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datos.AdministradorDatoLocal;
import entidades.Administrador;

public class AdministradorNegocioTest {
	@Mock
	AdministradorNegocioLocal mockedAdministradorNegocioLocal;
	@Mock
	AdministradorDatoLocal mockedAdministradorDatoLocal; 
	@Mock
	Administrador mockedAdministrador;
	
	@InjectMocks
	AdministradorNegocio administradorNegocio;
	
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testObtenerAdministradorPorCi() {
		mockedAdministrador = Mockito.mock(Administrador.class);
		Mockito.when(mockedAdministradorDatoLocal.obtenerAdministradorPorCI(456)).thenReturn(mockedAdministrador);
				
				
				Administrador admin = administradorNegocio.obtenerAdministradorPorCi(456);
				assertEquals(mockedAdministrador, admin);
		//fail("Not yet implemented");
	}

}
