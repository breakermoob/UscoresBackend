package co.edu.udea.uscores.blImpl;

/**
 * <p>Pruebas para los metodos en la logica de negocio de MisTorneos</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.MisTorneosBL;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml")
@Transactional

public class MisTorneosBLImplTest {

	@Autowired
	MisTorneosBL misTorneosBL;

	@Test
	public void testObtener() throws UsException {
		
		List<Torneo> torneos;
		
		try {
			torneos = misTorneosBL.obtener("Leo@gmail.com");
			for (Torneo miTorneo : torneos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Correo: " + miTorneo.getId());
				System.out.println("id_torneo: " + miTorneo.getNombre());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			assertTrue(torneos.size() > 0);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testInsertar() {
		try {
			misTorneosBL.insertarMisTorneos("Leo@gmail.com", 3);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testEliminarFavorito() throws UsException {
		try {
			misTorneosBL.eliminarMisTorneos("Leo@gmail.com", 3);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
