package datos;

import javax.ejb.Local;

@Local
public interface VacunatorioGeomDatoLocal {
	public void agregarCoordenadas(long idVacunatorio, String lat, String lon);
}
