package Modelo.dao.generico;

import Modelo.dto.Administracion;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Administración
 */
public interface IAdministracion extends DAOGenerico<Administracion, Integer>{
    
    Administracion consultaNombre(String nombre);
    
    List<Administracion> leerAdministracionDadoUsuario(String dni);
}
