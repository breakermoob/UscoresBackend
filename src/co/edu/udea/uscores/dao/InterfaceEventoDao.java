package co.edu.udea.uscores.dao;

/**
 * <p>Interfaz con el CRUD para Evento</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.List;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

public interface InterfaceEventoDao {
	
	/**
	 * <p>Entrega la lista de Eventos de un Torneo</p>
	 * @return Lista de Eventos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Evento> obtenerEventos(Torneo torneo) throws UsException;
	
	/**
	 * <p>Crear Evento en el Torneo</p>
	 * @param Evento que vamos a agregar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Evento crearEvento(Evento evento) throws UsException;
	
	/**
	 * <p>Eliminar Evento en el Torneo</p>
	 * @param Evento que vamos a eliminar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void eliminarEvento(Evento evento) throws UsException;
	
	/**
	 * <p>Actualizar Evento en el Torneo</p>
	 * @param Evento que vamos a actualizar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Evento actualizarEvento(Evento evento) throws UsException;
	
	/**
	 * <p>Buscar Evento en el Torneo</p>
	 * @param Evento que vamos a buscar
	 * @return Evento que buscamos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Evento buscarEvento(int idEvento) throws UsException;

}
