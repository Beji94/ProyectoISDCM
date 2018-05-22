package entidades;

import entidades.Videos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T17:50:35")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile SingularAttribute<Usuarios, String> passwd;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile SingularAttribute<Usuarios, String> identificador;
    public static volatile CollectionAttribute<Usuarios, Videos> videosCollection;

}