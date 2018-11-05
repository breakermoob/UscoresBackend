package co.edu.udea.uscores.blImpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.UsuarioBL;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>Pruebas para los metodos en la logica de negocio de usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml" )
@Transactional

public class UsuarioBLImplTest { 
	@Autowired
	UsuarioBL usuarioBL;
	
	@Test
	public void testAutentificar() {
		try {
			usuarioBL.autentificar("leo@gmail.com", "1234");
		}catch(UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrar() {
		try {
			usuarioBL.insertar("has@udea.co", "Ana", "cont");;
		}catch(UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testEliminar() {
		try {
			usuarioBL.eliminarUsuario("leo@gmail.com");
		}catch(UsException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
