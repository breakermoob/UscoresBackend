package co.edu.udea.uscores.daoImpl;

/**
 * <p>Pruebas para TorneoDao</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import co.edu.udea.uscores.dao.InterfaceTorneoDao;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml" )
@Transactional
public class TorneoDaoSpringTest { 

	@Autowired
	InterfaceTorneoDao torneoDao;
	final Logger log = Logger.getLogger(TorneoDaoSpringTest.class.getName());

	@Test
	public void testObtenerTorneos() {

		log.info("Iniciando prueba de obtener Torneos de la BD");
		List<Torneo> torneos = new ArrayList<Torneo>();

		try {
			torneos = torneoDao.obtenerTorneos();
			// Muestra los usuarios en la db
			for (Torneo torneo : torneos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Id: " + torneo.getId());
				System.out.println("Nombre: " + torneo.getNombre());
				System.out.println("Deporte: " + torneo.getDeporte()); 
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
	public void testCrearTorneo() {
		
		Torneo torneo = new Torneo();

		try {
			torneo.setId(5);
			torneo.setNombre("Liga");
			torneo.setDeporte("Judo5");
			torneoDao.crearTorneo(torneo);

		} catch (UsException e) {
			e.printStackTrace();
			System.out.println(e.getCause().getMessage());
		}
	
	}

	@Test
	@Rollback(false)
	public void testActualizarTorneo() {
		Torneo torneo = new Torneo();

		try {
			torneo = torneoDao.buscarTorneo(4);
			torneo.setNombre("Champions 3");
			torneoDao.actualizarTorneo(torneo);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Rollback(false)
	public void testEliminarTorneo() {
		Torneo torneo = new Torneo();

		try {
			torneo = torneoDao.buscarTorneo(5);
			torneoDao.eliminarTorneo(torneo);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
