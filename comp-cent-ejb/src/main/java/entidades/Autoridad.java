package entidades;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="usuarioCi")
public class Autoridad extends Usuario{

	private static final long serialVersionUID = 1L;

	public Autoridad() {
		// TODO Auto-generated constructor stub
	}

}
