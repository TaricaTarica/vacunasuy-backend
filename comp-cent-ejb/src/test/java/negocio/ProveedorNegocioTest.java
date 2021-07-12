package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import datatypes.DTProveedor;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import datos.ProveedorDatoLocal;
import entidades.PlanVacunacion;
import entidades.Proveedor;

public class ProveedorNegocioTest {
	
	@Mock
	private ProveedorDatoLocal pdl;
	
	@InjectMocks
	private ProveedorNegocio pn;

	private static Proveedor proveedor;
	private static DTProveedor dtProveedor;
	private static List<Proveedor> proveedores;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		proveedor = Mockito.mock(Proveedor.class);
		dtProveedor = Mockito.mock(DTProveedor.class);
		proveedores = new ArrayList<Proveedor>();
		proveedores.add(proveedor);
	}
	
	

	@Test
	public void testAgregarProveedor() throws Exception {
		Mockito.when(pdl.existeProveedor(any(String.class))).thenReturn(false);
		Mockito.doNothing().when(pdl).agregarProveedor(any(Proveedor.class));
		pn.agregarProveedor("prueba", 11111);
		Mockito.verify(pdl ,Mockito.times(1)).agregarProveedor(any(Proveedor.class));
		
	}
	
	@Test(expected = Exception.class)
	public void testAgregarProveedorException() throws Exception {
		Mockito.when(pdl.existeProveedor(any(String.class))).thenReturn(true);
		pn.agregarProveedor("prueba", 11111);
	}

	@Test
	public void testObtenerProveedores()  {
		Mockito.when(pdl.obtenerProveedores()).thenReturn(proveedores);
		
		assert(pn.obtenerProveedores()!= null);
		
		
	}
	
	
	@Test
	public void testObtenerProveedorPorId() {
		Mockito.when(pdl.obtenerProveedorPorId(any(Long.class))).thenReturn(proveedor);
		assert(pn.obtenerProveedorPorId(any(Long.class))!=null);
	}

	@Test
	public void testEditarProveedor() throws Exception {
		Mockito.when(pdl.obtenerProveedorPorId(any(Long.class))).thenReturn(proveedor);
		Mockito.doNothing().when(pdl).editarProveedor(any(Proveedor.class));
		pn.editarProveedor(dtProveedor);
		Mockito.verify(pdl ,Mockito.times(1)).editarProveedor(any(Proveedor.class));
	}
	
	@Test(expected = Exception.class)
	public void testEditarProveedorException() throws Exception {
		Mockito.when(pdl.obtenerProveedorPorId(any(Long.class))).thenReturn(null);
		pn.editarProveedor(dtProveedor);
	}
	
	@Test
	public void testEliminarProveedor() throws Exception {
		Mockito.when(pdl.obtenerProveedorPorId(any(Long.class))).thenReturn(proveedor);
		Mockito.doNothing().when(pdl).eliminarProveedor(any(Proveedor.class));
		pn.eliminarProveedor(dtProveedor);
		Mockito.verify(pdl ,Mockito.times(1)).eliminarProveedor(any(Proveedor.class));
	}
	
	@Test(expected = Exception.class)
	public void testEliminarProveedorException() throws Exception {
		Mockito.when(pdl.obtenerProveedorPorId(any(Long.class))).thenReturn(null);
		pn.eliminarProveedor(dtProveedor);
	}
	
	@Test
	public void testObtenerProveedor() throws Exception {
		Mockito.when(pdl.existeProveedor(any(String.class))).thenReturn(true);
		Mockito.when(pdl.obtenerProveedorPorNombre(any(String.class))).thenReturn(proveedor);
		pn.obtenerProveedor("prueba");
	}
	
	@Test(expected = Exception.class)
	public void testObtenerProveedorException() throws Exception {
		Mockito.when(pdl.existeProveedor(any(String.class))).thenReturn(false);
		pn.obtenerProveedor("prueba");
		
	}
	

}
