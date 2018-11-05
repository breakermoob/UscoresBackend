package co.edu.udea.uscores.blImpl;

/**
 * <p>Pruebas para los m�todos de la l�gica de negocio de Usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 	      Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.uscores.bl.UsuarioBL;
import co.edu.udea.uscores.dao.InterfaceUsuarioDao;
import co.edu.udea.uscores.daoImpl.UsuarioDaoSpring;
import co.edu.udea.uscores.dto.Usuario;
import co.edu.udea.uscores.exception.UsException;
import co.edu.udea.uscores.util.Cifrar;
import co.edu.udea.uscores.util.Validaciones;

@Transactional
public class UsuarioBLImpl implements UsuarioBL{

	private UsuarioDaoSpring usuarioDao;
	
	@Autowired
	InterfaceUsuarioDao UsuarioDao;
	
	private final String MENSAJE_AUTENTICA = "Usuario y/o contraseña invalida";
	
	@SuppressWarnings("unused")
	@Override
	/**
  * Metodo para implemenatr el dao de buscarUsuario
  * @param correo y contraseña del usuario que buscamos validar
  */
	public Usuario autentificar(String correo, String password) throws UsException {
		Usuario usuario = null; 
		Cifrar cifra = new Cifrar();
		if(Validaciones.isTextoVacio(correo)) {
			throw new UsException(MENSAJE_AUTENTICA);
		}
		if(!Validaciones.isEmail(correo)) {
			throw new UsException("Formato incorrecto");
		}
		
		usuario = UsuarioDao.buscarUsuario(correo);

		if(usuario==null)
		{
			throw new UsException(MENSAJE_AUTENTICA);
		}
		if(!usuario.getContrasena().equals(password)) {
			throw new UsException(MENSAJE_AUTENTICA);
		}
		return usuario;
	}

	@Override
	/**
	  * Metodo para implemenatar el dao de crearUsuario
	  * @param datos del usuario qu vamos a crear
	  */
	public void insertar(String correo, String nombre, String contrasena) throws UsException {
			Usuario usuario = new Usuario();
			
			if(Validaciones.isTextoVacio(correo)) {
				throw new UsException("El correo del usuario no puede ser vacia");
			}
			if(Validaciones.isTextoVacio(nombre)) {
				throw new UsException("Los nombres del usuario no pueden ser vacia");
			}
			if(Validaciones.isTextoVacio(contrasena)) {
				throw new UsException("La contrase�a del usuario no pueden ser vacia");
			}
			if(!Validaciones.isEmail(correo)) {
				throw new UsException("Formato incorrecto");
			}
			usuario.setCorreo(correo);
			usuario.setNombre(nombre);
			usuario.setContrasena(contrasena);
			UsuarioDao.crearUsuario(usuario);
	}

	@Override
	/**
	  * Metodo para implemenatar el dao de eliminarUsuario
	  * @param pk del usuario que se va a eliminar
	  */
	public void eliminarUsuario(String correo) throws UsException {
		Usuario usuario = null;
		if(Validaciones.isTextoVacio(correo)) {
			throw new UsException("La cedula del cliente no puede ser vac�a");
		}
		
		usuario = UsuarioDao.buscarUsuario(correo);
		if(usuario == null) {
			throw new UsException("El cliente a eliminar no existe en el sistema");
		}
		UsuarioDao.eliminarUsuario(usuario);		
	}

	public UsuarioDaoSpring getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDaoSpring usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	
	
}
