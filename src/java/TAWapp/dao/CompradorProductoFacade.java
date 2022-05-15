/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import java.util.List;
import TAWapp.entity.CompradorProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class CompradorProductoFacade extends AbstractFacade<CompradorProducto> {

    @PersistenceContext(unitName = "TAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompradorProductoFacade() {
        super(CompradorProducto.class);
    }
    
    public List<CompradorProducto> findByComprador (Usuario usuario) {
        Query q = this.getEntityManager().createQuery("select cp from CompradorProducto cp where cp.usuarioComprador = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
    
    public List<CompradorProducto> findProductosDisponibles () {
        Query q = this.getEntityManager().createQuery("select cp from CompradorProducto cp where cp.usuarioComprador is null");
        return q.getResultList();
    }
}
