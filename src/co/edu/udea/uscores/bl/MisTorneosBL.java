package co.edu.udea.uscores.bl;

import java.util.List;

import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>
 * Interface que contiene los m�todos para la l�gica de negocio de MisTorneos
 * </p>
 * 
 * @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna -
 *         yennifer.serna@udea.edu.co
 * @since 01/05/2018
 * @Version = 1.0
 */

public interface MisTorneosBL {

	/**
	 * Entrega los datos de los torneos de un usuario
	 * 
	 * @return
	 * @throws UsException
	 */
	public List<Torneo> obtener(String idUsuario) throws UsException;

	/**
	 * Insertar un torneo en la lista de torneos de un usuario
	 * 
	 * @param correo
	 *            que identifica al usuario e id del torneo que se va a crear
	 * @throws UsException
	 */
	public void insertarMisTorneos(String correo, int idTorneo) throws UsException;

	/**
	 * Eliminar un torneo en la lista de torneos de un usuario
	 * 
	 * @param correo
	 *            que identifica al usuario e id del torneo que se va a eliminar
	 * @throws UsException
	 */
	public void eliminarMisTorneos(String correo, int idTorneo) throws UsException;

}
