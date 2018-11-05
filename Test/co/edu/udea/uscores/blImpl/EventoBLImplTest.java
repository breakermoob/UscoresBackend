package co.edu.udea.uscores.blImpl;

/**
 * <p>Pruebas para los metodos en la logica de negocio de Evento</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import static org.junit.Assert.fail;

/**
 * <p>Implementacion de la logica del negocio para Evento</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co 
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.EventoBL;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml" )
@Transactional

public class EventoBLImplTest { 
	
	@Autowired
	EventoBL eventoBL;
	
	@Test
	public void testObtener() {
		try {
			List<Evento> eventos = eventoBL.obtener(2);
			for (Evento evento : eventos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Id: " + evento.getId());
				System.out.println("Nombre: " + evento.getNombre());
				System.out.println("Lugar: " + evento.getLugar()); 
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCrear() {
		try {
			eventoBL.crearEvento(20, "Juegos", new Date(), "UdeA", 1);
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testActualizar() {
		try {
		eventoBL.actualizarEvento(1, "Juegos", new Date(), "Estadio", 1);
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testEliminar() {
		try {
			eventoBL.eliminarEvento(2);
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
