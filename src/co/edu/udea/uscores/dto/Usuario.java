package co.edu.udea.uscores.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>POJO para el usuario, contiene informacion de login,favoritos y torneos creados</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

@XmlRootElement
public class Usuario {
	
	private String correo;
	private String nombre;
	private String contrasena;
		
	public Usuario() {
		super();
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	

}
