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

/**
 * Acción dedicada a la gestión de una competición
 */
public class gestionCompeticionAction extends ActionSupport {

    //Sesión
    private Map sesion = (Map) ActionContext.getContext().get("session");

    //Objetos auxiliares
    private List<Competicion> listaCompeticion = new ArrayList<>();
    private int idCompeticion;
    private Competicion competicion;
    private List<Partido> listaPartidos = new ArrayList<>();
    private List<Ranking> listaRanking = new ArrayList<>();

    //DAO necesarios
    private CompeticionDAO competicionDAO = new CompeticionDAO();
    private PartidoDAO partidoDAO = new PartidoDAO();
    private RankingDAO rankingDAO = new RankingDAO();

    public gestionCompeticionAction() {
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String execute() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) sesion.get("usuario");
        this.setListaCompeticion(competicionDAO.listarPorAdministrador(usuario.getDni()));
        return SUCCESS;
    }

    /**
     * verPartidos(): método dedicado a visualizar los partidos de la
     * competición seleccionada
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String verPartidos() throws Exception {
        this.setListaPartidos(partidoDAO.listarPartidosPorCompeticion(this.getIdCompeticion()));
        return this.execute();
    }

    /**
     * verRanking(): método dedicado a visualizar el ranking de la competición
     * seleccionada
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String verRanking() throws Exception {
        this.setListaRanking(rankingDAO.listarRankingPorCompeticion(this.getIdCompeticion()));
        return this.execute();
    }

     /**
     * verInformacionExtra(): método dedicado a visualizar la información extra
     * referente a la competición seleccionada
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String verInformacionExtra() throws Exception {
        this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
        return this.execute();
    }

    //Getter & Setter de los atributos
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
}
