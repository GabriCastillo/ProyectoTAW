/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Estadistica;
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
public class EstadisticaFacade extends AbstractFacade<Estadistica> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaFacade() {
        super(Estadistica.class);
    }
    
     public List<Estadistica> findByTitulo (String titulo) {
        Query q;
        q = this.getEntityManager().createQuery("select p from Producto p where p.titulo like :titulo");
        q.setParameter("titulo", '%' + titulo +'%');
        return q.getResultList();
    }
    
}
