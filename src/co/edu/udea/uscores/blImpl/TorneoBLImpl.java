package co.edu.udea.uscores.blImpl;

/**
 * <p>Implementacion de la logica del negocio para Torneo</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co 
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.TorneoBL;
import co.edu.udea.uscores.daoImpl.MisTorneosDaoSpring;
import co.edu.udea.uscores.daoImpl.TorneoDaoSpring;
import co.edu.udea.uscores.dto.MisTorneos;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;
import co.edu.udea.uscores.util.Validaciones;

@Transactional
public class TorneoBLImpl implements TorneoBL {

	@Autowired
	TorneoDaoSpring torneoDao;
	@Autowired
	MisTorneosDaoSpring misTorneosDao;

	@Override
	/**
	 * Metodo para recuperar torneos en la tabla Torneos de la DB
	 * 
	 * @param Torneo
	 *            que vamos a eliminar
	 */
	public List<Torneo> obtener() throws UsException {
		try {
			return torneoDao.obtenerTorneos();
		} catch (UsException e) {
			throw new UsException("Lista vacia");
		}
	}

	/**
	 * Metodo para crear un torneo en la tabla Torneos de la DB
	 * 
	 * @param Torneo y correo del usuario creador
	 * @return torneo que se va a eliminar
	 */
	public Torneo crearTorneo(int id, String nombre, String deporte, String correo) throws UsException {

		if (nombre.isEmpty() || nombre == null) {
			throw new UsException("El nombre no puede estar vacio");
		}
		if (deporte.isEmpty() || deporte == null) {
			throw new UsException("El deporte no puede estar vacio");
		}
		Torneo torneo = new Torneo();
		torneo.setId(id);
		torneo.setNombre(nombre);
		torneo.setDeporte(deporte);
		torneoDao.crearTorneo(torneo);
		MisTorneos misTorneos = new MisTorneos();
		if (Validaciones.isTextoVacio(correo)) {
			throw new UsException("Usuario y/o contraseoa invalido");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new UsException("Formato incorrecto");
		}
		
		misTorneos.setCorreo(correo);
		misTorneos.setIdTorneo(id);
		misTorneosDao.crearMisTorneos(misTorneos);

		return torneo;

	}

	@Override
	/**
	 * Metodo para actualizar un torneo en la tabla Torneos de la DB
	 * 
	 * @param Torneo
	 *            que se va a actualizar
	 */
	public Torneo actualizarTorneo(int id, String nombre, String deporte) throws UsException {

		if (torneoDao.buscarTorneo(id).equals(null)) {
			throw new UsException("El id del torneo no existe");
		}

		Torneo torneo = torneoDao.buscarTorneo(id);
		torneo.setNombre(nombre);
		torneo.setDeporte(deporte);
		torneoDao.actualizarTorneo(torneo);
		return torneo;
	}

	@Override
	/**
	 * Metodo para eliminar un torneo en la tabla Torneos de la DB
	 * 
	 * @param Torneo, correo del usuario creador
	 *            que se va a eliminar
	 */
	public void eliminarTorneo(int id, String correo) throws UsException {

		List<MisTorneos> misTorneos;

		if (Validaciones.isTextoVacio(correo)) {
			throw new UsException("Usuario y/o contraseoa invalido");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new UsException("Formato incorrecto");
		}

		misTorneos = misTorneosDao.buscarMisTorneos(correo, id);
		misTorneosDao.eliminarMisTorneos(misTorneos.get(0));
		
		if (torneoDao.buscarTorneo(id).equals(null)) {
			throw new UsException("El id del torneo no existe");
		}
		Torneo torneo = torneoDao.buscarTorneo(id);
		torneoDao.eliminarTorneo(torneo);

		

	}

	public TorneoDaoSpring getTorneoDao() {
		return torneoDao;
	}

	public void setTorneoDao(TorneoDaoSpring torneoDao) {
		this.torneoDao = torneoDao;
	}

}
