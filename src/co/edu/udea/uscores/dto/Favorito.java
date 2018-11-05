package co.edu.udea.uscores.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>POJO para los favoritos, contiene los eventos favoritos de cada usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

@XmlRootElement
public class Favorito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private int idEvento;
	
	
	public Favorito() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public int getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	

	
	

}
