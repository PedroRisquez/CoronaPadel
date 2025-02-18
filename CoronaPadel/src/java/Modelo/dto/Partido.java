package Modelo.dto;
// Generated 22-abr-2020 12:52:52 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Partido generated by hbm2java
 */
public class Partido  implements java.io.Serializable {


     private Integer idPartido;
     private Competicion competicion;
     private Usuario usuario;
     private Date fechaInicio;
     private int duracion;
     private Set resultados = new HashSet(0);

    public Partido() {
    }

	
    public Partido(Usuario usuario, Date fechaInicio, int duracion) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
    }
    public Partido(Competicion competicion, Usuario usuario, Date fechaInicio, int duracion, Set resultados) {
       this.competicion = competicion;
       this.usuario = usuario;
       this.fechaInicio = fechaInicio;
       this.duracion = duracion;
       this.resultados = resultados;
    }
   
    public Integer getIdPartido() {
        return this.idPartido;
    }
    
    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }
    public Competicion getCompeticion() {
        return this.competicion;
    }
    
    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public int getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public Set getResultados() {
        return this.resultados;
    }
    
    public void setResultados(Set resultados) {
        this.resultados = resultados;
    }




}


