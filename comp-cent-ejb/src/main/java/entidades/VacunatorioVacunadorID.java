package entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class VacunatorioVacunadorID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long vacunatorio;
	private int vacunador;
	
	public VacunatorioVacunadorID() {
		// TODO Auto-generated constructor stub
	}
	
	

	public long getVacunatorio() {
		return vacunatorio;
	}



	public void setVacunatorio(long vacunatorio) {
		this.vacunatorio = vacunatorio;
	}



	public int getVacunador() {
		return vacunador;
	}



	public void setVacunador(int vacunador) {
		this.vacunador = vacunador;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vacunador;
		result = prime * result + (int) (vacunatorio ^ (vacunatorio >>> 32));
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
		VacunatorioVacunadorID other = (VacunatorioVacunadorID) obj;
		if (vacunador != other.vacunador)
			return false;
		if (vacunatorio != other.vacunatorio)
			return false;
		return true;
	}
	
}
