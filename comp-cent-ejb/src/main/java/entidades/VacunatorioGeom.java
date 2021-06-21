package entidades;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class VacunatorioGeom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	Vacunatorio vacunatorio;
	
	@Lob @Basic(fetch=FetchType.LAZY)
    @Column(name = "geom", columnDefinition = "geometry(point)")
	private String geom;

	public VacunatorioGeom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VacunatorioGeom(Vacunatorio vacunatorio, String geom) {
		super();
		this.vacunatorio = vacunatorio;
		this.geom = geom;
	}

	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}
	
	
	
	
}
