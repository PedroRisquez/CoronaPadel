/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.CompeticionDAO;
import Modelo.dao.PistaDAO;
import Modelo.dto.Administracion;
import Modelo.dto.Clasificacionglobal;
import Modelo.dto.Competicion;
import Modelo.dto.Pista;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class verAdmin extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    Integer id;
    List<Pista> listadoPistas;
    List<Clasificacionglobal> listadoClasificaciones;
    List<Competicion> listadoCompeticiones;
    Administracion admin;

    AdministracionDAO adminDAO = new AdministracionDAO();
    PistaDAO pistaDAO = new PistaDAO();
    ClasificacionglobalDAO clasiDAO = new ClasificacionglobalDAO();
    CompeticionDAO competiDAO = new CompeticionDAO();

    public verAdmin() {
    }

    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.admin = this.adminDAO.read(id);
        getSesion().put("admin", admin);
        this.listadoPistas = this.pistaDAO.consultarPistas(getAdmin().getIdAdministracion());
        getSesion().put("listadoPistas", listadoPistas);
        this.listadoCompeticiones = this.competiDAO.consultarCompeticiones(getAdmin().getIdAdministracion());
        getSesion().put("listadoCompeticiones", listadoCompeticiones);
        this.listadoClasificaciones = this.clasiDAO.consultarClasificaciones(getAdmin().getIdAdministracion());
        getSesion().put("listadoClasificaciones", listadoClasificaciones);
        
        return SUCCESS;
    }

    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pista> getListadoPistas() {
        return listadoPistas;
    }

    public void setListadoPistas(List<Pista> listadoPistas) {
        this.listadoPistas = listadoPistas;
    }

    public Administracion getAdmin() {
        return admin;
    }

    public void setAdmin(Administracion admin) {
        this.admin = admin;
    }

    public List<Clasificacionglobal> getListadoClasificaciones() {
        return listadoClasificaciones;
    }

    public void setListadoClasificaciones(List<Clasificacionglobal> listadoClasificaciones) {
        this.listadoClasificaciones = listadoClasificaciones;
    }

    public List<Competicion> getListadoCompeticiones() {
        return listadoCompeticiones;
    }

    public void setListadoCompeticiones(List<Competicion> listadoCompeticiones) {
        this.listadoCompeticiones = listadoCompeticiones;
    }


}
