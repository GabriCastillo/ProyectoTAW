/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import TAWapp.entity.Correo;
import TAWapp.entity.Usuario;

/**
 * 
 * @author Javier
 */
@Stateless
public class CorreoFacade extends AbstractFacade<Correo> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreoFacade() {
        super(Correo.class);
    }
    
    public List<Correo> findMensajesFromUser(Usuario usuario) {
        Query q = this.getEntityManager().createQuery("select c from Correo c where c.idUsuario = :usuario");
        q.setParameter("usuario", usuario);
        List<Correo> correosUsuario = q.getResultList();
        
        return correosUsuario;
    }
}
