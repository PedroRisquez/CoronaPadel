package Acciones.competicion;

import Modelo.dao.CompeticionDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import Modelo.dto.Resultado;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada a la eliminación de una competición
 */
public class eliminarCompeticion extends ActionSupport {

    //Sesión
    Map sesion = (Map) ActionContext.getContext().get("session");

    //Objetos necesarios
    int idCompeticion;
    Competicion c;
    List<Competicion> listaCompeticion = new ArrayList<>();

    //DAO necesarios
    CompeticionDAO competicionDAO = new CompeticionDAO();
    PartidoDAO partidoDAO = new PartidoDAO();
    RankingDAO rankingDAO = new RankingDAO();
    ResultadoDAO resultadoDAO = new ResultadoDAO();

    public eliminarCompeticion() {
    }

     /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        c = this.competicionDAO.read(idCompeticion);
        List<Partido> borrarPart = this.partidoDAO.listarPartidosPorCompeticion(c.getIdCompeticion());
        List<Ranking> borrarRank = this.rankingDAO.listarRankingPorCompeticion(c.getIdCompeticion());

        //BORRAR PARTIDOS+RESULTADOS
        for (int j = 0; j < borrarPart.size(); j++) {
            Partido p = borrarPart.get(j);
            Resultado borrarRes = this.resultadoDAO.consultaPartido(p.getIdPartido());
            this.resultadoDAO.delete(borrarRes);
            this.partidoDAO.delete(p);
        }
        //BORRAR RANKING
        for (int j = 0; j < borrarRank.size(); j++) {
            Ranking r = borrarRank.get(j);
            this.rankingDAO.delete(r);
        }
        this.competicionDAO.delete(c);
        Usuario usuario = (Usuario)sesion.get("usuario");
        this.setListaCompeticion(competicionDAO.listarPorAdministrador(usuario.getDni()));
        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public Competicion getC() {
        return c;
    }

    public void setC(Competicion c) {
        this.c = c;
    }

    public List<Competicion> getListaCompeticion() {
        return listaCompeticion;
    }

    public void setListaCompeticion(List<Competicion> listaCompeticion) {
        this.listaCompeticion = listaCompeticion;
    }

}
