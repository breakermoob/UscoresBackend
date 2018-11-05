package co.edu.udea.uscores.daoImpl;

/**
 * <p>Pruebas para EventoDao</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import static org.junit.Assert.*;

import java.sql.Date;
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

import co.edu.udea.uscores.dao.InterfaceEventoDao;
import co.edu.udea.uscores.dao.InterfaceTorneoDao;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml" )
@Transactional
public class EventoDaoSpringTest {

	@Autowired
	InterfaceEventoDao eventoDao;
	@Autowired
	InterfaceTorneoDao torneoDao;
	final Logger log = Logger.getLogger(EventoDaoSpringTest.class.getName());

	
	@Test
	public void testObtenerEventos() {
		
		log.info("Iniciando prueba de obtener Torneos de la BD");
		List<Evento> eventos = new ArrayList<Evento>();
		Torneo torneo = new Torneo();
		torneo.setId(1);

		try {
			eventos = eventoDao.obtenerEventos(torneo);
			// Muestra los usuarios en la db
			for (Evento evento : eventos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Id: " + evento.getId());
				System.out.println("Nombre: " + evento.getNombre());
				System.out.println("Lugar: " + evento.getLugar()); 
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
	public void testCrearEvento() {
		Evento evento = new Evento();
		Torneo torneo;
		
		try {
			torneo = torneoDao.buscarTorneo(1);
			evento.setId(5);
			evento.setNombre("Evento 5 de T1");
			evento.setLugar("UdeA");
			evento.setFecha(new Date(6));
			evento.setTorneo(torneo); 
			eventoDao.crearEvento(evento);

		} catch (UsException e) {
			e.printStackTrace();
			System.out.println(e.getCause().getMessage());
		}
	}



	@Test
	@Rollback(false)
	public void testActualizarEvento() {
		Evento evento = new Evento();

		try {
			evento = eventoDao.buscarEvento(2);
			evento.setNombre("Champions League 2");
			eventoDao.actualizarEvento(evento);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Rollback(false)
	public void testEliminarEvento() {
		
		Evento evento = new Evento();

		try {
			evento = eventoDao.buscarEvento(5);
			eventoDao.eliminarEvento(evento);
		} catch (UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
