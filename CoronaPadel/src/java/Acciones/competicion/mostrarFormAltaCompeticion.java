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
 * Acción dedicada a recoger los datos de una competición para su creación
 */
public class mostrarFormAltaCompeticion extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objetos auxiliares
    private List<String> formato = new ArrayList<>();
    private List<Administracion> administracion = new ArrayList<>();

    //DAO necesarios
    private AdministracionDAO administracionDAO = new AdministracionDAO();

    public mostrarFormAltaCompeticion() {
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
        Usuario usuario = (Usuario) this.sesion.get("usuario");
        this.administracion = this.administracionDAO.leerAdministracionDadoUsuario(usuario.getDni());
        this.getFormato().add("Liga");
        return SUCCESS;
    }

    //Getter & Setter de los atributos
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
}
