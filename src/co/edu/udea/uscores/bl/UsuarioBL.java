package co.edu.udea.uscores.bl;

import co.edu.udea.uscores.dto.Usuario;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>Interface que contiene los métodos para la lógica de negocio de Usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

public interface UsuarioBL {
	
	/**
	 * @param login y contraseña del usuario que se va a autentificar
	 * @return el usuario que arroja como resultado la consulta obtenida
	 * @throws UsException 
	 */
	public Usuario autentificar(String login, String password) throws UsException;
	
	/**
	 * Inserta un nuevo usuario
	 * @param correo, nombre, contrasena del nuevo usuario a registrar
	 * @throws UsException 
	 */
	public void insertar(String correo, String nombre, String contrasena) throws UsException;
	
	/**
	 * Elimina el usuario ingresado por parametro
	 * @param correo que identifica el usuario que se va a eliminar 
	 * @throws UsException 
	 */
	public void eliminarUsuario(String correo) throws UsException;
	
}
