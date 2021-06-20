package datatypes;

import java.io.Serializable;

import entidades.Puesto;

public class DTPuesto implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String codigo;
	
	public DTPuesto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTPuesto(Puesto puesto) {
		super();
		this.id = puesto.getId();
		this.codigo = puesto.getCodigo();
	}
	
	public DTPuesto(String codigo) {
		super();
		this.codigo = codigo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "DTPuesto [id=" + id + ", codigo=" + codigo + "]";
	}

	
	
}
