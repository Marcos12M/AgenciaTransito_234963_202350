/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcos Toledo 00000234963
 */
/**
 * Clase que representa a una persona en el sistema. Esta clase es una entidad
 * JPA que está mapeada a una tabla en la base de datos.
 */
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id;

    @Basic
    @Column(name = "rfc") // Aquí se especifica que el atributo es único
    private String RFC;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "telefono")
    private String telefono;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Basic
    @Column(name = "discapacitado")
    private boolean discapacitado;

    @OneToMany(mappedBy = "persona")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "persona")
    private List<Tramite> tramites;

    // Constructores
    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona con el RFC como parámetro.
     *
     * @param RFC El RFC de la persona.
     */
    public Persona(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Constructor de la clase Persona con los atributos principales como
     * parámetros.
     *
     * @param RFC El RFC de la persona.
     * @param nombre El nombre de la persona.
     * @param telefono El teléfono de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param discapacitado Indica si la persona tiene alguna discapacidad.
     */
    public Persona(String RFC, String nombre, String telefono, Date fechaNacimiento, boolean discapacitado) {
        this.RFC = RFC;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacitado = discapacitado;
    }

    // Métodos Getter y Setter
    /**
     * Obtiene la lista de vehículos asociados a la persona.
     *
     * @return La lista de vehículos asociados a la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos asociados a la persona.
     *
     * @param vehiculos La lista de vehículos a establecer.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene la lista de trámites asociados a la persona.
     *
     * @return La lista de trámites asociados a la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     *
     * @param tramites La lista de trámites a establecer.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param id El ID a establecer.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Establece el RFC de la persona.
     *
     * @param RFC El RFC a establecer.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono de la persona.
     *
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     *
     * @param telefono El teléfono a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Indica si la persona tiene alguna discapacidad.
     *
     * @return true si la persona tiene alguna discapacidad, false en caso
     * contrario.
     */
    public boolean isDiscapacitado() {
        return discapacitado;
    }

    /**
     * Establece si la persona tiene alguna discapacidad.
     *
     * @param discapacitado Indica si la persona tiene alguna discapacidad.
     */
    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento a establecer.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula el valor de hash para la instancia de Persona.
     *
     * @return El valor de hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.RFC);
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.telefono);
        hash = 13 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 13 * hash + (this.discapacitado ? 1 : 0);
        hash = 13 * hash + Objects.hashCode(this.vehiculos);
        hash = 13 * hash + Objects.hashCode(this.tramites);
        return hash;
    }

    /**
     * Compara si esta instancia de Persona es igual a otro objeto.
     *
     * @param obj El objeto con el que se compara.
     * @return {@code true} si son iguales, {@code false} en caso contrario.
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
        final Persona other = (Persona) obj;
        if (this.discapacitado != other.discapacitado) {
            return false;
        }
        if (!Objects.equals(this.RFC, other.RFC)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.vehiculos, other.vehiculos)) {
            return false;
        }
        return Objects.equals(this.tramites, other.tramites);
    }

    /**
     * Genera una representación de cadena de caracteres de la instancia de
     * Persona.
     *
     * @return La representación de cadena de caracteres de la instancia.
     */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", RFC=" + RFC + ", nombre=" + nombre + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", discapacitado=" + discapacitado + ", vehiculos=" + vehiculos + ", tramites=" + tramites + '}';
    }
}
