/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao.generico;

import Modelo.dto.Competicion;
import java.util.List;

/**
 *
 * @author paula
 */
public interface ICompeticionDAO extends DAOGenerico<Competicion, Integer>{

    List<Competicion> consultarCompeticiones(Integer id);

   List<Competicion> listarPorAdministrador(String dni);
}
