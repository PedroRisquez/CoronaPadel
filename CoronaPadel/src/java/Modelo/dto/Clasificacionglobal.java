package Modelo.dto;
// Generated 22-abr-2020 12:52:52 by Hibernate Tools 4.3.1



/**
 * Clasificacionglobal generated by hbm2java
 */
public class Clasificacionglobal  implements java.io.Serializable {


     private Integer idClasificacionGlobal;
     private Administracion administracion;
     private Usuario usuario;
     private int puntuacion;

    public Clasificacionglobal() {
    }

	
    public Clasificacionglobal(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    public Clasificacionglobal(Administracion administracion, Usuario usuario, int puntuacion) {
       this.administracion = administracion;
       this.usuario = usuario;
       this.puntuacion = puntuacion;
    }
   
    public Integer getIdClasificacionGlobal() {
        return this.idClasificacionGlobal;
    }
    
    public void setIdClasificacionGlobal(Integer idClasificacionGlobal) {
        this.idClasificacionGlobal = idClasificacionGlobal;
    }
    public Administracion getAdministracion() {
        return this.administracion;
    }
    
    public void setAdministracion(Administracion administracion) {
        this.administracion = administracion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getPuntuacion() {
        return this.puntuacion;
    }
    
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }




}


