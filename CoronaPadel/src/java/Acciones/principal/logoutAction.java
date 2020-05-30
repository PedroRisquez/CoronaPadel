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
 * Acción dedicada a cerrar sesión en la aplicación
 */
public class logoutAction extends ActionSupport {

    //Sesión
    private Map sesion;

    public logoutAction() {
    }

     /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        sesion.remove("usuario");
        return SUCCESS;
    }

}
