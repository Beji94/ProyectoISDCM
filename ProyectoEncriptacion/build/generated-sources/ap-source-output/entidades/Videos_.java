package entidades;

import entidades.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T17:50:35")
@StaticMetamodel(Videos.class)
public class Videos_ { 

    public static volatile SingularAttribute<Videos, String> descripcion;
    public static volatile SingularAttribute<Videos, Date> fecha;
    public static volatile SingularAttribute<Videos, Integer> reproduccion;
    public static volatile SingularAttribute<Videos, String> formato;
    public static volatile SingularAttribute<Videos, Usuarios> idUsuario;
    public static volatile SingularAttribute<Videos, String> titulo;
    public static volatile SingularAttribute<Videos, Date> duracion;
    public static volatile SingularAttribute<Videos, String> autor;
    public static volatile SingularAttribute<Videos, String> url;
    public static volatile SingularAttribute<Videos, Integer> apubli;
    public static volatile SingularAttribute<Videos, Long> identificador;

}