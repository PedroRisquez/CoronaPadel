/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class listasPista extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    List<String> listadoCubierta;
    List<String> listadoPista;
    List<String> listadoSuelo;

    public listasPista() {
    }

    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        
        this.listadoCubierta = new ArrayList<>();
        this.listadoPista = new ArrayList<>();
        this.listadoSuelo = new ArrayList<>();
        
        this.listadoCubierta.add("Exterior");
        this.listadoCubierta.add("Semi-cubierto");
        this.listadoCubierta.add("Cubierto");

        this.listadoPista.add("Muro");
        this.listadoPista.add("Cristal");

        this.listadoSuelo.add("Cesped");
        this.listadoSuelo.add("Hormigon");
        this.listadoSuelo.add("Madera");
        this.listadoSuelo.add("Resina");
        this.listadoSuelo.add("Cemento");

        getSesion().put("listadoCubierta", this.listadoCubierta);
        getSesion().put("listadoPista", this.listadoPista);
        getSesion().put("listadoSuelo", this.listadoSuelo);

        return SUCCESS;
    }

    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public List<String> getListadoCubierta() {
        return listadoCubierta;
    }

    public void setListadoCubierta(List<String> listadoCubierta) {
        this.listadoCubierta = listadoCubierta;
    }

    public List<String> getListadoPista() {
        return listadoPista;
    }

    public void setListadoPista(List<String> listadoPista) {
        this.listadoPista = listadoPista;
    }

    public List<String> getListadoSuelo() {
        return listadoSuelo;
    }

    public void setListadoSuelo(List<String> listadoSuelo) {
        this.listadoSuelo = listadoSuelo;
    }

}
