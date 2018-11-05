package co.edu.udea.uscores.daoImpl;

/**
 * <p>Pruebas para Usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */


import static org.junit.Assert.*;

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

import co.edu.udea.uscores.dao.InterfaceUsuarioDao;
import co.edu.udea.uscores.dto.Usuario;
import co.edu.udea.uscores.exception.UsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/uscores/spring/SpringBeanDefinition.xml")
@Transactional
public class UsuarioDaoSpringTest {




		@Autowired
		InterfaceUsuarioDao UsuarioDaoSpring;

		final Logger log = Logger.getLogger(UsuarioDaoSpringTest.class.getName());

		@Test
		public void obtenerUsuarioTest() {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				usuarios = UsuarioDaoSpring.obtenerUsuario();
				for (Usuario usuario : usuarios) {
					System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
					System.out.println("Correo: " + usuario.getCorreo());
					System.out.println("Nombre: " + usuario.getNombre());
					System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				}
				assertTrue(usuarios.size() > 0);
			} catch (UsException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}

		@Test
		@Rollback(false)
		public void testCrearUsuario() {
			Usuario usuario = null;
			try {
				usuario = new Usuario();
				usuario.setCorreo("ada@gmail.com");
				usuario.setNombre("laura");
				usuario.setContrasena("lau");
				UsuarioDaoSpring.crearUsuario(usuario);
			} catch (UsException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}

		@Test
		@Rollback(false)
		public void testEliminarUsuarios() {
			Usuario usuario = new Usuario();
			try {
				usuario = UsuarioDaoSpring.buscarUsuario("ada@gmail.com");
				UsuarioDaoSpring.eliminarUsuario(usuario);
			} catch (UsException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}

		@Test
		public void testActualizarUsuario() {
			Usuario usuario = new Usuario();
			try {
				usuario = UsuarioDaoSpring.buscarUsuario("leo@gmail.com");
				usuario.setNombre("Leonidas");
				UsuarioDaoSpring.actualizarUsuario(usuario);
			} catch (UsException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}
 
		@Test
		public void testBuscarUsuario() {
			Usuario usuario = null;
			try {
				usuario = UsuarioDaoSpring.buscarUsuario("vane@gmail.com");
				assertNotNull(usuario);
			} catch (UsException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}

}
