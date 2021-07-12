package negocio;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTEnvio;
import datatypes.DTLote;
import datatypes.DTSocioLogistico;
import datatypes.DTStockVacuna;
import datatypes.DTVacuna;
import datatypes.DTVacunatorio;
import datos.EnvioDatoLocal;
import datos.LoteDatoLocal;
import datos.SocioLogisticoDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Enfermedad;
import entidades.Envio;
import entidades.Lote;
import entidades.SocioLogistico;
import entidades.Vacuna;
import entidades.Vacunatorio;
import enumeradores.EstadoEnvio;
import static org.mockito.ArgumentMatchers.any;

public class EnvioNegocioTest {

	@Mock
	private EnvioDatoLocal envioLocal;
	
	@Mock
	private LoteDatoLocal loteLocal;
	
	@Mock
	private VacunatorioDatoLocal vacunatorioLocal;
	
	@Mock
	private SocioLogisticoDatoLocal socioLocal;
	
	@Mock
	private EnvioNegocio envNegocio;
	
	@InjectMocks
	private EnvioNegocio en;
	
	private static List<Envio> envios;
	private static List<Lote> lotes;
	private static Envio envio;
	private static DTLote dtLote;  
	private static DTVacunatorio dtVacunatorio;
	private static DTSocioLogistico dtSocio;
	private static DTEnvio dtEnvio;
	private static Lote lote;
	private static SocioLogistico socio;
	private static Vacunatorio vacunatorio;
	private static Vacuna vacuna;
	private static Enfermedad enfermedad;
	private static List<String> estados ;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		dtVacunatorio = new DTVacunatorio();
		dtVacunatorio.setId(1);
		dtSocio = new DTSocioLogistico();
		dtSocio.setCodigo("prueba");
		dtLote = new DTLote();
		dtLote.setNombre("prueba");
		lote = new Lote();
		lote.setFechaCreado(LocalDate.now());
		envio = new Envio();
		envio.setEstado(EstadoEnvio.Entransito);
		envio.setFechaCreacion(LocalDate.now());
		envios = new ArrayList<Envio>();
		
		lotes = new ArrayList<Lote>();
		vacuna = new Vacuna();
		enfermedad = new Enfermedad();
		vacuna.setEnfermedad(enfermedad);
		lote.setVacuna(vacuna);
		envio.setLote(lote);
		envios.add(envio);
		lotes.add(lote);
		estados = Stream.of(EstadoEnvio.values())
                .map(Enum::name)
                .collect(Collectors.toList());
	}

	@Test
	public void testListarEnvios() {
		Mockito.when(envioLocal.listarEnvios()).thenReturn(envios);
		List<DTEnvio> dtEnvios= en.listarEnvios();
		assertEquals(envios.size(), dtEnvios.size());
	}

	@Test
	public void testListarEnviosPorSocioLogistico() {
		Mockito.when(envioLocal.listarEnviosPorSocioLogistico("prueba")).thenReturn(envios);
		List<DTEnvio> dtEnvios= en.listarEnviosPorSocioLogistico("prueba");
		assertEquals(envios.size(), dtEnvios.size());
	}
	
	@Test
	public void testCambiarEstadoEnvio() {
		Mockito.when(envioLocal.obtenerEnvio(any(Long.class))).thenReturn(envio);
		Mockito.doNothing().when(envioLocal).editarEnvio(envio);
		en.cambiarEstadoEnvio(EstadoEnvio.Entregado, any(Long.class));
		Mockito.verify(envioLocal ,Mockito.times(1)).editarEnvio(envio);
	}
	
	@Test
	public void testAgregarEnvio() throws Exception {
		dtEnvio = Mockito.mock(DTEnvio.class);
		socio = Mockito.mock(SocioLogistico.class);
		vacunatorio = Mockito.mock(Vacunatorio.class);
		Mockito.when(loteLocal.obtenerLote("prueba")).thenReturn(lote);
		Mockito.when(socioLocal.obtenerSocioLogistico("prueba")).thenReturn(socio);
		Mockito.when(vacunatorioLocal.obtenerVacunatorio(any(Long.class))).thenReturn(vacunatorio);
		Mockito.doNothing().when(envioLocal).guardarEnvio(envio);
		en.AgregarEnvio(dtEnvio, dtLote, dtVacunatorio, dtSocio);
		Mockito.verify(loteLocal ,Mockito.times(1)).obtenerLote("prueba");
		
		
	}
	
	@Test
	public void testListarEstado() {
		Mockito.when(en.listarEstado()).thenReturn(estados);
		List<String> result = en.listarEstado();
		assertEquals(estados,result);
	}
	
	@Test
	public void testListarLotePendientesDeEnviar() {
		Mockito.when(loteLocal.listarLotes()).thenReturn(lotes);
		Mockito.when(envioLocal.ExisteLote(lote)).thenReturn(false);
		List<DTLote> dtLotes = en.listarLotePendientesDeEnviar();
		assertEquals(lotes.size(),dtLotes.size());
	}

	@Test
	public void testStockEnviado() {
		Mockito.when(envioLocal.cantVacEnviado(any(Long.class), any(LocalDate.class))).thenReturn(envios);
		List<DTStockVacuna> stock = en.stockEnviado(any(Integer.class), any(LocalDate.class));
		assertTrue (stock!=null);
		
	}

}
