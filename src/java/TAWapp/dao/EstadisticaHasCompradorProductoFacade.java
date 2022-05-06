/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.EstadisticaHasCompradorProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author casti
 */
@Stateless
public class EstadisticaHasCompradorProductoFacade extends AbstractFacade<EstadisticaHasCompradorProducto> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaHasCompradorProductoFacade() {
        super(EstadisticaHasCompradorProducto.class);
    }
    
}
