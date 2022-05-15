/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Categoria;
import TAWapp.entity.Producto;
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
    
    public List<Producto> findByCategoria(String i) {
       Query q;
        q = this.getEntityManager().createQuery("select p from Producto p where p.categoriaIdcategoria = :categoria");
        Categoria c = new Categoria(Integer.parseInt(i));
        q.setParameter("categoria",c );
        return q.getResultList();
    }
    
    public Producto findByID(Integer id) {
       Query q;
        q = this.getEntityManager().createQuery("select p from Producto p where p.idproducto = :ID");
        q.setParameter("ID", id);
        return (Producto) q.getResultList().get(0);
    }
    
    public List<Producto> findByTituloCategoria(String filtroTitulo,String i) {
       Query q;
       
        q = this.getEntityManager().createQuery("select p from Producto p where UPPER(p.titulo) like :titulo and p.categoriaIdcategoria = :categoria");
        q.setParameter("titulo", '%' + filtroTitulo.toUpperCase() +'%');
        Categoria c = new Categoria(Integer.parseInt(i));
        q.setParameter("categoria",c );
        return q.getResultList();
    }
}
