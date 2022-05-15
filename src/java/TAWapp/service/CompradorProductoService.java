/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.CompradorProductoFacade;
import TAWapp.dao.UsuarioFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import TAWapp.dto.CategoriaDTO;
import TAWapp.dto.ListaDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Lista;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class CompradorProductoService {
    @EJB CompradorProductoFacade compradorProductoFacade;
    @EJB UsuarioFacade usuarioFacade;
    
    public CategoriaDTO encontrarUltimaCategoriaCliente(int idUsuario) {
        Usuario usuario = this.usuarioFacade.find(idUsuario);
        List<CompradorProducto> listaCompradorProducto = compradorProductoFacade.findByComprador(usuario);  
        return listaCompradorProducto.get(listaCompradorProducto.size() - 1).getProductoIdproducto().getCategoriaIdcategoria().toDTO();  
    }
}
