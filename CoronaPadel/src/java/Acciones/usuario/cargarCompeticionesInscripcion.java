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
 * Acción dedicada a visualizar las competiciones aún disponibles para
 * inscribirse
 */
public class cargarCompeticionesInscripcion extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objeto auxiliar
    private List<Competicion> listaInscripcion = new ArrayList<>();
    private List<Competicion> listaDeCompeticionesDisponibles = new ArrayList<>();

    //DAO necesario
    private CompeticionDAO competicionDAO = new CompeticionDAO();

    public cargarCompeticionesInscripcion() {
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
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
                    if (next1.getParejaByIdParejaLocal() == null && next1.getParejaByIdParejaVisitante() == null) {
                        add = true;
                    }
                }

            }
            if (add && fechaHoy.before(fechaInicioComp)) {
                this.listaDeCompeticionesDisponibles.add(competicion);
            }

        }
        this.sesion = (Map) ActionContext.getContext().get("session");
        if (this.sesion.get("usuario") == null) {
            this.sesion.put("usuario", null);
        }

        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public Map getSesion() {
        return sesion;
    }

    public void setSesion(Map sesion) {
        this.sesion = sesion;
    }

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

}
