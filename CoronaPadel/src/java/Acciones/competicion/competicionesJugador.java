/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.competicion;

import Modelo.dao.CompeticionDAO;
import Modelo.dao.ParejaDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Pareja;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import Modelo.dto.Resultado;
import Modelo.dto.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class competicionesJugador extends ActionSupport {

    private Map sesion = (Map) ActionContext.getContext().get("session");
    Competicion competicion;
    private int idCompeticion;

    List<Competicion> listaCompeticion = new ArrayList<>();
    List<Pareja> listaParejas = new ArrayList<>();
    List<Resultado> listaResultados = new ArrayList<>();
    List<Partido> listaPartidos = new ArrayList<>();
    List<Ranking> listaRanking = new ArrayList<>();

    private ParejaDAO parejaDAO = new ParejaDAO();
    private ResultadoDAO resultadoDAO = new ResultadoDAO();
    private CompeticionDAO competicionDAO = new CompeticionDAO();
    private RankingDAO rankingDAO = new RankingDAO();

    public competicionesJugador() {
    }

    public String execute() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) sesion.get("usuario");

        listaParejas = this.parejaDAO.parejasDadoUsuario(usuario.getDni());

        for (int i = 0; i < listaParejas.size(); i++) {
            Pareja p = listaParejas.get(i);
            listaResultados = this.resultadoDAO.consultaPareja(p.getIdPareja());
            if (!listaResultados.isEmpty()) {
                for (int k = 0; k < listaResultados.size(); k++) {
                    Partido p2 = listaResultados.get(k).getPartido();
                    if (!listaCompeticion.contains(p2.getCompeticion())) {
                        listaCompeticion.add(p2.getCompeticion());
                    }
                }
            }
        }

        return SUCCESS;
    }

    public String verInformacionExtra() throws Exception {
        this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
        return this.execute();
    }

    public String verPartidos() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) sesion.get("usuario");
        listaParejas = this.parejaDAO.parejasDadoUsuario(usuario.getDni());

        for (int i = 0; i < listaParejas.size(); i++) {
            Pareja p = listaParejas.get(i);
            listaResultados = this.resultadoDAO.consultaPareja(p.getIdPareja());
            if (!listaResultados.isEmpty()) {
                for (int k = 0; k < listaResultados.size(); k++) {
                    Partido p2 = listaResultados.get(k).getPartido();
                    if (p2.getCompeticion().getIdCompeticion() == this.getIdCompeticion()) {
                        listaPartidos.add(p2);
                    }
                }
            }
        }
        getSesion().put("listaPartidos", listaPartidos);
        return this.execute();
    }
    
     public String verRanking() throws Exception{
        this.setListaRanking(rankingDAO.listarRankingPorCompeticion(this.getIdCompeticion()));
        getSesion().put("listaRanking", listaRanking);
        return this.execute();
    }

    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public List<Competicion> getListaCompeticion() {
        return listaCompeticion;
    }

    public void setListaCompeticion(List<Competicion> listaCompeticion) {
        this.listaCompeticion = listaCompeticion;
    }

    public List<Pareja> getListaParejas() {
        return listaParejas;
    }

    public void setListaParejas(List<Pareja> listaParejas) {
        this.listaParejas = listaParejas;
    }

    public List<Resultado> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<Resultado> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
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

}
