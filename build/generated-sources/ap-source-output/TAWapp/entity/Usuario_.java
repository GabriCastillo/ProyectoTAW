package TAWapp.entity;

import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Estadistica;
import TAWapp.entity.Producto;
import TAWapp.entity.ProductosFavoritos;
import TAWapp.entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-06T19:23:27")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, CompradorProducto> compradorProductoList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> edad;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile ListAttribute<Usuario, Estadistica> estadisticaList;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, String> domicilio;
    public static volatile SingularAttribute<Usuario, String> ciudadResidencia;
    public static volatile ListAttribute<Usuario, Producto> productoList;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile ListAttribute<Usuario, ProductosFavoritos> productosFavoritosList;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, Rol> rolIdrol;

}