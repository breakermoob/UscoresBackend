package co.edu.udea.uscores.dao;

/**
 * <p>Interfaz con el CRUD para Grupo</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.List;

import co.edu.udea.uscores.dto.Favorito;
import co.edu.udea.uscores.exception.UsException;

public interface InterfaceFavoritosDao {


	/**
	 * <p>Entrega la lista de Favoritos del usuario</p>
	 * @return Lista de Favoritos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Favorito> obtenerFavorito(String usuario) throws UsException;
	
	/**
	 * <p>Crear Favorito del usuario</p>
	 * @param Favorito que vamos a agregar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void crearFavorito(Favorito favorito) throws UsException;
	
	/**
	 * <p>Eliminar Favorito del usuario</p>
	 * @param Favorito que vamos a eliminar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void eliminarFavorito(Favorito favorito) throws UsException;
	
	/**
	 * <p>Actualizar Favorito del usuario</p>
	 * @param Favorito que vamos a actualizar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void actualizarFavorito(Favorito favorito) throws UsException;
	
	/**
	 * <p>Buscar Torneo en el sistema</p>
	 * @param Torneo que vamos a buscar
	 * @return Torneo que buscamos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Favorito> buscarFavorito(String correo, int id_evento) throws UsException;
	
}
