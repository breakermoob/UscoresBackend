package co.edu.udea.uscores.blImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.FavoritoBL;
import co.edu.udea.uscores.dao.InterfaceEventoDao;
import co.edu.udea.uscores.dao.InterfaceFavoritosDao;
import co.edu.udea.uscores.dao.InterfaceUsuarioDao;
import co.edu.udea.uscores.daoImpl.FavoritoDaoSpring;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.dto.Favorito;
import co.edu.udea.uscores.exception.UsException;
import co.edu.udea.uscores.util.Validaciones;

/**
 * <p>Implementacion de la interface que define los metodos de negocio del dao de Favorito</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

@Transactional
public class FavoritoBLImpl implements FavoritoBL {


	private FavoritoDaoSpring favoritoDao;
	
	@Autowired
	InterfaceFavoritosDao favoritosDao;
	
	@Autowired
	InterfaceUsuarioDao usuariosDao;
	
	@Autowired
	InterfaceEventoDao eventoDao;
	
	@Override
	/**
	  * Metodo para implementar el dao de crearFavorito
	  * @param pk del Usuario y pk del evento
	  */
	public void insertarFavorito(String correo, int idEvento) throws UsException {
		Favorito favorito = new Favorito();
		if(Validaciones.isTextoVacio(correo)) {
			throw new UsException("Correo y/o contraseña invalidos");
		}
		if(!Validaciones.isEmail(correo)) {
			throw new UsException("Formato incorrecto");
		}
		favorito.setCorreo(correo);
		favorito.setIdEvento(idEvento);
		favoritosDao.crearFavorito(favorito);
	}

	@Override
	/**
	  * Metodo para implementar el dao de eliminarFavorito
	  * @param pk del Usuario y pk del evento
	  */
	public void eliminarFavorito(String correo, int id_evento) throws UsException {
		if(Validaciones.isTextoVacio(correo)) {
			throw new UsException("El correo del usuario no puede ser vaco");
		}
		
		List<Favorito> favorito = favoritosDao.buscarFavorito(correo, id_evento);
		favoritosDao.eliminarFavorito(favorito.get(0));	
		
	}

	@Override
	/**
	  * Metodo para implementar el dao de obtenerFavoritos
	  * @retrun lista con los favoritos
	  */
	public List<Evento> obtenerFavoritos(String idUsuario) throws UsException {
		List<Favorito> favoritos;
		List<Evento> eventos = new ArrayList<Evento>();
		
		favoritos = favoritosDao.obtenerFavorito(idUsuario);
		
			for (Favorito favorito : favoritos) {
				eventos.add(eventoDao.buscarEvento(favorito.getIdEvento()));
				System.out.println(eventoDao.buscarEvento(favorito.getIdEvento()));
			}
		return eventos;
		
	}
	
	public FavoritoDaoSpring getFavoritoDao() {
		return favoritoDao;
	}

	public void setFavoritoDao(FavoritoDaoSpring favoritoDao) {
		this.favoritoDao = favoritoDao;
	}

}
