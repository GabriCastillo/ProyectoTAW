/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Usuario;

/**
 *  @author casti
 *  DONE: 90%
 * 
 *  @author Javier
 *  DONE: 10%
 *
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario comprobarUsuario(String strusuario, String strclave) {
        Query q;

        q = this.getEntityManager().createQuery("select u from Usuario u where u.nombre = :usuario and"
                + " u.password = :clave");
        q.setParameter("usuario", strusuario);
        q.setParameter("clave", strclave);
        List<Usuario> lista = q.getResultList();
        if (lista == null || lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }

    public List<Usuario> findByNombre(String n) {
        Query q;

        q = this.getEntityManager().createQuery("select u from Usuario u where upper(u.nombre)  like :nombre");
        q.setParameter("nombre", '%' + n.toUpperCase() + '%');

        return q.getResultList();

    }

    public List<Usuario> findByTodo(String filtroNombre, String filtroApellido, String filtroRol) {
        Query q;

        q = this.getEntityManager().createQuery("select u from Usuario u where upper(u.nombre)  like :nombre and upper(u.apellido)  like :apellido and u.rolIdrol.idRol  = :rol");
        q.setParameter("nombre", '%' + filtroNombre.toUpperCase() + '%');
        q.setParameter("apellido", '%' + filtroApellido.toUpperCase() + '%');
        q.setParameter("rol", Integer.parseInt(filtroRol));

        return q.getResultList();
    }

    public List<Usuario> findByRol(String filtroRol) {
        Query q;

         q = this.getEntityManager().createQuery("select u from Usuario u where u.rolIdrol.idRol = :rol");

        q.setParameter("rol", Integer.parseInt(filtroRol));
        
        return q.getResultList();
    }

    public List<Usuario> findByAplellido(String filtroApellido) {
        Query q;

        q = this.getEntityManager().createQuery("select u from Usuario u where  upper(u.apellido)  like :apellido" );

        q.setParameter("apellido", '%' + filtroApellido.toUpperCase() + '%');

        return q.getResultList();
    }

    public List<Usuario> findByApellidoRol(String filtroApellido, String filtroRol) {
        Query q;

        q = this.getEntityManager().createQuery("select u from Usuario u where upper(u.apellido)  like :apellido and u.rolIdrol.idRol  = :rol");
        q.setParameter("apellido", '%' + filtroApellido.toUpperCase() + '%');
        q.setParameter("rol", Integer.parseInt(filtroRol));

        return q.getResultList();
    }

    public List<Usuario> findByNombreRol(String filtroNombre, String filtroRol) {
        Query q;

         q = this.getEntityManager().createQuery("select u from Usuario u where upper(u.nombre)  like :nombre  and u.rolIdrol.idRol  = :rol");
        q.setParameter("nombre", '%' + filtroNombre.toUpperCase() + '%');
        q.setParameter("rol", Integer.parseInt(filtroRol));
        
        return q.getResultList();
    }

    public List<Usuario> findByNombreApellido(String filtroNombre, String filtroApellido) {
        Query q;

        q = this.getEntityManager().createQuery("select u from Usuario u where upper(u.nombre)  like :nombre and upper(u.apellido)  like :apellido ");
        q.setParameter("nombre", '%' + filtroNombre.toUpperCase() + '%');
        q.setParameter("apellido", '%' + filtroApellido.toUpperCase() + '%');
        
        return q.getResultList();
    }

    public List<Usuario> findCompradores() {
        Query q = this.getEntityManager().createQuery("select c from CompradorProducto c");
        List<CompradorProducto> compradoresProducto = q.getResultList();
        
        List<Usuario> usuariosCompradores = new ArrayList();
        compradoresProducto.forEach((compradorProducto) -> {
            if(compradorProducto.getUsuarioComprador() != null) {
                usuariosCompradores.add(compradorProducto.getUsuarioComprador());
            }
        });
        
        return usuariosCompradores;
    }
    
}
