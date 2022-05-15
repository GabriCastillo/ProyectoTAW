package TAWapp.entity;

import TAWapp.entity.Estadistica;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T18:32:07")
@StaticMetamodel(CompradorProducto.class)
public class CompradorProducto_ { 

    public static volatile SingularAttribute<CompradorProducto, Integer> idcompra;
    public static volatile ListAttribute<CompradorProducto, Estadistica> estadisticaList;
    public static volatile SingularAttribute<CompradorProducto, Integer> precioSalida;
    public static volatile SingularAttribute<CompradorProducto, Integer> precioCompra;
    public static volatile SingularAttribute<CompradorProducto, Usuario> usuarioVendedor;
    public static volatile SingularAttribute<CompradorProducto, Producto> productoIdproducto;
    public static volatile SingularAttribute<CompradorProducto, Usuario> usuarioComprador;

}