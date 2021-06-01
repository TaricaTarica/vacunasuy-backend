package negocio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

import datatypes.DTCiudadano;

import datos.AdministradorDatoLocal;
import datos.AutoridadDatoLocal;
import datos.CiudadanoDatoLocal;
import datos.UsuarioDatoLocal;
import entidades.Usuario;
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
   
  
   
   
    public UsuarioNegocio() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void registrarUsuario(Usuario user) throws Exception {
    	
    	
		if (!usuarioDato.existeUsuario(user.getCi())) {
			
			
			try {
				Autoridad aut = (Autoridad)user;
				try {
				aut.setContrasenia(hashPassword(aut.getContrasenia()));
				autoridadDato.guardarAutoridad(aut);
				} catch (NoSuchAlgorithmException e2) {
					throw new Exception("\nOcurrio un error interno, vuelva a intentar");
				}
				
			} catch(Exception e) {
				try {
					Administrador admin = (Administrador)user;
					try {
					admin.setContrasenia(hashPassword(admin.getContrasenia()));
					administradorDato.guardarAdministrador(admin);
					} catch (NoSuchAlgorithmException e2) {
						throw new Exception("\nOcurrio un error interno, vuelva a intentar");
					}
					
				} catch(Exception e1) {
					e.printStackTrace();
					e1.printStackTrace();
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
			if((user.getClass() == Ciudadano.class)){
				ciudadanoDato.editarCiudadano((Ciudadano)user);
			}
			if ((user.getClass() == Administrador.class)) {
				administradorDato.editarAdministrador((Administrador)user);	
				}
			else {
				autoridadDato.editarAutoridad((Autoridad)user);
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
	   			//return administradorDato.obtenerAdministradorPorCI(ci).getContrasenia().equals(hashPassword(pass));
	   			return administradorDato.obtenerAdministradorPorCI(ci).getContrasenia().equals(pass);
	   		else if (autoridadDato.obtenerAutoridadPorCI(ci) != null)
	   			//return autoridadDato.obtenerAutoridadPorCI(ci).getContrasenia().equals(hashPassword(pass));
	   			return autoridadDato.obtenerAutoridadPorCI(ci).getContrasenia().equals(pass);
	   		else
	   			return false; /* El usuario no existe en la base de datos */
   		}catch (Exception e) {
			
   			System.out.println("ERROR: No se pudo obtener el hash MD5 para la password.");
			return false;
		}

   	}
    
}
