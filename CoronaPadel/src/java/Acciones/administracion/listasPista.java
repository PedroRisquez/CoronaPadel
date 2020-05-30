package Acciones.administracion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada a listar los elementos necesarios para la creación de una
 * pista
 */
public class listasPista extends ActionSupport {

    //Sesión
    Map sesion = (Map) ActionContext.getContext().get("session");

    //Objetos auxiliares
    List<String> listadoCubierta;
    List<String> listadoPista;
    List<String> listadoSuelo;

    public listasPista() {
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");

        this.listadoCubierta = new ArrayList<>();
        this.listadoPista = new ArrayList<>();
        this.listadoSuelo = new ArrayList<>();

        this.listadoCubierta.add(getText("pista.exterior"));
        this.listadoCubierta.add(getText("pista.semi"));
        this.listadoCubierta.add(getText("pista.cubierto"));

        this.listadoPista.add(getText("pista.muro"));
        this.listadoPista.add(getText("pista.cristal"));

        this.listadoSuelo.add(getText("pista.cesped"));
        this.listadoSuelo.add(getText("pista.hormigon"));
        this.listadoSuelo.add(getText("pista.madera"));
        this.listadoSuelo.add(getText("pista.resina"));
        this.listadoSuelo.add(getText("pista.cemento"));

        getSesion().put("listadoCubierta", this.listadoCubierta);
        getSesion().put("listadoPista", this.listadoPista);
        getSesion().put("listadoSuelo", this.listadoSuelo);

        return SUCCESS;
    }

    //Getter & Setter de los atributos
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
