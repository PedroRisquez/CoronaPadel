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
 * Acción dedicada la gestión de un partido
 */
public class gestionPartidoAction extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objetos auxiliares
    private int idPartido;
    private List<Partido> listaDePartidosArbitro = new ArrayList<>();
    private int idResultado;
    private Resultado resultado;
    private Partido partido;

    //DAO necesarios
    private PartidoDAO partidoDAO = new PartidoDAO();
    private ResultadoDAO resultadoDAO = new ResultadoDAO();

    public gestionPartidoAction() {
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
        Usuario usuario = (Usuario) this.sesion.get("usuario");
        this.setListaDePartidosArbitro(this.partidoDAO.listarPartidosPorArbitro(usuario.getDni()));
        return SUCCESS;
    }

    /**
     * eliminarPartido(): método dedicado al borrado de un partido
     * 
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String eliminarPartido() throws Exception {
        Partido partido = partidoDAO.read(this.getIdPartido());
        this.partidoDAO.delete(partido);
        return SUCCESS;
    }

    /**
     * mostrarModificarPartidoAction(): método dedicado a mostrar los datos de
     * un partido para poder modificarlo
     * 
     * @return Exito de la aplicación
     * @throws java.lang.Exception
     */
    public String mostrarModificarPartidoAction() throws Exception {
        this.setPartido(this.partidoDAO.read(this.getIdPartido()));
        this.setResultado(this.resultadoDAO.read(this.getIdResultado()));
        return this.execute();
    }

    /**
     * eliminarResultado(): método dedicado a eliminar el resultado de un partido
     * 
     * @return Exito de la operación
     * @throws java.lang.Exception
    */
    public String eliminarResultado() throws Exception {
        Resultado resultado = this.resultadoDAO.read(this.getIdResultado());
        this.resultadoDAO.delete(resultado);
        return SUCCESS;
    }

    //Getter & Setter de los atributos
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

}
