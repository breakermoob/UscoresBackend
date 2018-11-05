package co.edu.udea.uscores.blImpl;

/**
 * <p>Implementacion de la logica del negocio para Evento</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co 
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.EventoBL;
import co.edu.udea.uscores.daoImpl.EventoDaoSpring;
import co.edu.udea.uscores.daoImpl.TorneoDaoSpring;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

@Transactional
public class EventoBLImpl implements EventoBL {

	@Autowired
	EventoDaoSpring eventoDao;
	@Autowired
	TorneoDaoSpring torneoDao;
	
	@Override
	/**
	  * Metodo para implementar el dao obtenerEventos
	  * @return lista de eventos
	  */
	public List<Evento> obtener(int idTorneo) throws UsException {
		Torneo torneo = torneoDao.buscarTorneo(idTorneo);
		return eventoDao.obtenerEventos(torneo);
	}
	
	@Override
	public Evento crearEvento(int id, String nombre, Date fecha, String lugar, int idTorneo) throws UsException {
		
		if(nombre.isEmpty() || nombre == null) {
			throw new UsException("El nombre no puede estar vacio");
		}
		if(lugar.isEmpty() || lugar == null) {
			throw new UsException("El lugar no puede estar vacio");
		}
//		if(eventoDao.buscarEvento(id)!=null){
//			throw new UsException("El id del evento ya existe");
//		}
			
		Torneo torneo = torneoDao.buscarTorneo(idTorneo);
		
		Evento evento = new Evento();
		evento.setId(id);
		evento.setNombre(nombre);
		evento.setFecha(fecha);
		evento.setLugar(lugar);
		evento.setTorneo(torneo);
		eventoDao.crearEvento(evento);
	
		return evento;
	}

	@Override
	/**
	  * Metodo para implementar el dao de actualizarEvento
	  * @param pk evento que se va a actualizar
	  * @return evento actualizado
	  */
	public Evento actualizarEvento(int id, String nombre, Date fecha, String lugar, int idTorneo) throws UsException {
		
		if(torneoDao.buscarTorneo(idTorneo).equals(null)) {
			throw new UsException("El id del torneo no existe");
		}
		if(eventoDao.buscarEvento(id).equals(null)) {
			throw new UsException("El id del torneo no existe");
		}
		if(nombre.isEmpty() || nombre == null) {
			throw new UsException("El nombre no puede estar vacio");
		}
		if(lugar.isEmpty() || lugar == null) {
			throw new UsException("El lugar no puede estar vacio");
		}

		Evento evento = eventoDao.buscarEvento(id);
		evento.setNombre(nombre);
		evento.setFecha(fecha);
		evento.setLugar(lugar);
		eventoDao.actualizarEvento(evento);
		
		return evento;
	}

	@Override
	/**
	  * Metodo para implementar el dao de eliminarEvento
	  * @param pk del evento que se va a eliminar
	  */
	public void eliminarEvento(int id) throws UsException {

		Evento evento = eventoDao.buscarEvento(id);
		eventoDao.eliminarEvento(evento);
	}

	public EventoDaoSpring getEventoDao() {
		return eventoDao;
	}

	public void setEventoDao(EventoDaoSpring eventoDao) {
		this.eventoDao = eventoDao;
	}

}
