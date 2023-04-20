/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcos Toledo 00000234963
 */
/**
 * Esta es una clase que representa un Trámite en un sistema. Esta clase es una
 * entidad JPA, lo que significa que se puede mapear a una tabla en una base de
 * datos. Utiliza la estrategia de herencia "Joined" para la persistencia en la
 * base de datos. El nombre de la columna discriminatoria en la tabla se
 * establece como "tipo_tramite". Esta clase implementa la interfaz
 * Serializable, lo que permite que los objetos de esta clase sean
 * serializables.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite")
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date Fecha = new Date();

    @Basic
    @Column(name = "estado")
    private String Estado; //Esta opción la agregue por esto (- considerar que pasa si me roban o pierdo las licencias o placas, ademas de saber si esta vigente)

    @Basic
    @Column(name = "costo")
    private int Costo; //Son dos atributos que comparten

    @ManyToOne
    @JoinColumn(name = "id_Persona")
    private Persona persona;

    /**
     * Constructor por defecto de la clase Tramite.
     */
    public Tramite() {
    }

    /**
     * Constructor de la clase Tramite con parámetros.
     *
     * @param Estado
     * @param Costo
     * @param persona Persona asociada al trámite.
     */
    public Tramite(String Estado, int Costo, Persona persona) {
        this.Estado = Estado;
        this.Costo = Costo;
        this.persona = persona;
    }

    /**
     * Método para obtener el ID del trámite.
     *
     * @return El ID del trámite.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método para establecer el ID del trámite.
     *
     * @param id El ID del trámite.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método para obtener la fecha del trámite.
     *
     * @return La fecha del trámite.
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * Método para establecer la fecha del trámite.
     *
     * @param Fecha
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * Método para obtener el estado del trámite.
     *
     * @return El estado del trámite.
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * Método para establecer el estado del trámite.
     *
     * @param Estado
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * Método para obtener el costo del trámite.
     *
     * @return El costo del trámite.
     */
    public int getCosto() {
        return Costo;
    }

    /**
     * Método para establecer el costo del trámite.
     *
     * @param Costo
     */
    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    /**
     * Método para obtener la persona asociada al trámite.
     *
     * @return La persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método para establecer la persona asociada al trámite.
     *
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Calcula y devuelve el código hash del objeto Tramite.
     *
     * @return El código hash del objeto Tramite.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.Fecha);
        hash = 29 * hash + Objects.hashCode(this.Estado);
        hash = 29 * hash + this.Costo;
        hash = 29 * hash + Objects.hashCode(this.persona);
        return hash;
    }

    /**
     * Compara si el objeto actual es igual al objeto pasado como parámetro.
     *
     * @param obj El objeto a comparar.
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
        final Tramite other = (Tramite) obj;
        if (this.Costo != other.Costo) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    /**
     * Devuelve una representación en forma de cadena de caracteres del objeto
     * Tramite.
     *
     * @return La representación en forma de cadena de caracteres del objeto
     * Tramite.
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", Fecha=" + Fecha + ", Estado=" + Estado + ", Costo=" + Costo + ", persona=" + persona + '}';
    }

}
