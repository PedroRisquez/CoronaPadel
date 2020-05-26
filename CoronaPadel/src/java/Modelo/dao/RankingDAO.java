/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.dao.generico.IRankingDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author paula
 */
public class RankingDAO implements IRankingDAO {

    Session sesion = null;

    @Override
    public void create(Ranking entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Ranking read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Ranking where idRanking='" + pk + "'");
        Ranking ranking = (Ranking) q.uniqueResult();
        tx.commit();
        return ranking;
    }

    @Override
    public void update(Ranking entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Ranking entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Ranking> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Ranking");
        List<Ranking> listaDeRanking = (List<Ranking>) q.list();
        tx.commit();
        return listaDeRanking;
    }

    public List<Ranking> listarRankingPorCompeticion(int idCompeticion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Ranking where idCompeticion='" + idCompeticion + "' order by puntuacion DESC");
        List<Ranking> listaDeRankingPorCompeticion = (List<Ranking>) q.list();
        tx.commit();
        return listaDeRankingPorCompeticion;
    }
    
    public Ranking rankingDadaPareja (int idPareja, int idCompeticion){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Ranking where idPareja='" + idPareja + "' and idCompeticion='" + idCompeticion + "'");
        Ranking ranking = (Ranking) q.uniqueResult();
        tx.commit();
        return ranking;
    }
}
