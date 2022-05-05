/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.RolFacade;
import TAWapp.dto.RolDTO;
import TAWapp.entity.Rol;
import java.util.ArrayList;
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
    
    public List<RolDTO> listarRoles () {
        List<Rol> lista = this.rolFacade.findAll();
        return this.listaEntityADTO(lista);
    }
    
     private List<RolDTO> listaEntityADTO (List<Rol> lista) {
        List<RolDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Rol r :lista) {
                listaDTO.add(r.toDTO());
            }
        }
        return listaDTO;
    }
}
