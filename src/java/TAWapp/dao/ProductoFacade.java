/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RaulDF
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    public List<Producto> findByTitulo (String titulo) {
        Query q;
        q = this.getEntityManager().createQuery("select p from Producto p where upper(p.titulo) like :titulo");
        q.setParameter("titulo", '%' + titulo.toUpperCase() +'%');
        return q.getResultList();
    }
}
