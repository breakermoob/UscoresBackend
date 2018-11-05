package co.edu.udea.uscores.daoImpl;

/**
 * <p>Implementacion del dao para Evento</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* 		  Yennifer Serna - yennifer.serna@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.uscores.dao.InterfaceEventoDao;
import co.edu.udea.uscores.dto.Evento;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

public class EventoDaoSpring extends HibernateDaoSupport implements InterfaceEventoDao {
	
	@SuppressWarnings("unchecked")
	@Override
	
    /**
     * Metodo para traer todos los eventos en la DB
     * @return Lista de eventos
     */
	public List<Evento> obtenerEventos(Torneo torneo) throws UsException {
		
		List<Evento> evento = new ArrayList<Evento>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Evento.class).add( Restrictions.like("torneo", torneo));			
			evento = criteria.list();
		} catch (HibernateException e) {
			throw new UsException(e);
		} 
		return evento;
	}

	@Override
    /**
     * Metodo para hacer registros en la tabla Evento de la DB
     * @param evento que se va a crear
     * @return el evento creado
     */
	public Evento crearEvento(Evento evento) throws UsException {
		
		Session session = null;
		try {
			
			session = this.getSessionFactory().getCurrentSession();
			session.save(evento);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return evento;

	}

	@Override
    /**
     * Metodo para eliminar registros en la tabla Evento de la DB
     * @param evento que se va a eliminar
     */
	public void eliminarEvento(Evento evento) throws UsException {
		
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.delete(evento);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

	}

	@Override
    /**
     * Metodo para actualizar registros en la tabla Evento de la DB
     * @param evento que se va a acutlizar
     * @return el evento actualizado
     */
	public Evento actualizarEvento(Evento evento) throws UsException {
		
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.update(evento);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return evento;

	}

	@Override
    /**
     * Metodo para buscar registros en la tabla Evento de la DB
     * @param pk del evento que buscamos
     * @return el evento que se busca
     */
	public Evento buscarEvento(int idEvento) throws UsException {
		
		Evento evento = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			evento = (Evento) session.load(Evento.class, idEvento);
		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return evento;
	}

}
