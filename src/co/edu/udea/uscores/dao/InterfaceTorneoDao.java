package co.edu.udea.uscores.dao;

/**
 * <p>Interfaz con el CRUD para Torneo</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.List;

import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

public interface InterfaceTorneoDao {

	/**
	 * <p>Entrega la lista de Torneos del sistema</p>
	 * @return Lista de Torneos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Torneo> obtenerTorneos() throws UsException;
	
	/**
	 * <p>Crear Torneo en el sistema</p>
	 * @param Torneo que vamos a agregar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Torneo crearTorneo(Torneo torneo) throws UsException;
	
	/**
	 * <p>Eliminar Torneo en el sistema</p>
	 * @param Torneo que vamos a eliminar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void eliminarTorneo(Torneo torneo) throws UsException;
	
	/**
	 * <p>Actualizar Torneo en el sistema</p>
	 * @param Torneo que vamos a actualizar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Torneo actualizarTorneo(Torneo torneo) throws UsException;
	
	/**
	 * <p>Buscar Torneo en el sistema</p>
	 * @param Torneo que vamos a buscar
	 * @return Torneo que buscamos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Torneo buscarTorneo(int idTorneo) throws UsException;
}
