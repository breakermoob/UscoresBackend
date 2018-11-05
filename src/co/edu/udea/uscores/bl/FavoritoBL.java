package co.edu.udea.uscores.bl;

import java.util.List;

import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>Interface que contiene los m�todos para la l�gica de negocio de Favorito</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

public interface FavoritoBL {

	/**
	 * Entrega los datos de los eventos favoritos de un usuario 
	 * @return lista de eventos favoritos de un usuario
	 * @throws UsException 
	 */
	public List<Evento> obtenerFavoritos(String idUsuario) throws UsException;
	
	/**
	 * Inserta un evento como favorito
	 * @param correo, id_evento del nuevo evento favorito a registrar
	 * @throws UsException 
	 */
	public void insertarFavorito(String correo, int idEvento) throws UsException;
	
	/**
	 * Elimina el evento favorito ingresado por parametro
	 * @param correo que identifica el usuario e id del evento que se va a eliminar 
	 * @throws UsException 
	 */
	public void eliminarFavorito(String correo, int id_evento) throws UsException;
	
}
