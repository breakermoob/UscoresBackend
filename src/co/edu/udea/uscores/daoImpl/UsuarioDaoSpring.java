package co.edu.udea.uscores.daoImpl;

/**
 * <p>Implementacion de la interfaz Usuario</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.uscores.dao.InterfaceUsuarioDao;
import co.edu.udea.uscores.dto.Usuario;
import co.edu.udea.uscores.exception.UsException;


public class UsuarioDaoSpring extends HibernateDaoSupport implements InterfaceUsuarioDao{	
	
	@SuppressWarnings("unchecked")
	@Override
    /**
     * Metodo para registros en la tabla Usuario de la DB
     * @return lista de ususarios
     */
	public List<Usuario> obtenerUsuario() throws UsException {

		List<Usuario> usuario = new ArrayList<Usuario>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			usuario = criteria.list();

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return usuario;
	}
	

	@Override
    /**
     * Metodo para crear registros en la tabla Usuario de la DB
     * @param usuario que se va a crear
     */
	public void crearUsuario(Usuario usuario) throws UsException {
		try{
			Session session = this.getSessionFactory().getCurrentSession();			
			session.save(usuario);
		}catch(HibernateException e){
			throw new UsException(e);
		}
	}

	@Override
    /**
     * Metodo para eliminar registros en la tabla Usuario de la DB
     * @param usuario que se va a eliminar
     */
	public void eliminarUsuario(Usuario usuario) throws UsException {

		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();			
			session.delete(usuario);			
		}catch(HibernateException e){
			throw new UsException(e);
		}
	}

	@Override
    /**
     * Metodo para actualizar registros en la tabla usuario de la DB
     * @param usuario que se va a actualizar
     */
	public void actualizarUsuario(Usuario usuario) throws UsException {

		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			session.update(usuario);

		}catch(HibernateException e){
			throw new UsException(e);
		}
	}

	@Override
    /**
     * Metodo para hacer buscar un usuario en la tabla usuario de la DB
     * @param usuario que se va a buscar
     * @return el usuario que retorna la búsqueda
     */
	public Usuario buscarUsuario(String correo) throws UsException {
		Usuario usuario = null;
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			usuario = (Usuario)session.load(Usuario.class, correo);
		}catch(HibernateException e){
			throw new UsException(e);
		}	
		return usuario;
	}
	


}
