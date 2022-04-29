/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.RolFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.entity.Rol;
import TAWapp.entity.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author casti
 */

@Stateless
public class UsuarioService {
    
      @EJB UsuarioFacade usuarioFacade;
      @EJB RolFacade rolFacade;
      
    public Usuario comprobarCredenciales (String user, String password) {
        return this.usuarioFacade.comprobarUsuario(user, password);
    }
    
    public List<Usuario> listarUsuarios (String filtroNombre) {
        List<Usuario> usuarios = null;

        if (filtroNombre == null || filtroNombre.isEmpty()) {
            usuarios = this.usuarioFacade.findAll();        
        } else {
            usuarios = this.usuarioFacade.findByNombre(filtroNombre);
        }
        
        return usuarios;                
    } 
    
    public Usuario buscarUsuario (Integer id) {
        return this.usuarioFacade.find(id);
    }
    
    public void borrarUsuario (Integer id) {
        Usuario customer = this.usuarioFacade.find(id);

        this.usuarioFacade.remove(customer);        
    }
    
    
    private void rellenarUsuario (Usuario usuario,
                              String nombre, String apellido, String domicilio, String ciudad, 
                              int edad, String sexo, String contraseña, int rol) {
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDomicilio(domicilio);
        usuario.setCiudadResidencia(ciudad);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setPassword(contraseña);
       

        Rol r = this.rolFacade.find(rol);
        usuario.setRolIdrol(r);
              
    }
    
    public void crearUsuario (String nombre, String apellido, String domicilio, String ciudad, 
                              int edad, String sexo, String contraseña, int rol) {
        Usuario usuario = new Usuario();

        this.rellenarUsuario(usuario,  nombre,  apellido,  domicilio,  ciudad, 
                               edad,  sexo,  contraseña,  rol);

        this.usuarioFacade.create(usuario);
    }

    public void modificarUsuario (Integer id,
                              String nombre, String apellido, String domicilio, String ciudad, 
                              int edad, String sexo, String contraseña, int rol) {
        
        Usuario usuario = this.usuarioFacade.find(id);

        this.rellenarUsuario(usuario,  nombre,  apellido,  domicilio,  ciudad, 
                               edad,  sexo,  contraseña,  rol);

        this.usuarioFacade.edit(usuario);
    }
    
}
