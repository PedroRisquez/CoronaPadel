package Modelo.dao;

import Modelo.dao.generico.IParejaDAO;
import Modelo.dto.Pareja;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase dedicada a la implementación de los métodos relacionados con la entidad Pareja
 */
public class ParejaDAO implements IParejaDAO{
    Session sesion = null;

    @Override
    public void create(Pareja entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Pareja read(Integer pk) {
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Pareja where idPareja='"+pk+"'");
        Pareja pareja = (Pareja)q.uniqueResult();
        tx.commit();
        return pareja;
    }

    @Override
    public void update(Pareja entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Pareja entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Pareja> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Pareja");
        List<Pareja> listaDePareja = (List<Pareja>) q.list();
        tx.commit();
        return listaDePareja;
    }

    @Override
    public List<Pareja> parejasDadoUsuario(String dni) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Pareja where dni1='"+ dni +"' or dni2='"+ dni +"'");
        List<Pareja> listaDeParejaDadoUsuario = (List<Pareja>) q.list();
        tx.commit();
        return listaDeParejaDadoUsuario;
    }
    
    @Override
    public Pareja parejasDadoUsuarios(String dni1,String dni2) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Pareja where (dni1='"+ dni1 +"' and dni2='"+ dni2 +"') or (dni2='"+ dni1 +"' and dni1='"+ dni2 +"')");
        Pareja pareja = (Pareja)q.uniqueResult();
        tx.commit();
        return pareja;
    }
    
}
