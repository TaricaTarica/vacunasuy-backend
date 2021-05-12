package entidades;

import java.io.Serializable;

public class ReglaID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private long vacuna;
	private long plan;
	
	public ReglaID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getVacuna() {
		return vacuna;
	}

	public void setVacuna(long vacuna) {
		this.vacuna = vacuna;
	}

	public long getPlan() {
		return plan;
	}

	public void setPlan(long plan) {
		this.plan = plan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (plan ^ (plan >>> 32));
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
		ReglaID other = (ReglaID) obj;
		if (plan != other.plan)
			return false;
		if (vacuna != other.vacuna)
			return false;
		return true;
	}

	

	
}
