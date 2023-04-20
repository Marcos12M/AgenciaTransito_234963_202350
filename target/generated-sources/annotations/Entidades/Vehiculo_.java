package Entidades;

import Entidades.Persona;
import Entidades.Placa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-20T09:38:06", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-20T04:20:57", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> 7742156fcccc00445b80d0ed48667ca9a623e3b7
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, Persona> persona;
    public static volatile SingularAttribute<Vehiculo, String> Modelo;
    public static volatile SingularAttribute<Vehiculo, String> Marca;
    public static volatile SingularAttribute<Vehiculo, String> Color;
    public static volatile SingularAttribute<Vehiculo, Integer> id;
    public static volatile SingularAttribute<Vehiculo, String> numSerie;
    public static volatile SingularAttribute<Vehiculo, Placa> placa;

}