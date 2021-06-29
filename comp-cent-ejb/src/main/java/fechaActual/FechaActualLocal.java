package fechaActual;

import java.time.LocalDate;

import javax.ejb.Local;

@Local
public interface FechaActualLocal {
	public LocalDate getFechaInicio();
	public void setFechaInicio(LocalDate fechaInicio);
}
