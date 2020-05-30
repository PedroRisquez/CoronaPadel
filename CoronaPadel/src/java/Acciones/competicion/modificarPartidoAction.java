package Acciones.competicion;

import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dto.Clasificacionglobal;
import Modelo.dto.Pareja;
import Modelo.dto.Partido;
import Modelo.dto.Resultado;
import Modelo.dto.Ranking;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada a la modificación de un partido
 */
public class modificarPartidoAction extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objeto auxiliar
    private int idResultado;
    private int idPartido;
    private int duracion;
    private int puntuacionLocal;
    private int puntuacionVisitante;
    private List<Partido> listaDePartidosArbitro = new ArrayList<>();
    private Resultado resultado;
    private Partido partido;

    //DAO necesario
    private ResultadoDAO resultadoDAO = new ResultadoDAO();
    private PartidoDAO partidoDAO = new PartidoDAO();
    private RankingDAO rankingDAO = new RankingDAO();
    private ClasificacionglobalDAO clasificacionglobalDAO = new ClasificacionglobalDAO();

    public modificarPartidoAction() {
    }

    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
    @Override
    public void validate() {
        if (this.getDuracion() < 0) {
            addActionError(getText("partido.duracion.formato"));
            this.setPartido(this.partidoDAO.read(this.getIdPartido()));
            this.setResultado(this.resultadoDAO.read(this.getIdResultado()));
        }
        if (this.getPuntuacionLocal() < 0) {
            addActionError(getText("partido.puntuacionLocal.formato"));
            this.setPartido(this.partidoDAO.read(this.getIdPartido()));
            this.setResultado(this.resultadoDAO.read(this.getIdResultado()));
        }
        if (this.getPuntuacionVisitante() < 0) {
            addActionError(getText("partido.puntuacionVisitante.formato"));
            this.setPartido(this.partidoDAO.read(this.getIdPartido()));
            this.setResultado(this.resultadoDAO.read(this.getIdResultado()));
        }
        this.sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) this.sesion.get("usuario");
        System.out.println(usuario.getNombreCompleto());
        this.setListaDePartidosArbitro(this.partidoDAO.listarPartidosPorArbitro(usuario.getDni()));

    }

     /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        partido = this.partidoDAO.read(this.getIdPartido());
        resultado = this.resultadoDAO.read(this.getIdResultado());

        partido.setDuracion(this.getDuracion());
        resultado.setPuntuacionLocal(this.getPuntuacionLocal());
        resultado.setPuntuacionVisitante(this.getPuntuacionVisitante());

        this.partidoDAO.update(partido);
        this.resultadoDAO.update(resultado);
        Pareja pareja;
        Usuario usuario1;
        Usuario usuario2;
        if (resultado.getPuntuacionLocal() > resultado.getPuntuacionVisitante()) {
            pareja = resultado.getParejaByIdParejaLocal();
            usuario1 = pareja.getUsuarioByDni1();
            usuario2 = pareja.getUsuarioByDni2();
        } else {
            pareja = resultado.getParejaByIdParejaVisitante();
            usuario1 = pareja.getUsuarioByDni1();
            usuario2 = pareja.getUsuarioByDni2();
        }
        
        Ranking ranking = this.rankingDAO.rankingDadaPareja(pareja.getIdPareja(), partido.getCompeticion().getIdCompeticion());
        ranking.setPuntuacion(ranking.getPuntuacion() + 1);
        
        Clasificacionglobal clasificacionGlobal1 = this.clasificacionglobalDAO.clasificacionGlobalDadoUsuario(usuario1.getDni(), partido.getCompeticion().getAdministracion().getIdAdministracion());
        Clasificacionglobal clasificacionGlobal2 = this.clasificacionglobalDAO.clasificacionGlobalDadoUsuario(usuario2.getDni(), partido.getCompeticion().getAdministracion().getIdAdministracion());
        clasificacionGlobal1.setPuntuacion(clasificacionGlobal1.getPuntuacion() + 1);
        clasificacionGlobal2.setPuntuacion(clasificacionGlobal2.getPuntuacion() + 1);
        
        this.rankingDAO.update(ranking);
        this.clasificacionglobalDAO.update(clasificacionGlobal1);
        this.clasificacionglobalDAO.update(clasificacionGlobal2);
        
        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPuntuacionLocal() {
        return puntuacionLocal;
    }

    public void setPuntuacionLocal(int puntuacionLocal) {
        this.puntuacionLocal = puntuacionLocal;
    }

    public int getPuntuacionVisitante() {
        return puntuacionVisitante;
    }

    public void setPuntuacionVisitante(int puntuacionVisitante) {
        this.puntuacionVisitante = puntuacionVisitante;
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
}
