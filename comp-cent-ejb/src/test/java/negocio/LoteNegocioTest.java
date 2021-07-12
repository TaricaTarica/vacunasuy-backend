package negocio;

import static org.junit.Assert.*;

import java.time.LocalDate;
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
import datatypes.DTLote;
import datatypes.DTVacuna;
import datos.LoteDatoLocal;
import datos.VacunaDatoLocal;
import entidades.Lote;
import entidades.Vacuna;
import static org.mockito.ArgumentMatchers.any;

public class LoteNegocioTest {
	
	@Mock
	private LoteDatoLocal datoLocal;
	
	
	@Mock
	private VacunaDatoLocal vacunaDatoLocal;
	
	@InjectMocks
	private LoteNegocio ln;
	
	private static List<Lote> lotes;
	private static Lote lote;
	private static DTLote dtLote;
	private static Vacuna vacuna;
	private static DTVacuna dtVacuna;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		lote = new Lote();
		vacuna = new Vacuna();
		vacuna.setNombre("prueba");
		vacuna.setId(1);
		lote.setVacuna(vacuna);
		lote.setFechaCreado(LocalDate.now());
		dtVacuna = Mockito.mock(DTVacuna.class);
		dtLote = new DTLote(lote);
		dtLote.setNombre("prueba");
		dtLote.setVacuna(dtVacuna);
		lote.setFechaCreado(LocalDate.now());
		lotes = new ArrayList<Lote>();
		lotes.add(lote);
	}

	@Test
	public void testListarLotes() {
		Mockito.when(datoLocal.listarLotes()).thenReturn(lotes);
		Mockito.when(vacunaDatoLocal.obtenerVacuna("prueba")).thenReturn(vacuna);
		List<DTLote> dtLotes= ln.listarLotes();
		assertEquals(lotes.size(), dtLotes.size());
		
	}

	@Test
	public void testAgregarLote() throws Exception {
		Mockito.when(datoLocal.existeLote(any(String.class))).thenReturn(false);
		Mockito.when(vacunaDatoLocal.obtenerVacuna(null)).thenReturn(vacuna);
		Mockito.doNothing().when(datoLocal).agregarLote(lote);
		ln.agregarLote(dtLote);
		Mockito.verify(vacunaDatoLocal ,Mockito.times(1)).obtenerVacuna(null);
		
	}
	
	@Test(expected = Exception.class)
	public void testAgregarLoteException() throws Exception {
		Mockito.when(datoLocal.existeLote("prueba")).thenReturn(true);
		ln.agregarLote(dtLote);
	}
	
	@Test
	public void testObtenerLote() throws Exception {
		Mockito.when(datoLocal.existeLote("prueba")).thenReturn(true);
		Mockito.when(datoLocal.obtenerLote("prueba")).thenReturn(lote);
		DTLote dt = ln.obtenerLote("prueba");
		assertTrue(dt!=null);
	}
	
	@Test(expected = Exception.class)
	public void testObtenerLoteException() throws Exception {
		Mockito.when(datoLocal.existeLote("prueba")).thenReturn(false);
		DTLote dt = ln.obtenerLote("prueba");
	}
	
	@Test
	public void testEditarLote() throws Exception {
		Mockito.when(datoLocal.obtenerLotePorId(any(Long.class))).thenReturn(lote);
		Mockito.when(vacunaDatoLocal.obtenerVacuna(null)).thenReturn(vacuna);
		Mockito.doNothing().when(datoLocal).editarLote(lote);
		ln.editarLote(dtLote);
		Mockito.verify(datoLocal ,Mockito.times(1)).editarLote(lote);
		
	}
	
	@Test(expected = Exception.class)
	public void testEditarLoteException() throws Exception {
		Mockito.when(datoLocal.obtenerLotePorId(any(Long.class))).thenReturn(null);
		ln.editarLote(dtLote);
	}
	
	@Test
	public void testEliminarLote() throws Exception {
		Mockito.when(datoLocal.obtenerLotePorId(any(Long.class))).thenReturn(lote);
		Mockito.doNothing().when(datoLocal).eliminarLote(lote);
		ln.eliminarLote(dtLote);
		Mockito.verify(datoLocal ,Mockito.times(1)).eliminarLote(lote);
		
	}
	
	@Test(expected = Exception.class)
	public void testEliminarLoteException() throws Exception {
		Mockito.when(datoLocal.obtenerLotePorId(any(Long.class))).thenReturn(null);
		ln.eliminarLote(dtLote);
		
	}

}
