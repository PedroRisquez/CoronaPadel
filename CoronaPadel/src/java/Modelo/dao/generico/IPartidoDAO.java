package Modelo.dao.generico;

import Modelo.dto.Partido;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Partido
 */
public interface IPartidoDAO extends DAOGenerico<Partido, Integer> {

    List<Partido> listarPartidosPorCompeticion(int idCompeticion);

    List<Partido> listarPartidosPorArbitro(String dniArbitro);

    List<Partido> listarPartidosNoFinalizadosPorArbitro(String dniArbitro);
}
