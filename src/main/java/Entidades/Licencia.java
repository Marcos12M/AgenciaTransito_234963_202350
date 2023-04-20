/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcos Toledo 00000234963
 */
/**
 * Clase que representa la entidad Licencia, que hereda de la clase Tramite y se
 * mapea a una tabla en la base de datos. Esta clase representa una licencia con
 * su tipo, vigencia y fecha de vigencia.
 */
@Entity
@DiscriminatorValue("Licencia")
public class Licencia extends Tramite implements Serializable {

    @Id
    @Column(name = "id_Licencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "Tipo")
    private String Tipo;

    @Basic
    @Column(name = "Vigencia")
    private int Vigencia;

    @Column(name = "vigenciaFecha")
    @Temporal(TemporalType.DATE)
    private Date VigenciaF;

    /**
     * Constructor vacío de la clase Licencia.
     */
    public Licencia() {
    }

    /**
     * Constructor de la clase Licencia que recibe los parámetros Tipo,
     * Vigencia, VigenciaF, Estado, Costo y Persona, y los asigna a las
     * correspondientes variables de la clase.
     *
     * @param Tipo Tipo de la licencia.
     * @param Vigencia Vigencia de la licencia en meses.
     * @param VigenciaF Fecha de vigencia de la licencia.
     * @param Estado Estado del trámite de la licencia.
     * @param Costo Costo del trámite de la licencia.
     * @param persona Persona asociada a la licencia.
     */
    public Licencia(String Tipo, int Vigencia, Date VigenciaF, String Estado, int Costo, Persona persona) {
        super(Estado, Costo, persona);
        this.Tipo = Tipo;
        this.Vigencia = Vigencia;
        this.VigenciaF = VigenciaF;
    }

    /**
     * Método para establecer la persona asociada a la Licencia, heredado de la
     * clase Tramite.
     *
     * @param persona Persona asociada a la Licencia.
     */
    @Override
    public void setPersona(Persona persona) {
        super.setPersona(persona);
    }

    /**
     * Método para establecer el costo del trámite de la Licencia, heredado de
     * la clase Tramite.
     *
     * @param costo Costo del trámite de la Licencia.
     */
    @Override
    public void setCosto(int costo) {
        super.setCosto(costo);
    }

    /**
     * Método para establecer la fecha del trámite de la Licencia, heredado de
     * la clase Tramite.
     *
     * @param fecha Fecha del trámite de la Licencia.
     */
    @Override
    public void setFecha(Date fecha) {
        super.setFecha(fecha);
    }

    /**
     * Método para establecer el estado del trámite de la Licencia, heredado de
     * la clase Tramite.
     *
     * @param estado Estado del trámite de la Licencia.
     */
    @Override
    public void setEstado(String estado) {
        super.setEstado(estado);
    }

    /**
     * Método para obtener el ID de la Licencia.
     *
     * @return ID de la Licencia.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Método para establecer el ID de la Licencia.
     *
     * @param id ID de la Licencia.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método para obtener el tipo de la Licencia.
     *
     * @return Tipo de la Licencia.
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * Método para establecer el tipo de la Licencia.
     *
     * @param tipo Tipo de la Licencia.
     */
    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    /**
     * Método para obtener la vigencia de la Licencia en meses.
     *
     * @return Vigencia de la Licencia en meses.
     */
    public int getVigencia() {
        return Vigencia;
    }

    /**
     * Método para establecer la vigencia de la Licencia en meses.
     *
     * @param vigencia Vigencia de la Licencia en meses.
     */
    public void setVigencia(int vigencia) {
        this.Vigencia = vigencia;
    }

    /**
     * Método para obtener la fecha de vigencia de la Licencia.
     *
     * @return Fecha de vigencia de la Licencia.
     */
    public Date getVigenciaF() {
        return VigenciaF;
    }

    /**
     * Método para establecer la fecha de vigencia de la Licencia.
     *
     * @param vigenciaF Fecha de vigencia de la Licencia.
     */
    public void setVigenciaF(Date vigenciaF) {
        this.VigenciaF = vigenciaF;
    }

    /**
     * Método para calcular el código hash de la Licencia.
     *
     * @return Código hash de la Licencia.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.Tipo);
        hash = 29 * hash + this.Vigencia;
        hash = 29 * hash + Objects.hashCode(this.VigenciaF);
        return hash;
    }

    /**
     * Método para comparar si esta Licencia es igual a otro objeto.
     *
     * @param obj Objeto a comparar.
     * @return true si son iguales, false si no lo son.
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
        final Licencia other = (Licencia) obj;
        if (this.Vigencia != other.Vigencia) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.VigenciaF, other.VigenciaF);
    }

    /**
     * Método para obtener una representación en formato de cadena de la
     * Licencia.
     *
     * @return Representación en formato de cadena de la Licencia.
     */
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", Tipo=" + Tipo + ", Vigencia=" + Vigencia + ", VigenciaF=" + VigenciaF + '}';
    }

}
