/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.competicion;

import Modelo.dao.RankingDAO;
import Modelo.dto.Ranking;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author paula
 */
public class gestionRankingAction extends ActionSupport {

    private int idRanking;
    private RankingDAO rankingDAO = new RankingDAO();

    public gestionRankingAction() {
    }

    public int getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String eliminarRanking() throws Exception {
        Ranking ranking = rankingDAO.read(this.getIdRanking());
        this.rankingDAO.delete(ranking);
        return SUCCESS;
    }
}
