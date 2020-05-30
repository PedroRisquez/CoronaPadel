package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dto.Administracion;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 * Acción dedicada a recoger los datos de una administración para su posterior
 * modificación
 */
public class readAdmin extends ActionSupport {

    //Sesión
    Map sesion = (Map) ActionContext.getContext().get("session");

    //Objetos auxiliares
    int id;
    Administracion admin;

    //DAO necesarios
    AdministracionDAO adminDAO = new AdministracionDAO();

    public readAdmin() {
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
        this.admin = this.adminDAO.read(this.id);
        getSesion().put("admin", this.admin);
        return SUCCESS;
    }

    //Getter & Setter de los atributos
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

    public Administracion getAdmin() {
        return admin;
    }

    public void setAdmin(Administracion admin) {
        this.admin = admin;
    }

}
