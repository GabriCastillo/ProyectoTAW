package TAWapp.entity;

import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T18:32:07")
@StaticMetamodel(Correo.class)
public class Correo_ { 

    public static volatile SingularAttribute<Correo, Integer> idpromo;
    public static volatile SingularAttribute<Correo, Usuario> idUsuario;
    public static volatile SingularAttribute<Correo, String> mensaje;
    public static volatile SingularAttribute<Correo, Producto> idProducto;

}