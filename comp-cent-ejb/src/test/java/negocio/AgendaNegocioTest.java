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

import datatypes.DTAgenda;
import datatypes.DTPlanVacunacion;
import datatypes.DTVacuna;
import datos.AgendaDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunadorDatoLocal;
import datos.VacunatorioDatoLocal;
import datos.VacunatorioVacunadorDatoLocal;
import entidades.Administrador;
import entidades.Agenda;
import entidades.Enfermedad;
import entidades.PlanVacunacion;
import entidades.Vacuna;
import entidades.Vacunador;
import entidades.Vacunatorio;
import static org.mockito.ArgumentMatchers.any;

public class AgendaNegocioTest {
	
	@Mock
	private AgendaDatoLocal agendaLocal;
	@Mock
	private VacunatorioDatoLocal vacunatorioLocal;
	@Mock
	private PlanVacunacionDatoLocal planLocal;
	@Mock
	private ReservaDatoLocal reservaLocal;
	@Mock
	private VacunatorioVacunadorDatoLocal vvl;
	@Mock
	private VacunadorDatoLocal vdl;
	@Mock
	private AgendaNegocioLocal mockedAgendaNegocioLocal;
	

	@InjectMocks
	private AgendaNegocio an;
	
	private static Vacunador vacunador;
	
	private static Agenda agenda1,agenda2;
	
	private  static DTAgenda dtAgenda;
	
	private static Vacunatorio vacunatorio;
	
	private static DTPlanVacunacion dtPlan;
	
	private static DTVacuna dtVacuna;
	
	private static PlanVacunacion plan;
	
	private static Vacuna vacuna;
	
	private static Enfermedad enfermedad;
	
	private static List<DTAgenda> agendass;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		agenda1 = new Agenda();
		agenda2 = new Agenda();
		vacunatorio = Mockito.mock(Vacunatorio.class);
		agenda1.setVacunatorio(vacunatorio);
		agenda2.setVacunatorio(vacunatorio);
		agenda1.setInicio(LocalDate.parse("2021-01-01"));
		agenda2.setInicio(LocalDate.parse("2021-01-01"));
		agenda1.setFin(LocalDate.parse("2021-10-03"));
		agenda2.setFin(LocalDate.parse("2021-10-03"));
		
		dtAgenda = new DTAgenda(agenda1);
		
		dtPlan = Mockito.mock(DTPlanVacunacion.class);
		dtVacuna = Mockito.mock(DTVacuna.class);
		List<DTVacuna> vacunas = new ArrayList<DTVacuna>();
		vacunas.add(dtVacuna);
		dtPlan.setVacunas(vacunas);
		List<DTPlanVacunacion> planes = new ArrayList<DTPlanVacunacion>();
		planes.add(dtPlan);
		dtAgenda.setListDtPlanVacunacion(planes);
		
		plan = new PlanVacunacion();
		enfermedad =new Enfermedad();
		enfermedad.setFechaCreacion(LocalDate.parse("2021-01-01"));
		plan.setEnfermedad(enfermedad);
		vacuna = new Vacuna();
		vacuna.setId(1);
		List<Vacuna> vacunas2 = new ArrayList<Vacuna>();
		vacunas2.add(vacuna);
		plan.setVacunas(vacunas2);
		List<PlanVacunacion> planes2 = new ArrayList<PlanVacunacion>();
		planes2.add(plan);
		agenda1.setPlanes(planes2);
		
		
	}


	@Test
	public void testAgregarAgenda() throws Exception {
		//DTAgenda agenda =Mockito.mock(DTAgenda.class);
		Mockito.doNothing().when(mockedAgendaNegocioLocal).agregarAgenda(Mockito.isA(DTAgenda.class));
		mockedAgendaNegocioLocal.agregarAgenda(dtAgenda);
		an.agregarAgenda(dtAgenda);
		Mockito.verify(mockedAgendaNegocioLocal ,Mockito.times(1)).agregarAgenda(dtAgenda);
	}

	@Test
	public void testListarAgenda() {
		
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		agendas.add(agenda1);
		agendas.add(agenda2);
		Mockito.when(agendaLocal.listarAgenda()).thenReturn(agendas);
		
		agendass = an.listarAgenda();
		List<Agenda> Agendas = new ArrayList<Agenda>();;
		for (DTAgenda agenda: agendass) {
			Agenda dtAgenda = new Agenda(agenda);
			Agendas.add(dtAgenda);
		}
		assertEquals(Agendas.size(),agendas.size());
	}

	@Test
	public void testListarAgendasActivas() {
		
		
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		agendas.add(agenda1);
		agendas.add(agenda2);
		Mockito.when(agendaLocal.listarAgenda()).thenReturn(agendas);
		
		agendass = an.listarAgendasActivas();
		List<Agenda> Agendas = new ArrayList<Agenda>();;
		for (DTAgenda agenda: agendass) {
			Agenda dtAgenda = new Agenda(agenda);
			Agendas.add(dtAgenda);
		}
		assertEquals(Agendas.size(),agendas.size());
	}

	@Test
	public void testEditarAgenda() throws Exception {
		Mockito.when(agendaLocal.obtenerAgendaPorId(Long.parseLong("0"))).thenReturn(agenda1);
		Mockito.doNothing().when(mockedAgendaNegocioLocal).editarAgenda(Mockito.isA(DTAgenda.class));
		mockedAgendaNegocioLocal.editarAgenda(dtAgenda);
		an.editarAgenda(dtAgenda);
		Mockito.verify(mockedAgendaNegocioLocal ,Mockito.times(1)).editarAgenda(dtAgenda);
	}

	@Test
	public void testEliminarAgenda() throws Exception {
		Mockito.when(agendaLocal.obtenerAgendaPorId(Long.parseLong("0"))).thenReturn(agenda1);
		Mockito.doNothing().when(mockedAgendaNegocioLocal).eliminarAgenda(Mockito.isA(DTAgenda.class));
		mockedAgendaNegocioLocal.eliminarAgenda(dtAgenda);
		an.eliminarAgenda(dtAgenda);
		Mockito.verify(mockedAgendaNegocioLocal ,Mockito.times(1)).eliminarAgenda(dtAgenda);
	}

	@Test
	public void testObtenerAgendaActiva() {
		agenda1 = Mockito.mock(Agenda.class);
		Mockito.when(agendaLocal.obtenerAgendaActivaVacunatorio(1, LocalDate.parse("2021-01-01"))).thenReturn(agenda1);
		Agenda agenda = an.obtenerAgendaActiva(1, LocalDate.parse("2021-01-01"));
		assertEquals(agenda1, agenda);
		
	}

	@Test
	public void testCountAgendasActivasHoy() {
		List<Agenda> agendas = new ArrayList<Agenda>();
		int cant=1;
		agendas.add(agenda1);
		agendas.add(agenda2);
		Mockito.when(agendaLocal.listarAgenda()).thenReturn(agendas);
		Mockito.when(mockedAgendaNegocioLocal.countAgendasActivasHoy(1)).thenReturn(cant);
		int result = an.countAgendasActivasHoy(1);
		assertEquals(cant, result);
	}

	@Test
	public void testAgendasVacunador() {
		vacunador = Mockito.mock(Vacunador.class);
		vacunatorio = Mockito.mock(Vacunatorio.class);
		Mockito.when(vdl.obteneVacunadorPorCI(12345678)).thenReturn(vacunador);
		Mockito.when(vvl.buscarVacunatorio(vacunador)).thenReturn(vacunatorio);
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		agendas.add(agenda1);
		agendas.add(agenda2);
		Mockito.when(agendaLocal.obtenerAgendasActivasYPasadasVacunatorio(any(Long.class))).thenReturn(agendas);
		
		agendass = an.agendasVacunador(12345678);
		assertEquals(agendas.size(), agendass.size());
	}

}
