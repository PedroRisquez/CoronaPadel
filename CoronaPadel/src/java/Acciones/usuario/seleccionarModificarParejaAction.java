/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.usuario;

import Modelo.dao.ParejaDAO;
import Modelo.dto.Pareja;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author pedro
 */
public class seleccionarModificarParejaAction extends ActionSupport {
    private Pareja pareja;
    private int idPareja;

    
    private ParejaDAO parejaDAO = new ParejaDAO();
    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }
    
    
    public seleccionarModificarParejaAction() {
    }
    
    public String execute() throws Exception {
        this.setPareja(this.parejaDAO.read(this.getIdPareja()));
        return SUCCESS;
    }
    
}
