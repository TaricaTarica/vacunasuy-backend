package entidades;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import datatypes.DTReserva;

@Entity
public class Reserva {
	@Id 
	@GeneratedValue	
	private long id;
	private int hora;
	private LocalDate fecha;
	
	@ManyToOne
	private Ciudadano ciudadano;
	
	@ManyToOne
	private Agenda agenda;
	
	@ManyToOne
	private PlanVacunacion planVacunacion;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(DTReserva res) {
		super();
		this.hora = res.getHora();
		this.fecha = res.getFecha();
	}	

	public Reserva(int hora, LocalDate fecha, Ciudadano ciudadano, Agenda agenda, PlanVacunacion planVacunacion) {
		super();
		this.hora = hora;
		this.fecha = fecha;
		this.ciudadano = ciudadano;
		this.agenda = agenda;
		this.planVacunacion = planVacunacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public PlanVacunacion getPlanVacunacion() {
		return planVacunacion;
	}

	public void setPlanVacunacion(PlanVacunacion planVacunacion) {
		this.planVacunacion = planVacunacion;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", hora=" + hora + ", fecha=" + fecha + ", ciudadano=" + ciudadano + ", agenda="
				+ agenda + ", planVacunacion=" + planVacunacion + "]";
	}
	
	
}
