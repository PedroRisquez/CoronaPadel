package Modelo.dao.generico;

import Modelo.dto.Pareja;
import java.util.List;

/**
 *  Interfaz dedicada a los métodos relacionados con la entidad Pareja.
 */
public interface IParejaDAO extends DAOGenerico<Pareja, Integer>{
    
    List<Pareja> parejasDadoUsuario(String dni);
    
    Pareja parejasDadoUsuarios(String dni1,String dni2);
}
