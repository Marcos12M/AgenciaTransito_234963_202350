package Entidades;

import Entidades.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-14T16:06:30", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Reporte.class)
public class Reporte_ { 

    public static volatile SingularAttribute<Reporte, String> Tipo;
    public static volatile SingularAttribute<Reporte, Persona> persona;
    public static volatile SingularAttribute<Reporte, Date> Fecha;
    public static volatile SingularAttribute<Reporte, Integer> Costo;
    public static volatile SingularAttribute<Reporte, Integer> id;

}