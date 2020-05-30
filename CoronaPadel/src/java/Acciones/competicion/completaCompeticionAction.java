package Acciones.competicion;

import Modelo.dao.ClasificacionglobalDAO;
import Modelo.dao.CompeticionDAO;
import Modelo.dao.ParejaDAO;
import Modelo.dao.PartidoDAO;
import Modelo.dao.RankingDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dao.UsuarioDAO;
import Modelo.dto.Clasificacionglobal;
import Modelo.dto.Competicion;
import Modelo.dto.Pareja;
import Modelo.dto.Partido;
import Modelo.dto.Ranking;
import Modelo.dto.Resultado;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada a visualizar las parejas y árbitros disponibles para la
 * competición en curso
 */
public class completaCompeticionAction extends ActionSupport {

    //Sesion
    private Map sesion;

    //Objetos auxiliares
    private List<Pareja> listaDeParejas = new ArrayList<>();
    private List<Partido> listaDePartidos = new ArrayList<>();
    private String asigna;
    private List<Integer> idPareja = new ArrayList<>();
    private List<Usuario> listaDeArbitros = new ArrayList<>();
    private List<Partido> listaPartidosPareja1 = new ArrayList<>();
    private List<Partido> listaPartidosPareja2 = new ArrayList<>();
    private List<Resultado> listaResultadosPareja1 = new ArrayList<>();
    private List<Resultado> listaResultadosPareja2 = new ArrayList<>();
    private List<Partido> listaPartidosArbitro = new ArrayList<>();
    private List<Date> fechasPartidos = new ArrayList<>();
    private String dni;

    //DAO necesarios
    private ParejaDAO parejaDAO = new ParejaDAO();
    private PartidoDAO partidoDAO = new PartidoDAO();
    private ResultadoDAO resultadoDAO = new ResultadoDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private CompeticionDAO competicionDAO = new CompeticionDAO();
    private RankingDAO rankingDAO = new RankingDAO();
    private ClasificacionglobalDAO clasificacionDAO = new ClasificacionglobalDAO();

    public completaCompeticionAction() {
    }

    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
    @Override
    public void validate() {
        this.sesion = (Map) ActionContext.getContext().get("session");
        Competicion competicion = (Competicion) this.sesion.get("competicion");
        int numParejas = competicion.getNparejas();
        if (this.asigna != null && this.asigna.equals("true")) {
            if (this.idPareja.size() < numParejas && competicion.isPrivada()) {
                addActionError(getText("competicion.numParejas1") + numParejas + getText("competicion.numParejas2"));
                crearFechasPartidos();
                this.setListaDeParejas(this.parejaDAO.list());
                this.setListaDeArbitros(this.usuarioDAO.listarArbitros());
            } else if (idPareja.size() < 2 && !competicion.isPrivada()) {
                addActionError(getText("competicion.nParejas.publica"));
                crearFechasPartidos();
                this.setListaDeParejas(this.parejaDAO.list());
                this.setListaDeArbitros(this.usuarioDAO.listarArbitros());
            }
            if (this.dni == null) {
                addActionError(getText("competicion.noArbitro"));
            }
        }
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        crearFechasPartidos();
        this.setListaDeParejas(this.parejaDAO.list());
        this.setListaDeArbitros(this.usuarioDAO.listarArbitros());
        return SUCCESS;
    }

    /**
     * asignarParejas(): método dedicado a asignar las parejas a los partidos de
     * la competición en curso
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    public String asignaParejas() throws Exception {
        this.sesion = (Map) ActionContext.getContext().get("session");
        Competicion competicion = (Competicion) this.sesion.get("competicion");
        int numParejas = competicion.getNparejas();
        int numPartidos = competicion.getNpartidos();
        Usuario arbitro = this.usuarioDAO.read(this.dni);
        crearFechasPartidos();
        competicion.setFechaFin(this.fechasPartidos.get(this.fechasPartidos.size() - 1));
        this.competicionDAO.create(competicion);
        if (competicion.isPrivada()) {
            for (int i = 0; i < numParejas; i++) {
                for (int j = 0; j < numParejas; j++) {
                    if (i != j) {
                        Partido p = new Partido();
                        p.setUsuario(arbitro);
                        p.setCompeticion(competicion);
                        Pareja pareja1 = this.parejaDAO.read(this.idPareja.get(i));
                        Pareja pareja2 = this.parejaDAO.read(this.idPareja.get(j));
                        p.setFechaInicio(fechasPartidos.get(i));
                        Resultado resultado = new Resultado(0, 0);
                        resultado.setPartido(p);
                        resultado.setParejaByIdParejaLocal(pareja1);
                        resultado.setParejaByIdParejaVisitante(pareja2);
                        this.partidoDAO.create(p);
                        this.resultadoDAO.create(resultado);
                    }
                }
            }
        } else {
            //APUNTAR PAREJAS ESCOGIDAS
            for (int i = 0; i < idPareja.size(); i++) {
                for (int j = 0; j < idPareja.size(); j++) {
                    if (i != j) {
                        Partido p = new Partido(arbitro, fechasPartidos.get(i), 0);
                        p.setCompeticion(competicion);
                        Pareja pareja1 = this.parejaDAO.read(this.idPareja.get(i));
                        Pareja pareja2 = this.parejaDAO.read(this.idPareja.get(j));
                        Resultado resultado = new Resultado(0, 0);
                        resultado.setPartido(p);
                        resultado.setParejaByIdParejaLocal(pareja1);
                        resultado.setParejaByIdParejaVisitante(pareja2);
                        this.partidoDAO.create(p);
                        this.resultadoDAO.create(resultado);
                    }
                }
            }

            //DEJAR PARTIDOS SIN PAREJAS
            for (int i = idPareja.size(); i < numPartidos; i++) {
                Partido p = new Partido();
                p.setUsuario(arbitro);
                p.setCompeticion(competicion);
                p.setFechaInicio(fechasPartidos.get(i));
                Resultado resultado = new Resultado(0, 0);
                resultado.setPartido(p);
                this.partidoDAO.create(p);
                this.resultadoDAO.create(resultado);
            }
        }

        //AÑADIR PAREJAS AL RANKING DE LA COMPETICIÓN Y AÑADIR A LOS USUARIOS EN LA CLASIFICACIÓN GLOBAL DE LA ADMINISTRACIÓN
        Ranking r;
        Clasificacionglobal c, c2;
        for (int i = 0; i < idPareja.size(); i++) {
            Pareja pareja1 = this.parejaDAO.read(this.idPareja.get(i));
            r = new Ranking(competicion, pareja1, 0);
            this.rankingDAO.create(r);
            Clasificacionglobal cl = this.clasificacionDAO.clasificacionGlobalDadoUsuario(pareja1.getUsuarioByDni1().getDni(), competicion.getAdministracion().getIdAdministracion());
            if (cl == null) {
                c = new Clasificacionglobal(competicion.getAdministracion(), pareja1.getUsuarioByDni1(), 0);
                this.clasificacionDAO.create(c);
            }
            Clasificacionglobal cl2 = this.clasificacionDAO.clasificacionGlobalDadoUsuario(pareja1.getUsuarioByDni2().getDni(), competicion.getAdministracion().getIdAdministracion());
            if (cl2 == null) {
                c2 = new Clasificacionglobal(competicion.getAdministracion(), pareja1.getUsuarioByDni2(), 0);
                this.clasificacionDAO.create(c2);
            }

        }

        return SUCCESS;
    }

    /**
     * crearFechasPartidos(): método dedicado a crear las fechas para los
     * partidos de la competición en curso
     */
    private void crearFechasPartidos() {
        this.sesion = (Map) ActionContext.getContext().get("session");
        Competicion competicion = (Competicion) this.sesion.get("competicion");
        //OBTENER FECHAS PREDEFINIDAS PARA LA COMPETICION
        Date fecha = competicion.getFechaInicio();
        int nPartidos = competicion.getNpartidos();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        fecha.setHours(12);
        this.fechasPartidos.add(fecha);
        Date fechaAnterior;
        Calendar fAnterior = Calendar.getInstance();
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay;
        for (int i = 1; i < nPartidos; i++) {
            fechaAnterior = fechasPartidos.get(i - 1);
            fAnterior.setTime(fechaAnterior);
            finalDay = format2.format(fechaAnterior);
            if (finalDay.equals("sábado")) {
                //Añadir un dia
                fAnterior.add(Calendar.DAY_OF_YEAR, 1);
            } else {
                //Añadir 6 dias, para empezar en sabado.
                fAnterior.add(Calendar.DAY_OF_YEAR, 6);
            }
            this.fechasPartidos.add(i, fAnterior.getTime());
        }
    }

    /**
     * setListaDeParejas(): método dedicado a establecer que parejas hay disponibles para participar
     * en la competición en curso
     * 
     * @param listaDeParejas todas las parejas del sistema
     */
    public void setListaDeParejas(List<Pareja> listaDeParejas) {
        List<Pareja> listaParejasJugador = new ArrayList<>();
        for (int i = 0; i < listaDeParejas.size(); i++) {
            boolean valido = true;
            Pareja p = listaDeParejas.get(i);
            //JUGADOR 1
            Usuario j1 = p.getUsuarioByDni1();
            listaParejasJugador = this.parejaDAO.parejasDadoUsuario(j1.getDni());
            for (int j = 0; j < listaParejasJugador.size() && valido; j++) {
                Pareja pp = listaParejasJugador.get(j);
                listaResultadosPareja1 = this.resultadoDAO.consultaPareja(pp.getIdPareja());
                if (!listaResultadosPareja1.isEmpty()) {
                    for (int k = 0; k < listaResultadosPareja1.size() && valido; k++) {
                        Partido p2 = listaResultadosPareja1.get(k).getPartido();
                        Date fechaPartido = new Date(p2.getFechaInicio().getTime());
                        if (fechasPartidos.contains(fechaPartido)) {
                            valido = false;
                        }
                    }
                }
            }

            //JUGADOR 2
            Usuario j2 = p.getUsuarioByDni2();
            listaParejasJugador = this.parejaDAO.parejasDadoUsuario(j2.getDni());
            for (int j = 0; j < listaParejasJugador.size() && valido; j++) {
                Pareja pp = listaParejasJugador.get(j);
                listaResultadosPareja2 = this.resultadoDAO.consultaPareja(pp.getIdPareja());
                if (!listaResultadosPareja2.isEmpty()) {
                    for (int k = 0; k < listaResultadosPareja2.size() && valido; k++) {
                        Partido p2 = listaResultadosPareja2.get(k).getPartido();
                        Date fechaPartido = new Date(p2.getFechaInicio().getTime());
                        if (fechasPartidos.contains(fechaPartido)) {
                            valido = false;
                        }
                    }
                }
            }

            if (valido) {
                this.listaDeParejas.add(p);
            }
        }
    }

    /**
     * setListaDeArbitros(): método dedicado a establecer que árbitros hay disponibles para arbitrar
     * en la competición en curso
     * 
     * @param listaDeArbitros todos los árbitros del sistema
     */
    public void setListaDeArbitros(List<Usuario> listaDeArbitros) {
        //VER SI LOS ARBITROS ESTAN DISPONIBLES
        for (int i = 0; i < listaDeArbitros.size(); i++) {
            List<Partido> partidos = new ArrayList<>();
            Usuario arb = listaDeArbitros.get(i);
            partidos = this.partidoDAO.listarPartidosPorArbitro(arb.getDni());
            if (partidos.isEmpty()) {
                this.listaDeArbitros.add(arb);
            } else {
                boolean v = false;
                for (int j = 0; j < partidos.size(); j++) {
                    Date fechaPartido = new Date(partidos.get(j).getFechaInicio().getTime());
                    if (fechasPartidos.contains(fechaPartido)) {
                        v = true;
                    }
                }
                if (!v) {
                    this.listaDeArbitros.add(arb);
                }
            }
        }
    }

    //Getter & Setter de los atributos
    public List<Pareja> getListaDeParejas() {
        return listaDeParejas;
    }

    public List<Partido> getListaDePartidos() {
        return listaDePartidos;
    }

    public void setListaDePartidos(List<Partido> listaDePartidos) {
        this.listaDePartidos = listaDePartidos;
    }

    public String getAsigna() {
        return asigna;
    }

    public void setAsigna(String asigna) {
        this.asigna = asigna;
    }

    public List<Integer> getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(List<Integer> idPareja) {
        this.idPareja = idPareja;
    }

    public List<Usuario> getListaDeArbitros() {
        return listaDeArbitros;
    }

    public List<Date> getFechasPartidos() {
        return fechasPartidos;
    }

    public void setFechasPartidos(List<Date> fechasPartidos) {
        this.fechasPartidos = fechasPartidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Partido> getListaPartidosPareja1() {
        return listaPartidosPareja1;
    }

    public void setListaPartidosPareja1(List<Partido> listaPartidosPareja1) {
        this.listaPartidosPareja1 = listaPartidosPareja1;
    }

    public List<Partido> getListaPartidosPareja2() {
        return listaPartidosPareja2;
    }

    public void setListaPartidosPareja2(List<Partido> listaPartidosPareja2) {
        this.listaPartidosPareja2 = listaPartidosPareja2;
    }

    public List<Resultado> getListaResultadosPareja1() {
        return listaResultadosPareja1;
    }

    public void setListaResultadosPareja1(List<Resultado> listaResultadosPareja1) {
        this.listaResultadosPareja1 = listaResultadosPareja1;
    }

    public List<Resultado> getListaResultadosPareja2() {
        return listaResultadosPareja2;
    }

    public void setListaResultadosPareja2(List<Resultado> listadoResultadoPareja2) {
        this.listaResultadosPareja2 = listadoResultadoPareja2;
    }

    public List<Partido> getListaPartidosArbitro() {
        return listaPartidosArbitro;
    }

    public void setListaPartidosArbitro(List<Partido> listaPartidosArbitro) {
        this.listaPartidosArbitro = listaPartidosArbitro;
    }

}
