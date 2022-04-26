/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pueba;

import TAWapp.dao.RolFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.entity.Rol;
import javax.ejb.EJB;

/**
 *
 * @author casti
 */
public class prueba {

    @EJB
    RolFacade rolFacade;
    @EJB
    UsuarioFacade usuarioFacade;
    
    public void hacer() {
        Rol r;
        r = rolFacade.findById("1");
    }
}
