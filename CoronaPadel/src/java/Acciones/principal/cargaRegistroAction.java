package Acciones.principal;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Acción dedicada a recoger los datos de un nuevo usuario para su creación
 */
public class cargaRegistroAction extends ActionSupport {
    
    //Objetos auxiliares
    private List<String> listaDeSexo = new ArrayList<>();
    private List<String> listaDeRol = new ArrayList<>();
    private List<String> listaDeCategoria = new ArrayList<>();
    private List<String> listaDeLadoDeJuego = new ArrayList<>();

    public cargaRegistroAction() {
    }
    
    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        this.getListaDeSexo().add(getText("sexo.hombre"));
        this.getListaDeSexo().add(getText("sexo.mujer"));
        this.getListaDeSexo().add(getText("sexo.otro"));
        
        this.getListaDeRol().add(getText("rol.admin"));
        this.getListaDeRol().add(getText("rol.jugador"));
        this.getListaDeRol().add(getText("rol.arbitro"));
        
        this.getListaDeCategoria().add(getText("categoria.benjamin"));
        this.getListaDeCategoria().add(getText("categoria.alevin"));
        this.getListaDeCategoria().add(getText("categoria.infantil"));
        this.getListaDeCategoria().add(getText("categoria.cadete"));
        this.getListaDeCategoria().add(getText("categoria.juvenil"));
        this.getListaDeCategoria().add(getText("categoria.senior"));
        
        this.getListaDeLadoDeJuego().add(getText("ladoDeJuego.reves"));
        this.getListaDeLadoDeJuego().add(getText("ladoDeJuego.derecha"));
        this.getListaDeLadoDeJuego().add(getText("ladoDeJuego.ambos"));

        return SUCCESS;
    }
    
    //Getter & Setter de los atributos
    public List<String> getListaDeSexo() {
        return listaDeSexo;
    }

    public void setListaDeSexo(List<String> listaDeSexo) {
        this.listaDeSexo = listaDeSexo;
    }

    public List<String> getListaDeRol() {
        return listaDeRol;
    }

    public void setListaDeRol(List<String> listaDeRol) {
        this.listaDeRol = listaDeRol;
    }

    public List<String> getListaDeCategoria() {
        return listaDeCategoria;
    }

    public void setListaDeCategoria(List<String> listaDeCategoria) {
        this.listaDeCategoria = listaDeCategoria;
    }

    public List<String> getListaDeLadoDeJuego() {
        return listaDeLadoDeJuego;
    }

    public void setListaDeLadoDeJuego(List<String> listaDeLadoDeJuego) {
        this.listaDeLadoDeJuego = listaDeLadoDeJuego;
    }
}
