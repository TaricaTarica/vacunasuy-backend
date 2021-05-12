package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ReglaID.class)
public class Regla {
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
	private PlanVacunacion plan;
	
	public Regla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Regla(Vacuna vacuna, PlanVacunacion plan) {
		super();
		this.vacuna = vacuna;
		this.plan = plan;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public PlanVacunacion getPlan() {
		return plan;
	}

	public void setPlan(PlanVacunacion plan) {
		this.plan = plan;
	}
	
	
}
