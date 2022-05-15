package TAWapp.entity;

import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Correo;
import TAWapp.entity.Estadistica;
import TAWapp.entity.Lista;
import TAWapp.entity.Producto;
import TAWapp.entity.Productosfavorito;
import TAWapp.entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T18:32:07")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, CompradorProducto> compradorProductoList;
    public static volatile CollectionAttribute<Usuario, Productosfavorito> productosfavoritosCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> edad;
    public static volatile ListAttribute<Usuario, Correo> correoList;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile ListAttribute<Usuario, Estadistica> estadisticaList;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, String> domicilio;
    public static volatile SingularAttribute<Usuario, String> ciudadResidencia;
    public static volatile ListAttribute<Usuario, Lista> listaList;
    public static volatile ListAttribute<Usuario, Producto> productoList;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile ListAttribute<Usuario, Productosfavorito> productosFavoritosList;
    public static volatile ListAttribute<Usuario, CompradorProducto> compradorProductoList1;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, Rol> rolIdrol;

}