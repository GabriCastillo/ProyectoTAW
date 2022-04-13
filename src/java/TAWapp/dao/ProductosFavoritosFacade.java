/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAWapp.dao;

import TAWapp.entity.ProductosFavoritos;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author casti
 */
@jakarta.ejb.Stateless
public class ProductosFavoritosFacade extends AbstractFacade<ProductosFavoritos> {

    @PersistenceContext(unitName = "ProyectoTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFavoritosFacade() {
        super(ProductosFavoritos.class);
    }
    
}
