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
 * Acción dedicada a recoger de una administración para ser visualizada más
 * detalladamente
 */
public class verAdmin extends ActionSupport {

    //Sesión
    Map sesion = (Map) ActionContext.getContext().get("session");

    //Objetos auxiliares
    Integer id;
    List<Pista> listadoPistas;
    List<Clasificacionglobal> listadoClasificaciones;
    List<Competicion> listadoCompeticiones;
    Administracion admin;

    //DAO necesarios
    AdministracionDAO adminDAO = new AdministracionDAO();
    PistaDAO pistaDAO = new PistaDAO();
    ClasificacionglobalDAO clasiDAO = new ClasificacionglobalDAO();
    CompeticionDAO competiDAO = new CompeticionDAO();

    public verAdmin() {
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

    //Getter & Setter de los atributos
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
