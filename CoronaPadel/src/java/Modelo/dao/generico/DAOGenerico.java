/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao.generico;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface DAOGenerico <T extends Serializable, K extends Serializable> {
    void create(T entidad);
    T read(K pk);
    void update(T entidad);
    void delete(T entidad);
    List<T> list();
}
