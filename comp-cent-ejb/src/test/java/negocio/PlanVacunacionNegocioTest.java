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

import datatypes.DTEnfermedad;
import datatypes.DTPlanVacunacion;
import datatypes.DTVacuna;
import datos.EnfermedadDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.VacunaDatoLocal;
import entidades.Enfermedad;
import entidades.PlanVacunacion;
import entidades.Vacuna;
import static org.mockito.ArgumentMatchers.any;

public class PlanVacunacionNegocioTest {
	
	@Mock
	private PlanVacunacionDatoLocal datoLocal;
	
	@Mock
	private EnfermedadDatoLocal enfermedadDatoLocal;
	
	@Mock
	private VacunaDatoLocal vacunaDatoLocal;
	
	private List<PlanVacunacion> planes;
	private List<Vacuna> vacunas;
	private List<DTVacuna> dtVacunas;
	private PlanVacunacion plan;
	private Enfermedad enfermedad;
	private Vacuna vacuna;
	private DTPlanVacunacion dtPlan;
	private DTEnfermedad dtEnfermedad;
	private DTVacuna dtVacuna;
	
	
	@InjectMocks
	private PlanVacunacionNegocio pvn;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		enfermedad = new Enfermedad();
		enfermedad.setNombre("prueba");
		enfermedad.setFechaCreacion(LocalDate.now());
		vacuna = Mockito.mock(Vacuna.class);
		vacunas = new ArrayList<Vacuna>();
		vacunas.add(vacuna);
		plan = new PlanVacunacion();
		plan.setNombre("prueba");
		plan.setEnfermedad(enfermedad);
		plan.setVacunas(vacunas);
		planes = new ArrayList<PlanVacunacion>();
		planes.add(plan);
		dtPlan = new DTPlanVacunacion(plan);
		dtEnfermedad = new DTEnfermedad(enfermedad);
		dtVacuna = new DTVacuna(vacuna);
		dtVacunas = new ArrayList<DTVacuna>();
		dtVacunas.add(dtVacuna);
		dtPlan.setVacunas(dtVacunas);
		dtPlan.setEnfermedad(dtEnfermedad);
	}

	@Test
	public void testListarPlanesDeVacunacion() {
		Mockito.when(datoLocal.listarPlanesDeVacunacion()).thenReturn(planes);
		Mockito.when(enfermedadDatoLocal.buscarEnfermedad(any(String.class))).thenReturn(enfermedad);
		
		assertEquals(planes.size(), pvn.listarPlanesDeVacunacion().size());
	}

	@Test
	public void testAgregarPlanVacunacion() throws Exception {
		Mockito.when(datoLocal.existePlanVacunacion(any(String.class))).thenReturn(false);
		Mockito.when(enfermedadDatoLocal.buscarEnfermedad(any(String.class))).thenReturn(enfermedad);
		Mockito.doNothing().when(datoLocal).agregarPlanVacunacion(any(PlanVacunacion.class));
		pvn.agregarPlanVacunacion(dtPlan);
		Mockito.verify(datoLocal ,Mockito.times(1)).agregarPlanVacunacion(any(PlanVacunacion.class));
	}
	
	@Test(expected = Exception.class)
	public void testAgregarPlanVacunacionException() throws Exception {
		Mockito.when(datoLocal.existePlanVacunacion("prueba")).thenReturn(true);
		pvn.agregarPlanVacunacion(dtPlan);
	}
		
	@Test
	public void testNombresPlanes() {
		Mockito.when(datoLocal.listarPlanesDeVacunacion()).thenReturn(planes);
		Mockito.when(enfermedadDatoLocal.buscarEnfermedad(any(String.class))).thenReturn(enfermedad);
		
		assertEquals(planes.size(), pvn.nombresPlanes().size());
	}
	
	@Test
	public void testObtenerPlanVacunacion() throws Exception {
		Mockito.when(datoLocal.existePlanVacunacion("prueba")).thenReturn(true);
		Mockito.when(datoLocal.obtenerPlanVacunacion(any(String.class))).thenReturn(plan);
		
		assert(pvn.obtenerPlanVacunacion("prueba")!= null);
		
	}
	
	@Test(expected = Exception.class)
	public void testObtenerPlanVacunacionException() throws Exception {
		Mockito.when(datoLocal.existePlanVacunacion("prueba")).thenReturn(false);
		pvn.obtenerPlanVacunacion("prueba");
	}
	
	@Test
	public void testEditarPlanVacunacion() throws Exception {
		Mockito.when(datoLocal.obtenerPlanVacunacionPorId(any(Long.class))).thenReturn(plan);
		Mockito.when(enfermedadDatoLocal.buscarEnfermedad(any(String.class))).thenReturn(enfermedad);
		Mockito.when(vacunaDatoLocal.obtenerVacuna(any(String.class))).thenReturn(vacuna);
		Mockito.doNothing().when(datoLocal).editarPlanVacunacion(any(PlanVacunacion.class));
		pvn.editarPlanVacunacion(dtPlan);
		Mockito.verify(datoLocal ,Mockito.times(1)).editarPlanVacunacion(any(PlanVacunacion.class));
		
		
	}
	
	@Test(expected = Exception.class)
	public void testEditarPlanVacunacionException() throws Exception {
		Mockito.when(datoLocal.obtenerPlanVacunacionPorId(any(Long.class))).thenReturn(null);
		pvn.editarPlanVacunacion(dtPlan);
	}
	
	@Test
	public void testEliminarPlanVacunacion() throws Exception {
		Mockito.when(datoLocal.obtenerPlanVacunacionPorId(any(Long.class))).thenReturn(plan);
		Mockito.doNothing().when(datoLocal).eliminarPlanVacunacion(any(PlanVacunacion.class));
		pvn.eliminarPlanVacunacion(dtPlan);
		Mockito.verify(datoLocal ,Mockito.times(1)).eliminarPlanVacunacion(any(PlanVacunacion.class));
		
		
	}
	
	@Test(expected = Exception.class)
	public void testEliminarPlanVacunacionException() throws Exception {
		Mockito.when(datoLocal.obtenerPlanVacunacionPorId(any(Long.class))).thenReturn(null);
		pvn.eliminarPlanVacunacion(dtPlan);
	}
	
	@Test
	public void testObtenerPlanesVacunacionObjetivoEdad() {
		Mockito.when(datoLocal.obtenerPlanesVacunacionObjetivoEdad("prueba","prueba")).thenReturn(planes);
		
		assertEquals(planes.size(),pvn.obtenerPlanesVacunacionObjetivoEdad("prueba","prueba").size());
		
	}

}
