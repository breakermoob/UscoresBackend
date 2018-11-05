package co.edu.udea.uscores.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.uscores.dao.InterfaceMisTorneosDao;
import co.edu.udea.uscores.dto.MisTorneos;
import co.edu.udea.uscores.exception.UsException;

/**
 * <p>Implementaci�n de la interfaz MisTorneos</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co / Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

public class MisTorneosDaoSpring extends HibernateDaoSupport implements InterfaceMisTorneosDao {
	
	@SuppressWarnings("unchecked")
	@Override
    /**
     * Metodo para recuperar la lista de los torneos creados por un usuario en la tabla MisTorneo de la DB
     * @return lista de torneos de un usuario recuperada
     */
	public List<MisTorneos> obtenerMisTorneos(String usuario) throws UsException {
		List<MisTorneos> misTorneos = new ArrayList<MisTorneos>();
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(MisTorneos.class).add( Restrictions.like("correo", usuario));
			misTorneos = criteria.list();			
		}catch(HibernateException e){
			throw new UsException(e);
		}
		return misTorneos;
	}

	@Override
    /**
     * Metodo para asociar un torneo a un usuario en la tabla MisTorneo de la DB
     * @param Torneo que se va a asociar
     */
	public void crearMisTorneos(MisTorneos misTorneos) throws UsException {
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();			
			session.save(misTorneos);
		}catch(HibernateException e){
			throw new UsException(e);
		}
	}

	@Override
    /**
     * Metodo para eliminar un torneo en la tabla MisTorneo de la DB
     * @param Torneo que se va a eliminar
     */
	public void eliminarMisTorneos(MisTorneos misTorneos) throws UsException {
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();	
			session.delete(misTorneos);			
		}catch(HibernateException e){
			throw new UsException(e);
		}
	}

	@Override
    /**
     * Metodo para actualizar un torneo en la tabla MisTorneo de la DB
     * @param Torneo que se va a actulalizar
     */
	public void actualizarMisTorneos(MisTorneos misTorneos) throws UsException {
		Transaction tx = null;
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();			
			tx = session.beginTransaction();
			session.update(misTorneos);
			tx.commit();
		}catch(HibernateException e){
			throw new UsException(e);
		}		
	}
	
	/**
     * Metodo para buscar un torneo en la tabla MisTorneo de la DB
     * @param correo del usuario y id del torneo
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<MisTorneos> buscarMisTorneos(String correo, int id_torneo) throws UsException {		
		List<MisTorneos> misTorneos = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();			
			misTorneos = session.createQuery("from MisTorneos where correo ="+"'"+correo+"'"+"and idTorneo = "+id_torneo).list();
		} catch (HibernateException e) {
			throw new UsException(e);
		} 
		return misTorneos;
	}

}
