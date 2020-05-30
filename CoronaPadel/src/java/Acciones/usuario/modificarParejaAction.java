package Acciones.usuario;

import Modelo.dao.ParejaDAO;
import Modelo.dto.Pareja;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Acción dedicada a modificar una pareja seleccionada
 */
public class modificarParejaAction extends ActionSupport {
    
    //Sesion
    private Map sesion;
    
    //Objetos auxiliares
    private int idPareja;
    private String nombre;
    private List<Pareja> listaDeParejas = new ArrayList<>();
    private Pareja pareja;

    //DAO necesario
    private ParejaDAO parejaDAO = new ParejaDAO();
    
    public modificarParejaAction() {
    }
    
    /**
     * validate(): método para validar los campos recogidos en el formulario
     */
    @Override
    public void validate(){
        if(this.getNombre().equals("")){
            addActionError(getText("competicion.nombre.requerido"));
            this.setPareja(this.parejaDAO.read(this.getIdPareja()));
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
        pareja = this.parejaDAO.read(this.getIdPareja());
        pareja.setNombre(this.getNombre());
        this.parejaDAO.update(pareja);
        this.sesion = (Map)ActionContext.getContext().get("session");
        Usuario usuario = (Usuario)this.sesion.get("usuario");
        this.setListaDeParejas(this.parejaDAO.parejasDadoUsuario(usuario.getDni()));
        return SUCCESS;
    }
    
    //Getter & Setter de los atributos
    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pareja> getListaDeParejas() {
        return listaDeParejas;
    }

    public void setListaDeParejas(List<Pareja> listaDeParejas) {
        this.listaDeParejas = listaDeParejas;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }
    
}
