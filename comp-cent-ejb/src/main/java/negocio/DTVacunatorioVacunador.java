package negocio;

import java.time.LocalDate;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import entidades.VacunatorioVacunador;

public class DTVacunatorioVacunador {

	public DTVacunatorioVacunador() {
		// TODO Auto-generated constructor stub
	}
	private DTVacunatorio dtVacunatorio;
	private DTVacunador dtVacunador;
	private LocalDate fecha;
	
	
	
	public DTVacunatorioVacunador(DTVacunatorio dtVacunatorio, DTVacunador dtVacunador, LocalDate fecha) {
		super();
		this.dtVacunatorio = dtVacunatorio;
		this.dtVacunador = dtVacunador;
		this.fecha = fecha;
	}
	
	public DTVacunatorioVacunador(VacunatorioVacunador vacunatorioVacunador) {
		this.dtVacunatorio = new DTVacunatorio(vacunatorioVacunador.getVacunatorio());
		this.dtVacunador = new DTVacunador(vacunatorioVacunador.getVacunador());
		this.fecha = vacunatorioVacunador.getFecha();
		
	}
	
	public DTVacunatorio getDtVacunatorio() {
		return dtVacunatorio;
	}
	public void setDtVacunatorio(DTVacunatorio dtVacunatorio) {
		this.dtVacunatorio = dtVacunatorio;
	}
	public DTVacunador getDtVacunador() {
		return dtVacunador;
	}
	public void setDtVacunador(DTVacunador dtVacunador) {
		this.dtVacunador = dtVacunador;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
