package TAWapp.entity;

import TAWapp.entity.EstadisticaHasCompradorProducto;
import TAWapp.entity.EstadisticaHasProductosFavoritos;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-08T02:40:50")
@StaticMetamodel(Estadistica.class)
public class Estadistica_ { 

    public static volatile SingularAttribute<Estadistica, EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritos;
    public static volatile SingularAttribute<Estadistica, Usuario> usuarioAnalista;
    public static volatile CollectionAttribute<Estadistica, EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoCollection;
    public static volatile SingularAttribute<Estadistica, Integer> idestadistica;

}