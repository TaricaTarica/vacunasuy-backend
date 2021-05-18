package datatypes;

import java.io.Serializable;
import java.time.LocalDate;

import entidades.Reserva;

public class DTReserva implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int hora;
	private LocalDate fecha;	
	private DTCiudadano ciudadano;
	private DTPlanVacunacion planVacunacion;
	private DTAgenda agenda;
	
	public DTReserva() {
		super();
	}
	
	public DTReserva(Reserva res) {
		super();
		this.id = res.getId();
		this.hora = res.getHora();
		this.fecha = res.getFecha();		
	}

	public DTReserva(long id, int hora, LocalDate fecha) {
		super();
		this.id = id;
		this.hora = hora;
		this.fecha = fecha;
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
	
	

	public DTCiudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(DTCiudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public DTPlanVacunacion getPlanVacunacion() {
		return planVacunacion;
	}

	public void setPlanVacunacion(DTPlanVacunacion planVacunacion) {
		this.planVacunacion = planVacunacion;
	}

	public DTAgenda getAgenda() {
		return agenda;
	}

	public void setAgenda(DTAgenda agenda) {
		this.agenda = agenda;
	}

	@Override
	public String toString() {
		return "DTReserva [id=" + id + ", hora=" + hora + ", fecha=" + fecha + "]";
	}	
	
}
