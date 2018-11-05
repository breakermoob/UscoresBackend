package co.edu.udea.uscores.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.uscores.dao.InterfaceFavoritosDao;
import co.edu.udea.uscores.dto.Favorito;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>Implementacion de la interfaz Favoritos</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

public class FavoritoDaoSpring extends HibernateDaoSupport implements InterfaceFavoritosDao {
	
	@SuppressWarnings("unchecked")
	@Override
	   /**
     * Metodo para recuperar la lista de favoritos en la tabla Evento de la DB
     * @return lista de favorito 
     */
	public List<Favorito> obtenerFavorito(String usuario) throws UsException {
		List<Favorito> favoritos = new ArrayList<Favorito>();
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Favorito.class).add( Restrictions.like("correo", usuario));
			favoritos = criteria.list();			
		}catch(HibernateException e){ 
			throw new UsException(e);
		}
		return favoritos;
	}

	@Override
	   /**
     * Metodo para asociar eventos un usuario en la tabla Favoritos de la DB
     * @param Favorito que vamos a enlazar
     */
	public void crearFavorito(Favorito favorito) throws UsException {
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();			
			session.save(favorito);
		}catch(HibernateException e){
			throw new UsException(e);
		}		
	}

	@Override
	/**
  * Metodo para eliminar eventos un usuario en la tabla Favoritos de la DB
  * @param Favorito que vamos a eliminar
  */
	public void eliminarFavorito(Favorito favorito) throws UsException {
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();			
			session.delete(favorito);
		}catch(HibernateException e){
			throw new UsException(e);
		}
	}

	@Override
	/**
  * Metodo para actualizar eventos un usuario en la tabla Favoritos de la DB
  * @param Favorito que vamos a actualizar
  */
	public void actualizarFavorito(Favorito favorito) throws UsException {
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();			
			session.update(favorito);
		}catch(HibernateException e){
			throw new UsException(e);
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
  * Metodo para buscar eventos un usuario en la tabla Favoritos de la DB
  * @param Favorito que vamos a buscar
  */
	public List<Favorito> buscarFavorito(String correo, int id_evento) throws UsException {		
		List<Favorito> favorito = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();			
			favorito = session.createQuery("from Favorito where correo ="+"'"+correo+"'"+"and idEvento = "+id_evento).list();
		} catch (HibernateException e) {
			throw new UsException(e);
		} 
		return favorito;
	}
}
