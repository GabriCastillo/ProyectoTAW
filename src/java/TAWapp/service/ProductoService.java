/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.CategoriaFacade;
import TAWapp.dao.ProductoFacade;
import TAWapp.dao.CompradorProductoFacade;
import TAWapp.dao.ProductosfavoritosFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.dto.FavoritoDTO;
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
import TAWapp.entity.Categoria;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Lista;
import TAWapp.entity.Producto;
import TAWapp.entity.Productosfavoritos;
import TAWapp.entity.Usuario;

/**
 *  @author casti
 *  DONE: 90%
 * 
 *  @author Javier
 *  DONE: 10%
 *
 */
@Stateless
public class ProductoService {
    @EJB ProductoFacade productoFacade;
    @EJB CompradorProductoFacade compradorProductoFacade;
    @EJB CategoriaFacade categoriaFacade;
    @EJB UsuarioFacade usuarioFacade;
    @EJB ProductosfavoritosFacade FavoritoFacade;
    
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
    
    public List<ProductoDTO> listarProductos (String filtroTitulo) {
        List<Producto> productos;

        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.productoFacade.findAll();        
        } else {
            productos = this.productoFacade.findByTitulo(filtroTitulo);
        }
        
        return this.listaEntityADTO(productos);                
    } 
    
    public List<Producto> listaProductos (String filtroTitulo) {
        List<Producto> productos;

        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.productoFacade.findAll();        
        } else {
            productos = this.productoFacade.findByTitulo(filtroTitulo);
        }
        
        return productos;                
    } 

    public ProductoDTO buscarProducto(Integer id) {
        Producto producto = this.productoFacade.find(id);
        return producto.toDTO();
    }

    public void borrarProducto(Integer id) {
        Producto producto = this.productoFacade.find(id);
        Usuario u = producto.getUsuarioVendedor();
        u.getProductoList().remove(producto);

        this.productoFacade.remove(producto);
    }

    private void rellenarProducto(Producto producto,
            String titulo, String descripcion, String URL, int categoria, int idUsuario) {

        producto.setTitulo(titulo);
        producto.setDescripcion(descripcion);
        producto.setUrlImagen(URL);

        Categoria c = this.categoriaFacade.find(categoria);
        Usuario usuario = this.usuarioFacade.find(idUsuario);
        
        producto.setCategoriaIdcategoria(c);
        producto.setUsuarioVendedor(usuario);
        usuario.getProductoList().add(producto);
    }

    public void crearProducto(String titulo, String descripcion, String URL,  int categoria, int idUsuario) {
        Producto producto = new Producto();
        this.rellenarProducto(producto, titulo, descripcion, URL,categoria,idUsuario);

        this.productoFacade.create(producto);

    }

    public void modificarProducto(Integer id,
            String titulo, String descripcion, String URL, int categoria, int idUsuario) {

        Producto producto = this.productoFacade.find(id);
        Usuario u = producto.getUsuarioVendedor();
        u.getProductoList().remove(producto);
        
        this.rellenarProducto(producto, titulo, descripcion, URL,categoria,idUsuario);


        this.productoFacade.edit(producto);
    }

    public ProductoDTO crearNuevoProducto(String titulo, String descripcion, String URL,  int categoria, int idUsuario) {
        Producto producto = new Producto();
        this.rellenarProducto(producto, titulo, descripcion, URL,categoria,idUsuario);

        this.productoFacade.create(producto);
        Producto pro=this.productoFacade.findAll().get(this.productoFacade.findAll().lastIndexOf(producto));
        return pro.toDTO();
    }
    
    public List<ProductoDTO> listarProductosDisponibles () {
        List<CompradorProducto> compradorProductosDisponibles = this.compradorProductoFacade.findProductosDisponibles();        
        
        List<Producto> productosDisponibles = new ArrayList<>();
        if(compradorProductosDisponibles != null) {
            for(CompradorProducto compradorProducto : compradorProductosDisponibles) {
                productosDisponibles.add(compradorProducto.getProductoIdproducto());
            }
        }
        
        return this.listaEntityADTO(productosDisponibles);  
    }
    
    public void AñadirFavorito(String id, Integer idusuario) {
        Producto producto = this.productoFacade.find(Integer.parseInt(id));
        Usuario user = this.usuarioFacade.find(idusuario);
        Productosfavoritos favorito = new Productosfavoritos();
        favorito.setProductoIdproducto(producto);
        favorito.setUsuarioComprador(user);
        
        
        this.FavoritoFacade.create(favorito);
        
        
    }
    
    public List<ProductoDTO> listarProductosCategoria (String filtroTitulo,String categoria) {
        List<Producto> productos;
        if(categoria == null || categoria.isEmpty() ){
        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.productoFacade.findAll(); 
            return this.listaEntityADTO(productos);  
        } else {
            productos = this.productoFacade.findByTitulo(filtroTitulo);
            return this.listaEntityADTO(productos);  
        }
        }
        else{
            if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            productos = this.productoFacade.findByCategoria(categoria); 
            return this.listaEntityADTO(productos);  
        } else {
            productos = this.productoFacade.findByTituloCategoria(filtroTitulo,categoria);
            return this.listaEntityADTO(productos);  
        }
        }
       
                     
    } 
    
    public List<ProductoDTO> listaFavoritos(List<FavoritoDTO> favoritos){
       
        List<Producto> listaMisFavoritos = new ArrayList<>();
        for(FavoritoDTO favorito:favoritos){
            Producto f = this.productoFacade.findByID(favorito.getProductoIdproducto().getIdproducto());
           listaMisFavoritos.add(f);
        }
    return this.listaEntityADTO(listaMisFavoritos);
    }
    
    public Producto crearProductoID2(String titulo, String descripcion, String URL,  int categoria, int idUsuario) {
        Producto producto = new Producto();
        this.rellenarProducto(producto, titulo, descripcion, URL,categoria,idUsuario);

        this.productoFacade.create(producto);
        return producto;
    }

}
