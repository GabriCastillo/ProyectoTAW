package TAWapp.entity;

import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-06T19:23:27")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> idRol;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile SingularAttribute<Rol, String> nombre;

}