/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.administracion;

import Modelo.dao.AdministracionDAO;
import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.CompeticionDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.PistaDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dao.UsuarioDAO;
import Modelo.dto.Administracion;
import Modelo.dto.Competicion;
import Modelo.dto.Partido;
import Modelo.dto.Pista;
import Modelo.dto.Ranking;
import Modelo.dto.Resultado;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nerea
 */
public class eliminarAdmin extends ActionSupport {

    Map sesion = (Map) ActionContext.getContext().get("session");

    int id;
    Administracion admin;
    List<Administracion> listadoAdministraciones;

    AdministracionDAO adminDAO = new AdministracionDAO();
    CompeticionDAO competicionDAO = new CompeticionDAO();
    PartidoDAO partidoDAO = new PartidoDAO();
    RankingDAO rankingDAO = new RankingDAO();
    ResultadoDAO resultadoDAO = new ResultadoDAO();
    ClasificacionglobalDAO clasiDAO = new ClasificacionglobalDAO();
    PistaDAO pistaDAO = new PistaDAO();

    public eliminarAdmin() {
    }

    @Override
    public String execute() throws Exception {
        this.admin = this.adminDAO.read(id);
        List<Competicion> borrarComp = this.competicionDAO.consultarCompeticiones(id);
        List<Pista> borrarPista = this.pistaDAO.consultarPistas(id);
        if (!borrarComp.isEmpty()) {
            for (int i = 0; i < borrarComp.size(); i++) {
                Competicion c = borrarComp.get(i);
                List<Partido> borrarPart = this.partidoDAO.listarPartidosPorCompeticion(c.getIdCompeticion());
                List<Ranking> borrarRank = this.rankingDAO.listarRankingPorCompeticion(c.getIdCompeticion());
                
                //BORRAR PARTIDOS+RESULTADOS
                for (int j = 0; j < borrarPart.size(); j++) {
                    Partido p = borrarPart.get(j);
                    Resultado borrarRes = this.resultadoDAO.consultaPartido(p.getIdPartido());
                    this.resultadoDAO.delete(borrarRes);
                    this.partidoDAO.delete(p);
                }
                //BORRAR RANKING
                for (int j = 0; j < borrarRank.size(); j++) {
                    Ranking r = borrarRank.get(j);
                    this.rankingDAO.delete(r);
                }
                this.competicionDAO.delete(c);
            }
        }
        //BORRAR PISTAS
        for (int j = 0; j < borrarPista.size(); j++) {
            Pista pista = borrarPista.get(j);
            this.pistaDAO.delete(pista);
        }
        
        //BORRAR ADMINISTRACION
        this.adminDAO.delete(admin);
        this.sesion = (Map) ActionContext.getContext().get("session");
        this.listadoAdministraciones = this.adminDAO.list();
        getSesion().put("listadoAdministraciones", this.listadoAdministraciones);
        return SUCCESS;
    }

    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Administracion getAdmin() {
        return admin;
    }

    public void setAdmin(Administracion admin) {
        this.admin = admin;
    }

    public List<Administracion> getListadoAdministraciones() {
        return listadoAdministraciones;
    }

    public void setListadoAdministraciones(List<Administracion> listadoAdministraciones) {
        this.listadoAdministraciones = listadoAdministraciones;
    }

}
