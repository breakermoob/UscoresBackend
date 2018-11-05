package co.edu.udea.uscores.blImpl;
/**
 * <p>Pruebas para los metodos en la logica de negocio de torneo</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */


import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.TorneoBL;
import co.edu.udea.uscores.exception.UsException;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml" )
@Transactional
public class TorneoBLImplTest{
	
	@Autowired
	TorneoBL torneoBL; 

	@Test 
	public void testObtener() {
		try {
			torneoBL.obtener();
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}
	
	@Test
	public void testCrear() {
		try {
			torneoBL.crearTorneo(56, "udea", "futbol","Leo@gmail.com");
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Rollback(false)
	public void testActualizar() {
		try {
			torneoBL.actualizarTorneo(20, "Torneito", "Billar :V");
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Rollback(false)
	public void testEliminar() {
		try {
			torneoBL.eliminarTorneo(54,"Leo@gmail.com");
		}catch(UsException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
