package datatypes;

import java.time.LocalDate;

public class DTVigencia {
	private LocalDate inicioAgenda;
	private LocalDate finAgenda;
	
	public DTVigencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTVigencia(LocalDate inicioAgenda, LocalDate finAgenda) {
		super();
		this.inicioAgenda = inicioAgenda;
		this.finAgenda = finAgenda;
	}
	
	public LocalDate getInicioAgenda() {
		return inicioAgenda;
	}
	
	public void setInicioAgenda(LocalDate inicioAgenda) {
		this.inicioAgenda = inicioAgenda;
	}
	
	public LocalDate getFinAgenda() {
		return finAgenda;
	}
	
	public void setFinAgenda(LocalDate finAgenda) {
		this.finAgenda = finAgenda;
	}
}
