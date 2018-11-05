package co.edu.udea.uscores.dao;

import java.util.List;

import co.edu.udea.uscores.dto.MisTorneos;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>Interfaz con el CRUD para MisTorneo</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

public interface InterfaceMisTorneosDao {
	
	/**
	 * <p>Entrega la lista de MisTorneos del sistema</p>
	 * @return Lista de Torneos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<MisTorneos> obtenerMisTorneos(String usuario) throws UsException;
	
	/**
	 * <p>Crear MisTorneo en el sistema</p>
	 * @param MisTorneo que vamos a agregar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void crearMisTorneos(MisTorneos misTorneo) throws UsException;
	
	/**
	 * <p>Eliminar MisTorneos en el la lista</p>
	 * @param MisTorneos que vamos a eliminar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void eliminarMisTorneos(MisTorneos misTorneo) throws UsException;
	
	/**
	 * <p>Actualizar MisTorneos en el sistema</p>
	 * @param Torneo que vamos a actualizar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void actualizarMisTorneos(MisTorneos misTorneo) throws UsException;
	
	/**
	 * <p>Busca un MisTorneos en el sistema</p>
	 * @param correo del usuario y id del Torneo que buscaremos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<MisTorneos> buscarMisTorneos(String correo, int id_torneo) throws UsException;
	
}
