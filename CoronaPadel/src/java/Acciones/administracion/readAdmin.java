/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dto.Administracion;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class readAdmin extends ActionSupport {
    
    Map sesion = (Map) ActionContext.getContext().get("session");
    
    int id;
    Administracion admin;

    AdministracionDAO adminDAO = new AdministracionDAO();
    
    public readAdmin() {
    }
    
    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.admin = this.adminDAO.read(this.id);
        getSesion().put("admin", this.admin);
        return SUCCESS;
    }

    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Administracion getAdmin() {
        return admin;
    }

    public void setAdmin(Administracion admin) {
        this.admin = admin;
    }
    
}
