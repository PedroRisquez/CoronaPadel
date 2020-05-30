package Modelo.dao;

import Modelo.dao.generico.IClasificacionglobal;
import Modelo.dto.Clasificacionglobal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase dedicada a la implementación de los métodos relacionados con la entidad
 * Clasificacionglobal
 */
public class ClasificacionglobalDAO implements IClasificacionglobal {

    Session sesion = null;

    @Override
    public void create(Clasificacionglobal entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Clasificacionglobal read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Clasificacionglobal where idClasificacionGlobal='" + pk + "'");
        Clasificacionglobal c = (Clasificacionglobal) q.uniqueResult();
        tx.commit();
        return c;
    }

    @Override
    public void update(Clasificacionglobal entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Clasificacionglobal entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Clasificacionglobal> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Clasificacionglobal");
        List<Clasificacionglobal> listaDeClasificacionGlobal = (List<Clasificacionglobal>) q.list();
        tx.commit();
        return listaDeClasificacionGlobal;
    }

    @Override
    public List<Clasificacionglobal> consultarClasificaciones(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Clasificacionglobal where idAdministracion ='" + id + "' order by puntuacion desc");
        List<Clasificacionglobal> listaDeClasificacionGlobal = (List<Clasificacionglobal>) q.list();
        tx.commit();
        return listaDeClasificacionGlobal;
    }

    @Override
    public Clasificacionglobal clasificacionGlobalDadoUsuario(String dni, Integer idAdministracion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Clasificacionglobal where dni='" + dni + "' and idAdministracion='" + idAdministracion + "'");
        Clasificacionglobal c = (Clasificacionglobal) q.uniqueResult();
        tx.commit();
        return c;
    }

}
