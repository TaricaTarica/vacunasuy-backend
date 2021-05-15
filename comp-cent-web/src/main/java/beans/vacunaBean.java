package beans;

import java.io.Serializable;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import negocio.VacunaNegocioLocal;



@Named("VacunaBean")
@RequestScoped
public class VacunaBean implements  Serializable{
	
	
	private static final long serialVersionUID = 1L;

	 @Inject
	 private VacunaNegocioLocal mv;
	
	 
	 public void agregarVacuna(String nombre, String codigo, String laboratorio) {
		 mv.agregarVacuna(nombre, codigo, laboratorio, null, null);
	 }
	 


}
