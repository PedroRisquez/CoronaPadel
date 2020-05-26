/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.competicion;

import Modelo.dao.CompeticionDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.RankingDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class gestionCompeticionAction extends ActionSupport {

    private List<Competicion> listaCompeticion = new ArrayList<>();
    private int idCompeticion;
    private Competicion competicion;
    private List<Partido> listaPartidos = new ArrayList<>();
    private List<Ranking> listaRanking = new ArrayList<>();   
    private CompeticionDAO competicionDAO = new CompeticionDAO();
    private PartidoDAO partidoDAO = new PartidoDAO();
    private RankingDAO rankingDAO = new RankingDAO();
    private Map sesion = (Map) ActionContext.getContext().get("session");

    public gestionCompeticionAction() {
    }

    public List<Competicion> getListaCompeticion() {
        return listaCompeticion;
    }

    public void setListaCompeticion(List<Competicion> listaCompeticion) {
        this.listaCompeticion = listaCompeticion;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public List<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public List<Ranking> getListaRanking() {
        return listaRanking;
    }

    public void setListaRanking(List<Ranking> listaRanking) {
        this.listaRanking = listaRanking;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }
    
    

    public String execute() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario)sesion.get("usuario");
        this.setListaCompeticion(competicionDAO.listarPorAdministrador(usuario.getDni()));
        return SUCCESS;
    }

    /**
     * Listado de partidos en función de la competicion
     * @return success
     * @throws Exception 
     */
    public String verPartidos() throws Exception{
        this.setListaPartidos(partidoDAO.listarPartidosPorCompeticion(this.getIdCompeticion()));
        return this.execute();
    }
    public String verRanking() throws Exception{
        this.setListaRanking(rankingDAO.listarRankingPorCompeticion(this.getIdCompeticion()));
        return this.execute();
    }
    
    public String verInformacionExtra() throws Exception{
        this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
        return this.execute();
    }

}
