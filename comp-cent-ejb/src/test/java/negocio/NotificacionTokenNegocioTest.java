package negocio;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTEnvio;
import datatypes.DTNotificacionToken;
import datos.NotificacionTokenDatoLocal;
import datos.UsuarioDatoLocal;
import entidades.NotificacionToken;
import entidades.Usuario;

public class NotificacionTokenNegocioTest {
	
	@Mock
	private NotificacionTokenDatoLocal notificacionTokenDato;
	
	@Mock
	private UsuarioDatoLocal usuariosDato;
	
	@InjectMocks
	private NotificacionTokenNegocio ntn;
	
	private static DTNotificacionToken dtNotificacion;
	private static NotificacionToken notificacion;
	private static Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveUserToken() {
		dtNotificacion = Mockito.mock(DTNotificacionToken.class);
		notificacion =  Mockito.mock(NotificacionToken.class);
		usuario = Mockito.mock(Usuario.class);
		Mockito.when(usuariosDato.obtenerUsuarioPorCI(any(Integer.class))).thenReturn(usuario);
		Mockito.when(notificacionTokenDato.existeNoficacionToken(notificacion)).thenReturn(false);
		Mockito.doNothing().when(notificacionTokenDato).saveUserToken(notificacion);
		ntn.saveUserToken(dtNotificacion);
		Mockito.verify(usuariosDato ,Mockito.times(1)).obtenerUsuarioPorCI(any(Integer.class));

		
	}
	
	@Test(expected = Exception.class)
	public void testSaveUserTokenException() {
		dtNotificacion = Mockito.mock(DTNotificacionToken.class);
		notificacion =  Mockito.mock(NotificacionToken.class);
		usuario = Mockito.mock(Usuario.class);
		Mockito.when(usuariosDato.obtenerUsuarioPorCI(any(Integer.class))).thenReturn(null);
		ntn.saveUserToken(dtNotificacion);
	}
	

	@Test
	public void testGetUserTokens() {
		notificacion =  Mockito.mock(NotificacionToken.class);
		usuario = Mockito.mock(Usuario.class);
		List<String> sTokens = new ArrayList <String>();
		List<NotificacionToken> tokens = new ArrayList <NotificacionToken>();
		tokens.add(notificacion);
		Mockito.when(usuariosDato.obtenerUsuarioPorCI(any(Integer.class))).thenReturn(usuario);
		Mockito.when(notificacionTokenDato.getUserTokens(usuario)).thenReturn(tokens);
		sTokens = ntn.getUserTokens(any(Integer.class));
		
		
		
	}

}
