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
@Entity
@DiscriminatorValue("Placa")
public class Placa extends Reporte implements Serializable {

    @Id
    @Column(name = "id_placa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(unique = true, name = "numero") // Aquí se especifica que el atributo es único
    private String Numero;

    @Basic
    @Column(name = "costo")
    private Integer Precio;

    @OneToOne(mappedBy = "placa")
    private Vehiculo vehiculo;

    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Placa() {
    }

    public Placa(Integer id, String Numero, Integer Precio, Vehiculo vehiculo, Persona persona) {
        this.id = id;
        this.Numero = Numero;
        this.Precio = Precio;
        this.vehiculo = vehiculo;
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer Precio) {
        this.Precio = Precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.Numero);
        hash = 31 * hash + Objects.hashCode(this.Precio);
        hash = 31 * hash + Objects.hashCode(this.vehiculo);
        hash = 31 * hash + Objects.hashCode(this.persona);
        return hash;
    }

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
        if (!Objects.equals(this.Precio, other.Precio)) {
            return false;
        }
        if (!Objects.equals(this.vehiculo, other.vehiculo)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", Numero=" + Numero + ", Precio=" + Precio + ", vehiculo=" + vehiculo + ", persona=" + persona + '}';
    }

}
