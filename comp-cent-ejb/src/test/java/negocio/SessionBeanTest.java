package negocio;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

public class SessionBeanTest {
	
	@Mock
	private UsuarioNegocio usuarioNegocio;
	
	@InjectMocks
	private SessionBean sessionBean;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIniciarSesion() {
		Boolean b = true;
		Mockito.when(usuarioNegocio.autenticarUsuario(any(Integer.class), any(String.class))).thenReturn(b);
		
		Boolean t = sessionBean.iniciarSesion(112233, "112233");
		assertEquals(b,t);
	}
	
	@Test
	public void testIniciarSesionElse() {
		Boolean b = false;
		Mockito.when(usuarioNegocio.autenticarUsuario(any(Integer.class), any(String.class))).thenReturn(b);
		
		Boolean t = sessionBean.iniciarSesion(112233, "112233");
		assertEquals(b,t);
	}	

}
