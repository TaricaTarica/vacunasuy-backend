package entidades;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import enumeradores.Sexo;

@Entity
@DiscriminatorColumn(name="tipo")
public abstract class Usuario {

	@Id
	private int ci;
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;	
	private int telefono;
	private String email;
	private String contrasenia;
	@Enumerated(value = EnumType.STRING)
	private Sexo sexo; 
	
	public Usuario() {
		super();
	}

	public Usuario(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String contrasenia) {
		super();
		this.ci = ci;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.email = email;
		this.contrasenia = contrasenia;
	}
	
	public Usuario(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email) {
		super();
		this.ci = ci;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.email = email;
		
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [ci=" + ci + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono="
				+ telefono + ", email=" + email + ", contrasenia=" + contrasenia + "]";
	}

	
	
}
