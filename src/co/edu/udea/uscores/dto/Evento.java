package co.edu.udea.uscores.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>POJO para el evento, posee la informacion del evento y los grupos que contiene</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
*   	  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

@XmlRootElement
public class Evento {

	private int id;
	private String nombre;
	private Date fecha;
	private String lugar;
	private Torneo torneo;	
	
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public Torneo getTorneo() {
		return torneo;
	}


	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
	
	

}
