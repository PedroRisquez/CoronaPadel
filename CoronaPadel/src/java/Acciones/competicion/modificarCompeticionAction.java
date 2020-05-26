/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.competicion;

import Modelo.dao.CompeticionDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class modificarCompeticionAction extends ActionSupport {

    private int idCompeticion;
    private Competicion competicion;
    private CompeticionDAO competicionDAO = new CompeticionDAO();

//    formulario
    private String nombre;
    private String descripcion;
    private String formulario;

    //   salida
    private List<Competicion> listaCompeticion = new ArrayList<>();
//sesion
    private Map sesion;

//metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Competicion> getListaCompeticion() {
        return listaCompeticion;
    }

    public void setListaCompeticion(List<Competicion> listaCompeticion) {
        this.listaCompeticion = listaCompeticion;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }

    public modificarCompeticionAction() {
    }

    public void validate() {
        if (this.getFormulario() != null && this.getFormulario().equals("si")) {
            if (this.getNombre().equals("")) {
                this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
                addActionError(getText("competicion.nombre.requerido"));
            }
            if (this.getDescripcion().equals("")) {
                this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
                addActionError(getText("competicion.descripcion.requerido"));
            }
        }
    }

    public String execute() throws Exception {
        this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
        return SUCCESS;
    }

    public String modificaCompeticion() throws Exception {
        this.setCompeticion(this.competicionDAO.read(this.getIdCompeticion()));
        this.competicion.setNombre(this.getNombre());
        this.competicion.setDescripcion(this.getDescripcion());
        this.competicionDAO.update(competicion);
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) sesion.get("usuario");
        this.setListaCompeticion(competicionDAO.listarPorAdministrador(usuario.getDni()));
        return SUCCESS;
    }
}
