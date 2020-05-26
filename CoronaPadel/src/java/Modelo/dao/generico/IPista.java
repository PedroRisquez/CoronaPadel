/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao.generico;

import Modelo.dto.Pista;
import java.util.List;

/**
 *
 * @author Nerea
 */
public interface IPista extends DAOGenerico<Pista, Integer> {

    List<Pista> consultarPistas(Integer idAdmin);
}
