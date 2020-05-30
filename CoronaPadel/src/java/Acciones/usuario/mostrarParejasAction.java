package Acciones.usuario;

import Modelo.dao.ParejaDAO;
import Modelo.dto.Pareja;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada a mostrar las parejas en la que un usuario esta involucrado
 */
public class mostrarParejasAction extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objeto auxiliar
    private List<Pareja> listaDeParejas = new ArrayList<>();

    //DAO necesario
    private ParejaDAO parejaDAO = new ParejaDAO();

    public mostrarParejasAction() {
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
        this.setListaDeParejas(this.parejaDAO.parejasDadoUsuario(usuario.getDni()));
        return SUCCESS;
    }

    public List<Pareja> getListaDeParejas() {
        return listaDeParejas;
    }

    public void setListaDeParejas(List<Pareja> listaDeParejas) {
        this.listaDeParejas = listaDeParejas;
    }
}
