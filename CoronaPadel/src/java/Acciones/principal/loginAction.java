/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.principal;

import Modelo.dao.UsuarioDAO;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class loginAction extends ActionSupport {

    private String usuario;
    private String clave;
    private Map sesion;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

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

    public loginAction() {
    }

    public void validate() {
        if (this.getUsuario().equals("")) {
            addActionError(getText("usuario.usuario.requerido"));
        } else if (this.getClave().equals("")) {
            addActionError(getText("usuario.clave.requerida"));
        } else {
            try {
                Usuario user = this.usuarioDAO.comprobarLogin(this.getUsuario(), this.getClave());
                if (user == null) {
                    addActionError(getText("login.fallo"));
                }
            } catch (Exception ex) {
                Logger.getLogger(loginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String execute() throws Exception {
        Usuario user = this.usuarioDAO.comprobarLogin(this.getUsuario(), this.getClave());
        if (user != null) {
            this.sesion = (Map) ActionContext.getContext().get("session");
            sesion.put("usuario", user);
            if(user.getRol().equals("Arbitro") || user.getRol().equals("Referee")){
                return "arbitro";
            }else if(user.getRol().equals("Jugador") || user.getRol().equals("Player")){
                return "jugador";
            }else{
                return "jugador";
            }
        } else {
            return ERROR;
        }
    }
    
}
