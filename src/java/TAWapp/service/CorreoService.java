/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.ProductoFacade;
import TAWapp.dao.ListaFacade;
import TAWapp.dao.CorreoFacade;
import TAWapp.dao.UsuarioFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import TAWapp.dto.CorreoDTO;
import TAWapp.dto.ListaDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.entity.Correo;
import TAWapp.entity.Lista;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class CorreoService {
    @EJB CorreoFacade correoFacade;
    @EJB ListaFacade listaFacade;
    @EJB ProductoFacade productoFacade;
    @EJB UsuarioFacade usuarioFacade;
    
    private List<CorreoDTO> listaEntityADTO (List<Correo> correos) {
        List<CorreoDTO> correoDTO = null;
        if (correos != null) {
            correoDTO = new ArrayList<>();
            for (Correo correo : correos) {
                correoDTO.add(correo.toDTO());
            }
        }
        return correoDTO;
    }
    
    public List<CorreoDTO> listarCorreosFromUser (int idUsuario) {
        Usuario usuario = this.usuarioFacade.find(idUsuario);
        List<Correo> correosUsuario = this.correoFacade.findMensajesFromUser(usuario);        
        return this.listaEntityADTO(correosUsuario);
    }
    
    public void crearCorreo(String nombreListaPromo, int idProductoPromo, String mensaje) {
        List<Lista> usuariosLista = this.listaFacade.findByNombre(nombreListaPromo);
        
        Producto producto = this.productoFacade.find(idProductoPromo);
        
        if((usuariosLista.get(0).getUsuarioLista() != null) && !mensaje.isEmpty()) {
            for(Lista usuarioLista : usuariosLista) {
                Correo correo = new Correo();
                correo.setMensaje(mensaje);

                if(producto != null) {
                    correo.setIdProducto(producto);
                }

                int idUsuario = usuarioLista.getUsuarioLista().getIdusuario();
                Usuario usuario = this.usuarioFacade.find(idUsuario);
                correo.setIdUsuario(usuario);

                this.correoFacade.create(correo);
            }
        }
    }
    
    public void crearCorreoIndividual(int idUsuario, int idProductoPromo, String mensaje) {
        if(!mensaje.isEmpty()) {
            Correo correo = new Correo();

            correo.setMensaje(mensaje);

            Producto producto = this.productoFacade.find(idProductoPromo);
            if(producto != null) {
                correo.setIdProducto(producto);
            }

            Usuario usuario = this.usuarioFacade.find(idUsuario);
            correo.setIdUsuario(usuario);

            this.correoFacade.create(correo);
        }    
    }
    
    public void borrarCorreo(int idCorreo) {
        Correo correo = this.correoFacade.find(idCorreo);
        this.correoFacade.remove(correo);
    }
}
