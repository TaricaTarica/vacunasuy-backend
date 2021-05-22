package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datatypes.DTProveedor;
import datos.ProveedorDatoLocal;
import entidades.Proveedor;
import entidades.Vacuna;

/**
 * Session Bean implementation class ProveedorNegocio
 */
@Stateless
@LocalBean
public class ProveedorNegocio implements ProveedorNegocioRemote, ProveedorNegocioLocal {
	
	
	@Inject
	ProveedorDatoLocal mp;

    /**
     * Default constructor. 
     */
    public ProveedorNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void agregarProveedor(String nombre, int tel) throws Exception{
       	
       	if (mp.existeProveedor(nombre)) {
       		throw new Exception("\nEl nombre ya existe en el sistema");
       	}
       	else {
       		
       		Proveedor pro = new Proveedor(nombre, tel);
       		mp.agregarProveedor(pro);
       	}
      }

    @Override
    public List<DTProveedor> obtenerProveedores(){
    	ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>) mp.obtenerProveedores();
    	ArrayList<DTProveedor> lista = new ArrayList<DTProveedor>();
    	for(Proveedor pro:proveedores) {
    		DTProveedor dtProveedores = new DTProveedor(pro);
    		lista.add(dtProveedores);
    	}
    	return lista;
    }
}
