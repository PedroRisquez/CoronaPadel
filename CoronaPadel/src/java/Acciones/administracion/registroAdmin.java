package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dto.Administracion;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Acción dedicada a registrar una administración en el sistema
 */
public class registroAdmin extends ActionSupport {

    //Sesión
    Map sesion = (Map) ActionContext.getContext().get("session");

    //Objetos auxiliares
    int id;
    String nombre;
    Administracion admin;
    Administracion aux;

    //DAO necesarios
    AdministracionDAO adminDAO = new AdministracionDAO();
    List<Administracion> listadoAdministraciones;

    public registroAdmin() {
    }

    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
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

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
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
