/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.RolFacade;
import TAWapp.entity.Rol;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author casti
 */
@Stateless
public class RolService {
    @EJB RolFacade rolFacade;
    
    public List<Rol> listarRoles () {
        return this.rolFacade.findAll();
    }
}
