/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dao;

import TAWapp.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author casti
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PROYECTOTAWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario comprobarUsuario (String strusuario, String strclave) {
        Query q;
        
        q = this.getEntityManager().createQuery("select u from Usuario u where u.nombre = :usuario and"
                + " u.password = :clave");
        q.setParameter("usuario", strusuario);
        q.setParameter("clave", strclave);
        List<Usuario> lista = q.getResultList();
        if (lista == null || lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }        
    }
    
    public List<Usuario> findByNombre (String n) {
        Query q;
        q = this.getEntityManager().createQuery("select u from Usuario u where u.nombre like :nombre");
        q.setParameter("nombre", '%' + n +'%');
        return q.getResultList();
        
        /*
        List<Integer> list = em.createQuery("select u.balance from Users u where u.userName = '" + user_name.getText() +"'", Integer.class).getResultList();

        
        TypedQuery<Integer> query = em.createQuery("select u.balance from Users u where u.userName = :user_name", Integer.class);
query.setParameter("user_name", user_name.getText());
Integer balance = query.getSingleResult();
        
        */
    }
}
