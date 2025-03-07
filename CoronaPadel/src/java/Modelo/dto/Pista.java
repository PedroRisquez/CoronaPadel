package Modelo.dto;
// Generated 22-abr-2020 12:52:52 by Hibernate Tools 4.3.1



/**
 * Pista generated by hbm2java
 */
public class Pista  implements java.io.Serializable {


     private Integer idPista;
     private Administracion administracion;
     private String localizacion;
     private String tipoDeCubierta;
     private String tipoDePista;
     private String tipoDeSuelo;

    public Pista() {
    }

	
    public Pista(String localizacion, String tipoDeCubierta, String tipoDePista, String tipoDeSuelo) {
        this.localizacion = localizacion;
        this.tipoDeCubierta = tipoDeCubierta;
        this.tipoDePista = tipoDePista;
        this.tipoDeSuelo = tipoDeSuelo;
    }
    public Pista(Administracion administracion, String localizacion, String tipoDeCubierta, String tipoDePista, String tipoDeSuelo) {
       this.administracion = administracion;
       this.localizacion = localizacion;
       this.tipoDeCubierta = tipoDeCubierta;
       this.tipoDePista = tipoDePista;
       this.tipoDeSuelo = tipoDeSuelo;
    }
   
    public Integer getIdPista() {
        return this.idPista;
    }
    
    public void setIdPista(Integer idPista) {
        this.idPista = idPista;
    }
    public Administracion getAdministracion() {
        return this.administracion;
    }
    
    public void setAdministracion(Administracion administracion) {
        this.administracion = administracion;
    }
    public String getLocalizacion() {
        return this.localizacion;
    }
    
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    public String getTipoDeCubierta() {
        return this.tipoDeCubierta;
    }
    
    public void setTipoDeCubierta(String tipoDeCubierta) {
        this.tipoDeCubierta = tipoDeCubierta;
    }
    public String getTipoDePista() {
        return this.tipoDePista;
    }
    
    public void setTipoDePista(String tipoDePista) {
        this.tipoDePista = tipoDePista;
    }
    public String getTipoDeSuelo() {
        return this.tipoDeSuelo;
    }
    
    public void setTipoDeSuelo(String tipoDeSuelo) {
        this.tipoDeSuelo = tipoDeSuelo;
    }




}


