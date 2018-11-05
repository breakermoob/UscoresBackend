package co.edu.udea.uscores.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>POJO para los torneos, posee los datos de cada torneo y los eventos que contiene</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

@XmlRootElement
public class Torneo {
	
	private int id;
	private String nombre;
	private String deporte;
	
	
	public Torneo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDeporte() {
		return deporte;
	}


	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}


	

}
