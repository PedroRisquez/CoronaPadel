package Modelo.dao.generico;

import Modelo.dto.Usuario;
import java.util.List;

/**
 * Interfaz dedicada a los métodos relacionados con la entidad Usuario
 */
public interface IUsuarioDAO extends DAOGenerico<Usuario, String> {

    Usuario comprobarLogin(String usuario, String clave) throws Exception;

    List<Usuario> leerJugadores();

    List<Usuario> readUsuarioPorDniOUsuario(String usuarioOdni);

    List<Usuario> listarArbitros();
}
