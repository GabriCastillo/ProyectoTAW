/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Categoria;
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
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
     public List<Categoria> findByTitulo (String t) {
        Query q;
            q = this.getEntityManager().createQuery("select c from Categoria c where upper(c.tipo) like :tipo");
        q.setParameter("tipo", '%' + t.toUpperCase() +'%');
        return q.getResultList();

        
    }
    
}
