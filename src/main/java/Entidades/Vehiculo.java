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
/**
 * Clase que representa un vehículo. Esta clase es una entidad de JPA (Java
 * Persistence API) y se mapea a una tabla en la base de datos con el nombre
 * "Vehiculo". Implementa la interfaz Serializable para permitir la
 * serialización de objetos de esta clase.
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
    private String numSerie;

    @Basic
    @Column(name = "marca")
    private String Marca;

    @OneToOne
    @JoinColumn(name = "id_placa")
    private Placa placa;

    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    /**
     * Constructor por defecto de la clase Vehiculo. Se utiliza para crear
     * instancias de la clase sin proporcionar valores iniciales para los
     * atributos.
     */
    public Vehiculo() {
    }

    /**
     * Constructor de la clase Vehiculo que recibe todos los valores iniciales
     * para los atributos, incluyendo la Placa del vehículo.
     *
     * @param id Valor del id del vehículo.
     * @param Color Valor del color del vehículo.
     * @param Modelo Valor del modelo del vehículo.
     * @param NumSerie Valor del número de serie del vehículo.
     * @param Marca Valor de la marca del vehículo.
     * @param placa Objeto Placa que representa la placa del vehículo.
     * @param persona Objeto Persona que representa la persona asociada al
     * vehículo.
     */
    public Vehiculo(Integer id, String Color, String Modelo, String NumSerie, String Marca, Placa placa, Persona persona) {
        this.id = id;
        this.Color = Color;
        this.Modelo = Modelo;
        this.numSerie = NumSerie;
        this.Marca = Marca;
        this.placa = placa;
        this.persona = persona;
    }

    /**
     * Constructor de la clase Vehiculo que recibe todos los valores iniciales
     * para los atributos, excepto la Placa del vehículo.
     *
     * @param id Valor del id del vehículo.
     * @param Color Valor del color del vehículo.
     * @param Modelo Valor del modelo del vehículo.
     * @param NumSerie Valor del número de serie del vehículo.
     * @param Marca Valor de la marca del vehículo.
     * @param persona Objeto Persona que representa la persona asociada al
     * vehículo.
     */
    public Vehiculo(Integer id, String Color, String Modelo, String NumSerie, String Marca, Persona persona) {
        this.id = id;
        this.Color = Color;
        this.Modelo = Modelo;
        this.numSerie = NumSerie;
        this.Marca = Marca;
        this.persona = persona;
    }

    /**
     * Obtiene la Placa asociada al vehículo.
     *
     * @return Objeto Placa que representa la placa del vehículo.
     */
    public Placa getPlaca() {
        return placa;
    }

    /**
     * Establece la Placa asociada al vehículo.
     *
     * @param placa Objeto Placa que representa la placa del vehículo.
     */
    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    /**
     * Obtiene la Persona asociada al vehículo.
     *
     * @return Objeto Persona que representa la persona asociada al vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la Persona asociada al vehículo.
     *
     * @param persona Objeto Persona que representa la persona asociada al
     * vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el ID del vehículo.
     *
     * @return Valor del ID del vehículo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del vehículo.
     *
     * @param id Valor del ID del vehículo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el color del vehículo.
     *
     * @return Valor del color del vehículo.
     */
    public String getColor() {
        return Color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param Color Valor del color del vehículo.
     */
    public void setColor(String Color) {
        this.Color = Color;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return Valor del modelo del vehículo.
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param Modelo Valor del modelo del vehículo.
     */
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * Obtiene el número de serie del vehículo.
     *
     * @return Valor del número de serie del vehículo.
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param NumSerie Valor del número de serie del vehículo.
     */
    public void setNumSerie(String NumSerie) {
        this.numSerie = NumSerie;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return Valor de la marca del vehículo.
     */
    public String getMarca() {
        return Marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param Marca Valor de la marca del vehículo.
     */
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    /**
     * Calcula y retorna el valor hash de este objeto Vehiculo. El valor hash se
     * calcula en base a los valores de los atributos (id, Color, Modelo,
     * numSerie, Marca, placa, persona) de este objeto. Se utiliza el algoritmo
     * de hash recomendado por la documentación de Java.
     *
     * @return el valor hash de este objeto
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.Color);
        hash = 53 * hash + Objects.hashCode(this.Modelo);
        hash = 53 * hash + Objects.hashCode(this.numSerie);
        hash = 53 * hash + Objects.hashCode(this.Marca);
        hash = 53 * hash + Objects.hashCode(this.placa);
        hash = 53 * hash + Objects.hashCode(this.persona);
        return hash;
    }

    /**
     * Compara este objeto con otro objeto para determinar si son iguales.
     * Retorna true si el objeto especificado también es una instancia de
     * Vehiculo y todos sus atributos (id, Color, Modelo, numSerie, Marca,
     * placa, persona) son iguales, de lo contrario retorna false.
     *
     * @param obj el objeto con el cual se va a comparar la igualdad
     * @return true si el objeto es igual a este objeto (en términos de
     * atributos), false de lo contrario
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
        if (!Objects.equals(this.numSerie, other.numSerie)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    /**
     * Retorna una representación en forma de cadena de este objeto Vehiculo. La
     * representación incluye los valores de todos los atributos (id, Color,
     * Modelo, numSerie, Marca, placa, persona) de este objeto.
     *
     * @return una representación en forma de cadena de este objeto
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", Color=" + Color + ", Modelo=" + Modelo + ", NumSerie=" + numSerie + ", Marca=" + Marca + ", placa=" + placa + ", persona=" + persona + '}';
    }

}
