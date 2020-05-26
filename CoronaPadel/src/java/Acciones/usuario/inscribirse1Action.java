/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.usuario;

import Modelo.dao.CompeticionDAO;
import Modelo.dao.ParejaDAO;
import Modelo.dao.ResultadoDAO;
import Modelo.dto.Competicion;
import Modelo.dto.Pareja;
import Modelo.dto.Partido;
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
 *
 * @author pedro
 */
public class inscribirse1Action extends ActionSupport {
    private int idCompeticion;
    //salida
    private Map sesion;
    private List<Pareja> listaDePareja = new ArrayList<>();
    //dao
    private CompeticionDAO competicionDAO = new CompeticionDAO();
    private ParejaDAO parejaDAO = new ParejaDAO();
    private ResultadoDAO resultadoDAO = new ResultadoDAO();

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public List<Pareja> getListaDePareja() {
        return listaDePareja;
    }

    public void setListaDePareja(List<Pareja> listaDePareja) {
        this.listaDePareja = listaDePareja;
    }
    
    
    public inscribirse1Action() {
    }
    
    public String execute() throws Exception {
        this.sesion = (Map)ActionContext.getContext().get("session");
        Usuario usuario = (Usuario)this.sesion.get("usuario");
        List<Pareja> listTodasParejas = this.parejaDAO.parejasDadoUsuario(usuario.getDni());
        Competicion competicion = this.competicionDAO.read(this.getIdCompeticion());
        Date fechaInicioComp = new Date(competicion.getFechaInicio().getTime());
        
        
        List<Date> fechasPartidos = new ArrayList<>();
        
        this.sesion = (Map) ActionContext.getContext().get("session");
        //OBTENER FECHAS PREDEFINIDAS PARA LA COMPETICION
        Date fecha = competicion.getFechaInicio();
        int nPartidos = competicion.getNpartidos();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        fecha.setHours(12);
        fechasPartidos.add(fecha);
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
            fechasPartidos.add(i, fAnterior.getTime());
        }
        
        
        
        List<Resultado> listaResultadosPareja1 = new ArrayList<>();
        List<Resultado> listaResultadosPareja2 = new ArrayList<>();
        List<Pareja> listaParejasJugador = new ArrayList<>();
        
        for (int i = 0; i < listTodasParejas.size(); i++) {
            boolean valido = true;
            Pareja p = listTodasParejas.get(i);
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
                this.listaDePareja.add(p);
            }
        }
        
        
        
        
        
        
        this.sesion.put("competicion", competicion);
        return SUCCESS;
        
    }
    
}
