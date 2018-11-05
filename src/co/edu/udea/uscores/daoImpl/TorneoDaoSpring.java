package co.edu.udea.uscores.daoImpl;

/**
 * <p>Implementacion del dao para Torneo</p>
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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.uscores.dao.InterfaceTorneoDao;
import co.edu.udea.uscores.dto.Torneo;
import co.edu.udea.uscores.exception.UsException;

public class TorneoDaoSpring extends HibernateDaoSupport implements InterfaceTorneoDao {


	@SuppressWarnings("unchecked")
	@Override
    /**
     * Metodo para recuperar la lista de Torneos tabla Torneo de la DB
     * @return La lista de torneos
     */
	// Metodo para recuperar la lista de Torneos usando Spring
	public List<Torneo> obtenerTorneos() throws UsException {

		List<Torneo> torneo = new ArrayList<Torneo>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Torneo.class);
			torneo = criteria.list();

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return torneo;
	}

	@Override
    /**
     * Metodo para crear un torneo en la tabla usuario de la DB
     * @param Torneo que se va a crear
     * @return Torneo creado 
     */
	public Torneo crearTorneo(Torneo torneo) throws UsException {

		Session session = null;
		try {

			session = this.getSessionFactory().getCurrentSession();
			session.save(torneo);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return torneo;

	}

	@Override
    /**
     * Metodo para eliminar un torneo en la tabla Torneo de la DB
     * @param Torneo que se va a eliminar
     */
	public void eliminarTorneo(Torneo torneo) throws UsException {

		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.delete(torneo);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

	}

	@Override
    /**
     * Metodo para crear un torneo en la tabla Torneo de la DB
     * @param Torneo que se va a actulizar
     * @return Torneo actualizado 
     */
	public Torneo actualizarTorneo(Torneo torneo) throws UsException {
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();

			session.update(torneo);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return torneo;

	}

	@Override
    /**
     * Metodo para buscar un torneo en la tabla Torneo de la DB
     * @param id del torneo que se busca
     * @return Torneo que se busca 
     */
	public Torneo buscarTorneo(int idTorneo) throws UsException {

		Torneo torneo = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();

			torneo = (Torneo) session.load(Torneo.class, idTorneo);

		} catch (HibernateException e) {
			throw new UsException(e);
		} 

		return torneo;
	}
}
