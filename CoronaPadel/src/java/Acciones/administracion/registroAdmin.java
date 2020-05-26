/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.CompeticionDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.PistaDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dao.UsuarioDAO;
import Modelo.dto.Administracion;
import Modelo.dto.Competicion;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import Modelo.dto.Resultado;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nerea
 */
public class registroAdmin extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    int id;
    String nombre;
    Administracion admin;
    Administracion aux;

    AdministracionDAO adminDAO = new AdministracionDAO();
    List<Administracion> listadoAdministraciones;

    public registroAdmin() {
    }

    @Override
    public void validate() {
        String p = "^[A-Za-z0-9 ]*$";
        Pattern patron = Pattern.compile(p);
        Matcher m = patron.matcher(getNombre());

        if (getNombre().equals("")) {
            addActionError(getText("administracion.nombre.requerido"));
        } else if (!m.matches()) {
            addActionError(getText("administracion.nombre.formato"));
        }

        this.admin = this.adminDAO.read(id);
        this.aux = this.adminDAO.consultaNombre(this.nombre);
        if (this.aux != null) {
            addActionError(getText("administracion.nombre.existe"));
        }
    }

    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.admin = new Administracion(this.nombre);
        this.admin.setUsuario((Usuario) getSesion().get("usuario"));
        this.adminDAO.create(admin);
        this.listadoAdministraciones = this.adminDAO.list();
        getSesion().put("listadoAdministraciones", this.listadoAdministraciones);
        return SUCCESS;
    }

    public String updateAdmin() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.admin = (Administracion) getSesion().get("admin");

        if (!this.admin.getNombre().equals(this.nombre)) {
            this.admin.setNombre(nombre);
            this.adminDAO.update(this.admin);
        }

        this.listadoAdministraciones = this.adminDAO.list();
        getSesion().put("listadoAdministraciones", this.listadoAdministraciones);
        return SUCCESS;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Administracion getAdmin() {
        return admin;
    }

    public void setAdmin(Administracion admin) {
        this.admin = admin;
    }

    public Administracion getAux() {
        return aux;
    }

    public void setAux(Administracion aux) {
        this.aux = aux;
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
