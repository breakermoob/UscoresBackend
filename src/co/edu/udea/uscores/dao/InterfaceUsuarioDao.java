package co.edu.udea.uscores.dao;

/**
 * <p>Interfaz con el CRUD para Usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.List;

import co.edu.udea.uscores.dto.Usuario;
import co.edu.udea.uscores.exception.UsException;

public interface InterfaceUsuarioDao {
	
	/**
	 * <p>Entrega la lista de Usuario del sistema</p>
	 * @return Lista de Usuarios
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Usuario> obtenerUsuario() throws UsException;
	
	/**
	 * <p>Crear Usuario en el sistema</p>
	 * @param Usuario que vamos a agregar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void crearUsuario(Usuario usuario) throws UsException;
	
	/**
	 * <p>Eliminar Usuario en el sistema</p>
	 * @param Usuario que vamos a eliminar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void eliminarUsuario(Usuario usuario) throws UsException;
	
	/**
	 * <p>Actualizar Usuario en el sistema</p>
	 * @param Usuario que vamos a actualizar
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public void actualizarUsuario(Usuario usuario) throws UsException;
	
	/**
	 * <p>Buscar Usuario en el sistema</p>
	 * @param Usuario que vamos a buscar
	 * @return Usuario que buscamos
	 * @throws UsException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Usuario buscarUsuario(String correo) throws UsException;

}
