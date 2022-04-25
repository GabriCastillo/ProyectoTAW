/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAWapp.dao;

import TAWapp.entity.EstadisticaHasProductosFavoritos;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author casti
 */
@javax.ejb.Stateless
public class EstadisticaHasProductosFavoritosFacade extends AbstractFacade<EstadisticaHasProductosFavoritos> {

    @PersistenceContext(unitName = "ProyectoTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaHasProductosFavoritosFacade() {
        super(EstadisticaHasProductosFavoritos.class);
    }
    
}
