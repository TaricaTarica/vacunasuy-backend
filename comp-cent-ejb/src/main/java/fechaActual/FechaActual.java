package fechaActual;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class FechaActual
 */
@Singleton
@LocalBean
public class FechaActual implements FechaActualLocal {

    private LocalDate fechaInicio = LocalDate.of(2020, 12, 30);
    public FechaActual() {
        // TODO Auto-generated constructor stub
    	
    }
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
