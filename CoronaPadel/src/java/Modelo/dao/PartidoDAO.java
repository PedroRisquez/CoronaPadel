/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dao.generico.IPartidoDAO;
import Modelo.dto.Partido;
import Modelo.dto.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author paula
 */
public class PartidoDAO implements IPartidoDAO {

    Session sesion = null;

    @Override
    public void create(Partido entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Partido read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Partido where idPartido='" + pk + "'");
        Partido partido = (Partido) q.uniqueResult();
        tx.commit();
        return partido;
    }

    @Override
    public void update(Partido entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Partido entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Partido> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Partido");
        List<Partido> listaDePartido = (List<Partido>) q.list();
        tx.commit();
        return listaDePartido;
    }

    public List<Partido> listarPartidosPorCompeticion(int idCompeticion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Partido where idCompeticion ='" + idCompeticion + "'");
        List<Partido> listaPartidosPorCompeticion = (List<Partido>) q.list();
        tx.commit();
        return listaPartidosPorCompeticion;
    }
    
    public List<Partido> listarPartidosPorArbitro(String dniArbitro) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Partido where dniArbitro ='" + dniArbitro + "'");
        List<Partido> listaPartidosPorArbitro = (List<Partido>) q.list();
        tx.commit();
        return listaPartidosPorArbitro;
    }
    
    public List<Partido> listarPartidosNoFinalizadosPorArbitro(String dniArbitro){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Partido where dniArbitro ='" + dniArbitro + "' and duracion ='0'");
        List<Partido> listaPartidosPorArbitro = (List<Partido>) q.list();
        tx.commit();
        return listaPartidosPorArbitro;
    }
    
  
}
