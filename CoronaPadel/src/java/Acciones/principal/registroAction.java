package Acciones.principal;

import Modelo.dao.UsuarioDAO;
import Modelo.dto.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import encrypt.Encrypt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Acción dedicada al registro de un nuevo usuario
 */
public class registroAction extends ActionSupport {

    //Sesión
    private Map sesion;

    //Objetos auxiliares
    private String nombreCompleto;
    private String dni;
    private String usuario;
    private String clave;
    private String email;
    private String sexo;
    private String rol;
    private String categoria;
    private String ladoDeJuego;

    //fotoPerfil<
    private File fotoPerfil;
    private String fotoPerfilContentType;
    private String fotoPerfilFileName;//este es el que se guarda
    //fotoPerfil>

    //Listas del formulario
    private List<String> listaDeSexo = new ArrayList<>();
    private List<String> listaDeRol = new ArrayList<>();
    private List<String> listaDeCategoria = new ArrayList<>();
    private List<String> listaDeLadoDeJuego = new ArrayList<>();

    //DAO necesario
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    public registroAction() {
    }

  /**
  * validate(): método para validar los campos recogidos en el formulario
  */
    public void validate() {
        if (this.getNombreCompleto().equals("")) {
            addActionError(getText("competicion.nombre.requerido"));
        }
        if (this.getDni().equals("")) {
            addActionError(getText("usuario.dni.requerido"));
        } else if (!this.getDni().matches("^[0-9]{8}[A-Z]$")) {
            addActionError(getText("usuario.dni.formato"));
        }
        Usuario user = null;
        user = this.usuarioDao.read(this.getDni());
        if (user != null) {
            addActionError(getText("usuario.yaexiste"));
        }
        if (this.getUsuario().equals("")) {
            addActionError(getText("usuario.usuario.requerido"));
        }
        if (this.getClave().equals("")) {
            addActionError(getText("usuario.clave.requerida"));
        }
        if (this.getEmail().equals("")) {//expresionreg email
            addActionError(getText("usuario.email.requerido"));
        }
        if (this.getSexo() == null) {
            addActionError(getText("usuario.sexo.required"));
        }
        if (this.getRol() == null) {
            addActionError(getText("usuario.rol.requerido"));
        } else if (this.getRol().equals("Jugador") || this.getRol().equals("Player")) {
            if (this.getCategoria().equals("") || this.getCategoria() == null) {
                addActionError(getText("jugador.categoria.requerido"));
            }
            if (this.getLadoDeJuego() == null || this.getLadoDeJuego().equals("")) {
                addActionError(getText("jugador.ladoJuego.requerido"));
            }
        }
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
    }

    /**
     * execute(): método ejecutador de la acción requerida
     *
     * @return Exito de la operación
     * @throws java.lang.Exception
     */
    @Override
    public String execute() throws Exception {
        sesion = (Map) ActionContext.getContext().get("session");
        Encrypt cifrado = new Encrypt();
        if (this.fotoPerfil != null && this.fotoPerfilFileName != null) {
            String filePath = ServletActionContext.getServletContext().getRealPath("/");
            System.out.println("Ruta de la imagen:" + filePath);
            File archivoACrear = new File(filePath+"img", this.fotoPerfilFileName);
            FileUtils.copyFile(this.fotoPerfil, archivoACrear);
        }

        if (this.getRol().equals("Jugador") || this.getRol().equals("Player")) {
            if (this.fotoPerfil == null && this.fotoPerfilFileName == null) {
                Usuario user = new Usuario(this.getDni(), this.getNombreCompleto(), this.getUsuario(), cifrado.openFileToString(cifrado.cifra(this.getClave())), this.getEmail(), this.getSexo(), this.getRol(), this.getCategoria(), this.getLadoDeJuego());
                this.usuarioDao.create(user);
                sesion.put("usuario", user);
                return SUCCESS;
            } else {
                Usuario user = new Usuario(this.getDni(), this.getNombreCompleto(), this.getUsuario(), cifrado.openFileToString(cifrado.cifra(this.getClave())), this.getEmail(), this.getSexo(), this.getRol(), this.getCategoria(), this.getLadoDeJuego(), this.getFotoPerfilFileName());
                this.usuarioDao.create(user);
                sesion.put("usuario", user);
                return SUCCESS;
            }
        } else {
            if (this.fotoPerfil == null && this.fotoPerfilFileName == null) {
                Usuario user = new Usuario(this.getDni(), this.getNombreCompleto(), this.getUsuario(), cifrado.openFileToString(cifrado.cifra(this.getClave())), this.getEmail(), this.getSexo(), this.getRol());
                this.usuarioDao.create(user);
                sesion.put("usuario", user);
                return SUCCESS;
            } else {
                Usuario user = new Usuario(this.getDni(), this.getNombreCompleto(), this.getUsuario(), cifrado.openFileToString(cifrado.cifra(this.getClave())), this.getEmail(), this.getSexo(), this.getRol(), this.getFotoPerfilFileName());
                this.usuarioDao.create(user);
                sesion.put("usuario", user);
                return SUCCESS;
            }
        }   
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

    public File getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(File fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getFotoPerfilContentType() {
        return fotoPerfilContentType;
    }

    public void setFotoPerfilContentType(String fotoPerfilContentType) {
        this.fotoPerfilContentType = fotoPerfilContentType;
    }

    public String getFotoPerfilFileName() {
        return fotoPerfilFileName;
    }

    public void setFotoPerfilFileName(String fotoPerfilFileName) {
        this.fotoPerfilFileName = fotoPerfilFileName;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLadoDeJuego() {
        return ladoDeJuego;
    }

    public void setLadoDeJuego(String ladoDeJuego) {
        this.ladoDeJuego = ladoDeJuego;
    }

   
}
