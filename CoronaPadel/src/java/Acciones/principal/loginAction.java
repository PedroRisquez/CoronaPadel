package Acciones.principal;

import Modelo.dao.UsuarioDAO;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Acción dedicada al inicio de sesión en la aplicación
 */
public class loginAction extends ActionSupport {

    //Sesión
    private Map sesion;
    
    //Objetos auxiliares
    private String usuario;
    private String clave;
    
    //DAO necesario
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public loginAction() {
    }

    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
    @Override
    public void validate() {
        if (this.getUsuario().equals("")) {
            addActionError("Campo usuario requerido");
        } else if (this.getClave().equals("")) {
            addActionError("Campo clave requerido");
        } else {
            try {
                Usuario user = this.usuarioDAO.comprobarLogin(this.getUsuario(), this.getClave());
                if (user == null) {
                    addActionError("No existe ningun usuario con las credenciales introducidas");
                }
            } catch (Exception ex) {
                Logger.getLogger(loginAction.class.getName()).log(Level.SEVERE, null, ex);
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
        Usuario user = this.usuarioDAO.comprobarLogin(this.getUsuario(), this.getClave());
        if (user != null) {
            this.sesion = (Map) ActionContext.getContext().get("session");
            sesion.put("usuario", user);
            if(user.getRol().equals("Arbitro")){
                return "arbitro";
            }else if(user.getRol().equals("Jugador")){
                return "jugador";
            }else{
                return "jugador";
            }
        } else {
            return ERROR;
        }
    }
    
    //Getter & Setter de los atributos
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
