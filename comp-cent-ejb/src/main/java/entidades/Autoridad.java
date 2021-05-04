package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="usuarioCi")
public class Autoridad extends Usuario{

	private static final long serialVersionUID = 1L;
	
	
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Proveedor> proveedores = new ArrayList<>();

	public Autoridad() {
		// TODO Auto-generated constructor stub
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	/*	Esto no se si está teóricamente correcto	*/
	public void agregarProveedor(Proveedor proveedor) {
		proveedores.add(proveedor);
		proveedor.getAutoridades().add(this);
	}
	public void eliminarProveedor(Proveedor proveedor) {
		proveedores.remove(proveedor);
		proveedor.getAutoridades().remove(this);
	}
	

}
