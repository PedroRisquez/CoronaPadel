package Acciones.usuario;

import Modelo.dao.UsuarioDAO;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Acción dedicada a visualizar los usuarios registrados para poder formar
 * pareja
 */
public class irFormParejaAction extends ActionSupport {

    //Objetos auxiliares
    List<Usuario> listaDeUsuario = new ArrayList<>();
    private String dni;
    private String usuarioOdni;

    //DAO necesario
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public irFormParejaAction() {
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        this.setListaDeUsuario(this.usuarioDAO.leerJugadores());
        return SUCCESS;
    }

    /**
     * filtro(): método dedicado a filtrar la lista de usuario por dni
     * 
     * @return Exito de la operación
     * @throws java.lang.Exception
    */
    public String filtro() throws Exception {
        this.setListaDeUsuario(this.usuarioDAO.readUsuarioPorDniOUsuario(this.getUsuarioOdni()));
        return SUCCESS;
    }
    
    //Getter & Setter de los atributos
    public List<Usuario> getListaDeUsuario() {
        return listaDeUsuario;
    }

    public void setListaDeUsuario(List<Usuario> listaDeUsuario) {
        this.listaDeUsuario = listaDeUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuarioOdni() {
        return usuarioOdni;
    }

    public void setUsuarioOdni(String usuarioOdni) {
        this.usuarioOdni = usuarioOdni;
    }


}
