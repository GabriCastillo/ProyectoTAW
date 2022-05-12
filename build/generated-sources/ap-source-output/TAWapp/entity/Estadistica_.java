package TAWapp.entity;

import TAWapp.entity.CompradorProducto;
import TAWapp.entity.EstadisticaHasCompradorProducto;
import TAWapp.entity.EstadisticaHasProductosFavoritos;
import TAWapp.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-06T19:23:27")
@StaticMetamodel(Estadistica.class)
public class Estadistica_ { 

    public static volatile ListAttribute<Estadistica, CompradorProducto> compradorProductoList;
    public static volatile SingularAttribute<Estadistica, EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritos;
    public static volatile SingularAttribute<Estadistica, Usuario> usuarioAnalista;
    public static volatile ListAttribute<Estadistica, EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoList;
    public static volatile SingularAttribute<Estadistica, Integer> idestadistica;

}