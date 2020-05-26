/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.usuario;

import Modelo.dao.UsuarioDAO;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class irFormParejaAction extends ActionSupport {
    List<Usuario> listaDeUsuario = new ArrayList<>();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private String dni;
    private String usuarioOdni;
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
    
    
    
    public irFormParejaAction() {
    }
    
    public String execute() throws Exception {
        this.setListaDeUsuario(this.usuarioDAO.leerJugadores());
        return SUCCESS;
    }
    
    public String filtro() throws Exception{
        this.setListaDeUsuario(this.usuarioDAO.readUsuarioPorDniOUsuario(this.getUsuarioOdni()));
        return SUCCESS;
    }
    
}
