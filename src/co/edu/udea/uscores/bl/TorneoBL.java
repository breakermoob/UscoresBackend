package co.edu.udea.uscores.bl;

/**
 * <p>Interface de torneo para la logica del negocio</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.List;

import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;


public interface TorneoBL {
	
	
	/**Muestra todos los torneos
	 * @return Todos los torneos
	 * @throws UsException ocurre un error con la base de datos
	 */	
	public List<Torneo> obtener() throws UsException;
	
	/**
	 * Crea el torneo entregandole los datos
	 * @param Contienen como parametros los datos del torneo a crear
	 * @return Retorna los errores, pero si no los hay retorna vacio
	 * @throws UsException ocurre un error con la base de datos
	 */
	public Torneo crearTorneo(int id, String nombre, String deporte, String correo) throws UsException;

	/**
	 * Crea el cliente entregandole los datos
	 * @param Contienen como parametros los datos del cliente a modificar
	 * @return Retorna los errores, pero si no los hay retorna vacio
	 * @throws UsException ocurre un error con la base de datos
	 */
	public Torneo actualizarTorneo(int id, String nombre, String deporte) throws UsException;
	
	/**
	 * Crea el torneo entregandole los datos
	 * @param Contienen como parametros los datos del cliente a eliminar
	 * @return Retorna los errores, pero si no los hay retorna vacio
	 * @throws UsException ocurre un error con la base de datos
	 */
	public void eliminarTorneo(int id,String correo) throws UsException;

}
