package TAWapp.entity;

import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T04:03:32")
@StaticMetamodel(Productosfavorito.class)
public class Productosfavorito_ { 

    public static volatile SingularAttribute<Productosfavorito, Integer> idfavorito;
    public static volatile SingularAttribute<Productosfavorito, Producto> productoIdproducto;
    public static volatile SingularAttribute<Productosfavorito, Usuario> usuarioComprador;

}