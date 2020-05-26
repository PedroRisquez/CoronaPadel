/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.competicion;

import Modelo.dao.AdministracionDAO;
import Modelo.dto.Administracion;
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
public class mostrarFormAltaCompeticion extends ActionSupport {
    private List <String> formato = new ArrayList<>();
    private List <Administracion> administracion= new ArrayList<>();
    private Map sesion;
    private AdministracionDAO administracionDAO = new AdministracionDAO();

    public List<String> getFormato() {
        return formato;
    }

    public void setFormato(List<String> formato) {
        this.formato = formato;
    }

    public List<Administracion> getAdministracion() {
        return administracion;
    }

    public void setAdministracion(List<Administracion> administracion) {
        this.administracion = administracion;
    }
    
    
    
    public mostrarFormAltaCompeticion() {
    }
    
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario)this.sesion.get("usuario");
        this.administracion = this.administracionDAO.leerAdministracionDadoUsuario(usuario.getDni());
        this.getFormato().add("Liga");
        return SUCCESS;
    }
    
}
