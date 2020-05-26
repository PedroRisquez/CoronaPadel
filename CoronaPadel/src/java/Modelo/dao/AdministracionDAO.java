/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dao.generico.IAdministracion;
import Modelo.dto.Administracion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nerea
 */
public class AdministracionDAO implements IAdministracion {

    Session sesion = null;

    @Override
    public void create(Administracion entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Administracion read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Administracion where idAdministracion='" + pk + "'");
        Administracion a = (Administracion) q.uniqueResult();
        tx.commit();
        return a;
    }

    @Override
    public void update(Administracion entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Administracion entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Administracion> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Administracion");
        List<Administracion> listaDeAdministracion = (List<Administracion>) q.list();
        tx.commit();
        return listaDeAdministracion;
    }

    @Override
    public Administracion consultaNombre(String nombre) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Administracion where nombre = '" + nombre + "'");
        Administracion a = (Administracion) q.uniqueResult();
        tx.commit();
        return a;
    }

    public List<Administracion> leerAdministracionDadoUsuario(String dni) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Administracion where dniAdministrador = '" + dni + "'");
        List<Administracion> listaDeAdministracion = (List<Administracion>) q.list();
        tx.commit();
        return listaDeAdministracion;
    }

}
