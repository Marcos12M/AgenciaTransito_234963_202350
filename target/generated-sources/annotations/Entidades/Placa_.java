package Entidades;

import Entidades.Persona;
import Entidades.Vehiculo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-14T16:06:30", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Placa.class)
public class Placa_ { 

    public static volatile SingularAttribute<Placa, String> Numero;
    public static volatile SingularAttribute<Placa, Persona> persona;
    public static volatile SingularAttribute<Placa, Integer> id;
    public static volatile SingularAttribute<Placa, Vehiculo> vehiculo;
    public static volatile SingularAttribute<Placa, Integer> Precio;

}