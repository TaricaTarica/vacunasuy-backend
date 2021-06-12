package negocio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

import datatypes.DTAdministrador;
import datatypes.DTAutoridad;
import datatypes.DTCiudadano;
import datatypes.DTContrasenia;
import datatypes.DTVacunador;
import datos.AdministradorDatoLocal;
import datos.AutoridadDatoLocal;
import datos.CiudadanoDatoLocal;
import datos.UsuarioDatoLocal;
import datos.VacunadorDatoLocal;
import entidades.Usuario;
import entidades.Vacunador;
import entidades.Ciudadano;

import entidades.Administrador;
import entidades.Autoridad;



/**
 * Session Bean implementation class UsuarioNegocio
 */
@Stateless
@LocalBean
public class UsuarioNegocio implements UsuarioNegocioRemote, UsuarioNegocioLocal {

   @EJB
   private AutoridadDatoLocal autoridadDato; 
   
   @EJB
   private AdministradorDatoLocal administradorDato; 
   
   @EJB
   private CiudadanoDatoLocal ciudadanoDato; 
   
   @EJB
   private UsuarioDatoLocal usuarioDato; 
   
   @EJB
   private VacunadorDatoLocal vacunadorDato;
   
  
   
   
    public UsuarioNegocio() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void registrarUsuario(Usuario user) throws Exception {
    	
    	
		if (!usuarioDato.existeUsuario(user.getCi())) {
			if((user instanceof Autoridad)){
				Autoridad aut = (Autoridad)user;
				
				try {
				aut.setContrasenia(hashPassword(aut.getContrasenia()));
				autoridadDato.guardarAutoridad(aut);
				} catch (NoSuchAlgorithmException e2) {
					throw new Exception("\nOcurrio un error interno, vuelva a intentar");
				}
			} else {
				Administrador admin = (Administrador)user;	
					try {
					admin.setContrasenia(hashPassword(admin.getContrasenia()));
					administradorDato.guardarAdministrador(admin);
					} catch (NoSuchAlgorithmException e2) {
						throw new Exception("\nOcurrio un error interno, vuelva a intentar");
					}
					
				}
			
		}else {
			throw new Exception("\nYa existe un usuario para la cedula ingresada");
		}
	}
    
    /* AUXILIAR */
	private String hashPassword(String clave) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(clave.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		
		return myHash;
	}
	
	@Override
	public void actualizarDatos(Usuario user) throws Exception {
		
		if (usuarioDato.existeUsuario(user.getCi())) {	
			
			if((user instanceof Autoridad)){
				autoridadDato.editarAutoridad((Autoridad)user);
			} else if ((user instanceof Administrador )) {
				administradorDato.editarAdministrador((Administrador)user);	
			}
			else {
				ciudadanoDato.editarCiudadano((Ciudadano)user);
			}
		
		}else {
				throw new Exception("\nNo se encontro un usuario con la cedula ingresado");
		
		}
}
	
	
    @Override
	public List<DTCiudadano> mostrarCiudadanos(){
	 	List<Ciudadano> ciudadanos = ciudadanoDato.obtenerCiudadanos();
	 	
	 	List<DTCiudadano> lista = new ArrayList<DTCiudadano>();
	 	for(Ciudadano c : ciudadanos) {
	 		DTCiudadano dtCiudadano = new DTCiudadano(c);
	 		lista.add(dtCiudadano);
	 	}
	 	
	 	return lista;
	}
    
    
   	@Override
   	public boolean autenticarUsuario (int ci, String pass) {
   		try {
	   		if (administradorDato.obtenerAdministradorPorCI(ci) != null  )
	   			return administradorDato.obtenerAdministradorPorCI(ci).getContrasenia().equals(hashPassword(pass));
	   			//return administradorDato.obtenerAdministradorPorCI(ci).getContrasenia().equals(pass);
	   		else if (autoridadDato.obtenerAutoridadPorCI(ci) != null)
	   			return autoridadDato.obtenerAutoridadPorCI(ci).getContrasenia().equals(hashPassword(pass));
	   			//return autoridadDato.obtenerAutoridadPorCI(ci).getContrasenia().equals(pass);
	   		else
	   			return false; /* El usuario no existe en la base de datos */
   		}catch (Exception e) {
			
   			System.out.println("ERROR: No se pudo obtener el hash MD5 para la password.");
			return false;
		}

   	}
    
    
    @Override
	public List<DTAdministrador> mostrarAdministradores(){
	 	List<Administrador> administradores = administradorDato.obtenerAdministradores();
	 	
	 	List<DTAdministrador> lista = new ArrayList<DTAdministrador>();
	 	for(Administrador a : administradores) {
	 		DTAdministrador dtAdministrador = new DTAdministrador(a);
	 		lista.add(dtAdministrador);
	 	}
	 	
	 	return lista;
	}
    
    @Override
	public List<DTVacunador> mostrarVacunadores() {
		List<Vacunador> vacunadores = vacunadorDato.obtenerVacunadores();
	 	
	 	List<DTVacunador> lista = new ArrayList<DTVacunador>();
	 	for(Vacunador a : vacunadores) {
	 		DTVacunador dtVacunador = new DTVacunador(a);
	 		lista.add(dtVacunador);
	 	}
	 	
	 	return lista;
	}
    
    @Override
	public DTVacunador obtenerVacunador(int cedula) throws Exception {
		Vacunador vac = vacunadorDato.obteneVacunadorPorCI(cedula);
		if (vac == null) {
			throw new Exception("\nNo se encontro un usuario con la cedula ingresado");
		} else {
			DTVacunador dtVac = new DTVacunador(vac);
			return dtVac;
		}
			
	}

	@Override
	public List<DTAutoridad> mostrarAutoridades() {
		List<Autoridad> autoridades = autoridadDato.obtenerAutoridades();
	 	
	 	List<DTAutoridad> lista = new ArrayList<DTAutoridad>();
	 	for(Autoridad a : autoridades) {
	 		DTAutoridad dtAutoridad = new DTAutoridad(a);
	 		lista.add(dtAutoridad);
	 	}
	 	
	 	return lista;
	}
	
	@Override
	public DTAdministrador obtenerAdministrador(int cedula) throws Exception {
		Administrador admin = administradorDato.obtenerAdministradorPorCI(cedula);
		if (admin == null) {
			throw new Exception("\nNo se encontro un usuario con la cedula ingresado");
		} else {
			DTAdministrador dtAdmin = new DTAdministrador(admin);
			return dtAdmin;
		}
			
	}
	
	@Override
	public DTAutoridad obtenerAutoridad(int cedula) throws Exception {
		Autoridad aut = autoridadDato.obtenerAutoridadPorCI(cedula);
		if (aut == null) {
			throw new Exception("\nNo se encontro un usuario con la cedula ingresado");
		} else {
			DTAutoridad dtAut = new DTAutoridad(aut);
			return dtAut;
		}
			
	}
	
	@Override
	public void eliminarUsuario(int cedula) throws Exception {
		if (usuarioDato.existeUsuario(cedula)) {
				usuarioDato.eliminarUsuario(cedula);
		}else {
			throw new Exception("\nNo se encontro un usuario con la cedula ingresado");
		}
	}
	
	@Override
	public void editarContraseniaUsuario (DTContrasenia editarContrasenia) throws Exception {
		if (usuarioDato.existeUsuario(editarContrasenia.getCi())) {
			Usuario user = usuarioDato.obtenerUsuarioPorCI(editarContrasenia.getCi());
				
				try {
						user.setContrasenia(hashPassword(editarContrasenia.getContrasenia()));
						usuarioDato.editarUsuario(user);
					} catch (NoSuchAlgorithmException e2) {
						throw new Exception("\nOcurrio un error interno, vuelva a intentar");
					}
		}else {
			throw new Exception("\nNo se encontro un usuario con la cedula ingresada");
		}
	}
}
