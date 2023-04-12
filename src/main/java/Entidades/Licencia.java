/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Entity
@Table(name = "Licencia")
public class Licencia implements Serializable {

    @Id
    @Column(name = "id_licencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "tipo")
    private String Tipo;

    @Column(name = "vigencia")
    @Temporal(TemporalType.DATE)
    private Date Vigencia;

    @Basic
    @Column(name = "costo")
    private Integer Costo;

    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Licencia() {
    }

    public Licencia(Integer id, String Tipo, Date Vigencia, Integer Costo, Persona persona) {
        this.id = id;
        this.Tipo = Tipo;
        this.Vigencia = Vigencia;
        this.Costo = Costo;
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Date getVigencia() {
        return Vigencia;
    }

    public void setVigencia(Date Vigencia) {
        this.Vigencia = Vigencia;
    }

    public Integer getCosto() {
        return Costo;
    }

    public void setCosto(Integer Costo) {
        this.Costo = Costo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.Tipo);
        hash = 53 * hash + Objects.hashCode(this.Vigencia);
        hash = 53 * hash + Objects.hashCode(this.Costo);
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
        final Licencia other = (Licencia) obj;
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.Vigencia, other.Vigencia)) {
            return false;
        }
        if (!Objects.equals(this.Costo, other.Costo)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", Tipo=" + Tipo + ", Vigencia=" + Vigencia + ", Costo=" + Costo + ", persona=" + persona + '}';
    }
    
}
