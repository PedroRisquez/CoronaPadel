/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao.generico;

import Modelo.dto.Clasificacionglobal;
import java.util.List;

/**
 *
 * @author Nerea
 */
public interface IClasificacionglobal extends DAOGenerico<Clasificacionglobal, Integer> {

    List<Clasificacionglobal> consultarClasificaciones(Integer id);
}
