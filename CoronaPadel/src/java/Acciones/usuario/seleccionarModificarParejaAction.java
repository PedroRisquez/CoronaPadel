package Acciones.usuario;

import Modelo.dao.ParejaDAO;
import Modelo.dto.Pareja;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Acción dedicada a la selección de la pareja que desea posteriormente
 * modificar
 */
public class seleccionarModificarParejaAction extends ActionSupport {
    
    //Objetos auxiliares
    private Pareja pareja;
    private int idPareja;

    //DAO necesario
    private ParejaDAO parejaDAO = new ParejaDAO();
    
    public seleccionarModificarParejaAction() {
    }
    
    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        this.setPareja(this.parejaDAO.read(this.getIdPareja()));
        return SUCCESS;
    }
    
    //Getter & Setter de los atributos
    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }
}
