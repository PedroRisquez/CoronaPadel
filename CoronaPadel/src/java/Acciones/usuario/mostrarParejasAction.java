/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.usuario;

import Modelo.dao.ParejaDAO;
import Modelo.dto.Pareja;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class mostrarParejasAction extends ActionSupport {
    private List<Pareja> listaDeParejas = new ArrayList<>();
    private ParejaDAO parejaDAO = new ParejaDAO();
    private Map sesion;

    public List<Pareja> getListaDeParejas() {
        return listaDeParejas;
    }

    public void setListaDeParejas(List<Pareja> listaDeParejas) {
        this.listaDeParejas = listaDeParejas;
    }
    
    
    
    public mostrarParejasAction() {
    }
    
    public String execute() throws Exception {
        this.sesion = (Map)ActionContext.getContext().get("session");
        Usuario usuario = (Usuario)this.sesion.get("usuario");
        this.setListaDeParejas(this.parejaDAO.parejasDadoUsuario(usuario.getDni()));
        return SUCCESS;
    }
    
}
