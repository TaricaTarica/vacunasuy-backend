package datatypes;

import java.io.Serializable;

public class DTNotificacionToken implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String token;
	
	private int cedula;

	public DTNotificacionToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTNotificacionToken(long id, String token, int cedula) {
		super();
		this.id = id;
		this.token = token;
		this.cedula = cedula;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	
	

}
