package Modelo.dao.generico;

import Modelo.dto.Competicion;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Competición
 */
public interface ICompeticionDAO extends DAOGenerico<Competicion, Integer> {

    List<Competicion> consultarCompeticiones(Integer id);

    List<Competicion> listarPorAdministrador(String dni);
}
