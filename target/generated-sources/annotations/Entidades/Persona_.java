package Entidades;

import Entidades.Tramite;
import Entidades.Vehiculo;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-20T09:38:06", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-20T04:20:57", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> 7742156fcccc00445b80d0ed48667ca9a623e3b7
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Boolean> discapacitado;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile ListAttribute<Persona, Tramite> tramites;
    public static volatile SingularAttribute<Persona, Integer> id;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> RFC;
    public static volatile ListAttribute<Persona, Vehiculo> vehiculos;

}