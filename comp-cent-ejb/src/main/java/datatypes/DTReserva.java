package datatypes;

import java.time.LocalDate;

public class DTReserva {
	private long id;
	private int hora;
	private LocalDate fecha;	
	
	public DTReserva() {
		super();
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

	@Override
	public String toString() {
		return "DTReserva [id=" + id + ", hora=" + hora + ", fecha=" + fecha + "]";
	}	
	
}
