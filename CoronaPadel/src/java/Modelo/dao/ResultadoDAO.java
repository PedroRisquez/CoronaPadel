/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dao.generico.IResultadoDAO;
import Modelo.dto.Resultado;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pedro
 */
public class ResultadoDAO implements IResultadoDAO {

    Session sesion = null;

    @Override
    public void create(Resultado entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Resultado read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Resultado where idResultado='" + pk + "'");
        Resultado resultado = (Resultado) q.uniqueResult();
        tx.commit();
        return resultado;
    }

    @Override
    public void update(Resultado entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Resultado entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Resultado> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Resultado");
        List<Resultado> listaDeResultado = (List<Resultado>) q.list();
        tx.commit();
        return listaDeResultado;
    }

    public List<Resultado> consultaPareja(Integer idPareja) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Resultado where (idParejaLocal='" + idPareja + "' OR idParejaVisitante ='" + idPareja + "') "
                + "and puntuacionLocal ='0' and puntuacionVisitante ='0'");
        List<Resultado> listaDeResultado = (List<Resultado>) q.list();
        tx.commit();
        return listaDeResultado;
    }

    public Resultado consultaPartido(Integer idPartido) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Resultado where idPartido ='" + idPartido + "'");
        Resultado resultado = (Resultado) q.uniqueResult();
        tx.commit();
        return resultado;
    }
}
