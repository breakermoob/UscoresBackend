package co.edu.udea.uscores.daoImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * <p>Pruebas para los metodos en el dao de MisTorneos</p>
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

import co.edu.udea.uscores.dao.InterfaceMisTorneosDao;
import co.edu.udea.uscores.dto.MisTorneos;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml")
@Transactional

public class MisTorneosDaoSpringTest {

	@Autowired
	InterfaceMisTorneosDao misTorneosDao;

	final Logger log = Logger.getLogger(MisTorneosDaoSpringTest.class.getName());

	@Test
	public void testObtenerMisTorneos() {
		List<MisTorneos> misTorneos = new ArrayList<MisTorneos>();
		try {
			misTorneos = misTorneosDao.obtenerMisTorneos("Vane@gmail.com");
			for (MisTorneos miTorneo : misTorneos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Correo: " + miTorneo.getCorreo());
				System.out.println("id_torneo: " + miTorneo.getIdTorneo());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			assertTrue(misTorneos.size() > 0);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testCrearMisTorneos() {
		MisTorneos mistorneos = new MisTorneos();
		try {
			mistorneos.setCorreo("Vane@gmail.com");
			mistorneos.setIdTorneo(1);
			misTorneosDao.crearMisTorneos(mistorneos);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	@Rollback(false)
	public void testEliminarMisTorneos() {
		List<MisTorneos> misTorneos = new ArrayList<MisTorneos>();
		try {
			misTorneos = misTorneosDao.buscarMisTorneos("Vane@gmail.com", 1);
			misTorneosDao.eliminarMisTorneos(misTorneos.get(0));
			
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}
