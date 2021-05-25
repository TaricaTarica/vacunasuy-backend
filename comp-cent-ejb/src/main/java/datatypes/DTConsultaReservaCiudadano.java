package datatypes;

import java.io.Serializable;

import entidades.Reserva;

public class DTConsultaReservaCiudadano implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private int hora;
	private String fecha;	
	private String enfermedad;
	private String vacunatorio;
	
	public DTConsultaReservaCiudadano() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTConsultaReservaCiudadano(Reserva res){
		this.id = res.getId();
		this.hora = res.getHora();
		if(res.getFecha() == null) {
			this.fecha = "PENDIENTE";
		}
		else {
			this.fecha = res.getFecha().toString();
		}
		
		this.enfermedad = res.getPlanVacunacion().getEnfermedad().getNombre();
		this.vacunatorio = res.getAgenda().getVacunatorio().getNombre();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String getVacunatorio() {
		return vacunatorio;
	}
	public void setVacunatorio(String vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	
}
