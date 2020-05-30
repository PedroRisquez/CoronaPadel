package Acciones.competicion;

import Modelo.dao.AdministracionDAO;
import Modelo.dto.Administracion;
import Modelo.dto.Competicion;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Acción dedicada a registrar una competición en el sistema
 */
public class creaCompeticionAction extends ActionSupport {

    //Sesion
    private Map sesion;

    //Objetos auxiliares
    private String nombre;
    private String descripcion;
    private int nparejas;
    private boolean privada;
    private String formato;
    private String fechaInicio;
    private int idAdministracion;
    private List<Administracion> administracion = new ArrayList<>();

    //DAO necesario
    private AdministracionDAO administracionDAO = new AdministracionDAO();

    public creaCompeticionAction() {
    }

    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
    @Override
    public void validate() {
        if (this.getNombre().equals("")) {
            addActionError(getText("competicion.nombre.requerido"));
        }
        if (this.getDescripcion().equals("")) {
            addActionError(getText("competicion.descripcion.requerido"));
        }
        if ((Integer) this.getNparejas() == null) {
            addActionError(getText("competicion.nParejas.requerido"));
        }
        if (this.getFormato().equals("")) {
            addActionError(getText("competicion.formato.requerido"));
        }

        String p = "^[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]$";
        Pattern patron = Pattern.compile(p);
        Matcher m = patron.matcher(this.getFechaInicio());
        if (!m.matches()) {
            addActionError(getText("competicion.fechaInicio.formato"));
        } else {
            SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fechaInicioFinal = fFecha.parse(this.getFechaInicio());
                DateFormat format2 = new SimpleDateFormat("EEEE");
                String finalDay = format2.format(fechaInicioFinal);
                if (!(finalDay.equals("sábado") || finalDay.equals("domingo"))) {
                    this.sesion = (Map) ActionContext.getContext().get("session");
                    Usuario usuario = (Usuario) this.sesion.get("usuario");
                    this.administracion = this.administracionDAO.leerAdministracionDadoUsuario(usuario.getDni());
                    addActionError(getText("competicion.fechaInicio.lectivo"));
                }
            } catch (ParseException ex) {
                Logger.getLogger(creaCompeticionAction.class.getName()).log(Level.SEVERE, null, ex);
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
        int npartidos;
        if (this.getFormato().equals("Eliminatorio")) {
            npartidos = nparejas - 1;
        } else {
            npartidos = (nparejas - 1) * nparejas;
        }
        Administracion administracion = this.administracionDAO.read(this.getIdAdministracion());
        SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicioFinal = fFecha.parse(this.getFechaInicio());
        this.sesion = (Map) ActionContext.getContext().get("session");
        Usuario usuario = (Usuario) this.sesion.get("usuario");
        Competicion competicion = new Competicion(this.getFormato(), fechaInicioFinal, npartidos, this.getNparejas(), this.getNombre(), this.getDescripcion(), this.isPrivada());
        competicion.setAdministracion(administracion);
        competicion.setUsuario(usuario);
        this.sesion.put("competicion", competicion);

        return SUCCESS;
    }

    //Getter & Setter de los atributos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNparejas() {
        return nparejas;
    }

    public void setNparejas(int nparejas) {
        this.nparejas = nparejas;
    }

    public boolean isPrivada() {
        return privada;
    }

    public void setPrivada(boolean privada) {
        this.privada = privada;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdAdministracion() {
        return idAdministracion;
    }

    public void setIdAdministracion(int idAdministracion) {
        this.idAdministracion = idAdministracion;
    }

    public List<Administracion> getAdministracion() {
        return administracion;
    }

    public void setAdministracion(List<Administracion> administracion) {
        this.administracion = administracion;
    }
}
