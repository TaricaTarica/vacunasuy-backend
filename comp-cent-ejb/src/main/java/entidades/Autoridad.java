package entidades;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Aut")
public class Autoridad extends Usuario{

	private String usuarioAutoridad;
	private String contraseniaAutoridad;
	
	public Autoridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContraseniaAutoridad() {
		return contraseniaAutoridad;
	}

	public void setContraseniaAutoridad(String contraseniaAutoridad) {
		this.contraseniaAutoridad = contraseniaAutoridad;
	}

	public String getUsuarioAutoridad() {
		return usuarioAutoridad;
	}

	public void setUsuarioAutoridad(String usuarioAutoridad) {
		this.usuarioAutoridad = usuarioAutoridad;
	}

}
