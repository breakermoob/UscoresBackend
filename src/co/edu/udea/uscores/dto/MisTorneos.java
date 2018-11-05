package co.edu.udea.uscores.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>POJO para el Historial, contiene el historial de torneos de cada usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

@XmlRootElement
public class MisTorneos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String correo;
	private int idTorneo;
	
	public MisTorneos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}
}
