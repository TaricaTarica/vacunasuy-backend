package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import datatypes.DTCertificado;
import datatypes.DTRegistroVacuna;
import datos.CiudadanoDatoLocal;
import datatypes.DTVacuna;
import datos.RegistroVacunaDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunaDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Ciudadano;
import entidades.Departamento;
import entidades.PlanVacunacion;
import entidades.RegistroVacuna;
import entidades.Reserva;
import entidades.Ubicacion;
import entidades.Vacuna;
import enumeradores.EstadoReserva;
import enumeradores.Sexo;
import entidades.Vacunatorio;

/**
 * Session Bean implementation class RegistroVacunaNegocio
 */
@Stateless
@LocalBean
public class RegistroVacunaNegocio implements RegistroVacunaNegocioLocal {

	@EJB
	private RegistroVacunaDatoLocal registroVacunaDatoLocal;
	@EJB
	private VacunaDatoLocal vacunaDatoLocal;
	@EJB
	private VacunatorioDatoLocal vacunatorioDatoLocal;
	@EJB
	private CiudadanoDatoLocal ciudadanoDatoLocal;
	@EJB
	private ReservaDatoLocal reservaDatoLocal;


    /**
     * Default constructor. 
     */
    public RegistroVacunaNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DTCertificado> obtenerCertificados(String ci){
    	List<RegistroVacuna> listRegVac = registroVacunaDatoLocal.obtenerRegistroPorCi(Integer.valueOf(ci));
    	List<DTCertificado> listCert = new ArrayList<DTCertificado>();
    	if (listRegVac != null) {
        	for (RegistroVacuna regVac: listRegVac) {
        		Vacuna vac = regVac.getVacuna();
        		DTCertificado dtCert = new DTCertificado();
        		dtCert.setFechaVacuna(regVac.getFecha().toString());
        		dtCert.setIdVacuna(String.valueOf(vac.getId()));
        		dtCert.setNombreVacuna(vac.getNombre());
        		dtCert.setLaboratorioVacuna(vac.getLaboratorio());
        		dtCert.setCodigoVacuna(vac.getCodigo());
        		dtCert.setCantDosis(String.valueOf(vac.getDosis()));
        		dtCert.setPeriodoInmunidad(String.valueOf(vac.getPeriodoInmune()));
        		dtCert.setIdEnfermedad(String.valueOf(vac.getEnfermedad().getId()));
        		dtCert.setNombreEnfermedad(vac.getEnfermedad().getNombre());
        		listCert.add(dtCert);
        		
        	}
    	}
    	return listCert;
    }

    public List<RegistroVacuna> listarRegistros(){
    	List<RegistroVacuna> registros = registroVacunaDatoLocal.obtenerRegistro();
		return registros;
    }
    
    public void altaRegistroVacuna (List<DTRegistroVacuna> regVacunas) {
    	for(DTRegistroVacuna regVacuna : regVacunas ) {
	    	Ciudadano usuario = ciudadanoDatoLocal.obtenerCiudadano(regVacuna.getCedula());
	    	Vacunatorio vacunatorio = vacunatorioDatoLocal.obtenerVacunatorio(regVacuna.getIdVacunatorio());
	    	Vacuna vacuna = vacunaDatoLocal.obtenerVacunaPorId(regVacuna.getIdVacuna());
	    	Reserva reserva = reservaDatoLocal.obtenerReserva(regVacuna.getIdReserva());
	    	reserva.setDosisSuministradas(reserva.getDosisSuministradas()+1);
	    	if (reserva.getDosisSuministradas() < vacuna.getDosis()) {
	    		Reserva reservaNueva = new Reserva();
	    		reservaNueva.setCiudadano(usuario);
	    		reservaNueva.setPlanVacunacion(reserva.getPlanVacunacion());
	    		reservaNueva.setEstado(EstadoReserva.Pendiente);
	    		reservaNueva.setDepartamento(reserva.getDepartamento());
	    		reservaNueva.setUbicacion(reserva.getUbicacion());
	    		reservaNueva.setVacuna(vacuna);
	    		reservaNueva.setDosisSuministradas(reserva.getDosisSuministradas());
	    		reservaDatoLocal.crearReserva(reservaNueva);
	    	}
	    	RegistroVacuna registroVac = new RegistroVacuna(vacuna, usuario,vacunatorio, reserva, LocalDate.parse(regVacuna.getFecha()));
	    	registroVacunaDatoLocal.agregarRegistroVacuna(registroVac);
	    }
    }
    	
    
    public List<Integer> obtenerCantVac(DTVacuna vacuna, int anio) {
    	Vacuna vac = vacunaDatoLocal.obtenerVacunaPorId(vacuna.getId());
    	List<Integer> listaCantidadXMes = new ArrayList<Integer>();
    	for (int i=1; i<=12; i++){
    		listaCantidadXMes.add(registroVacunaDatoLocal.cantRegistroPorMes(vac, i, anio));
    	} ;
    	return listaCantidadXMes;
    }
    
    public List<Integer> cantRegistroPorSexo(DTVacuna vacuna, int anio) {
    	Vacuna vac = vacunaDatoLocal.obtenerVacunaPorId(vacuna.getId());
    	List<Integer> listaCantidadXSexo = new ArrayList<Integer>();
    	listaCantidadXSexo.add(registroVacunaDatoLocal.cantRegistroPorSexo(vac, Sexo.Mujer, anio));
    	listaCantidadXSexo.add(registroVacunaDatoLocal.cantRegistroPorSexo(vac, Sexo.Hombre, anio));
    	return listaCantidadXSexo;
    }
    
    public List<Integer> cantRegistroPorEdad(DTVacuna vacuna, int anio){
    	Vacuna vac = vacunaDatoLocal.obtenerVacunaPorId(vacuna.getId());
    	List<Integer> listaCantidadXEdad = new ArrayList<Integer>();
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 0, 11, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 12, 18, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 19, 25, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 26, 40, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 41, 60, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 61, 75, anio));
    	listaCantidadXEdad.add(registroVacunaDatoLocal.cantRegistroPorEdad(vac, 75, 150, anio));
    	return listaCantidadXEdad;
    }
    
    @Override
    public int countVacunadosHoy(long vacunaId) {
    	int retorno = 0;
    	List<RegistroVacuna> registros = registroVacunaDatoLocal.obtenerRegistro();
    	for(RegistroVacuna r: registros) {
    		if(
    				r.getFecha().equals(LocalDate.now()) &&
    				r.getVacuna().getId() == vacunaId
    		) {
    			retorno++;
    		}
    	}
    	
    	return retorno;
    }
    
    @Override
    public int[] countVacunadosPorMes(long vacunaId, int ano){
    	List<RegistroVacuna> registros = registroVacunaDatoLocal.obtenerRegistro();
    	int[] countVacunadosPorMes = new int[12];
    	LocalDate fechaIni = LocalDate.of(ano, 1, 1);
    	LocalDate fechaFin = LocalDate.of(ano, 12, 31);
    	for(RegistroVacuna rv: registros) {
    		if(
    				rv.getFecha().isAfter(fechaIni) &&
    				rv.getFecha().isBefore(fechaFin) &&
    				rv.getVacuna().getId() == vacunaId
    		){
    			countVacunadosPorMes[rv.getFecha().getMonthValue() - 1] = countVacunadosPorMes[rv.getFecha().getMonthValue() - 1] + 1;
    		}
    	}
    	return countVacunadosPorMes;
    }
	 
	public int[] countVacunadosPorDepartamento(long vacunaId, int ano){
		List<RegistroVacuna> registros = registroVacunaDatoLocal.obtenerRegistro();
    	int[] countVacunadosPorDepartamento = new int[19];
    	LocalDate fechaIni = LocalDate.of(ano, 1, 1);
    	LocalDate fechaFin = LocalDate.of(ano, 12, 31);
    	for(RegistroVacuna rv: registros) {
    		if(
    				rv.getFecha().isAfter(fechaIni) &&
    				rv.getFecha().isBefore(fechaFin) &&
    				rv.getVacuna().getId() == vacunaId
    		){
    			switch(rv.getReserva().getDepartamento().getDescripcion().toUpperCase()) {
    				
	    			case "ARTIGAS":
	    					countVacunadosPorDepartamento[0] = countVacunadosPorDepartamento[0] + 1;
	    				break;
	    				
	    			case "CANELONES":
	    					countVacunadosPorDepartamento[1] = countVacunadosPorDepartamento[1] + 1;
	    				break;
	    				
	    			case "CERRO LARGO":
	    					countVacunadosPorDepartamento[2] = countVacunadosPorDepartamento[2] + 1;
	    				break;
	    			case "COLONIA":
	    					countVacunadosPorDepartamento[3] = countVacunadosPorDepartamento[3] + 1;
	    				break;
	    			case "DURAZNO":
	    					countVacunadosPorDepartamento[4] = countVacunadosPorDepartamento[4] + 1;
	    				break;
	    				
	    			case "FLORIDA":
	    					countVacunadosPorDepartamento[5] = countVacunadosPorDepartamento[5] + 1;
	    				break;
	    				
	    			case "FLORES":
	    					countVacunadosPorDepartamento[6] = countVacunadosPorDepartamento[6] + 1;
	    				break;
	    				
	    			case "LAVALLEJA":
	    					countVacunadosPorDepartamento[7] = countVacunadosPorDepartamento[7] + 1;
	    				break;
	    			case "MALDONADO":
	    					countVacunadosPorDepartamento[8] = countVacunadosPorDepartamento[8] + 1;
	    				break;
	    				
	    			case "MONTEVIDEO":
	    					countVacunadosPorDepartamento[9] = countVacunadosPorDepartamento[9] + 1;
	    				break;
	    				
	    			case "PAYSANDÚ":
	    					countVacunadosPorDepartamento[10] = countVacunadosPorDepartamento[10] + 1;
	    				break;
	    			case "RÍO NEGRO":
	    					countVacunadosPorDepartamento[11] = countVacunadosPorDepartamento[11] + 1;
	    				break;
	    				
	    			case "ROCHA":
	    					countVacunadosPorDepartamento[12] = countVacunadosPorDepartamento[12] + 1;
	    				break;
	    			case "RIVERA":
	    					countVacunadosPorDepartamento[13] = countVacunadosPorDepartamento[13] + 1;
	    				break;
	    				
	    			case "SALTO":
	    					countVacunadosPorDepartamento[14] = countVacunadosPorDepartamento[14] + 1;
	    				break;
	    				
	    			case "SAN JOSÉ":
	    					countVacunadosPorDepartamento[15] = countVacunadosPorDepartamento[15] + 1;
	    				break;
	    				
	    			case "SORIANO":
	    					countVacunadosPorDepartamento[16] = countVacunadosPorDepartamento[16] + 1;
	    				break;
	    				
	    			case "TACUAREMBÓ":
	    				countVacunadosPorDepartamento[17] = countVacunadosPorDepartamento[17] + 1;
	    				break;
	    				
	    			case "TREINTA Y TRES":
	    				countVacunadosPorDepartamento[18] = countVacunadosPorDepartamento[18] + 1;
	    				break;
    			}
    		}
    	}
    	
    	return countVacunadosPorDepartamento;
	}
    
}
