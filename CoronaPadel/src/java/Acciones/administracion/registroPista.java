/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.PistaDAO;
import Modelo.dto.Administracion;
import Modelo.dto.Clasificacionglobal;
import Modelo.dto.Pista;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nerea
 */
public class registroPista extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    int id;
    String localizacion;
    String tipoDeCubierta;
    String tipoDePista;
    String tipoDeSuelo;

    Pista pista;
    Administracion admin;
    List<Pista> listadoPistas;
    List<Clasificacionglobal> listadoClasificaciones;
    PistaDAO pistaDAO = new PistaDAO();
    ClasificacionglobalDAO clasiDAO = new ClasificacionglobalDAO();


    public registroPista() {
    }

    @Override
    public void validate() {
        String p = "^[A-Za-z ]*$";
        Pattern patron = Pattern.compile(p);
        Matcher m = patron.matcher(getLocalizacion());

        if (getLocalizacion().equals("")) {
            addActionError(getText("pista.localizacion.requerido"));
        } else if (!m.matches()) {
            addActionError(getText("pista.localizacion.formato"));
        }
    }

    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.admin = (Administracion) getSesion().get("admin");
        this.pista = new Pista(getAdmin(), localizacion, tipoDeCubierta, tipoDePista, tipoDeSuelo);
        this.pistaDAO.create(pista);
        this.listadoPistas = this.pistaDAO.consultarPistas(getAdmin().getIdAdministracion());
        getSesion().put("listadoPistas", listadoPistas);
        this.listadoClasificaciones = this.clasiDAO.consultarClasificaciones(getAdmin().getIdAdministracion());
        getSesion().put("listadoClasificaciones", listadoClasificaciones);
        return SUCCESS;
    }

    public String updatePista() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.admin = (Administracion) getSesion().get("admin");
        this.pista = (Pista) getSesion().get("pista");

        boolean cambio = false;
        if (!this.pista.getTipoDeCubierta().equals(tipoDeCubierta)) {
            cambio = true;
            this.pista.setTipoDeCubierta(tipoDeCubierta);
        }

        if (!this.pista.getTipoDePista().equals(tipoDePista)) {
            if (!cambio) {
                cambio = true;
            }
            this.pista.setTipoDePista(tipoDePista);
        }

        if (!this.pista.getTipoDeSuelo().equals(tipoDeSuelo)) {
            if (!cambio) {
                cambio = true;
            }
            this.pista.setTipoDeSuelo(tipoDeSuelo);
        }

        if (cambio) {
            this.pistaDAO.update(this.pista);
        }

        this.listadoPistas = this.pistaDAO.consultarPistas(getAdmin().getIdAdministracion());
        getSesion().put("listadoPistas", listadoPistas);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getTipoDeCubierta() {
        return tipoDeCubierta;
    }

    public void setTipoDeCubierta(String tipoDeCubierta) {
        this.tipoDeCubierta = tipoDeCubierta;
    }

    public String getTipoDePista() {
        return tipoDePista;
    }

    public void setTipoDePista(String tipoDePista) {
        this.tipoDePista = tipoDePista;
    }

    public String getTipoDeSuelo() {
        return tipoDeSuelo;
    }

    public void setTipoDeSuelo(String tipoDeSuelo) {
        this.tipoDeSuelo = tipoDeSuelo;
    }

    public Pista getPista(){
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public Administracion getAdmin() {
        return admin;
    }

    public void setAdmin(Administracion admin) {
        this.admin = admin;
    }

    public List<Pista> getListadoPistas() {
        return listadoPistas;
    }

    public void setListadoPistas(List<Pista> listadoPistas) {
        this.listadoPistas = listadoPistas;
    }

    public List<Clasificacionglobal> getListadoClasificaciones() {
        return listadoClasificaciones;
    }

    public void setListadoClasificaciones(List<Clasificacionglobal> listadoClasificaciones) {
        this.listadoClasificaciones = listadoClasificaciones;
    }

}
