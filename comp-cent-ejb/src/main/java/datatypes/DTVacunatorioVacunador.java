package datatypes;

import java.time.LocalDate;
import java.util.List;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import entidades.VacunatorioVacunador;

public class DTVacunatorioVacunador {

	public DTVacunatorioVacunador() {
		// TODO Auto-generated constructor stub
	}
	private DTVacunatorio dtVacunatorio;
	private List<DTVacunador> dtVacunador;
	
	
	
	public DTVacunatorioVacunador(DTVacunatorio dtVacunatorio, List<DTVacunador> dtVacunador) {
		super();
		this.dtVacunatorio = dtVacunatorio;
		this.dtVacunador = dtVacunador;
	}
	
	public DTVacunatorioVacunador(VacunatorioVacunador vacunatorioVacunador) {
		this.dtVacunatorio = new DTVacunatorio(vacunatorioVacunador.getVacunatorio());

		
	}
	
	public DTVacunatorio getDtVacunatorio() {
		return dtVacunatorio;
	}
	public void setDtVacunatorio(DTVacunatorio dtVacunatorio) {
		this.dtVacunatorio = dtVacunatorio;
	}

	public List<DTVacunador> getDtVacunador() {
		return dtVacunador;
	}

	public void setDtVacunador(List<DTVacunador> dtVacunador) {
		this.dtVacunador = dtVacunador;
	}
	
	
}
