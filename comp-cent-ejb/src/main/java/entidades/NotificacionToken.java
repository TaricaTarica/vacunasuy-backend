package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import datatypes.DTNotificacionToken;

@Entity
public class NotificacionToken {
	@Id 
	@GeneratedValue
	private long id;
	
	private String token;
	
	@ManyToOne
	private Usuario usuario;
	
	

	public NotificacionToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public NotificacionToken(String token, Usuario usuario) {
		super();
		this.token = token;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public DTNotificacionToken getDt() {
		return new DTNotificacionToken(id,token,usuario.getCi());
	}
	
}
