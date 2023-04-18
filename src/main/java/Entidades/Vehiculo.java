/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Marcos Toledo 00000234963
 */
@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer id;

    @Basic
    @Column(name = "color")
    private String Color;

    @Basic
    @Column(name = "modelo")
    private String Modelo;

    @Basic
    @Column(name = "numero_serie")
    private String NumSerie;

    @Basic
    @Column(name = "marca")
    private String Marca;

    @OneToOne
    @JoinColumn(name = "id_placa")
    private Placa placa;

    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String Color, String Modelo, String NumSerie, String Marca, Placa placa, Persona persona) {
        this.id = id;
        this.Color = Color;
        this.Modelo = Modelo;
        this.NumSerie = NumSerie;
        this.Marca = Marca;
        this.placa = placa;
        this.persona = persona;
    }

    public Vehiculo(Integer id, String Color, String Modelo, String NumSerie, String Marca, Persona persona) {
        this.id = id;
        this.Color = Color;
        this.Modelo = Modelo;
        this.NumSerie = NumSerie;
        this.Marca = Marca;
        this.persona = persona;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.Color);
        hash = 53 * hash + Objects.hashCode(this.Modelo);
        hash = 53 * hash + Objects.hashCode(this.NumSerie);
        hash = 53 * hash + Objects.hashCode(this.Marca);
        hash = 53 * hash + Objects.hashCode(this.placa);
        hash = 53 * hash + Objects.hashCode(this.persona);
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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.Color, other.Color)) {
            return false;
        }
        if (!Objects.equals(this.Modelo, other.Modelo)) {
            return false;
        }
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.NumSerie, other.NumSerie)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", Color=" + Color + ", Modelo=" + Modelo + ", NumSerie=" + NumSerie + ", Marca=" + Marca + ", placa=" + placa + ", persona=" + persona + '}';
    }

}
