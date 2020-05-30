package Modelo.dao.generico;

import Modelo.dto.Ranking;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Ranking.
 */
public interface IRankingDAO extends DAOGenerico<Ranking, Integer>{
    
    List<Ranking> listarRankingPorCompeticion(int idCompeticion);
    
    Ranking rankingDadaPareja (int idPareja, int idCompeticion);
}
