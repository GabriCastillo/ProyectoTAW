/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.EstadisticaHasProductosFavoritos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class EstadisticaHasProductosFavoritosFacade extends AbstractFacade<EstadisticaHasProductosFavoritos> {

    @PersistenceContext(unitName = "TAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaHasProductosFavoritosFacade() {
        super(EstadisticaHasProductosFavoritos.class);
    }
    
}
