/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.usuario;

import Modelo.dao.CompeticionDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Partido;
import Modelo.dto.Resultado;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pedro
 */
public class cargarCompeticionesInscripcion extends ActionSupport {
    private List<Competicion> listaInscripcion = new ArrayList<>();
    private List<Competicion> listaDeCompeticionesDisponibles = new ArrayList<>();
    private Map sesion;
    
    //dao
    private CompeticionDAO competicionDAO = new CompeticionDAO();

    public List<Competicion> getListaInscripcion() {
        return listaInscripcion;
    }

    public void setListaInscripcion(List<Competicion> listaInscripcion) {
        this.listaInscripcion = listaInscripcion;
    }

    public List<Competicion> getListaDeCompeticionesDisponibles() {
        return listaDeCompeticionesDisponibles;
    }

    public void setListaDeCompeticionesDisponibles(List<Competicion> listaDeCompeticionesDisponibles) {
        this.listaDeCompeticionesDisponibles = listaDeCompeticionesDisponibles;
    }
    
    public cargarCompeticionesInscripcion() {
    }
    
    public String execute() throws Exception {
        this.listaInscripcion = this.competicionDAO.list();
        Competicion competicion;
        for (int i = 0; i < this.listaInscripcion.size(); i++) {
            competicion = this.listaInscripcion.get(i);
            Set<Partido> listaPartido = competicion.getPartidos();
            int numPartidos = listaPartido.size();
            Date fechaHoy = new Date();
            Date fechaInicioComp = new Date(competicion.getFechaInicio().getTime());
            boolean add = false;
            Iterator<Partido> it = listaPartido.iterator();
            while (it.hasNext()) {
                Partido next = it.next();
                Iterator<Resultado> it2 = next.getResultados().iterator();
                while (it2.hasNext()) {
                    Resultado next1 = it2.next();
                    if(next1.getParejaByIdParejaLocal()==null && next1.getParejaByIdParejaVisitante()==null){
                        add = true;
                    }
                }
                
            }
            if(add && fechaHoy.before(fechaInicioComp)){
                this.listaDeCompeticionesDisponibles.add(competicion);
            }
            
        }
        this.sesion = (Map)ActionContext.getContext().get("session");
        if(this.sesion.get("usuario")==null){
            this.sesion.put("usuario", null);
        }
        
        return SUCCESS;
    }
    
}
