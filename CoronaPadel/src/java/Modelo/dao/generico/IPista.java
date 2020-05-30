package Modelo.dao.generico;

import Modelo.dto.Pista;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Pista
 */
public interface IPista extends DAOGenerico<Pista, Integer> {

    List<Pista> consultarPistas(Integer idAdmin);
}
