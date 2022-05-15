/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import java.util.ArrayList;
import TAWapp.dao.RolFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.entity.Rol;
import TAWapp.entity.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import TAWapp.dto.UsuarioDTO;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class UsuarioService {
    @EJB UsuarioFacade usuarioFacade;
    
    private List<UsuarioDTO> listaEntityADTO (List<Usuario> lista) {
        List<UsuarioDTO> listaDTO = null;
        if (lista != null && !lista.isEmpty()) {
            listaDTO = new ArrayList<>();
            for (Usuario usuario:lista) {
                listaDTO.add(usuario.toDTO());
            }
        }
        return listaDTO;
    }
    
    public List<UsuarioDTO> listarClientes (String filtroNombre) {
        List<Usuario> usuarios = null;

        if (filtroNombre == null || filtroNombre.isEmpty()) {
            usuarios = this.usuarioFacade.findCompradores();        
        } else {
            usuarios = this.usuarioFacade.findByNombre(filtroNombre);
        }
        
        return this.listaEntityADTO(usuarios);                
    } 
}
