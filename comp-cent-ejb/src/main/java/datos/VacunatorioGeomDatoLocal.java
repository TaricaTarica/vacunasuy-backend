package datos;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTVacunatorioGeom;

@Local
public interface VacunatorioGeomDatoLocal {
	public void agregarCoordenadas(long idVacunatorio, String lat, String lon);

	public List<DTVacunatorioGeom> vacunatoriosCercanos(String lat, String lon);
}
