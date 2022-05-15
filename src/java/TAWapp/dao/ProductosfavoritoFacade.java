/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Productosfavorito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author frees
 */
@Stateless
public class ProductosfavoritoFacade extends AbstractFacade<Productosfavorito> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;
    public List<Productosfavorito> finduser;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosfavoritoFacade() {
        super(Productosfavorito.class);
    }

    public List<Productosfavorito> finduser(Integer id) {
         Query q;
        q = this.getEntityManager().createQuery("select f from Productosfavorito f where f.usuarioComprador = :ID");
        q.setParameter("ID", id);
        return q.getResultList();
    }
    public Productosfavorito finduserproducto(Integer user,String producto) {
         Query q;
        q = this.getEntityManager().createQuery("select f from Productosfavorito f where f.usuarioComprador.idusuario = :user AND f.productoIdproducto.idproducto =:producto");
        q.setParameter("user", user);
        q.setParameter("producto", Integer.parseInt(producto));
        return (Productosfavorito) q.getResultList().get(0);
    }

    public List<Productosfavorito> findproducto(Integer id) {
         Query q;
        q = this.getEntityManager().createQuery("select f from Productosfavorito f where f.productoIdproducto.idproducto =:producto");
        q.setParameter("producto", id);
        return q.getResultList();
    }
}
