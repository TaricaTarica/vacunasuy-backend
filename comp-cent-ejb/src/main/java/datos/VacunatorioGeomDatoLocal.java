package datos;

import java.util.List;

import javax.ejb.Local;

@Local
public interface VacunatorioGeomDatoLocal {
	public void agregarCoordenadas(long idVacunatorio, String lat, String lon);

	public List<Integer> vacunatoriosCercanos(String lat, String lon);
}
