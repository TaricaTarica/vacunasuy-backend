package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(VacunatorioVacunadorID.class)
public class VacunatorioVacunador {

	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Vacunatorio vacunatorio;
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Vacunador vacunador;
	
	@Id
	private LocalDate fecha;
	
	public VacunatorioVacunador() {
		// TODO Auto-generated constructor stub
	}

	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}

	public Vacunador getVacunador() {
		return vacunador;
	}

	public void setVacunador(Vacunador vacunador) {
		this.vacunador = vacunador;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
}
