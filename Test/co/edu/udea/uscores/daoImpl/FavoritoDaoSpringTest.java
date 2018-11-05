package co.edu.udea.uscores.daoImpl;

/**
 * <p>Pruebas para los metodos en el dao de MisTorneos</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * <p>Pruebas para FavoritoDao</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.dao.InterfaceEventoDao;
import co.edu.udea.uscores.dao.InterfaceFavoritosDao;
import co.edu.udea.uscores.dao.InterfaceUsuarioDao;
import co.edu.udea.uscores.dto.Favorito;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml")
@Transactional

public class FavoritoDaoSpringTest {

	@Autowired
	InterfaceFavoritosDao favoritoDao;

	@Autowired
	InterfaceUsuarioDao usuarioDao;

	@Autowired
	InterfaceEventoDao eventoDao;
	final Logger log = Logger.getLogger(FavoritoDaoSpringTest.class.getName());

	@Test
	public void testObtener() {
		List<Favorito> favoritos = new ArrayList<Favorito>();
		try {
			favoritos = favoritoDao.obtenerFavorito("Vane@gmail.com");
			for (Favorito favorito : favoritos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Usuario: " + favorito.getCorreo());
				System.out.println("idEvento: " + favorito.getIdEvento());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			assertTrue(favoritos.size() > 0);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerFavorito() {
		List<Favorito> favoritos = new ArrayList<Favorito>();
		try {
			favoritos = favoritoDao.buscarFavorito("Vane@gmail.com", 3);
			for (Favorito favorito : favoritos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Usuario: " + favorito.getCorreo());
				System.out.println("idEvento: " + favorito.getIdEvento());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			assertTrue(favoritos.size() > 0);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testCrearFavorito() {
		Favorito favorito = new Favorito();
		try {
			favorito.setCorreo("vane@gmail.com");
			favorito.setIdEvento(2);
			favoritoDao.crearFavorito(favorito);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testEliminarFavorito() {
		List<Favorito> favoritos = new ArrayList<Favorito>();
		try {
			favoritos = favoritoDao.buscarFavorito("vane@gmail.com", 2);
			favoritoDao.eliminarFavorito(favoritos.get(0));
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
