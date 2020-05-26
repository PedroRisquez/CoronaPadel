/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dto.Administracion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class verAdministraciones extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    AdministracionDAO adminDAO = new AdministracionDAO();
    List<Administracion> listadoAdministraciones;

    public verAdministraciones() {
    }

    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.listadoAdministraciones = this.adminDAO.list();
        getSesion().put("listadoAdministraciones", this.listadoAdministraciones);
        return SUCCESS;
    }

    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public List<Administracion> getListadoAdministraciones() {
        return listadoAdministraciones;
    }

    public void setListadoAdministraciones(List<Administracion> listadoAdministraciones) {
        this.listadoAdministraciones = listadoAdministraciones;
    }

}
