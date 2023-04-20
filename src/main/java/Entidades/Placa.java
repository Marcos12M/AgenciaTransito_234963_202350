/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Marcos Toledo 00000234963
 */
/**
 * Clase que representa una Placa de vehículo en el sistema. Extiende de la
 * clase Tramite y es serializable.
 */
@Entity
@DiscriminatorValue("Placa")
public class Placa extends Tramite implements Serializable {

    @Id
    @Column(name = "id_Placa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(unique = true, name = "Numero") // Aquí se especifica que el atributo es único
    private String Numero;

    @OneToOne(mappedBy = "Placa")
    private Vehiculo vehiculo;

    @ManyToOne()
    @JoinColumn(name = "id_Persona")
    private Persona persona;

    /**
     * Constructor vacío de la clase Placa.
     */
    public Placa() {
    }

    /**
     * Constructor de la clase Placa con parámetros.
     *
     * @param id El identificador de la Placa.
     * @param Numero El número de la Placa.
     * @param vehiculo El vehículo asociado a la Placa.
     * @param persona La persona titular de la Placa.
     */
    public Placa(Integer id, String Numero, Vehiculo vehiculo, Persona persona) {
        this.id = id;
        this.Numero = Numero;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    // Getters y setters
    // Getters y setters
    /**
     * Obtiene el identificador de la Placa.
     *
     * @return El identificador de la Placa.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador de la Placa.
     *
     * @param id El identificador de la Placa.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el número de la Placa.
     *
     * @return El número de la Placa.
     */
    public String getNumero() {
        return Numero;
    }

    /**
     * Establece el número de la Placa.
     *
     * @param Numero El número de la Placa.
     */
    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    /**
     * Obtiene el vehículo asociado a la Placa.
     *
     * @return El vehículo asociado a la Placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado a la Placa.
     *
     * @param vehiculo El vehículo asociado a la Placa.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene la persona titular de la Placa.
     *
     * @return La persona titular de la Placa.
     */
    @Override
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona titular de la Placa.
     *
     * @param persona La persona titular de la Placa.
     */
    @Override
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve un valor hash único para el objeto Placa, basado en sus
     * atributos id, Numero, vehiculo y persona.
     *
     * @return Un valor hash único para el objeto Placa.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.Numero);
        hash = 17 * hash + Objects.hashCode(this.vehiculo);
        hash = 17 * hash + Objects.hashCode(this.persona);
        return hash;
    }

    /**
     * Compara si el objeto Placa es igual a otro objeto dado.
     *
     * @param obj El objeto a comparar con el objeto Placa.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Placa other = (Placa) obj;
        if (!Objects.equals(this.Numero, other.Numero)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.vehiculo, other.vehiculo)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    /**
     * Devuelve una representación en forma de String del objeto Placa.
     *
     * @return Una representación en forma de String del objeto Placa.
     */
    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", Numero=" + Numero + ", vehiculo=" + vehiculo + ", persona=" + persona + '}';
    }

}
