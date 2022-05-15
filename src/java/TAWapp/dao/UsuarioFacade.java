/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Usuario;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "TAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> findByNombre (String nombre) {
        Query q;
        q = this.getEntityManager().createQuery("select u from Usuario u where u.nombre like :nombre");
        q.setParameter("nombre", '%' + nombre +'%');
        
        List<Usuario> usuariosByNombre = q.getResultList();
        List<Usuario> allCompradores = this.findCompradores();
        
        List<Usuario> compradoresByNombre = new ArrayList();
        for(Usuario comprador : allCompradores) {
            if(usuariosByNombre.contains(comprador)) {
                compradoresByNombre.add(comprador);
            }
        }

        return compradoresByNombre;
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
