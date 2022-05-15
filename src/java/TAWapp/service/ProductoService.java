/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.ProductoFacade;
import TAWapp.dao.CompradorProductoFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class ProductoService {
    @EJB ProductoFacade productoFacade;
    @EJB CompradorProductoFacade compradorProductoFacade;
    
    private List<ProductoDTO> listaEntityADTO (List<Producto> productos) {
        List<ProductoDTO> productoDTO = null;
        if (productos != null && !productos.isEmpty()) {
            productoDTO = new ArrayList<>();
            for (Producto producto : productos) {
                productoDTO.add(producto.toDTO());
            }
        }
        return productoDTO;
    }
    
    public List<ProductoDTO> listarProductos () {
        List<CompradorProducto> compradorProductosDisponibles = this.compradorProductoFacade.findProductosDisponibles();        
        
        List<Producto> productosDisponibles = new ArrayList<>();
        if(compradorProductosDisponibles != null) {
            for(CompradorProducto compradorProducto : compradorProductosDisponibles) {
                productosDisponibles.add(compradorProducto.getProductoIdproducto());
            }
        }
        
        return this.listaEntityADTO(productosDisponibles);  
    }
}
