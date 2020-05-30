package Modelo.dao;

import Modelo.dao.generico.ICompeticionDAO;
import Modelo.dto.Competicion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase dedicada a la implementación de los métodos relacionados con la entidad Competición
 */
public class CompeticionDAO implements ICompeticionDAO {

    Session sesion = null;

    @Override
    public void create(Competicion entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Competicion read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Competicion where idCompeticion='" + pk + "'");
        Competicion competicion = (Competicion) q.uniqueResult();
        tx.commit();
        return competicion;
    }

    @Override
    public void update(Competicion entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Competicion entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Competicion> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Competicion");
        List<Competicion> listaDeCompeticion = (List<Competicion>) q.list();
        tx.commit();
        return listaDeCompeticion;
    }


    @Override
    public List<Competicion> consultarCompeticiones(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Competicion where idAdministracion ='" + id + "'");
        List<Competicion> listaDeCompeticion = (List<Competicion>) q.list();
        tx.commit();
        return listaDeCompeticion;
    }
  
    @Override
    public List<Competicion> listarPorAdministrador(String dni) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Competicion where dni='" + dni + "'");
        List<Competicion> listaDeCompeticionPorAdministrador = (List<Competicion>) q.list();
        tx.commit();
        return listaDeCompeticionPorAdministrador;
    }
}
