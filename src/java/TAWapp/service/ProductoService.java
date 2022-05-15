/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.CategoriaFacade;
import TAWapp.dao.ProductoFacade;
import TAWapp.dao.ProductosfavoritoFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.dto.FavoritoDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.entity.Categoria;
import TAWapp.entity.Producto;
import TAWapp.entity.Productosfavorito;
import TAWapp.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author casti
 * Done: 100%
 */
@Stateless
public class ProductoService {

    @EJB
    CategoriaFacade categoriaFacade;
    @EJB
    ProductoFacade productoFacade;
    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    ProductosfavoritoFacade FavoritoFacade;

    private List<ProductoDTO> listaEntityADTO (List<Producto> lista) {
        List<ProductoDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Producto prodcuto:lista) {
                listaDTO.add(prodcuto.toDTO());
            }
        }
        return listaDTO;
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
    public void AñadirFavorito(String id, Integer idusuario) {
        Producto producto = this.productoFacade.find(Integer.parseInt(id));
        Usuario user = this.usuarioFacade.find(idusuario);
        Productosfavorito favorito = new Productosfavorito();
        favorito.setProductoIdproducto(producto);
        favorito.setUsuarioComprador(user);
        
        
        this.FavoritoFacade.create(favorito);
        
        
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

    public ProductoDTO crearNuevoProducto(String titulo, String descripcion, String URL,  int categoria, int idUsuario) {
        Producto producto = new Producto();
        this.rellenarProducto(producto, titulo, descripcion, URL,categoria,idUsuario);

        this.productoFacade.create(producto);
        Producto pro=this.productoFacade.findAll().get(this.productoFacade.findAll().lastIndexOf(producto));
        return pro.toDTO();
    }

}
