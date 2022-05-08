package TAWapp.entity;

import TAWapp.entity.EstadisticaHasProductosFavoritos;
import TAWapp.entity.Producto;
import TAWapp.entity.ProductosFavoritosPK;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-08T02:40:50")
@StaticMetamodel(ProductosFavoritos.class)
public class ProductosFavoritos_ { 

    public static volatile CollectionAttribute<ProductosFavoritos, EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritosCollection;
    public static volatile SingularAttribute<ProductosFavoritos, Usuario> usuario;
    public static volatile SingularAttribute<ProductosFavoritos, ProductosFavoritosPK> productosFavoritosPK;
    public static volatile SingularAttribute<ProductosFavoritos, Producto> producto;

}