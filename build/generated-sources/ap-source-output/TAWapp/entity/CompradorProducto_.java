package TAWapp.entity;

import TAWapp.entity.EstadisticaHasCompradorProducto;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T04:03:32")
@StaticMetamodel(CompradorProducto.class)
public class CompradorProducto_ { 

    public static volatile SingularAttribute<CompradorProducto, String> idcompra;
    public static volatile SingularAttribute<CompradorProducto, Integer> precioSalida;
    public static volatile SingularAttribute<CompradorProducto, Integer> precioCompra;
    public static volatile SingularAttribute<CompradorProducto, Usuario> usuarioVendedor;
    public static volatile CollectionAttribute<CompradorProducto, EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoCollection;
    public static volatile SingularAttribute<CompradorProducto, Producto> productoIdproducto;
    public static volatile SingularAttribute<CompradorProducto, Usuario> usuarioComprador;

}