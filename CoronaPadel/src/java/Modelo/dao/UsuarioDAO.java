package Modelo.dao;

import Modelo.dao.generico.IUsuarioDAO;
import Modelo.dto.Usuario;
import encrypt.Encrypt;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase dedicada a la implementación de los métodos relacionados con la entidad Usuario.
 */
public class UsuarioDAO implements IUsuarioDAO {

    Session sesion = null;
    Encrypt cifrado = new Encrypt();

    @Override
    public void create(Usuario entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(entidad);
        tx.commit();
    }

    @Override
    public Usuario read(String pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where dni='" + pk + "'");
        Usuario usuario = (Usuario) q.uniqueResult();
        tx.commit();
        return usuario;
    }

    @Override
    public void update(Usuario entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(entidad);
        tx.commit();
    }

    @Override
    public void delete(Usuario entidad) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(entidad);
        tx.commit();
    }

    @Override
    public List<Usuario> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario");
        List<Usuario> listaDeUsuario = (List<Usuario>) q.list();
        tx.commit();
        return listaDeUsuario;
    }

    @Override
    public Usuario comprobarLogin(String usuario, String clave) throws Exception {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + usuario + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        if (u != null) {
            String desencriptada = cifrado.descifra(cifrado.StringToByte(u.getClave()));
            if (desencriptada.equals(clave)) {
                return u;
            } else {
                return null;
            }
        }else{
            return u;
        }
        
    }

    @Override
    public List<Usuario> leerJugadores() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where rol = 'Jugador'");
        List<Usuario> listaDeJugador = (List<Usuario>) q.list();
        tx.commit();
        return listaDeJugador;
    }

    @Override
    public List<Usuario> readUsuarioPorDniOUsuario(String usuarioOdni) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where dni = '" + usuarioOdni + "' or usuario = '" + usuarioOdni + "'");
        List<Usuario> listaDeUsuario = (List<Usuario>) q.list();
        tx.commit();
        return listaDeUsuario;
    }

    @Override
    public List<Usuario> listarArbitros() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where rol='Arbitro'");
        List<Usuario> listaDeUsuario = (List<Usuario>) q.list();
        tx.commit();
        return listaDeUsuario;
    }

}
