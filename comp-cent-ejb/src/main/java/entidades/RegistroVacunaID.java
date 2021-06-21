package entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class RegistroVacunaID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long vacuna;
	private int ciudadano;
	private long vacunatorio;
	private long reserva;
	private LocalDate fecha;
	
	public RegistroVacunaID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(long vacunatorio) {
		this.vacunatorio = vacunatorio;
	}

	public long getVacuna() {
		return vacuna;
	}

	public void setVacuna(long vacuna) {
		this.vacuna = vacuna;
	}

	public int getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(int ciudadano) {
		this.ciudadano = ciudadano;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public long getReserva() {
		return reserva;
	}

	public void setReserva(long reserva) {
		this.reserva = reserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ciudadano;
		result = prime * result + (int) (vacuna ^ (vacuna >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroVacunaID other = (RegistroVacunaID) obj;
		if (ciudadano != other.ciudadano)
			return false;
		if (vacuna != other.vacuna)
			return false;
		return true;
	}

	
}
