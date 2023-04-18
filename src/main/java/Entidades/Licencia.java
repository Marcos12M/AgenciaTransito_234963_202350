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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_Persona")
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Licencia() {
    }

    public void setCosto(int costo) {
        super.setCosto(costo);
    }

    public void setFecha(Date Fecha ) {
        super.setFecha(Fecha);
    }

    public void setEstado(String Estado) {
        super.setEstado(Estado);
    }

    public Licencia(String Tipo, int Vigencia, Date VigenciaF, Persona persona, String Estado, int Costo) {
        super(Estado, Costo);
        this.Tipo = Tipo;
        this.Vigencia = Vigencia;
        this.VigenciaF = VigenciaF;
        this.persona = persona;
    }

    public Licencia(Integer id, String Tipo, int Vigencia, Date VigenciaF, Persona persona) {
        this.id = id;
        this.Tipo = Tipo;
        this.Vigencia = Vigencia;
        this.VigenciaF = VigenciaF;
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

    public int getVigencia() {
        return Vigencia;
    }

    public void setVigencia(int Vigencia) {
        this.Vigencia = Vigencia;
    }

    public Date getVigenciaF() {
        return VigenciaF;
    }

    public void setVigenciaF(Date VigenciaF) {
        this.VigenciaF = VigenciaF;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.Tipo);
        hash = 71 * hash + this.Vigencia;
        hash = 71 * hash + Objects.hashCode(this.VigenciaF);
        hash = 71 * hash + Objects.hashCode(this.persona);
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
        if (this.Vigencia != other.Vigencia) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.VigenciaF, other.VigenciaF)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", Tipo=" + Tipo + ", Vigencia=" + Vigencia + ", VigenciaF=" + VigenciaF + ", persona=" + persona + '}';
    }

}
