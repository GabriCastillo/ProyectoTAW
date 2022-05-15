package TAWapp.entity;

import TAWapp.entity.EstadisticaHasProductosFavoritos;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T18:32:07")
@StaticMetamodel(ProductosFavoritos.class)
public class ProductosFavoritos_ { 

    public static volatile ListAttribute<ProductosFavoritos, EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritosList;
    public static volatile SingularAttribute<ProductosFavoritos, Integer> idfavorito;
    public static volatile SingularAttribute<ProductosFavoritos, Producto> productoIdproducto;
    public static volatile SingularAttribute<ProductosFavoritos, Usuario> usuarioComprador;

}