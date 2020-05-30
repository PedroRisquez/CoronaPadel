package Modelo.dao.generico;

import Modelo.dto.Clasificacionglobal;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Clasificacionglobal
 */
public interface IClasificacionglobal extends DAOGenerico<Clasificacionglobal, Integer> {

    List<Clasificacionglobal> consultarClasificaciones(Integer id);
    
    Clasificacionglobal clasificacionGlobalDadoUsuario(String dni, Integer idAdministracion);
}
