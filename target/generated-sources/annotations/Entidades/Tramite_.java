package Entidades;

import Entidades.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-18T23:47:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Persona> persona;
    public static volatile SingularAttribute<Tramite, Date> Fecha;
    public static volatile SingularAttribute<Tramite, Integer> Costo;
    public static volatile SingularAttribute<Tramite, Integer> id;
    public static volatile SingularAttribute<Tramite, String> Estado;

}