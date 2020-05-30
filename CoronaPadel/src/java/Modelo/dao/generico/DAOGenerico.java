package Modelo.dao.generico;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz genérica dedicada a los métodos CRUD de la base de datos
 */
public interface DAOGenerico <T extends Serializable, K extends Serializable> {
    void create(T entidad);
    T read(K pk);
    void update(T entidad);
    void delete(T entidad);
    List<T> list();
}
