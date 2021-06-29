package negocio;

import java.util.List;

import javax.ejb.Local;

@Local
public interface VacunatorioGeomNegocioLocal {
	
	public void agregarCoordenadas(long idVacunatorio, String lat, String lon);
	
	public List<Integer> vacunatoriosCercanos(String lat, String lon);

}
