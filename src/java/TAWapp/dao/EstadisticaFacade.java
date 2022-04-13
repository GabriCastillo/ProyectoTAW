/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAWapp.dao;

import TAWapp.entity.Estadistica;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author casti
 */
@jakarta.ejb.Stateless
public class EstadisticaFacade extends AbstractFacade<Estadistica> {

    @PersistenceContext(unitName = "ProyectoTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaFacade() {
        super(Estadistica.class);
    }
    
}
