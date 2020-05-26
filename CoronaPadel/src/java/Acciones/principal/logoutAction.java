/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.principal;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class logoutAction extends ActionSupport {

    private Map sesion;

    public logoutAction() {
    }

    public String execute() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        sesion.remove("usuario");
        return SUCCESS;
    }

}
