package Entidades;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-11T17:42:06", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, String> Tipo;
    public static volatile SingularAttribute<Licencia, Integer> Costo;
    public static volatile SingularAttribute<Licencia, Date> Vigencia;
    public static volatile SingularAttribute<Licencia, Integer> id;

}