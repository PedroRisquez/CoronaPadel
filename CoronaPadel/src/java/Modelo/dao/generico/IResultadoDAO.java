package Modelo.dao.generico;

import Modelo.dto.Resultado;
import java.util.List;

/**
 * Clase dedicada a la implementación de los métodos relacionados con la entidad Resultado
 */
public interface IResultadoDAO extends DAOGenerico<Resultado, Integer>{
    
    List<Resultado> consultaPareja(Integer idPareja);
    
    Resultado consultaPartido(Integer idPartido);
}
