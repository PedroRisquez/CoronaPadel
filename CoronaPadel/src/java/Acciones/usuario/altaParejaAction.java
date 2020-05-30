package Acciones.usuario;

import Modelo.dao.ParejaDAO;
import Modelo.dao.UsuarioDAO;
import Modelo.dto.Pareja;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada al registro de una pareja en el sistema
 */
public class altaParejaAction extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objetos auxiliares
    private String dni;
    private String nombre;
    private String formulario;
    List<Usuario> listaDeUsuario = new ArrayList<>();
    private List<Pareja> listaDeParejas = new ArrayList<>();

    //DAO necesarios
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ParejaDAO parejaDAO = new ParejaDAO();

    public altaParejaAction() {
    }

    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
    @Override
    public void validate() {
        if (this.getFormulario() != null && this.getFormulario().equals("no")) {
            sesion = (Map) ActionContext.getContext().get("session");
            Usuario pareja = this.usuarioDAO.read(this.getDni());
            Usuario usuario = (Usuario) sesion.get("usuario");
            if (this.parejaDAO.parejasDadoUsuarios(usuario.getDni(), pareja.getDni()) != null) {
                addActionError(getText("parejaNO") + pareja.getNombreCompleto() + " (" + pareja.getUsuario() + ")");
                this.setListaDeUsuario(this.usuarioDAO.leerJugadores());
            }

            if (pareja.getDni().equals(usuario.getDni())) {
                addActionError(getText("parejaNO2"));
                this.setListaDeUsuario(this.usuarioDAO.leerJugadores());
            }
        } else {
            if (this.getNombre().equals("")) {
                this.setListaDeUsuario(this.usuarioDAO.leerJugadores());
                addFieldError("nombre", "El campo debe de estar relleno");
            }
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
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) this.sesion.get("usuario");
        Pareja pareja = new Pareja(this.getNombre());
        pareja.setUsuarioByDni1(usuario);
        pareja.setUsuarioByDni2((Usuario) sesion.get("pareja"));
        this.parejaDAO.create(pareja);
        this.setListaDeParejas(this.parejaDAO.parejasDadoUsuario(usuario.getDni()));
        return SUCCESS;
    }

    /**
     * seleccionarPareja(): método dedicado a reflejar el nombre del compañero
     * que será pareja del usuario "Jugador"
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String seleccionarPareja() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = this.usuarioDAO.read(this.getDni());
        sesion.put("pareja", usuario);
        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public List<Usuario> getListaDeUsuario() {
        return listaDeUsuario;
    }

    public void setListaDeUsuario(List<Usuario> listaDeUsuario) {
        this.listaDeUsuario = listaDeUsuario;
    }

    public List<Pareja> getListaDeParejas() {
        return listaDeParejas;
    }

    public void setListaDeParejas(List<Pareja> listaDeParejas) {
        this.listaDeParejas = listaDeParejas;
    }
}
