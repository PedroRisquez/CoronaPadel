/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.PistaDAO;
import Modelo.dto.Pista;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class readPista extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    int id;
    Pista pista;
    
    PistaDAO pistaDAO = new PistaDAO();
    List<String> listadoCubierta;
    List<String> listadoPista;
    List<String> listadoSuelo;

    public readPista() {
    }

    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.pista = this.pistaDAO.read(this.id);
        getSesion().put("pista", this.pista);

        this.listadoCubierta = new ArrayList<>();
        this.listadoPista = new ArrayList<>();
        this.listadoSuelo = new ArrayList<>();
        
        switch (this.pista.getTipoDeCubierta()) {
            case "Exterior":
                this.listadoCubierta.add(getText("pista.exterior"));
                this.listadoCubierta.add(getText("pista.semi"));
                this.listadoCubierta.add(getText("pista.cubierto"));
                break;
            case "Semi-cubierto":
                this.listadoCubierta.add(getText("pista.semi"));
                this.listadoCubierta.add(getText("pista.exterior"));
                this.listadoCubierta.add(getText("pista.cubierto"));
                break;
            case "Cubierto":
                this.listadoCubierta.add(getText("pista.cubierto"));
                this.listadoCubierta.add(getText("pista.exterior"));
                this.listadoCubierta.add(getText("pista.semi"));
                break;
        } 

        switch (this.pista.getTipoDePista()) {
            case "Muro":
                this.listadoPista.add(getText("pista.muro"));
                this.listadoPista.add(getText("pista.cristal"));
                break;
            case "Cristal":
                this.listadoPista.add(getText("pista.cristal"));
                this.listadoPista.add(getText("pista.muro"));
        }

        switch (this.pista.getTipoDeSuelo()) {
            case "Cesped":
                this.listadoSuelo.add(getText("pista.cesped"));
                this.listadoSuelo.add(getText("pista.hormigon"));
                this.listadoSuelo.add(getText("pista.madera"));
                this.listadoSuelo.add(getText("pista.resina"));
                this.listadoSuelo.add(getText("pista.cemento"));
                break;
            case "Hormigon":
                this.listadoSuelo.add(getText("pista.hormigon"));
                this.listadoSuelo.add(getText("pista.cesped"));
                this.listadoSuelo.add(getText("pista.madera"));
                this.listadoSuelo.add(getText("pista.resina"));
                this.listadoSuelo.add(getText("pista.cemento"));
                break;
            case "Madera":
                this.listadoSuelo.add(getText("pista.madera"));
                this.listadoSuelo.add(getText("pista.cesped"));
                this.listadoSuelo.add(getText("pista.hormigon"));
                this.listadoSuelo.add(getText("pista.resina"));
                this.listadoSuelo.add(getText("pista.cemento"));
                break;
            case "Resina":
                this.listadoSuelo.add(getText("pista.resina"));
                this.listadoSuelo.add(getText("pista.cesped"));
                this.listadoSuelo.add(getText("pista.hormigon"));
                this.listadoSuelo.add(getText("pista.madera"));
                this.listadoSuelo.add(getText("pista.cemento"));
                break;
            case "Cemento":
                this.listadoSuelo.add(getText("pista.cemento"));
                this.listadoSuelo.add(getText("pista.cesped"));
                this.listadoSuelo.add(getText("pista.hormigon"));
                this.listadoSuelo.add(getText("pista.madera"));
                this.listadoSuelo.add(getText("pista.resina"));
                break;
        }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
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
