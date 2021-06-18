package entidades;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import datatypes.DTReserva;
import enumeradores.EstadoReserva;

@Entity
public class Reserva {
	@Id 
	@GeneratedValue	
	private long id;
	private int hora;
	private LocalDate fecha;
	@Enumerated(value = EnumType.STRING)
	private EstadoReserva estado;
	
	@ManyToOne
	private Ciudadano ciudadano;
	
	@ManyToOne
	private Agenda agenda;
	
	@ManyToOne
	private PlanVacunacion planVacunacion;
	
	@ManyToOne
	private Departamento departamento;
	
	@ManyToOne
	private Ubicacion ubicacion;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(DTReserva res) {
		super();
		this.hora = res.getHora();
		this.fecha = res.getFecha();
		this.estado = res.getEstado();
	}	

	public Reserva(long id, int hora, LocalDate fecha, EstadoReserva estado, Ciudadano ciudadano, Agenda agenda,
			PlanVacunacion planVacunacion, Departamento departamento, Ubicacion ubicacion) {
		super();
		this.id = id;
		this.hora = hora;
		this.fecha = fecha;
		this.estado = estado;
		this.ciudadano = ciudadano;
		this.agenda = agenda;
		this.planVacunacion = planVacunacion;
		this.departamento = departamento;
		this.ubicacion = ubicacion;
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

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", hora=" + hora + ", fecha=" + fecha + ", ciudadano=" + ciudadano + ", agenda="
				+ agenda + ", planVacunacion=" + planVacunacion + "]";
	}
	
	
}
