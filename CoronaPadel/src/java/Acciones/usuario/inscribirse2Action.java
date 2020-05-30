package Acciones.usuario;

import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.ParejaDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dto.Clasificacionglobal;
import Modelo.dto.Competicion;
import Modelo.dto.Pareja;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import Modelo.dto.Resultado;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Acción dedicada a asignar a la pareja a la competición
 */
public class inscribirse2Action extends ActionSupport {

    //Sesion
    private Map sesion;
    
    //Objeto auxiliar
    private int idPareja;

    //DAO necesario
    private ParejaDAO parejaDAO = new ParejaDAO();
    private ResultadoDAO resultadoDAO = new ResultadoDAO();
    private ClasificacionglobalDAO clasificacionDAO = new ClasificacionglobalDAO();
    private RankingDAO rankingDAO = new RankingDAO();

    public inscribirse2Action() {
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        Competicion competicion = (Competicion) this.sesion.get("competicion");
        Pareja pareja = this.parejaDAO.read(this.getIdPareja());
        List<Pareja> listaDeParejasCompeticion = new ArrayList<>();
        List<Resultado> listaDeResultadosARellenar = new ArrayList<>();

        Set<Partido> listaPartido = competicion.getPartidos();
        Iterator<Partido> it = listaPartido.iterator();
        while (it.hasNext()) {
            Partido next = it.next();
            Iterator<Resultado> it2 = next.getResultados().iterator();
            while (it2.hasNext()) {
                Resultado next1 = it2.next();

                if (next1.getParejaByIdParejaLocal() == null && next1.getParejaByIdParejaVisitante() == null) {
                    listaDeResultadosARellenar.add(next1);
                } else {
                    if (!listaDeParejasCompeticion.contains(next1.getParejaByIdParejaLocal())) {
                        listaDeParejasCompeticion.add(next1.getParejaByIdParejaLocal());
                    }

                }
            }
        }

        for (int i = 0; i < listaDeParejasCompeticion.size(); i++) {
            Resultado r1 = listaDeResultadosARellenar.get(i);
            Resultado r2 = listaDeResultadosARellenar.get(i + listaDeParejasCompeticion.size());
            r1.setParejaByIdParejaLocal(pareja);
            r1.setParejaByIdParejaVisitante(listaDeParejasCompeticion.get(i));
            r2.setParejaByIdParejaVisitante(pareja);
            r2.setParejaByIdParejaLocal(listaDeParejasCompeticion.get(i));
            this.resultadoDAO.update(r1);
            this.resultadoDAO.update(r2);
        }

        Ranking r;
        Clasificacionglobal c, c2;
        r = new Ranking(competicion, pareja, 0);
        this.rankingDAO.create(r);
        c = new Clasificacionglobal(competicion.getAdministracion(), pareja.getUsuarioByDni1(), 0);
        this.clasificacionDAO.create(c);
        c2 = new Clasificacionglobal(competicion.getAdministracion(), pareja.getUsuarioByDni2(), 0);
        this.clasificacionDAO.create(c2);
        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }
}
