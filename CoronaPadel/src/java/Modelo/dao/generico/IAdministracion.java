/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao.generico;

import Modelo.dto.Administracion;

/**
 *
 * @author Nerea
 */
public interface IAdministracion extends DAOGenerico<Administracion, Integer>{
    
    Administracion consultaNombre(String nombre);
}
