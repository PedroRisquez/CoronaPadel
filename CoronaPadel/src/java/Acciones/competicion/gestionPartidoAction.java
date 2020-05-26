/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.competicion;

import Modelo.dao.PartidoDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dto.Partido;
import Modelo.dto.Resultado;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author paula
 */
public class gestionPartidoAction extends ActionSupport {
     private int idPartido;
     private PartidoDAO partidoDAO = new PartidoDAO();
     private ResultadoDAO resultadoDAO = new ResultadoDAO();
     private List<Partido> listaDePartidosArbitro = new ArrayList<>();
     private Map sesion;
     
     //formularioModificar
     private int idResultado;
     private Resultado resultado;
     private Partido partido;
    public gestionPartidoAction() {
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public List<Partido> getListaDePartidosArbitro() {
        return listaDePartidosArbitro;
    }

    public void setListaDePartidosArbitro(List<Partido> listaDePartidosArbitro) {
        this.listaDePartidosArbitro = listaDePartidosArbitro;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) this.sesion.get("usuario");
        this.setListaDePartidosArbitro(this.partidoDAO.listarPartidosPorArbitro(usuario.getDni()));
        return SUCCESS;
    }
    
     public String eliminarPartido() throws Exception{
         Partido partido = partidoDAO.read(this.getIdPartido());
         this.partidoDAO.delete(partido);
         return SUCCESS;
    }
     
     public String mostrarModificarPartidoAction() throws Exception{
         this.setPartido(this.partidoDAO.read(this.getIdPartido()));
         this.setResultado(this.resultadoDAO.read(this.getIdResultado()));
         return this.execute();
     }
     
     public String eliminarResultado() throws Exception{
         Resultado resultado = this.resultadoDAO.read(this.getIdResultado());
         this.resultadoDAO.delete(resultado);
         return SUCCESS;
    }
     
}
