/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dao.generico.IPista;
import Modelo.dto.Pista;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nerea
 */
public class PistaDAO implements IPista {

    Session sesion = null;

    @Override
    public void create(Pista entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Pista read(Integer pk) {
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Pista where idPista='"+pk+"'");
        Pista p = (Pista)q.uniqueResult();
        tx.commit();
        return p;
    }

    @Override
    public void update(Pista entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Pista entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Pista> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Pista");
        List<Pista> listaDePista = (List<Pista>) q.list();
        tx.commit();
        return listaDePista;
    }

    @Override
    public List<Pista> consultarPistas(Integer idAdmin) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Pista where idAdministracion='" + idAdmin + "'");
        List<Pista> listaDePista = (List<Pista>) q.list();
        tx.commit();
        return listaDePista;
    }

}
