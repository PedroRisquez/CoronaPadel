/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.principal;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class irUsuarioAction extends ActionSupport {
    private Map sesion;
    public irUsuarioAction() {
    }
    
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        if(this.sesion.get("usuario")!=null){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
}
