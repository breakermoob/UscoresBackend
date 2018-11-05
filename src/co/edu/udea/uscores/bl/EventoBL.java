package co.edu.udea.uscores.bl;

/**
 * <p>Interface de evento para la logica del negocio</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.Date;
import java.util.List;

import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.exception.UsException;

public interface EventoBL {

	
		/**Muestra todos los eventos
		 * @return Todos los eventos
		 * @throws UsException ocurre un error con la base de datos
		 */	
		public List<Evento> obtener(int idTorneo) throws UsException;
		
		/**
		 * Crea el eventos entregandole los datos
		 * @param Contienen como parametros los datos del torneo a crear
		 * @return Retorna los errores, pero si no los hay retorna vacio
		 * @throws UsException ocurre un error con la base de datos
		 */
		public Evento crearEvento(int id, String nombre, Date fecha, String lugar, int idTorneo) throws UsException;

		/**
		 * Crea el evento entregandole los datos
		 * @param Contienen como parametros los datos del evento a modificar
		 * @return Retorna los errores, pero si no los hay retorna vacio
		 * @throws UsException ocurre un error con la base de datos
		 */
		public Evento actualizarEvento(int id, String nombre, Date fecha, String lugar, int idTorneo) throws UsException;
		
		/**
		 * Crea el evento entregandole los datos
		 * @param Contienen como parametros los datos del evento a eliminar
		 * @return Retorna los errores, pero si no los hay retorna vacio
		 * @throws UsException ocurre un error con la base de datos
		 */
		public void eliminarEvento(int id) throws UsException;
}
