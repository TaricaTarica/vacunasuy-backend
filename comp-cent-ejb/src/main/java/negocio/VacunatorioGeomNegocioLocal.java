package negocio;

import javax.ejb.Local;

@Local
public interface VacunatorioGeomNegocioLocal {
	
	public void agregarCoordenadas(long idVacunatorio, String lat, String lon);

}
