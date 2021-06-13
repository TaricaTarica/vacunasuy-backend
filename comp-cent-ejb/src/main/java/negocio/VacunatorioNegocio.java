package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTAgenda;
import datatypes.DTEnfermedad;
import datatypes.DTPlanVacunacion;
import datatypes.DTVacuna;
import datatypes.DTVacunatorio;
import datos.DepartamentoDatoLocal;
import datos.UbicacionDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
import entidades.PlanVacunacion;
import entidades.Ubicacion;
import entidades.Vacuna;
import entidades.Vacunatorio;


/**
 * Session Bean implementation class VacunatorioNegocio
 */
@Stateless
@LocalBean
public class VacunatorioNegocio implements VacunatorioNegocioRemote, VacunatorioNegocioLocal {

	@EJB
	private VacunatorioDatoLocal vacunatorioLocal; 
	
	@EJB
	private UbicacionDatoLocal ubicacionLocal; 
	
    /**
     * Default constructor. 
     */
    public VacunatorioNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio) throws Exception{
		if (vacunatorioLocal.existeVacunatorio(dtVacunatorio.getCodigo()))
			throw new Exception("\nYa existe un vacunatorio con el codigo ingresado");
	else {
		Vacunatorio vacunatorio = new Vacunatorio(dtVacunatorio);
		Ubicacion ubi = this.ubicacionLocal.obtenerUbicacionPorId(dtVacunatorio.getUbicacion().getId());
		vacunatorio.setUbicacion(ubi);
		this.vacunatorioLocal.agregarVacunatorio(vacunatorio);
		ubi.setVacunatorio(vacunatorio);
		this.ubicacionLocal.actualizarVacunatorio(ubi);
		
	}
	}
	
	public List<DTVacunatorio> listarVacunatorio(){
		List <Vacunatorio> vacunatorio = (ArrayList<Vacunatorio>)(this.vacunatorioLocal.listarVacunatorio());
		List <DTVacunatorio> dtVacunatorio = new ArrayList<DTVacunatorio>();
		vacunatorio.forEach((v)->{dtVacunatorio.add(new DTVacunatorio(v));});
		return dtVacunatorio;
	}
	
	@Override
	public List<String> nombresVacunatorios() {
		
		List<DTVacunatorio> vacunatorio = listarVacunatorio();
		List<String> nombres = new ArrayList<String>();
		vacunatorio.forEach((v)->{nombres.add(v.getNombre());});
		return nombres;
    }
	@Override
	public DTAgenda obtenerAgendaActiva(long idVacunatorio) {
		Vacunatorio vacunatorio = vacunatorioLocal.obtenerVacunatorio(idVacunatorio);
		if(vacunatorio !=  null) {
			DTAgenda retorno = null;
			List<Agenda> agendas = vacunatorio.getAgendas();
			LocalDate fechaActual = LocalDate.now();
			
			for(Agenda a: agendas) {
				if((fechaActual.isAfter(a.getInicio()) || fechaActual.isEqual(a.getInicio()))  
						&& (fechaActual.isBefore(a.getFin()) || fechaActual.isEqual(a.getFin()))) {
					retorno = new DTAgenda(a);
				}
				else{
					if(fechaActual.isBefore(a.getFin())) {
						retorno = new DTAgenda(a);
					}
				}
			}

			return retorno;
		}
		else {
			return null;
		}
	}
	
	@Override
	public DTVacunatorio obtenerVacunatorioPorCodigo(String codigo) throws Exception {
	if (vacunatorioLocal.existeVacunatorio(codigo)) {
		Vacunatorio vacunatorio = vacunatorioLocal.obtenerVacunatorioPorCodigo(codigo);
		DTVacunatorio dtVacunatorio = new DTVacunatorio(vacunatorio);
		
		    return dtVacunatorio;
	}
	else {
		throw new Exception("\nNo existe un Vacunatorio con el codigo ingresado");
	}
	}

	@Override
	public void editarVacunatorio(DTVacunatorio vacunatorioSeleccionado) throws Exception {
			
		Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(vacunatorioSeleccionado.getId());
		vac.setCantidadPuestos(vacunatorioSeleccionado.getCantidadPuestos());
		vac.setCodigo(vacunatorioSeleccionado.getCodigo());
		vac.setNombre(vacunatorioSeleccionado.getNombre());
	
		vacunatorioLocal.editarVacunatorio(vac);
			
	}

	@Override
	public void eliminarVacunatorio(DTVacunatorio vacunatorio) throws Exception {
		Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(vacunatorio.getId());
		if (vac != null) {
			if (vac.getAgendas().isEmpty()) {
				Ubicacion ubi = this.ubicacionLocal.obtenerUbicacionPorId(vacunatorio.getUbicacion().getId());
				//ubi.eliminarVacunatorio();
				this.ubicacionLocal.actualizarVacunatorio(ubi);
				vacunatorioLocal.eliminarVacunatorio(vac);
			}else 
				throw new Exception("\nNo se puede eliminar el vacunatorio, porque tiene agendas asociadas");
			
		
		}else {
			throw new Exception("\nNo se encontro un vacunatorio con el id ingresado");
		}
			
		
	}
	
}
