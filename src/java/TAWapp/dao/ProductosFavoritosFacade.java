/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Productosfavoritos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author casti
 */
@Stateless
public class ProductosfavoritosFacade extends AbstractFacade<Productosfavoritos> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosfavoritosFacade() {
        super(Productosfavoritos.class);
    }
     public List<Productosfavoritos> finduser(Integer id) {
         Query q;
        q = this.getEntityManager().createQuery("select f from Productosfavorito f where f.usuarioComprador = :ID");
        q.setParameter("ID", id);
        return q.getResultList();
    }
    public Productosfavoritos finduserproducto(Integer user,String producto) {
         Query q;
        q = this.getEntityManager().createQuery("select f from Productosfavorito f where f.usuarioComprador.idusuario = :user AND f.productoIdproducto.idproducto =:producto");
        q.setParameter("user", user);
        q.setParameter("producto", Integer.parseInt(producto));
        return (Productosfavoritos) q.getResultList().get(0);
    }

    public List<Productosfavoritos> findproducto(Integer id) {
         Query q;
        q = this.getEntityManager().createQuery("select f from Productosfavorito f where f.productoIdproducto.idproducto =:producto");
        q.setParameter("producto", id);
        return q.getResultList();
    }
}
