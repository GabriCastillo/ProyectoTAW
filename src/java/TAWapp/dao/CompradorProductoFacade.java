/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.CompradorProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author casti
 * Done: 10% 
 *@author Ruben 
 * Done: 90%
 */
@Stateless
public class CompradorProductoFacade extends AbstractFacade<CompradorProducto> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompradorProductoFacade() {
        super(CompradorProducto.class);
    }
    public List<CompradorProducto> findByIdproducto(String ID) {
       Query q;
        q = this.getEntityManager().createQuery("select p from CompradorProducto p where p.productoIdproducto = :titulo");
        q.setParameter("titulo", ID);
        return q.getResultList();
    }
     
     
    public List<CompradorProducto> findByMisproductos(Integer ID) {
       Query q;
        q = this.getEntityManager().createQuery("select p from CompradorProducto p where p.usuarioComprador.idusuario = :id AND p.precioCompra =:value");
        q.setParameter("id",ID);
        q.setParameter("value",0);
        return q.getResultList();
    } 

    public CompradorProducto findByIdproductoFavoritos(Integer idproducto) {
        Query q;
        q = this.getEntityManager().createQuery("select p from CompradorProducto p where p.productoIdproducto.idproducto = :id");
        q.setParameter("id",idproducto);
        return (CompradorProducto) q.getResultList().get(0);
    }
}
