package Acciones.competicion;

import Modelo.dao.RankingDAO;
import Modelo.dto.Ranking;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Acción dedicada a la gestión del ranking
 */
public class gestionRankingAction extends ActionSupport {

    //Objeto auxiliar
    private int idRanking;

    //DAO necesario
    private RankingDAO rankingDAO = new RankingDAO();

    public gestionRankingAction() {
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * eliminarRanking(): método dedicado a eliminar el ranking de una
     * competición seleccionada
     * 
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String eliminarRanking() throws Exception {
        Ranking ranking = rankingDAO.read(this.getIdRanking());
        this.rankingDAO.delete(ranking);
        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public int getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }
}
