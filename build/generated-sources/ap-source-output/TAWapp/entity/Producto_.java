package TAWapp.entity;

import TAWapp.entity.Categoria;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.ProductosFavoritos;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-06T19:23:27")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile ListAttribute<Producto, CompradorProducto> compradorProductoList;
    public static volatile SingularAttribute<Producto, Categoria> categoriaIdcategoria;
    public static volatile SingularAttribute<Producto, String> titulo;
    public static volatile SingularAttribute<Producto, Usuario> usuarioVendedor;
    public static volatile ListAttribute<Producto, ProductosFavoritos> productosFavoritosList;
    public static volatile SingularAttribute<Producto, Integer> idproducto;
    public static volatile SingularAttribute<Producto, String> urlImagen;

}