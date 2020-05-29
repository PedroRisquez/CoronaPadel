/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao.generico;

import Modelo.dto.Usuario;

/**
 *
 * @author pedro
 */
public interface IUsuarioDAO extends DAOGenerico<Usuario, String>{
    Usuario comprobarLogin(String usuario, String clave) throws Exception;
}
