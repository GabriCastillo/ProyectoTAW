/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAWapp.dao;

import TAWapp.entity.EstadisticaHasCompradorProducto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author casti
 */
@javax.ejb.Stateless
public class EstadisticaHasCompradorProductoFacade extends AbstractFacade<EstadisticaHasCompradorProducto> {

    @PersistenceContext(unitName = "ProyectoTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaHasCompradorProductoFacade() {
        super(EstadisticaHasCompradorProducto.class);
    }
    
}
