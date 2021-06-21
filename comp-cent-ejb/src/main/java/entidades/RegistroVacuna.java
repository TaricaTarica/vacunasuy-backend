package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import datatypes.DTRegistroVacuna;

@Entity
@IdClass(RegistroVacunaID.class)
public class RegistroVacuna {
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Vacuna vacuna;
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Ciudadano ciudadano;
	
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
	private Reserva reserva;
	
	@Id
	private LocalDate fecha;

	public RegistroVacuna() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegistroVacuna(Vacuna vacuna, Ciudadano ciudadano, Vacunatorio vacunatorio, Reserva reserva,
			LocalDate fecha) {
		super();
		this.vacuna = vacuna;
		this.ciudadano = ciudadano;
		this.vacunatorio = vacunatorio;
		this.reserva = reserva;
		this.fecha = fecha;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public DTRegistroVacuna getDT () {
		DTRegistroVacuna dt = new DTRegistroVacuna ();
		dt.setCedula(ciudadano.getCi());
		dt.setIdVacuna(vacuna.getId());
		dt.setIdVacunatorio(vacunatorio.getId());
		dt.setFecha(fecha.toString());
		dt.setIdReserva(reserva.getId());
		
		return dt;
		
	}
	
	
}
