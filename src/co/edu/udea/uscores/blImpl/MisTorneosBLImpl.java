package co.edu.udea.uscores.blImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.MisTorneosBL;
import co.edu.udea.uscores.dao.InterfaceMisTorneosDao;
import co.edu.udea.uscores.dao.InterfaceTorneoDao;
import co.edu.udea.uscores.daoImpl.MisTorneosDaoSpring;
import co.edu.udea.uscores.dto.MisTorneos;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;
import co.edu.udea.uscores.util.Validaciones;

/**
 * <p>
 * Implementacion de la interface que define los metodos de negocio del dao de
 * MisUsuarios
 * </p>
 * 
 * @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna -
 *         yennifer.serna@udea.edu.co
 * @since 01/05/2018
 * @Version = 1.0
 */
@Transactional
public class MisTorneosBLImpl implements MisTorneosBL {

	private MisTorneosDaoSpring miTorneoDao;

	@Autowired
	InterfaceMisTorneosDao misTorneosDao;
	
	@Autowired
	InterfaceTorneoDao torneoDao;

	@Override
	/**
	 * Metodo para implementar el dao de obtenerMisTorneos
	 * 
	 * @return lista de torneos de un usuario
	 */
	public List<Torneo> obtener(String idUsuario) throws UsException {
		
		List<MisTorneos> misTorneos;
		List<Torneo> torneos = new ArrayList<Torneo>();
		
		misTorneos = misTorneosDao.obtenerMisTorneos(idUsuario);
		
			for (MisTorneos miTorneo : misTorneos) {
				torneos.add(torneoDao.buscarTorneo(miTorneo.getIdTorneo()));
				System.out.println(torneoDao.buscarTorneo(miTorneo.getIdTorneo()));
			}
		return torneos;
			
	}

	@Override
	/**
	 * Metodo para implementar el dao de insertarMisTorneos
	 * 
	 * @param pk
	 *            del Torneo que se va a crear
	 */
	public void insertarMisTorneos(String correo, int idTorneo) throws UsException {
		MisTorneos misTorneos = new MisTorneos();
		if (Validaciones.isTextoVacio(correo)) {
			throw new UsException("Usuario y/o contraseoa invalido");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new UsException("Formato incorrecto");
		}
		misTorneos.setCorreo(correo);
		misTorneos.setIdTorneo(idTorneo);
		misTorneosDao.crearMisTorneos(misTorneos);
	}

	@Override
	/**
	 * Metodo para implementar el dao de eliminar MisTorneos
	 * 
	 * @param pk
	 *            del Torneo que se va a eliminar
	 */
	public void eliminarMisTorneos(String correo, int idTorneo) throws UsException {

		List<MisTorneos> misTorneos;

		if (Validaciones.isTextoVacio(correo)) {
			throw new UsException("Usuario y/o contraseoa invalido");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new UsException("Formato incorrecto");
		}

		misTorneos = misTorneosDao.buscarMisTorneos(correo, idTorneo);
		misTorneosDao.eliminarMisTorneos(misTorneos.get(0));

	}

	public MisTorneosDaoSpring getMiTorneoDao() {
		return miTorneoDao;
	}

	public void setMiTorneoDao(MisTorneosDaoSpring miTorneoDao) {
		this.miTorneoDao = miTorneoDao;
	}

}
