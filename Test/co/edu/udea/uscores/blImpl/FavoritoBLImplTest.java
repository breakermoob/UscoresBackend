package co.edu.udea.uscores.blImpl;

/**
 * <p>Pruebas para los metodos en la logica de negocio de Favoritos</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.FavoritoBL;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml")
@Transactional

public class FavoritoBLImplTest {

	@Autowired
	FavoritoBL favoritoBL;

	@Test
	public void testObtener() {
		List<Evento> eventos;

		try {
			eventos = favoritoBL.obtenerFavoritos("Leo@gmail.com");
			for (Evento miEvento : eventos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Correo: " + miEvento.getId());
				System.out.println("id_torneo: " + miEvento.getNombre());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			assertTrue(eventos.size() > 0);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testInsertar() {
		try {
			favoritoBL.insertarFavorito("Leo@gmail.com", 1);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testEliminarFavorito() throws UsException {
		favoritoBL.eliminarFavorito("Leo@gmail.com", 1);
	}
}