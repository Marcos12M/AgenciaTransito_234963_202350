package Entidades;

import Entidades.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-14T16:06:30", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, String> Tipo;
    public static volatile SingularAttribute<Licencia, Persona> persona;
    public static volatile SingularAttribute<Licencia, Integer> costo;
    public static volatile SingularAttribute<Licencia, Integer> Vigencia;
    public static volatile SingularAttribute<Licencia, Date> VigenciaF;
    public static volatile SingularAttribute<Licencia, Integer> id;

}