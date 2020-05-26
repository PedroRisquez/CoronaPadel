/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author pedro
 */
public class modificarParejaAction extends ActionSupport {
    private int idPareja;
    private String nombre;
    private List<Pareja> listaDeParejas = new ArrayList<>();
    private Map sesion;
    private Pareja pareja;

    
    //dao
    private ParejaDAO parejaDAO = new ParejaDAO();
    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pareja> getListaDeParejas() {
        return listaDeParejas;
    }

    public void setListaDeParejas(List<Pareja> listaDeParejas) {
        this.listaDeParejas = listaDeParejas;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }
    
    
    
    public modificarParejaAction() {
    }
    
    public void validate(){
        if(this.getNombre().equals("")){
            addActionError("El nombre es un campo requerido");
            this.setPareja(this.parejaDAO.read(this.getIdPareja()));
        }
    }
    
    public String execute() throws Exception {
        Pareja pareja = this.parejaDAO.read(this.getIdPareja());
        pareja.setNombre(this.getNombre());
        this.parejaDAO.update(pareja);
        this.sesion = (Map)ActionContext.getContext().get("session");
        Usuario usuario = (Usuario)this.sesion.get("usuario");
        this.setListaDeParejas(this.parejaDAO.parejasDadoUsuario(usuario.getDni()));
        return SUCCESS;
    }
    
}
