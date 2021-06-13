package datos;

import javax.ejb.Local;

import entidades.Ubicacion;

@Local
public interface UbicacionDatoLocal {

	public Ubicacion obtenerUbicacionPorId(long id);

	public void actualizarVacunatorio(Ubicacion ubi);

}
